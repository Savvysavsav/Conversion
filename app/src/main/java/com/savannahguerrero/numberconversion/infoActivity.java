/******************************************************
 * Program:     Number Conversion
 * Developer:   Savannah Guerrero
 * Date:        November 3, 2016
 * Version:     1.0
 *
 * File:        infoActivity.java
 * Purpose:     Sets up everything needed for information
 *              activity - including functionality to
 *              buttons as well as showing some general
 *              information about the app
 ******************************************************/

package com.savannahguerrero.numberconversion;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;


public class infoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        // creates toolbar
        Toolbar myChildToolbar = (Toolbar) findViewById(R.id.childToolbar);
        setSupportActionBar(myChildToolbar);

        //sets up actionbar
        ActionBar ab = getSupportActionBar();

        // Enable the "up"
        ab.setDisplayHomeAsUpEnabled(true);
    }

    /**
     * Adds functionality to the website click button
     *
     * When the "website" button is clicked, go to my personal website
     * @param view
     */
    public void websiteClick (View view) {
        //gets url for website
        String url = "http://www.savannahguerrero.com";

        //creates new intent
        Intent webIntent = new Intent(Intent.ACTION_VIEW);

        //Sets data for url
        webIntent.setData(Uri.parse(url));

        //Starts Activity
        startActivity(webIntent);
    }

    /**
     * Adds functionality to the github click button
     *
     * When the "github" button is clicked, go to my gihub profile
     * @param view
     */
    public void githubClick (View view) {
        //Gets URL for github
        String url = "https://github.com/Savvysavsav";

        //creates new intent
        Intent gitIntent = new Intent(Intent.ACTION_VIEW);

        //Sets data for url
        gitIntent.setData(Uri.parse(url));

        // Starts activity
        startActivity(gitIntent);
    }
}
