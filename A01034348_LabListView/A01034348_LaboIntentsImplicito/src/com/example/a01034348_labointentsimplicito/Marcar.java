package com.example.a01034348_labointentsimplicito;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Marcar extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_marcar);
		final Button marcar=(Button)findViewById(R.id.botonMarca);
		final EditText numeroTel=(EditText)findViewById(R.id.telefono);
		OnClickListener registro=new OnClickListener(){
			public void onClick (View view){
			String tel=numeroTel.getText().toString();
			Uri uri=Uri.parse(tel);
			try{Intent intent=new Intent(android.content.Intent.ACTION_DIAL,uri);
			startActivity(intent);
			} catch(ActivityNotFoundException e){
			Toast.makeText(getApplicationContext(), "No se puede realizar llamada",(int)5.0).show();}
		}
			};
			marcar.setOnClickListener(registro);
	}
}