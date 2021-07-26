package com.tamilandroo.womensguard;

import android.graphics.Color;
import android.os.Bundle;

import com.hololo.tutorial.library.Step;
import com.hololo.tutorial.library.TutorialActivity;

public class HowToSwipe extends TutorialActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_how_to_swipe);

        addFragment(new Step.Builder()
        .setTitle("About Women's Guard")
        .setContent("First add your family and friends mobile number for emergency!\nStep 1")
        .setBackgroundColor(Color.parseColor("#CC0059"))
        .setDrawable(R.drawable.screen1).build());

        addFragment(new Step.Builder()
                .setTitle("How to use in trouble?")
                .setContent("Just Long press the SOS button.")
                .setSummary("Step 2")
                .setBackgroundColor(Color.parseColor("#CC0059"))
                .setDrawable(R.drawable.screen2).build());

        addFragment(new Step.Builder()
                .setTitle("What happens after SOS pressed?")
                .setContent("SOS will be triggered then sending a message with your location to the registered mobile numbers.")
                .setSummary("Step 3")
                .setBackgroundColor(Color.parseColor("#CC0059"))
                .setDrawable(R.drawable.sos).build());
    }

    @Override
    public void currentFragmentPosition(int position) {

    }
}
