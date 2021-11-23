package com.quantum.rerevise.activities;

import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.quantum.rerevise.R;

import services.Services;

public class ServiceActivity extends AppCompatActivity {
    private static final String TAG="MainActivityService";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_activity);
        Log.d(TAG, "onCreate: ");

        findViewById(R.id.start_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

                        for(int i=0;i<=10;i++) {
                             startForegroundService(new Intent(ServiceActivity.this,Services.class));
                        }
                        Log.d(TAG, "Above O Service: ");
                    }
                    else{
                        startService(new Intent(ServiceActivity.this,Services.class));
                        Log.d(TAG, "Below O service: ");
                    }

            }
        });

        findViewById(R.id.stop_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(ServiceActivity.this,Services.class));
                Log.d(TAG, "Service Stop: ");
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }
}
