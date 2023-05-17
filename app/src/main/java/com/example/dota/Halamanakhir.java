package com.example.dota;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Halamanakhir extends AppCompatActivity {

    Button quit;
    Button notif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halamanakhir);


        Bundle data = getIntent().getExtras();
        String user = data.getString("USER");

        TextView salam = findViewById(R.id.salam);
        salam.setText("Selamat Datang "+ user);


        quit = (Button) findViewById(R.id. quit );
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {quitDiklik();
            }
        });

        notif = (Button) findViewById(R.id. notif);
        notif.setOnClickListener(view -> {
                    Intent intent = new Intent(this, Halamanakhir.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                    PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),0, intent, PendingIntent.FLAG_ONE_SHOT);

                    Uri defaultUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "CH1")
                            .setSmallIcon(R.drawable.ic_launcher_foreground)
                            .setContentTitle("My notification")
                            .setContentText("Mweheheheheheeee!!!")
                            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                            // Set the intent that will fire when the user taps the notification
                            .setContentIntent(pendingIntent)
                            .setSound(defaultUri)
                            .setAutoCancel(true);

                    NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                        NotificationChannel channel = new NotificationChannel( "CH1", "Ada Notif Nih", NotificationManager.IMPORTANCE_DEFAULT);
                        notificationManager.createNotificationChannel(channel);
                    }
                    notificationManager.notify(0, builder.build());


                }
                );


}
    public void quitDiklik() {
        Intent MainActivity=new Intent(this, MainActivity.class);
        startActivity(MainActivity);
    }
}