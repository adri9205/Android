package com.example.a01034348_laboexamen;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final TextView usernameTV=(TextView) findViewById(R.id.UsernameTF);
		final ImageButton login=(ImageButton) findViewById(R.id.imageButton1);
		final Button botonhelp=(Button)findViewById(R.id.HelpB);
final OnClickListener registroListener = new OnClickListener(){
			
	    	
	       	@Override
	       	public void onClick(View v) {
	       		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(usernameTV.getWindowToken(),0); 
	       			if(usernameTV.getText().toString().equals("android") || 
	       			usernameTV.getText().toString().equals("topico")||usernameTV.getText().toString().equals("futbol")||usernameTV.getText().toString().equals("Android") || 
	       			usernameTV.getText().toString().equals("Topico")||usernameTV.getText().toString().equals("Futbol")||usernameTV.getText().toString().equals("ANDROID") || 
	       			usernameTV.getText().toString().equals("TOPICO")||usernameTV.getText().toString().equals("FUTBOL")){
	       				Toast.makeText(getApplicationContext(), "Redireccionando...", 
	       				     Toast.LENGTH_SHORT).show();
	       				Intent intent =new Intent (MainActivity.this, AccesoPerfil.class);
	    	       		String usuario=usernameTV.getText().toString();
	    	       
	    	       		intent.putExtra("username", usuario);
	    	       	
	    	       		startActivity(intent);
	       			
	       			}else{
	       				Toast.makeText(getApplicationContext(), "Has ingresado mal el username, intenta de nuevo...", 
	       				      Toast.LENGTH_SHORT).show();}}
	};
	login.setOnClickListener(registroListener);
	       				      
	final OnClickListener registroListener2 = new OnClickListener(){
		
    	
       	@Override
       	public void onClick(View v) {
       		String[] TO={"msordia@gmail.com"};
			String[] CC={"adri925@hotmail.com"};
			Intent emailIntent=new Intent(Intent.ACTION_SEND);
			
			emailIntent.putExtra(Intent.EXTRA_STREAM,Uri.parse("android.resource://"+getPackageName()+"/"+R.drawable.ic_launcher));
			emailIntent.setType("text/plain");
			emailIntent.putExtra(Intent.EXTRA_EMAIL,TO);
			emailIntent.putExtra(Intent.EXTRA_CC,CC);
			emailIntent.putExtra(Intent.EXTRA_SUBJECT,"AYUDA");
			emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");
       			}
};
botonhelp.setOnClickListener(registroListener2);
	}
}
