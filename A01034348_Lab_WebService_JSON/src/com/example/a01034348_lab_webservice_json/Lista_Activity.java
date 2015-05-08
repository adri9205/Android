package com.example.a01034348_lab_webservice_json;

import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Lista_Activity extends Activity {
	List<Clima> climas;
	ListView miListView;
	ListViewAdapter miAdaptador;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista_);
		miListView= (ListView) findViewById(R.id.lista_libros);
		String urlString= "http://api.openweathermap.org/data/2.5/forecast?lat=25.67&lon=-100.32";
		OnItemClickListener registro= new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				Clima clima= (Clima) miAdaptador.getItem(arg2);
				Toast.makeText(Lista_Activity.this, String.valueOf(clima.getTemp()), Toast.LENGTH_LONG).show();
				
			}
			
		};
		
		miListView.setOnItemClickListener(registro);
		new GetClimaData(Lista_Activity.this).execute(urlString);
	}
	
	public class GetClimaData extends AsyncTask<String, Void, JSONObject>{
		private ProgressDialog dialog;
		Context context;
		public GetClimaData(Context context){
			this.context = context;
		}
		@Override
		protected JSONObject doInBackground(String... urls) {
			ClimaServiceCall jsonObject = new ClimaServiceCall();
			JSONObject json;
			
			try{
				json =jsonObject.getJSONFromUrl(urls[0]);
				return json;
				} catch(SocketException e){
					e.printStackTrace();
				}
			
			return null;
		}
		
		protected void onPreExecute(){
			super.onPreExecute();
			dialog= new ProgressDialog(this.context);
			dialog.setMessage("Connecting...");
			dialog.setCancelable(false);
			dialog.show();
		}
		
		protected void onPostExecute(JSONObject json){
			climas= new ArrayList<Clima>();
			String ciudad =null;
			String pais=null;
			JSONArray dataJsonArray=null;
			JSONObject dataJsonObject=null;
			try{
				dataJsonObject=json.getJSONObject("city");
				ciudad=dataJsonObject.getString("name");
				pais=dataJsonObject.getString("country");
				dataJsonArray=json.getJSONArray("list");
				for(int i=0;i<dataJsonArray.length(); i++){
					JSONObject c=dataJsonArray.getJSONObject(i);
					JSONObject c1=c.getJSONObject("main");
					double temp=c1.getDouble("temp")-273.15;
					double temp_min=c1.getDouble("temp_min")-273.15;
					double temp_max=c1.getDouble("temp_max")-273.15;
					
					Clima clima =new Clima(temp, temp_min, temp_max);
					climas.add(clima);
				}
				
			}catch(JSONException e){
			e.printStackTrace();	
			}
			
			miAdaptador=new ListViewAdapter(this.context,R.layout.row,climas);
			miListView.setAdapter(miAdaptador);
			TextView ciudadTV=(TextView)findViewById(R.id.titulo_lista);
			ciudadTV.setText("Pronóstico de temperatura de " +ciudad+","+pais);
			if (dialog.isShowing()){
				dialog.dismiss();
			}
		
			
		}
		
		protected void onProgressUpdate(Void...values){
			super.onProgressUpdate(values);
			//new GetClima(Lista_Activity.this).execute(urlString);
		}
	//	new GetClima(Lista_Activity.this).execute(urlString);
	}
	//new GetClima(Lista_Activity.this).execute(urlString);
}
