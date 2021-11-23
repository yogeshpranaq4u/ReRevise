package com.quantum.rerevise.activities;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.quantum.rerevise.R;

import services.BoundServices;

public class BindingActivity extends AppCompatActivity {
    private static final String TAG="MainBindingActivity";

    BoundServices boundServices;
    boolean mBound=false;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.binding_activity);
        Log.d(TAG, "onCreate: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");

        Intent intent=new Intent(BindingActivity.this, BoundServices.class);
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");

        unbindService(connection);
        Log.d(TAG, "unBind: "+connection);
        mBound=false;
    }

    public void onButtonClick(View view) {
        if (mBound) {
            // Call a method from the LocalService.
            // However, if this call were something that might hang, then this request should
            // occur in a separate thread to avoid slowing down the activity performance.
            int num = boundServices.getRandomNumber();
            Log.d(TAG, "onButtonClick: "+num);
            Toast.makeText(this, "number: " + num, Toast.LENGTH_SHORT).show();
        }
    }

    private ServiceConnection connection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            BoundServices.LocalBinder binder=(BoundServices.LocalBinder) service;
            boundServices=binder.getService();
            mBound=true;
            Log.d(TAG, "onServiceConnected: "+boundServices);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mBound=false;
        }
    };
}
