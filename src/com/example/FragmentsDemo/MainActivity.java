
package com.example.FragmentsDemo;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.animation.Animation;
import android.widget.*;


public class MainActivity extends ActionBarActivity
        implements HeadlinesFragment.OnHeadlineSelectedListener {

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;

    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    private String[] mPlanetTitles;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_articles);

        getSupportActionBar().setTitle("Game");
        getSupportActionBar().setSubtitle("menu");

        if (findViewById(R.id.fragment_container) != null) {

            if (savedInstanceState != null) {
                return;
            }

            HeadlinesFragment firstFragment = new HeadlinesFragment();
            firstFragment.setArguments(getIntent().getExtras());

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, firstFragment).commit();
        }
    }

    public void onArticleSelected(int position) {


        if(!isItATablet(getApplicationContext())){

            selectItem(position);

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
                    getSupportActionBar().setSubtitle(mTitle);
                }

                /** Called when a drawer has settled in a completely open state. */
                public void onDrawerOpened(View drawerView) {
                    getSupportActionBar().setSubtitle(mDrawerTitle);
                }
            };

            // Set the drawer toggle as the DrawerListener
            mDrawerLayout.setDrawerListener(mDrawerToggle);
            // Set the list's click listener
            mDrawerList.setOnItemClickListener(new DrawerItemClickListener());


            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);

        } else {

            selectItemTablet(position);
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
                        .replace(R.id.article_fragment, newGameFragment)
                        .addToBackStack(null)
                        .commit();
                getSupportActionBar().setSubtitle("new game");
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
                getSupportActionBar().setSubtitle("options");
                break;
            case 4:

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.article_fragment, animationsFragment)
                        .addToBackStack(null)
                        .commit();

                getSupportActionBar().setSubtitle("animations");
                break;
            default:

                toast = Toast.makeText(
                        getApplicationContext(), R.string.continue_game, Toast.LENGTH_SHORT);
                toast.show();
                break;
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
                        .replace(R.id.fragment_container, newGameFragment)
                        .addToBackStack(null)
                        .commit();
                getSupportActionBar().setSubtitle("new game");
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
                getSupportActionBar().setSubtitle("options");
                break;
            case 4:

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, animationsFragment)
                        .addToBackStack(null)
                        .commit();

                getSupportActionBar().setSubtitle("animations");
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
        getSupportActionBar().setSubtitle("");

   }
   private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id) {
            selectItem(position);
        }
   }

    public boolean isItATablet(Context context) {
        boolean xlarge = ((context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == 4);
        boolean large = ((context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_LARGE);
        return (xlarge || large);
    }
}