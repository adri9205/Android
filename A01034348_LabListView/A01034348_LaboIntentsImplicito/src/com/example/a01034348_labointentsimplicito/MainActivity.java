package com.example.a01034348_labointentsimplicito;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button foto=(Button) findViewById(R.id.tomarFotoBotonId);
		Button emailButton=(Button) findViewById(R.id.boton_email);
		Button mapButton=(Button)findViewById(R.id.boton_mapa);
		Button marcarButton=(Button)findViewById(R.id.boton_llamada);
		Button accesoaWebButton=(Button)findViewById(R.id.boton_web);
		
		OnClickListener registro= new OnClickListener(){
			public void onClick(View v){
				Intent intent= new Intent(MainActivity.this, Foto.class);
				startActivity(intent);
			}
		};
		
		foto.setOnClickListener(registro);
		
		OnClickListener registro1= new OnClickListener(){
			public void onClick(View v){
				Intent intent= new Intent(MainActivity.this, Email.class);
				startActivity(intent);
			}
		};
		
		emailButton.setOnClickListener(registro1);
		
		OnClickListener registro2= new OnClickListener(){
			public void onClick(View v){
				Intent intent= new Intent(MainActivity.this, Mapa.class);
				startActivity(intent);
			}
		};
		
		mapButton.setOnClickListener(registro2);
		
		OnClickListener registro3= new OnClickListener(){
			public void onClick(View v){
				Intent intent= new Intent(MainActivity.this, Marcar.class);
				startActivity(intent);
			}
		};
		
		marcarButton.setOnClickListener(registro3);
		
		OnClickListener registro4= new OnClickListener(){
			public void onClick(View v){
				Intent intent= new Intent(MainActivity.this, Web.class);
				startActivity(intent);
			}
		};
		
		accesoaWebButton.setOnClickListener(registro4);
	}
}
