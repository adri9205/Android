package com.example.a01034348_labnotificaciones;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	Button iniciar, cancelar;
	int numMessages;
	Uri soundUri=Uri.parse("android.resource://com.example.a01034348_labnotificaciones/"+R.raw.rooster_alarm);
	NotificationManager notificationManager; 
	Intent notificationIntent;
	PendingIntent pendingIntent;
	int MY_NOTIFICATION_ID=001;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		iniciar=(Button)findViewById(R.id.button1);
		cancelar=(Button)findViewById(R.id.button2);
		iniciar.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				NotificationCompat.Builder notificacionBuilder= new NotificationCompat.Builder(getApplicationContext());
				notificacionBuilder.setContentTitle("New Notification");
				notificacionBuilder.setContentText("You've received new notification. "+"("+ ++numMessages +")");
				notificacionBuilder.setTicker("New Notification Alert!");
				notificacionBuilder.setSmallIcon(android.R.drawable.stat_sys_warning);
				notificacionBuilder.setSound(soundUri);
				notificacionBuilder.setContentIntent(pendingIntent);
				notificationManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
				notificationManager.notify(MY_NOTIFICATION_ID,notificacionBuilder.build());
				notificationIntent=new Intent(getApplicationContext(),NotificationSubActivity.class);
				pendingIntent.getActivity(getApplicationContext(),0,notificationIntent,Intent.FLAG_ACTIVITY_NEW_TASK);
				
				
				
				
				
			}
			
		});
		
		cancelar.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				notificationManager.cancel(MY_NOTIFICATION_ID);
				
				
			}
			
		});
		
	}
}
