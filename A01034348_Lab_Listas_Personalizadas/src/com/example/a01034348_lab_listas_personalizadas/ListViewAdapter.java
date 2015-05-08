package com.example.a01034348_lab_listas_personalizadas;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListViewAdapter extends ArrayAdapter<Libro> {

	private Context context;
	int layoutResourceId;
	List <Libro> listaLibros;
	public ListViewAdapter(Context context, int resource, List<Libro> libros){
		super (context, resource, libros);
		this.context=context;
		this.listaLibros=libros;
		this.layoutResourceId=resource;
	}
	
	public View getView(int position, View convertView, ViewGroup parent){
		View row =convertView;
		
		if (row==null){
			LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row=inflater.inflate(layoutResourceId, parent, false);
		}
		
		TextView titulo=(TextView)row.findViewById(R.id.titulo);
		TextView isbn=(TextView)row.findViewById(R.id.isbn);
		TextView fecha_publicacion=(TextView)row.findViewById(R.id.fecha_publicacion);
		ImageView libro_imagen =(ImageView)row.findViewById(R.id.imageView1);
		
		Libro libro=listaLibros.get(position);
		titulo.setText(libro.getTitulo());
		isbn.setText(libro.getIsbn());
		fecha_publicacion.setText(libro.getFecha_publicacion());
		libro_imagen.setImageResource(R.drawable.ic_launcher);
		
		return row;
	}
	
	
}
