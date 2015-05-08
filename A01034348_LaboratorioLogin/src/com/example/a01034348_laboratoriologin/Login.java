package com.example.a01034348_laboratoriologin;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		final EditText usernameET=(EditText) findViewById(R.id.userNameET);
		final EditText passwordET=(EditText) findViewById(R.id.passwordET);
		final Button loginButton=(Button) findViewById(R.id.loginButton);
 final OnClickListener registroListener = new OnClickListener(){
			
	    	
	       	@Override
	       	public void onClick(View v) {
	       			if(usernameET.getText().toString().equals("usuario1") && 
	       			passwordET.getText().toString().equals("passtec")){
	       				Toast.makeText(getApplicationContext(), "Redireccionando...", 
	       				     Toast.LENGTH_SHORT).show();
	       				Intent intent =new Intent (Login.this, Acceso.class);
	    	       		String usuario=usernameET.getText().toString();
	    	       		String password=passwordET.getText().toString();
	    	       		intent.putExtra("username", usuario);
	    	       		intent.putExtra("password", password);
	    	       		startActivity(intent);
	       			
	       			}else{
	       				Toast.makeText(getApplicationContext(), "Has ingresado mal los datos...", 
	       				      Toast.LENGTH_SHORT).show();
	       	
	       		
	       			}
	       		
	       		
	       	}
	       	
	       	};
	    	loginButton.setOnClickListener(registroListener);
		
	}
}
