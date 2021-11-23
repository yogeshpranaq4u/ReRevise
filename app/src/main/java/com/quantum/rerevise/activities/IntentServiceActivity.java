package com.quantum.rerevise.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.quantum.rerevise.R;

import services.CashBackIntentService;

public class IntentServiceActivity extends AppCompatActivity {

    private static final String TAG="MainIntentActivity";
    TextView tv;
    EditText editText;
    Button btn;
    private CashbackReciver cashbackReciver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_activity);

         tv= findViewById(R.id.results);

         registerCashbackReceiver();
        Log.d(TAG, "onCreate: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
        unregisterReceiver(cashbackReciver);
        Log.d(TAG, "unregister: ");
    }

    public void startCashbackService(View view){
        editText = (EditText) findViewById(R.id.edit_text);

        Intent cbIntent =  new Intent();
        cbIntent.setClass(this, CashBackIntentService.class);
        cbIntent.putExtra("cashback_cat", editText.getText().toString());
        startService(cbIntent);
    }

    private void registerCashbackReceiver(){
        cashbackReciver = new CashbackReciver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(CashBackIntentService.CASHBACK_INFO);

        registerReceiver(cashbackReciver, intentFilter);
    }

    private class CashbackReciver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String cbinfo = intent.getStringExtra("cashback");
            tv.setText(cbinfo);
        }
    }
}
