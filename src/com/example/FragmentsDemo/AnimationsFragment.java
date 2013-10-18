package com.example.FragmentsDemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.*;

public class AnimationsFragment extends Fragment implements Animation.AnimationListener {

    TextView viewToAnimate;
    Button buttonBlink, buttonRotate, buttonMove, buttonBounce;

    Animation animationBlink, animationRotate, animationMove, animationBounce;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.animations_fragment, container, false);

        viewToAnimate = (TextView) view.findViewById(R.id.textViewHelp);

        buttonBlink = (Button) view.findViewById(R.id.buttonBlink);
        animationBlink = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.blink);
        animationBlink.setAnimationListener(this);
        buttonBlink.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                viewToAnimate.setVisibility(View.VISIBLE);

                // start the animation
                viewToAnimate.startAnimation(animationBlink);
            }
        });

        buttonBounce = (Button) view.findViewById(R.id.buttonBounce);
        animationBounce = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.bounce);
        animationBounce.setAnimationListener(this);
        buttonBounce.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                viewToAnimate.setVisibility(View.VISIBLE);

                // start the animation
                viewToAnimate.startAnimation(animationBounce);
            }
        });

        buttonRotate = (Button) view.findViewById(R.id.buttonRotate);
        animationRotate = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.rotate);
        animationRotate.setAnimationListener(this);
        buttonRotate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                viewToAnimate.setVisibility(View.VISIBLE);

                // start the animation
                viewToAnimate.startAnimation(animationRotate);
            }
        });

        buttonMove = (Button) view.findViewById(R.id.buttonMove);
        animationMove = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.move);
        animationMove.setAnimationListener(this);
        buttonMove.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                viewToAnimate.setVisibility(View.VISIBLE);

                // start the animation
                viewToAnimate.startAnimation(animationMove);
            }
        });



        return view;
    }

    /** AnimationListener implement: */

    @Override
    public void onAnimationStart(Animation animation) {
        Toast.makeText(getActivity().getApplicationContext(), "Animation Start",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        Toast.makeText(getActivity().getApplicationContext(), "Animation Stopped",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        Toast.makeText(getActivity().getApplicationContext(), "Animation repeat!",
                Toast.LENGTH_SHORT).show();
    }


}
