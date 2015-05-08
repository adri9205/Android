package com.example.a01034348_labointentsimplicito;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Mapa extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mapa);
		final Button direccionboton=(Button)findViewById(R.id.botonMapas);
		final EditText dir=(EditText)findViewById(R.id.direccion);
		OnClickListener registro=new OnClickListener(){
			public void onClick (View view){
				String direccionStr=dir.getText().toString();
				direccionStr=direccionStr.replace(' ', '+');
				Uri uri=Uri.parse("geo:0,0?q="+direccionStr+"?z=10");
				Intent intent=new Intent(Intent.ACTION_VIEW);
				intent.setData(uri);
				if (intent.resolveActivity(getPackageManager())!=null){
					startActivity(intent);
				}
					}
			};
			direccionboton.setOnClickListener(registro);
	}
}
/*
 * public class Mapa extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mapa);
		public void onClick(View arg 0){
			String direccionStr=direccion.getText().toString();
			direccionStr=direccionStr.replace(' ', '+');
			Uri uri=Uri.parse("geo:0,0?q="+direccionStr+"?z=10");
			Intent intent=new Intent(Intent.ACTION_VIEW);
			intent.setData(uri);
			if (intent.resolveActivity(getPackageManager())!=null){
				startActivity(intent);
			}
		}
	}
}

 * 
 * */
 