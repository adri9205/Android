package com.example.a01034348_lab_menus;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends Activity {

	
	String[] paises=new String[]{"Alemania","Inglaterra","México","USA","Rusia" };
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ListView miListView=(ListView)findViewById(R.id.listView1);
		//Crear e inicializar lista colores
		final ArrayList<String> listaColores= new ArrayList<String>();
		listaColores.addAll(Arrays.asList(paises));
		ArrayAdapter<String> listAdapter= new ArrayAdapter<String>(this,R.layout.row,listaColores);
		miListView.setAdapter(listAdapter);
		registerForContextMenu(miListView);
		Button boton=(Button) findViewById(R.id.button1);
		final PopupMenu popupMenu=new PopupMenu(this, boton);
		OnClickListener registro = new OnClickListener(){
			public void onClick(View v){
				popupMenu.show();
			}
		};
		
		boton.setOnClickListener(registro);
		PopupMenu.OnMenuItemClickListener registroItem=new PopupMenu.OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				// TODO Auto-generated method stub
				switch(item.getItemId()){
				case R.id.menu_save:
					Toast.makeText(MainActivity.this, "Save is Selected", Toast.LENGTH_SHORT).show();
					return true;
				
				case R.id.menu_search:
					Toast.makeText(MainActivity.this, "Search is Selected", Toast.LENGTH_SHORT).show();
					return true;
				case R.id.menu_preferences:
					Toast.makeText(MainActivity.this, "Preferences is Selected", Toast.LENGTH_SHORT).show();
					return true;

			}
				return true;
				}
		};
	
	}
	//Métodos independientes 
	public boolean onCreateOptionsMeny(Menu menu){
		MenuInflater menuInflater=getMenuInflater();
		menuInflater.inflate(R.menu.menu_uno, menu);
		
		return true;
		
	}
	
	public boolean onOptionsItemSelected(MenuItem item){
		switch(item.getItemId()){
		case R.id.menu_save:
			Toast.makeText(MainActivity.this, "Save is Selected", Toast.LENGTH_SHORT).show();
			return true;
		
		case R.id.menu_search:
			Toast.makeText(MainActivity.this, "Search is Selected", Toast.LENGTH_SHORT).show();
			return true;
		case R.id.menu_preferences:
			Toast.makeText(MainActivity.this, "Preferences is Selected", Toast.LENGTH_SHORT).show();
			return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}
	
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo){
		super.onCreateContextMenu(menu, v, menuInfo);
		getMenuInflater().inflate(R.menu.menu_uno, menu);
	}
	
	public boolean onContextItemSelected(MenuItem item){
		AdapterContextMenuInfo info=(AdapterContextMenuInfo) item.getMenuInfo();
		
		
		switch(item.getItemId()){
		case R.id.menu_save:
			Toast.makeText(this, "Save :"+ paises[info.position], Toast.LENGTH_SHORT).show();
			break;
		
		case R.id.menu_search:
			Toast.makeText(this, "Search :"+paises[info.position], Toast.LENGTH_SHORT).show();
			break;
		case R.id.menu_preferences:
			Toast.makeText(this, "Preferences :"+paises[info.position], Toast.LENGTH_SHORT).show();
			break;
	}
		return true;
		
	}
}
