package com.example.a01034348_labointentsimplicito;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View.OnKeyListener;

public class Web extends Activity {
	final WebView myWebView=(WebView)findViewById(R.id.webViewURL);
	final EditText pagurl=(EditText)findViewById(R.id.urltextedit);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web);
		final Button web=(Button)findViewById(R.id.botonURL);
		myWebView.setWebViewClient(new WebViewClient());
		myWebView.loadUrl("http://google.com");
		
		OnClickListener registro=new OnClickListener(){
			public void onClick (View view){
				String urlStr=pagurl.getText().toString();
				myWebView.loadUrl(urlStr);
				}
			};
			web.setOnClickListener(registro);
	}


public boolean onKeyDown(int keyCode, KeyEvent event){
if ((keyCode==KeyEvent.KEYCODE_BACK)&&myWebView.canGoBack()){
Toast.makeText(Web.this,"Pressed Back Button", Toast.LENGTH_SHORT).show();
myWebView.goBack();
return true;}
return super.onKeyDown(keyCode,event);}
OnKeyListener registroKeyListener=new OnKeyListener(){
public boolean onKey(int keyCode, KeyEvent event){
if ((keyCode==KeyEvent.KEYCODE_ENTER)){
	String urlStr=pagurl.getText().toString();
	myWebView.loadUrl(urlStr);
return true;}
else{
return false;}}

@Override
public boolean onKey(View v, int keyCode, KeyEvent event) {
	// TODO Auto-generated method stub
	return false;
}};


}


/*
public void onClick(View view){

String urlStr=url.getText().toString();
myWebView.loadUrl(urlStr);
}
go,setOnClickListener
}//onCreate
public boolean
public boolean onKeyDown(int keyCode, KeyEvent event){
if ((keyCode==KeyEvent.KEYCODE_BACK)&&myWebView.canGoBack())
toast.makeText(Web.this,"Pressed Back Button", Toast.LENGTH_
myWebView.goBack();
return true;}
return super.onKeyDown(keyCode,event);}
}

*/