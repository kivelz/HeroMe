package com.iss.herome.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.iss.herome.Fragments.MainFragment;
import com.iss.herome.Fragments.PickPowerFragment;
import com.iss.herome.R;

public class MainActivity extends AppCompatActivity implements MainFragment.MainFragmentInteractionListener, PickPowerFragment.PickPowerInteractionListener {

    public static String howYouGotIt = "";
    public static int imageHowYouGotIt = 0;
    public static String primaryPower = "";
    public static int imagePrimaryPower=0;
    public static String name= "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager mgr = getSupportFragmentManager();
        Fragment frag = mgr.findFragmentById(R.id.fragment_container);

        if(frag == null) {
            frag = new MainFragment();
           FragmentTransaction trans = mgr.beginTransaction();
           trans.add(R.id.fragment_container, frag);
           trans.commit();
        }

    }

    public void loadPickPowerScreen() {
        PickPowerFragment pickPowerFragment = new PickPowerFragment();
        this.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, pickPowerFragment).addToBackStack(null).commit();
    }
    public void loadBackStory() {
        Intent story = new Intent(MainActivity.this, storyActivity.class);
        startActivity(story);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onPowerFragmentInteraction(Uri uri) {

    }


}
