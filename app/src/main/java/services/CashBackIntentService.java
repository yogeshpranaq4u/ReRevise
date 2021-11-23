package services;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;

public class CashBackIntentService extends IntentService {
    public static final String CASHBACK_INFO ="cashback_info" ;
    public static final String TAG ="MainintentService" ;
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public CashBackIntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        String cb_category = intent.getStringExtra("cashback_cat");

        String cbinfo = getCashbackInfo(cb_category);
        sendCashbackInfoToClient(cbinfo);
        Log.d(TAG, "onHandleIntent: "+cbinfo);

    }

    private String getCashbackInfo(String cbcat){
        String cashback;
        if("electronics".equals(cbcat)){
            cashback = "Upto 20% cashback on electronics";
        }else if("fashion".equals(cbcat)){
            cashback = "Upto 60% cashbak on all fashion items";
        }else{
            cashback = "All other categories except fashion and electronics, flat 30% cashback";
        }
        return cashback;
    }
    private void sendCashbackInfoToClient(String msg){
        Intent intent = new Intent();
        intent.setAction(CASHBACK_INFO);
        intent.putExtra("cashback",msg);
        Log.d(TAG, "sendCashbackInfoToClient: "+msg);
        sendBroadcast(intent);
    }
}
