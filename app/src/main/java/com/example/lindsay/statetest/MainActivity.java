package com.example.lindsay.statetest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity {

    int viewCounter =0; //keeps track of user views, or number of times onResume (3) is called

    //1. Called when app opened
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("APP", "onCreate was called");
    }

    //2. called when app opened
    @Override
    protected void onStart(){
        super.onStart();
        Log.d("APP", "onStart was called");
    }

    //3. Called when app opened, resumed from onPause. app now running
    @Override
    protected void onResume(){
        super.onResume();
        viewCounter++;
        Log.d("APP", "onResume was called");
    }

    //4. Called when app has dialog disabling the screen, switches to another activity
    @Override
    protected void onPause(){
        super.onPause();
        Log.d("APP", "onPause was called");
    }

    //5. Called when app switches to another activity, or app
    @Override
    protected void onStop(){
        super.onStop();
        Log.d("APP", "onStop was called");
    }

    //6. Called manually with finish method, or when android runs out of mem
    //If switching portrait/landscape views, goes back to 1. onCreate
    //Then 2. onStart, and 3. onResume
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("APP", "onDestroy was called");
    }

    //7. If app is stopped and restarts: switches from another app to yours
    //Then calls 2. onStart, and 3. onResume
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d("APP", "onRestart was called");
    }

    //Activity object held in memory when app is paused (4) or stopped (5)
    //Unless system explicitly destroys it (6)
    //Note: Pressing the Back button calls finish(), and therefore can't save the state
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        //To put information into the Bundle. Uses a key and a value
        outState.putInt("viewCounter", viewCounter);
        Log.d("APP", viewCounter + " was saved");
    }

    //onCreate also receives the same Bundle object from onSaveInstanceState
    //Can use onCreate instead of onRestoreInstanceState
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);

        //To get information out of the Bundle, using the key
        viewCounter=savedInstanceState.getInt("viewCounter");
        Log.d("APP", viewCounter + " was restored");
    }

//Didn't need the default onCreateOptionsMenu or onOptionsItemSelected methods for this app

}
