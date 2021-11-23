package services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.Random;

public class BoundServices extends Service {
    private static final String TAG="Mainboundservice";

    private final IBinder binder=new LocalBinder();
    private final Random mGenerator = new Random();


    public class LocalBinder extends Binder {
        public BoundServices getService(){
            Log.d(TAG, "getService: ");
            return BoundServices.this;
        }
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind: ");
        return binder;
    }

    public int getRandomNumber(){
        return mGenerator.nextInt(100);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind: ");
        return super.onUnbind(intent);
    }
}
