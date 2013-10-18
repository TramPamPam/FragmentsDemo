package com.example.FragmentsDemo;


//import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.content.res.Configuration;

import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.widget.*;
import android.support.v4.app.ActionBarDrawerToggle;

public class MyActivity extends ActionBarActivity {
    NewGameFragment newGameFragment = new NewGameFragment();
    OptionsFragment optionsFragment = new OptionsFragment();
    AnimationsFragment animationsFragment = new AnimationsFragment();

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;

    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    private String[] mPlanetTitles;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.drawer);

        getSupportActionBar().setTitle("Title");
        getSupportActionBar().setSubtitle("subtitle");

        mTitle = mDrawerTitle = getTitle();
        mPlanetTitles = getResources().getStringArray(R.array.game_menu);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        // Set the adapter for the list view
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item, mPlanetTitles));

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                mDrawerLayout,         /* DrawerLayout object */
                R.drawable.abc_ic_go,  /* nav drawer icon to replace 'Up' caret */
                R.string.drawer_open,  /* "open drawer" description */
                R.string.drawer_close  /* "close drawer" description */
        ) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                getSupportActionBar().setTitle(mTitle);
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle(mDrawerTitle);
            }
        };

        // Set the drawer toggle as the DrawerListener
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        // Set the list's click listener
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id) {
            selectItem(position);
        }
    }
    /** Swaps fragments in the main content view */

    private void selectItem(int position) {

        Toast toast;
        final Animation animation;
        final TextView viewToAnimate;
        Button buttonToStart;

        getSupportFragmentManager().beginTransaction();

        switch (position) {
            case 0:
                getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, newGameFragment).commit();

                break;
            case 1:
            case 2:
                toast = Toast.makeText(getApplicationContext(), R.string.nothing_to_load, Toast.LENGTH_SHORT);
                toast.show();

                break;
            case 3:
                getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, optionsFragment).commit();

                break;
            case 4:
                getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, animationsFragment).commit();

                /*
                viewToAnimate = (TextView)findViewById(R.id.textViewHelp);
                buttonToStart = (Button)findViewById(R.id.buttonHelp);

                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bounce);
                animation.setAnimationListener(this);

                buttonToStart.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        viewToAnimate.setVisibility(View.VISIBLE);

                        // start the animation
                        viewToAnimate.startAnimation(animation);
                    }
                });
                */

                break;
            default:
                toast = Toast.makeText(getApplicationContext(), R.string.continue_game, Toast.LENGTH_SHORT);
                toast.show();
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.action_bar_menu, menu);
        return true;

    }
}
