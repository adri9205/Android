package com.example.a01034348_laboexamen;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class Agregar extends Activity {

	String paisseleccionado;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_agregar);
		ListView miListView=(ListView)findViewById(R.id.listView1);
	
		final Button botonCancel=(Button)findViewById(R.id.cancelb);
		final Button botonDone=(Button)findViewById(R.id.doneb);
		final EditText nombreET=(EditText)findViewById(R.id.nombretf);
		final EditText emailET=(EditText) findViewById(R.id.emailtf);
		//final EditText paisET=(EditText)findViewById(R.id.paistf);
		final TextView username2TV=(TextView) findViewById(R.id.textView2);
		final Button botonSalir=(Button)findViewById(R.id.salirbutton);
		final ArrayList<String> listapais= new ArrayList<String>();
		String[] pais=new String[]{"Argentina", "Brazil", "Ecuador", "Germany", "Japan", "Mexico","Netherlands", "Russia", "United_States"};
		String[] colores=new String[]{ "Blue", "Yellow", "Red", "Black", "Green","White","Black","Orange","Purple","Magenta"};
		listapais.addAll(Arrays.asList(pais));
		ArrayAdapter<String> listAdapter= new ArrayAdapter<String>(this,R.layout.row, listapais);
		//R.id.textView1list
		miListView.setAdapter(listAdapter);
		Bundle datos= getIntent().getExtras();
		if (datos!=null){
			String usernameString=datos.getString("username");
			username2TV.setText(usernameString);	
		}
		
		/*
		 * final ArrayList<String> listaColores= new ArrayList<String>();
		//convertir arreglo de colores a una lista
		listaColores.addAll(Arrays.asList(colores));
		ArrayAdapter<String> listAdapter= new ArrayAdapter<String>(this,R.layout.row,listaColores);
		listAdapter.add("Pink");
		listAdapter.add("Brown");
		miListView.setAdapter(listAdapter);
		 * 
		 * */
		
		
		final OnClickListener registroListener = new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent intent =new Intent (Agregar.this, AccesoPerfil.class);
				String usuario=username2TV.getText().toString();
		    	 
	       		intent.putExtra("username", usuario);
	       		startActivity(intent);
				
			}
			
		};
		botonSalir.setOnClickListener(registroListener);
		
		OnItemClickListener registroOnItemClickListener4= new OnItemClickListener(){

			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				 paisseleccionado=listapais.get(position);
				
			}
	
		};
		miListView.setOnItemClickListener(registroOnItemClickListener4);
		
		final OnClickListener registroListener2 = new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//ArrayAdapter<String> listAdapter= new ArrayAdapter<String>(this,R.layout.row,listapais);
				//miListView.setAdapter(listAdapter);
				String nom=nombreET.getText().toString();
				String mail=emailET.getText().toString();
				Intent intent =new Intent (Agregar.this, AccesoPerfil.class);
				intent.putExtra("nombre", nom);
				intent.putExtra("email", mail);
				intent.putExtra("pais", paisseleccionado);
				String usuario=username2TV.getText().toString();
		    	 
	       		intent.putExtra("username", usuario);
	       		startActivity(intent);
				
			}
			
		};
		botonDone.setOnClickListener(registroListener2);
		
		final OnClickListener registroListener3 = new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			Intent intent =new Intent (Agregar.this, MainActivity.class);
	       	startActivity(intent);
				
			}
			
		};
		botonCancel.setOnClickListener(registroListener3);

	}
}
