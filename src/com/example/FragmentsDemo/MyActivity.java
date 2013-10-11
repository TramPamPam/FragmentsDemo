package com.example.FragmentsDemo;

//import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MyActivity extends FragmentActivity {
    NewGameFragment newGameFragment = new NewGameFragment();
    OptionsFragment optionsFragment = new OptionsFragment();
    HelpFragment helpFragment = new HelpFragment();

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);
//        if(savedInstanceState == null){
//            HelloFragment helloFragment = new HelloFragment();
//            getSupportFragmentManager().beginTransaction().add(R.id.fragmentContent,helloFragment).commit();
//        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

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

}
