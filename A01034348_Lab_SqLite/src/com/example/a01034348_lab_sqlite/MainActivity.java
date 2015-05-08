package com.example.a01034348_lab_sqlite;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	TextView peliculaID;
	EditText nameBox;
	EditText quantityBox;
    PeliculaOperations dao;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		dao=new PeliculaOperations(this);
		dao.open();
		peliculaID=(TextView) findViewById(R.id.productTV);
		nameBox=(EditText) findViewById(R.id.productName);
		quantityBox=(EditText) findViewById(R.id.productQuantity);
		Button add=(Button) findViewById(R.id.addb);
		Button find=(Button) findViewById(R.id.findb);
		Button delete=(Button) findViewById(R.id.deleteb);
		Button clear=(Button) findViewById(R.id.clearb);
		OnClickListener registro= new OnClickListener(){
			public void onClick(View v){
				switch(v.getId()){
				case R.id.addb:
				newPelicula(v);
				break;
				case R.id.deleteb:
				removePelicula(v);
				break;
				case R.id.findb:
				searchPelicula(v);
				break;
				case R.id.clearb:
					nameBox.setText("");
					quantityBox.setText("");
					peliculaID.setText("");
					
					break;
				}
			}
		};
		add.setOnClickListener(registro);
		delete.setOnClickListener(registro);
		find.setOnClickListener(registro);
		clear.setOnClickListener(registro);
	}
	public void newPelicula(View view){
	int quantity=Integer.parseInt(quantityBox.getText().toString());
	String name=nameBox.getText().toString();
	Pelicula pelicula=new Pelicula(name, quantity);
	dao.addPelicula(pelicula);
	Toast.makeText(getApplicationContext(),	"Product added", Toast.LENGTH_SHORT).show();
	nameBox.setText("");
	quantityBox.setText("");
	}
	public void searchPelicula(View view){
		String name=nameBox.getText().toString();
		Pelicula pelicula= dao.findPelicula(name);
		if (pelicula!=null){
			peliculaID.setText(String.valueOf(pelicula.getID()));
			quantityBox.setText(String.valueOf(pelicula.getRanking()));
			
		}
		else{
			Toast.makeText(getApplicationContext(), "No Match Found", Toast.LENGTH_SHORT).show();
			peliculaID.setText("No Match Found");
		}
	}
	
	public void removePelicula(View view){
		String name=nameBox.getText().toString();
		boolean result=dao.deletePelicula(name);
		if (result){
			peliculaID.setText("Record Deleted");
			nameBox.setText("");
			quantityBox.setText("");
			
		}
		else{
			Toast.makeText(getApplicationContext(), "No Match Found", Toast.LENGTH_SHORT).show();
			peliculaID.setText("No Match Found");
		}
		
	}
	protected void onResume(){
		dao.open();
		super.onResume();
	}
	protected void onPause(){
		dao.close();
		super.onPause();
	}
}
