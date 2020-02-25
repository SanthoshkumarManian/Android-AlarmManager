package in.dotworld.alarmmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    AlarmManager alarmManager;
    PendingIntent pendingIntent;
    Button btnStartAlarm,btnCancelAlarm;
    EditText Time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStartAlarm = findViewById(R.id.btnStartAlarm);
        btnCancelAlarm = findViewById(R.id.btnCancelAlarm);

        alarmManager=(AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent alarmIntent = new Intent(this, MyBroadCastReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(this, 0, alarmIntent, 0);

        btnStartAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAlarm();
            }
        });

        btnCancelAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelAlarm();
            }
        });

    }
    private void startAlarm() {
        Time=findViewById(R.id.time);
        int i=Integer.parseInt(Time.getText().toString());
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+(i*1000),10000,pendingIntent);
        Toast.makeText(getApplicationContext(),"Alarm Starting",Toast.LENGTH_SHORT).show();
    }

    private void cancelAlarm() {
        alarmManager.cancel(pendingIntent);
        Toast.makeText(getApplicationContext(), "Alarm Cancelled", Toast.LENGTH_SHORT).show();
        Intent intent =new Intent(getApplicationContext(),MyService.class);
        stopService(intent);
    }
}
