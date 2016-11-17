package com.example.gpsfinderbasic1;

import android.net.Uri;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.maps.GoogleMap;


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

        button_start = (Button)findViewById(R.id.button);
        button_map = (Button)findViewById(R.id.button1) ;

        lat = (TextView)findViewById(R.id.latitude);
        lon = (TextView)findViewById(R.id.longitude);

        button_start.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0){
                gps = new GPS(MainActivity.this);

                if(gps.isGetLocation()) {

                    double Latitude = gps.getLatitude();
                    double Longitude = gps.getLongitude();

                    lat.setText((String.valueOf(Latitude)));
                    lon.setText((String.valueOf(Longitude)));

                    Toast.makeText(getApplicationContext(), "현재 위치는 \n위도:" + Latitude + "\n경도:" + Longitude, Toast.LENGTH_LONG).show();
                } else {
                    gps.showSettingsAlert();
                }
            }
        }
        );
    }

    public void onClick(View v){
        Intent mapintent = new Intent(this, MAPVIEW.class);
        startActivity(mapintent);
    }
}
