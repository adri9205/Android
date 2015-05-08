package com.example.a01034348_laboexamen;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class PruebaIntent extends Activity {
String paisseleccionado;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_prueba_intent);
		ListView miListView=(ListView)findViewById(R.id.listView2);
		final Button botonCancel=(Button)findViewById(R.id.cancellb);
		final Button botonDone=(Button)findViewById(R.id.doneeb);
		final EditText nombreET=(EditText)findViewById(R.id.nombrettf);
		final EditText emailET=(EditText) findViewById(R.id.emailttf);
		final Button botonSalir=(Button)findViewById(R.id.salirbuttons);
		String[] pais=new String[]{"Argentina", "Brazil","Ecuador", "Germany","Japan", "Mexico","Netherlands", "Russia", "United States"};
		//final ArrayList<String> ListaPais= new ArrayList<String>();
		//ListaPais.addAll(Arrays.asList(pais));
		//ArrayAdapter<String> listAdapter= new ArrayAdapter<String>(this,R.layout.row,ListaPais);
		//miListView.setAdapter(listAdapter);
		
		final OnClickListener registroListener = new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent intent =new Intent (PruebaIntent.this, AccesoPerfil.class);
	       		startActivity(intent);
				
			}
			
		};
		botonSalir.setOnClickListener(registroListener);
		/*
		OnItemClickListener registroOnItemClickListener4= new OnItemClickListener(){

			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				 paisseleccionado=ListaPais.get(position);
				
			}
	
		};
		miListView.setOnItemClickListener(registroOnItemClickListener4);
		*/
		final OnClickListener registroListener2 = new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//ArrayAdapter<String> listAdapter= new ArrayAdapter<String>(this,R.layout.row,listapais);
				//miListView.setAdapter(listAdapter);
				String nom=nombreET.getText().toString();
				String mail=emailET.getText().toString();
				Intent intent =new Intent (PruebaIntent.this, AccesoPerfil.class);
				intent.putExtra("nombre", nom);
				intent.putExtra("email", mail);
			//	intent.putExtra("pais", paisseleccionado);
	       		startActivity(intent);
				
			}
			
		};
		botonDone.setOnClickListener(registroListener2);
		
		final OnClickListener registroListener3 = new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			Intent intent =new Intent (PruebaIntent.this, MainActivity.class);
	       	startActivity(intent);
				
			}
			
		};
		botonCancel.setOnClickListener(registroListener3);
	}
}
