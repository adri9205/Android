package com.example.a01034348_laboratoriologin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Acceso extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_acceso);
		final TextView usernameTV=(TextView) findViewById(R.id.username);
		final TextView username2TV=(TextView) findViewById(R.id.username1);
		final TextView passwordTV=(TextView) findViewById(R.id.password);
		final Button salirButton=(Button) findViewById(R.id.salir1);
		Bundle datos= getIntent().getExtras();
		if (datos!=null){
			String usernameString=datos.getString("username");
			String passwordString=datos.getString("password");
			usernameTV.setText(usernameString);
			username2TV.setText(usernameString);
			passwordTV.setText(passwordString);
			
		}
		
		final OnClickListener registroListener = new OnClickListener(){
			
			public void onClick(View v) {
				Intent intent=new Intent(Acceso.this,Login.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	             startActivity(intent);
	              
				
				
			}
		};
		salirButton.setOnClickListener(registroListener);
	}
}
