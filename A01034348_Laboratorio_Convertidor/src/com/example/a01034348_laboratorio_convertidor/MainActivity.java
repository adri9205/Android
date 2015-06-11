package com.example.a01034348_laboratorio_convertidor;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final EditText text=(EditText) findViewById(R.id.valorET);
		final EditText textKM=(EditText) findViewById(R.id.kmET);
		final Button boton= (Button) findViewById(R.id.convertir);
		//String v1=textKM.getText().toString();
	   // final Double valor=Double.parseDouble(v1);
		final RadioButton botonPulgadas = (RadioButton) findViewById(R.id.rPulgadas);
        final RadioButton botonMillas = (RadioButton) findViewById(R.id.rMillas);
        final RadioButton botonMetros = (RadioButton) findViewById(R.id.rMetros);

		final OnClickListener registroListener = new OnClickListener(){
			
	    	
	       	@Override
	       	public void onClick(View v) {
	       		
	       	 	         
	     	InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(textKM.getWindowToken(),0); 
	        if (botonPulgadas.isChecked()){
	        	
		    	//botonMillas.setChecked(false);
		    	//botonMetros.setChecked(false);
	        	String total= Double.toString(UtileriaConvertidor.convertirKM_pulgadas(Double.parseDouble(textKM.getText().toString())));
	        	//String total= Double.toString(valor*.32);
	        	
	    	   	text.setText(total+" pulgadas...");
	    		
	        	}
	          if (botonMillas.isChecked()){
	        	  //botonPulgadas.setChecked(false);
	  	    	
	  	    	//botonMetros.setChecked(false);
             String total2= Double.toString(UtileriaConvertidor.convertirKM_millas(Double.parseDouble(textKM.getText().toString())));
	       		//String total2= Double.toString(valor*.32);
	        	
	    	   	text.setText(total2+" millas...");
	    		
	    	   	
	    	   	}
	       	if (botonMetros.isChecked()){
	       		//botonPulgadas.setChecked(false);
		    	//botonMillas.setChecked(false);
		    	
             String total3= Double.toString(UtileriaConvertidor.convertirKM_metros(Double.parseDouble(textKM.getText().toString())));
	       	//	String total3= Double.toString(valor*.32);
	        	
	       		text.setText(total3+" metros...");
	       		
	       	
	       		} 
	      	botonPulgadas.setChecked(false);
	    	botonMillas.setChecked(false);
	    	botonMetros.setChecked(false);
	       	}
	       	
	       	};
	    	boton.setOnClickListener(registroListener);
	    	
	  
	    }
		
	}

