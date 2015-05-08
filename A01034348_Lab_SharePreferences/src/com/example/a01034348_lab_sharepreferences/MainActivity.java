package com.example.a01034348_lab_sharepreferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	private SharedPreferences.Editor editor;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final EditText nombre= (EditText) findViewById(R.id.nombreET);
		final EditText email= (EditText) findViewById(R.id.emailET);
		final String MY_PREFS="MisPreferencias";
		final SharedPreferences prefs=getSharedPreferences(MY_PREFS,Activity.MODE_PRIVATE);
		Button save=(Button) findViewById(R.id.button1);
		Button clear=(Button) findViewById(R.id.button2);
		//final SharedPreferences.Editor editor;
		OnClickListener registro = new OnClickListener(){
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				editor=prefs.edit();
				editor.putString("nombre", nombre.getText().toString());
				editor.putString("email", email.getText().toString());
				editor.commit();
				Toast.makeText(MainActivity.this, "Se han guardado los datos", Toast.LENGTH_LONG).show();
				
				
			}
			
		};
		save.setOnClickListener(registro);
		nombre.setText(prefs.getString("nombre", ""));
		email.setText(prefs.getString("email", ""));
		OnClickListener registro2 = new OnClickListener(){
			//private SharedPreferences.Editor editor;
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				editor=prefs.edit();
				editor.remove("nombre");
				editor.remove("email");
				editor.commit();
				
			}
			
		};
		clear.setOnClickListener(registro2);
	}
}
