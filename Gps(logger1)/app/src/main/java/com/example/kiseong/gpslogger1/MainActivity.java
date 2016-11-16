
package com.example.kiseong.gpslogger1;


import android.content.Intent;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;

/**
 * Created by kiseong on 2016-11-15.
 */
public class MainActivity extends AppCompatActivity {


    private Button button_start;
    private Button button_map;
    private TextView lat;
    private TextView lon;

    private GPS gps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_map = (Button) findViewById(R.id.button1);
        button_start = (Button) findViewById(R.id.button);
        lat = (TextView) findViewById(R.id.latitude);
        lon = (TextView) findViewById(R.id.longitude);

        gps = new GPS(MainActivity.this);

        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {


                if (gps.isGetLocation()) {

                    double Latitude = gps.getLatitude();
                    double Longitude = gps.getLongitude();

                    lat.setText((String.valueOf(Latitude)));
                    lon.setText((String.valueOf(Longitude)));

                    Toast.makeText(getApplicationContext(), "현재 위치는 \n위도:" + Latitude + "\n경도:" + Longitude, Toast.LENGTH_LONG).show();
                } else {
                    gps.showSettingsAlert();
                }


            }
        });
    }

        public void onClick(View v) {

            Intent it = new Intent(this,MapsActivity.class);
            startActivity(it);

/*
            // Create a Uri from an intent string. Use the result to create an Intent.
        Uri gmmIntentUri = Uri.parse("google.streetview:cbll=46.414382,10.013988");

// Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
// Make the Intent explicit by setting the Google Maps package
        mapIntent.setPackage("com.google.android.apps.maps");


        startActivity(mapIntent);
        */
        }

}




