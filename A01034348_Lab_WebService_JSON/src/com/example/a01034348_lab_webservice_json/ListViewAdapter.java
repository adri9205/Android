package com.example.a01034348_lab_webservice_json;

import java.text.DecimalFormat;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ListViewAdapter extends ArrayAdapter<Clima> {
	private Context context;
	int layoutResourceId;
	List <Clima> listaForecast;
	public ListViewAdapter (Context context, int resource, List<Clima> listaForecast){
		super(context,resource,listaForecast);
		this.context=context;
		this.listaForecast=listaForecast;
		this.layoutResourceId=resource;
	}
	
	public View getView(int position, View convertView, ViewGroup parent){
		View row= convertView;
		//convertView->vista a reusar, si es nulo se crea
		if (row==null){
			LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row=inflater.inflate(layoutResourceId, parent, false);
		}
		
		TextView temp=(TextView)row.findViewById(R.id.temp);
		TextView tempMin=(TextView)row.findViewById(R.id.temp_min);
		TextView tempMax=(TextView)row.findViewById(R.id.temp_max);
		
		Clima clima=listaForecast.get(position);
		DecimalFormat df=new DecimalFormat("#.##");
		temp.setText(String.valueOf(df.format(clima.getTemp())));
		tempMin.setText(String.valueOf(df.format(clima.getTemp_min())));
		tempMax.setText(String.valueOf(df.format(clima.getTemp_max())));
		
		
		return row;
	}
}
