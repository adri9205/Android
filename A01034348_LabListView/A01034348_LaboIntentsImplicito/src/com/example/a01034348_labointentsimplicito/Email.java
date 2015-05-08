package com.example.a01034348_labointentsimplicito;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Email extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_email);
		final Button email=(Button)findViewById(R.id.botonemail);
		OnClickListener registro=new OnClickListener(){
			public void onClick (View view){
				String[] TO={"adri925@gmail.com"};
				String[] CC={"adri925@hotmail.com"};
				Intent emailIntent=new Intent(Intent.ACTION_SEND);
				
				emailIntent.putExtra(Intent.EXTRA_STREAM,Uri.parse("android.resource://"+getPackageName()+"/"+R.drawable.ic_launcher));
				emailIntent.setType("text/plain");
				emailIntent.putExtra(Intent.EXTRA_EMAIL,TO);
				emailIntent.putExtra(Intent.EXTRA_CC,CC);
				emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Your subject");
				emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");
					}
			};
			email.setOnClickListener(registro);
	}
}
/*
String[] T0={};
emailIntent.putExtra(Intent.EXTRA_STREAM,Uri.parse("android.resource://"+getPackageName()+"/"+R.drawable.ic_l
emailIntent.setType("text/plain");
emailIntent.putExtra(Intent.EXTRA_EMAIL,TO);
emailIntent.putExtra(Intent.EXTRA_CC,CC);
emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Your subject");
emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");

*/