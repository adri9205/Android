package com.example.a01034348_labacelerometro;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private TextView currentX, currentY, currentZ;
	SensorEventListener registro;
	SensorManager sensorManager;
	Sensor accelerometer;
	private long lastUpdate = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		currentX=(TextView) findViewById(R.id.textView1);
		currentY=(TextView) findViewById(R.id.textView2);
		currentZ=(TextView) findViewById(R.id.textView3);
		sensorManager=(SensorManager) getSystemService(Context.SENSOR_SERVICE);
		accelerometer=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		if (accelerometer!=null){
			registro= new SensorEventListener(){

				@Override
				public void onSensorChanged(SensorEvent event) {
					// TODO Auto-generated method stub
					Sensor mySensor=event.sensor;
					if (mySensor.getType()==Sensor.TYPE_ACCELEROMETER){
						long curTime=System.currentTimeMillis();
						if ((curTime-lastUpdate)>500){
							lastUpdate=curTime;
							float x=event.values[0];
							float y=event.values[1];
							float z=event.values[2];
							
							currentX.setText("X: "+ x);
							currentY.setText("Y: "+ y);
							currentZ.setText("Z: "+ z);
							
						}
						
					}
				}

				@Override
				public void onAccuracyChanged(Sensor sensor, int accuracy) {
					// TODO Auto-generated method stub
					
				}
				
			};
			sensorManager.registerListener(registro, accelerometer,SensorManager.SENSOR_DELAY_NORMAL);
			
			
			
		}
		else{
			Toast.makeText(this, "Failed device doesn't have accelerometer", Toast.LENGTH_LONG).show();;
		
		}
		
	}
	protected void onPause() {
	    super.onPause();
	    sensorManager.unregisterListener(registro);
	}
	protected void onResume() {
	    super.onResume();
	    sensorManager.registerListener(registro, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
	}
	
}
