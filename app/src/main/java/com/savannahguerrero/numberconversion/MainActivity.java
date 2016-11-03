/******************************************************
 * Program:     Number Conversion
 * Developer:   Savannah Guerrero
 * Date:        November 3, 2016
 * Version:     1.0
 *
 * File:        MainActivity.java
 *
 * Purpose:     Sets up everything needed for the main
 *              activity - including all the functionality
 *              for the number, clear, and number system
 *              buttons.
 *
 * App Purpose: Allows users to be able to easily convert
 *              decimal numbers to binary or hexidecimal
 *              and inbetween both. Adds previous data
 *              to a list view for easy access
 *
 * Future:      Allow conversion between decimal as well
 *              as configure the historyListView portion
 *              of the app to properly fill the rest of
 *              the screen to make it easier to be
 *              compatible with various screens.
 ******************************************************/

package com.savannahguerrero.numberconversion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Create variables
    private TextView answerTV;

    // Set binary and hex both to false
    Boolean binary = false, hex = false;

    private ListView list;

    // Create new ArrayAdapaters and ArrayLists
    private ArrayAdapter<String> adapter;
    private ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create toolbar
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        // Connect to the screen
        answerTV = (TextView) findViewById(R.id.answerTextView);
        list = (ListView) findViewById(R.id.historyListView);

        // Create new arrayList
        arrayList = new ArrayList<String>();

        // Set adapter to arrayList
        adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.historylist, R.id.historyListTextView, arrayList);

        // Set data in list view
        list.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate menu
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Populate menu information
        switch (item.getItemId()) {
            /**
             * In the case that the settings button is clicked, open a new activity for app information
             */
            case R.id.action_info:
                // User chose the "Settings" item, show the app settings UI...
                Intent intent = new Intent(MainActivity.this, infoActivity.class);
                startActivity(intent);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    /*************************************************
     * Button work for numbers 0-9
     *
     * @param view
     *************************************************/
    public void zeroClick (View view) {
        answerTV.setText(answerTV.getText() + "0");
    }

    public void oneClick (View view) {
        answerTV.setText(answerTV.getText() + "1");
    }

    public void twoClick (View view) {
        answerTV.setText(answerTV.getText() + "2");
    }

    public void threeClick (View view) {
        answerTV.setText(answerTV.getText() + "3");
    }

    public void fourClick (View view) {
        answerTV.setText(answerTV.getText() + "4");
    }

    public void fiveClick (View view) {
        answerTV.setText(answerTV.getText() + "5");
    }

    public void sixClick (View view) {
        answerTV.setText(answerTV.getText() + "6");
    }

    public void sevenClick (View view) {
        answerTV.setText(answerTV.getText() + "7");
    }

    public void eightClick (View view) {
        answerTV.setText(answerTV.getText() + "8");
    }

    public void nineClick (View view) {
        answerTV.setText(answerTV.getText() + "9");
    }

    /*************************************************
     * Button work for clear entries and clear all
     *
     * @param view
     *************************************************/

    /**
     * Give functionality to the clear entry button
     * @param view
     */
    public void clearEntryClick (View view) {
        arrayList.add(answerTV.getText().toString());
        adapter.notifyDataSetChanged();
        answerTV.setText("");

        // reset hex and binary systems to false
        hex = false;
        binary = false;
    }

    /**
     * Give functionality to the clear button
     * @param view
     */
    public void clearClick (View view) {
        arrayList.clear();
        adapter.notifyDataSetChanged();

        // Clear answerTV
        answerTV.setText("");

        // reset hex and binary systems to false
        hex = false;
        binary = false;
    }

    /**
     * Binary System Clicked button
     *
     * Converts the string to binary format
     * @param view
     */
    public void binSysClick (View view) {

        // declares needed variables
        int answer;
        int hexToDec;

        // if answerTV is empty, give a toast error
        if (answerTV.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "You must enter a value", Toast.LENGTH_LONG).show();
        // If answerTV is not empty, convert according to criteria
        } else {
            // Puts calculation into the history tv
            arrayList.add(answerTV.getText().toString() + " → BIN = ");

            if (hex == true) {
                hexToDec = Integer.parseInt(answerTV.getText().toString(), 16);
                answerTV.setText(Integer.toString(hexToDec, 2));
            } else {
                answer = Integer.parseInt(answerTV.getText().toString());
                answerTV.setText(Integer.toBinaryString(answer));
            }
        }

        // converts the answer and sets the tv
        adapter.notifyDataSetChanged();

        // set binary system to true
        binary = true;
        hex = false;
    }

    /**
     * Hexadecimal system clicked button
     *
     * Converts the string to hexadecimal format
     * @param view
     */
    public void hexSysClick (View view) {
        int answer;
        int decimal;

        // Check to see if answerTV is empty - if it is, give a toast message
        if (answerTV.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "You must enter a value", Toast.LENGTH_LONG).show();

        // If answerTV is not empty, do calculations accordingly
        } else {

            answer = Integer.parseInt(answerTV.getText().toString());
            arrayList.add(answerTV.getText().toString() + " → HEX = ");

            if (binary == true) {
                // Sets the answer to the parsed integer of the string
                decimal = Integer.parseInt(answerTV.getText().toString(), 2);
                answerTV.setText(Integer.toString(decimal, 16));
            } else {
                answerTV.setText(Integer.toHexString(answer));
            }
        }

        // convert answer to integer
        //int answer = Integer.parseInt(answerTV.getText().toString());

        // converts answer to hex and sets tv
        adapter.notifyDataSetChanged();

        // Set hex system to true
        binary = false;
        hex = true;
    }


}
