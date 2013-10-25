/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.FragmentsDemo;

import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity
        implements HeadlinesFragment.OnHeadlineSelectedListener {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_articles);

        // Check whether the activity is using the layout version with
        // the fragment_container FrameLayout. If so, we must add the first fragment
        if (findViewById(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create an instance of ExampleFragment
            HeadlinesFragment firstFragment = new HeadlinesFragment();

            // In case this activity was started with special instructions from an Intent,
            // pass the Intent's extras to the fragment as arguments
            firstFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, firstFragment).commit();
        }
    }

    public void onArticleSelected(int position) {

        if(!getResources().getBoolean(R.bool.istablet)){

            selectItem(position);

        } else {

            selectItemTablet(position);
        }
    }

    private void selectItem(int position) {

        NewGameFragment newGameFragment = new NewGameFragment();
        OptionsFragment optionsFragment = new OptionsFragment();
        AnimationsFragment animationsFragment = new AnimationsFragment();

        Toast toast;
        final Animation animation;
        final TextView viewToAnimate;
        Button buttonToStart;

        getSupportFragmentManager().beginTransaction();

        switch (position) {
            case 0:

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.article_fragment, newGameFragment)
                        .addToBackStack(null)
                        .commit();

                break;
            case 1:
            case 2:
                toast = Toast.makeText(getApplicationContext(), R.string.nothing_to_load, Toast.LENGTH_SHORT);
                toast.show();

                break;
            case 3:

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.article_fragment, optionsFragment)
                        .addToBackStack(null)
                        .commit();

                break;
            case 4:

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.article_fragment, animationsFragment)
                        .addToBackStack(null)
                        .commit();


                break;
            default:

                toast = Toast.makeText(
                        getApplicationContext(), R.string.continue_game, Toast.LENGTH_SHORT);
                toast.show();
                break;
        }
    }

    private void selectItemTablet(int position) {

        NewGameFragment newGameFragment = new NewGameFragment();
        OptionsFragment optionsFragment = new OptionsFragment();
        AnimationsFragment animationsFragment = new AnimationsFragment();

        Toast toast;
        final Animation animation;
        final TextView viewToAnimate;
        Button buttonToStart;

        getSupportFragmentManager().beginTransaction();

        switch (position) {
            case 0:

                        getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, newGameFragment)
                        .addToBackStack(null)
                        .commit();

                break;
            case 1:
            case 2:
                toast = Toast.makeText(getApplicationContext(), R.string.nothing_to_load, Toast.LENGTH_SHORT);
                toast.show();

                break;
            case 3:

                        getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, optionsFragment)
                        .addToBackStack(null)
                        .commit();

                break;
            case 4:

                        getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, animationsFragment)
                        .addToBackStack(null)
                        .commit();


                break;
            default:

                toast = Toast.makeText(
                        getApplicationContext(), R.string.continue_game, Toast.LENGTH_SHORT);
                toast.show();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        FragmentManager fm = getSupportFragmentManager();
        fm.popBackStack();

    }
}