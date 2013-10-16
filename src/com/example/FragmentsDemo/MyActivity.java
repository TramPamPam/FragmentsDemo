package com.example.FragmentsDemo;

//import android.app.Activity;
import android.os.Bundle;
//import android.support.v4.app.FragmentActivity;
import android.provider.ContactsContract;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.support.v4.app.ActionBarDrawerToggle;

public class MyActivity extends ActionBarActivity {
    NewGameFragment newGameFragment = new NewGameFragment();
    OptionsFragment optionsFragment = new OptionsFragment();
    HelpFragment helpFragment = new HelpFragment();
    private String[] mPlanetTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        getSupportActionBar().setTitle("Title");
        getSupportActionBar().setSubtitle("subtitle");

        String[] myStringArray = {"one","two","three"};
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, myStringArray);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);


/*
        String[] fromColumns = {ContactsContract.Data.DISPLAY_NAME,
        ContactsContract.CommonDataKinds.Phone.NUMBER};
        int[] toViews = {R.id.display_name, R.id.phone_number};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
        R.layout.person_name_and_number, cursor, fromColumns, toViews, 0);
        ListView listView = getListView();
        listView.setAdapter(adapter);



        mPlanetTitles = getResources().getStringArray(R.array.planets_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        // Set the adapter for the list view
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_list_item, mPlanetTitles));
        // Set the list's click listener
        //mDrawerList.setOnItemClickListener(new DrawerItemClickListener());    */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.action_bar_menu, menu);
        return true;
    }
   /*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        getSupportFragmentManager().beginTransaction();
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.new_game:

                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContent, newGameFragment).commit();
                return true;

            case R.id.load_game:
            case R.id.continue_game:
                Toast toast = Toast.makeText(getApplicationContext(), R.string.nothing_to_load, Toast.LENGTH_SHORT);
                toast.show();
                return true;

            case R.id.options:

                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContent, optionsFragment).commit();
                return true;

            case R.id.help:

                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContent, helpFragment).commit();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    */
}
