package in.dotworld.alarmmanager;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.icu.util.TimeZone;
import android.net.ConnectivityManager;
import android.util.Log;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import static androidx.legacy.content.WakefulBroadcastReceiver.startWakefulService;

public class MyBroadCastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.getAction()!=null && intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {

           /* Intent intent1=new Intent(context,MainActivity.class);
            context.startActivity(intent1);*/
            //ContextCompat.startForegroundService(context,intent1);
           /* ComponentName comp = new ComponentName(context.getPackageName(), MyService.class.getName());
            startWakefulService(context, (intent.setComponent(comp)));*/
            Toast.makeText(context,"boot completed",Toast.LENGTH_LONG).show();
            Log.v("MyBroadCastReceiver", "Service loaded at start");
        }/*else {
            Intent intent1=new Intent(context,MyService.class);
            context.startService(intent1);
            Log.i("MyBroadCastReceiver", String.valueOf(System.currentTimeMillis()/1000));

        }*/
        if(ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction()))
        {
            Toast.makeText(context,"Connection changed",Toast.LENGTH_LONG).show();
            Log.v("MyBroadCastReceiver", "Connection changed");
        }

    }
}
