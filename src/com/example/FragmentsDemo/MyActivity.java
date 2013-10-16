package com.example.FragmentsDemo;

//import android.app.Activity;
import android.os.Bundle;
//import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MyActivity extends ActionBarActivity {
    NewGameFragment newGameFragment = new NewGameFragment();
    OptionsFragment optionsFragment = new OptionsFragment();
    HelpFragment helpFragment = new HelpFragment();

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);
        getSupportActionBar().setTitle("test");
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
