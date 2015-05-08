package com.example.a01034348_lab_listas_personalizadas;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class ListaActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista);
		ListView miListView =(ListView) findViewById(R.id.listView1);
		final ListViewAdapter miAdaptador= new ListViewAdapter(getApplicationContext(), R.layout.row,getDataForListView());
		
		miListView.setAdapter(miAdaptador);
		
		
		OnItemClickListener registro = new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				Libro perfil=(Libro)miAdaptador.getItem(arg2);
				Toast.makeText(ListaActivity.this,perfil.titulo, Toast.LENGTH_LONG).show();
				
				// TODO Auto-generated method stub
				
			}
			
		};
		miListView.setOnItemClickListener(registro);
			}

		
	public List<Libro> getDataForListView(){
		
		Libro libro;
		List<Libro> listLibros= new ArrayList<Libro>();
		libro= new Libro("ios programming cookbook", "9780470918029","23/01/2010");
		listLibros.add(libro);
		libro= new Libro("Beginning ios 4 Application Development", "9781479211418","10/08/2011");
		listLibros.add(libro);
		libro= new Libro("ios 7 Application Development in 24 Hours", "9781449372422","25/03/2014");
		listLibros.add(libro);
		return listLibros;
	}
	
	
	
}
