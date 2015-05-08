package com.example.a01034348_lablistview2;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ListView miListView=(ListView)findViewById(R.id.listView1);
		
		final WebView miWebView=(WebView) findViewById(R.id.webView1);
		ProgressBar miprogressbar=(ProgressBar) findViewById(R.id.progressBar1);
		String[] colores=new String[]{ "Blue", "Yellow", "Red", "Black", "Green", "White","Black","Orange","Purple"};
		//Crear e inicializar lista colores
		final ArrayList<String> listaColores= new ArrayList<String>();
		//convertir arreglo de colores a una lista
		listaColores.addAll(Arrays.asList(colores));
		ArrayAdapter<String> listAdapter= new ArrayAdapter<String>(this,R.layout.row,listaColores);
		listAdapter.add("Pink");
		listAdapter.add("Brown");
		miListView.setAdapter(listAdapter);
		OnItemClickListener registroOnItemClickListener= new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				String color=listaColores.get(position);
				Toast.makeText(getApplicationContext(),color,Toast.LENGTH_SHORT).show();
				try{
					miWebView.loadUrl("http://www.floraphotographs.com/showrandomios.php?color="+color+"&session=100");
					
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}
	
		};
		miListView.setOnItemClickListener(registroOnItemClickListener);
		miWebView.getSettings().setBuiltInZoomControls(true);
		miWebView.getSettings().setUseWideViewPort(true);
		miWebView.getSettings().setLoadWithOverviewMode(true);
		miWebView.setInitialScale(1);
		miWebView.setWebViewClient(new WebViewClient());
		
		
	
	}
}
