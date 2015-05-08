package com.example.a01034348_laboexamen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class AccesoPerfil extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_acceso_perfil);
		final TextView user=(TextView) findViewById(R.id.textView2);
		final TextView nombret=(TextView) findViewById(R.id.nombretv);
		final TextView mailt=(TextView) findViewById(R.id.mailtv);
		final TextView paist=(TextView) findViewById(R.id.paistv);
		final TextView usernameMayor=(TextView)findViewById(R.id.textView2);
		final Button salir=(Button) findViewById(R.id.salirb);
		final Button agregaInformacion=(Button) findViewById(R.id.agregarb);
		final WebView imagenpais=(WebView)findViewById(R.id.webView1);
		ProgressBar miprogressbar=(ProgressBar) findViewById(R.id.progressBar1);
		Bundle datos= getIntent().getExtras();
		if (datos!=null){
			String usernameString=datos.getString("username");
			String nombreString=datos.getString("nombre");
			String emailString=datos.getString("email");
			String paisString=datos.getString("pais");
			usernameMayor.setText(usernameString);
			nombret.setText(nombreString);
			mailt.setText(emailString);
			paist.setText(paisString);
			try{
				imagenpais.loadUrl("http://flagspictures.org/photo/150-jpeg/"+paisString+".jpg");
				
			}catch(Exception e){
				e.printStackTrace();
			}
		
			imagenpais.getSettings().setBuiltInZoomControls(true);
		imagenpais.getSettings().setUseWideViewPort(true);
			imagenpais.getSettings().setLoadWithOverviewMode(true);
			imagenpais.setInitialScale(1);
			imagenpais.setWebViewClient(new WebViewClient());
		}
		final OnClickListener registroListener = new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent =new Intent (AccesoPerfil.this, MainActivity.class);
	       		startActivity(intent);
				
			}
			
		};
		salir.setOnClickListener(registroListener);
		
		final OnClickListener registroListener2 = new OnClickListener(){

			@Override
			public void onClick(View v) {				
				Intent intent =new Intent (AccesoPerfil.this, Agregar.class);
				String usuario=usernameMayor.getText().toString();
	    	  
	       		intent.putExtra("username", usuario);
	       		startActivity(intent);
			}
			
		};
		agregaInformacion.setOnClickListener(registroListener2);
	}
}
