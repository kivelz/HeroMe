package com.iss.herome.Activity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.iss.herome.R;

public class storyActivity extends AppCompatActivity {

    private static final String HULK = " During times of high stress or anger, an increase in adrenaline causes the Hulk's strength to increase dramatically." +
            " There has never been a limit shown as to the highest strength the Hulk can reach thus it is assumed it is limitless.";
    private static final String CYCLOPS = "Cyclops  is  capable of generating concussive force red-colored beams from his eyes." +
            " He has fought for peace and equality between humans and mutants since joining the X-Men.";
    private static final String SUPERMAN = "Superman possesses the powers of flight, superhuman strength, x-ray vision, heat vision, cold breath, super-speed, enhanced hearing, and nigh-invulnerability.";
    private static final String SPIDERMAN =  "1.1 Generally enhanced physiology.\n" +
            "1.2 Possible mystical connection.\n" +
            "1.3 Wall-crawling. ...\n" +
            "1.4 Superhuman strength, durability, healing factor, jumping, leaping and speed.\n" +
            "1.5 Superhuman agility, reflexes and equilibrium.\n";
    private static final String THOR = "Thor possesses physical powers superior to those of normal Asgardian gods. He has an extended lifespan augmented (although not immortal) by the Golden Apples of Idunn, immunity to conventional diseases, enhanced endurance.";

    TextView title;
    TextView bio;
    Button primary;
    ImageView heroIcon;
    Button secondary;
    Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        title = findViewById(R.id.title_text_view);
        bio = findViewById(R.id.bio_text_view);

        primary = findViewById(R.id.primary_power_button);
        secondary = findViewById(R.id.secondary_power_button);

        title.setText(MainActivity.name);

        primary.setText(MainActivity.primaryPower);
        secondary.setText(MainActivity.howYouGotIt);

        switch (MainActivity.name){
            case "Hulk":
                bio.setText(HULK);
                bio.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.super_strength, 0,0,0);
                break;
            case "Spiderman":
                bio.setText(SPIDERMAN);
                bio.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.spiderweb, 0,0,0);
                break;
            case "Cyclops":
                bio.setText(CYCLOPS);
                bio.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.laser_vision, 0,0,0);
                break;
            case "Superman":
                bio.setText(SUPERMAN);
                bio.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.superman_crest, 0,0,0);
                break;
            case "Thor":
                bio.setText(THOR);
                bio.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.lightning, 0,0,0);
        }

        reset = findViewById(R.id.reset);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reset = new Intent(storyActivity.this, MainActivity.class);
                startActivity(reset);
            }
        });
    }


}
