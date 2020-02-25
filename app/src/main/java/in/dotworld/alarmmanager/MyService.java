package in.dotworld.alarmmanager;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import java.util.concurrent.FutureTask;

public class MyService extends Service {

    int notify_id=1;
    private NotificationManager notificationManager;
    Notification notification;
    private final String CHANNEL_ID="Alarm";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

        notificationManager= (NotificationManager) getApplicationContext().getSystemService(NOTIFICATION_SERVICE);

        notification = new NotificationCompat.Builder(this,CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Alarm")
                .setContentText("Ringing Alarm")
                .setContentIntent(pendingIntent)
                .build();

            notificationManager.notify(notify_id,notification);
          //  startForeground(1, notification);
//          this.stopSelf();
            return START_STICKY;

    }

    @Override
    public void onDestroy() {

        super.onDestroy();

    }
}
