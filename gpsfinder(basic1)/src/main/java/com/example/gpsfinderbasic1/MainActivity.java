package com.example.gpsfinderbasic1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button_start;
    private TextView lat;
    private TextView lon;

    private GPS gps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_start = (Button)findViewById(R.id.button);
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
}
