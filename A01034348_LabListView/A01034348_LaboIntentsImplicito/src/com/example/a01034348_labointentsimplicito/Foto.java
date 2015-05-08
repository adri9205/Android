package com.example.a01034348_labointentsimplicito;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class Foto extends Activity {

	ImageView foto= (ImageView) findViewById(R.id.foto);
	//command+shift+ O
	Integer MY_REQUEST_CODE;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_foto);
		
		Button tomarFotoButton=(Button) findViewById(R.id.botonFoto);
		
		OnClickListener registro= new OnClickListener(){
			public void onClick(View v){
				Intent intent =new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				if (intent.resolveActivity(getPackageManager())!=null){
				
				startActivityForResult(intent, MY_REQUEST_CODE);}
				
			}
		};
		tomarFotoButton.setOnClickListener(registro); 
	}
	 protected void onActivityResult(int requestCode, int resultCode,
             Intent data) {
         if (requestCode == MY_REQUEST_CODE) {
             if (resultCode == RESULT_OK) {
                 // A contact was picked.  Here we will just display it
                 // to the user.
            	 Bitmap miFoto= (Bitmap) data.getExtras().get("data");
            	 foto.setImageBitmap(miFoto);
                 //startActivity(new Intent(Intent.ACTION_VIEW, data));
             }
         }
     }
}
