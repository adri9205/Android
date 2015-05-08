package com.example.a01034348_lab_gesture;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

	ImageView imagen;
	private GestureDetector mDetector;
	//Display display = getWindowManager().getDefaultDisplay(); 
	int windowWidth = 1080;  // deprecated
	int windowHeight = 720;  // deprecated
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mDetector=new GestureDetector(this, new MyGestureListener());
		imagen=(ImageView)findViewById(R.id.imageView1);
		imagen.setOnTouchListener(new View.OnTouchListener(){
			public boolean onTouch(View v, MotionEvent event){
				float downx, downy,upx,upy;
				int action=event.getAction();
				switch (action){
				case MotionEvent.ACTION_DOWN:
					downx=event.getX();
					downy=event.getY();
					//imagen.scrollBy((int)downx, (int)downy);
					break;
				case MotionEvent.ACTION_MOVE:
					upx=event.getX();
					upy=event.getY();
				//	imagen.scrollBy((int)upx, (int)upy);
					downx=upx;
					downy=upy;
					break;
				case MotionEvent.ACTION_UP:
					upx=event.getX();
					upy=event.getY();
					//imagen.scrollBy((int)upx, (int)upy);
					break;
				case MotionEvent.ACTION_CANCEL:
					break;
				default:
					break;
			}
			return true;
		}});
		

	}
	 public boolean onTouchEvent(MotionEvent event){ 
         int x = (int) event.getX(); 
         int y = (int) event.getY(); 
          
         if(x > windowWidth - 50) 
              x = windowWidth - 50; 
         if(y > windowHeight - 50) 
              y = windowWidth - 50; 
          
         imagen.layout(x, y - 50, x + 50, y); 
          
          
         this.mDetector.onTouchEvent(event); 
         return super.onTouchEvent(event); 
    }
	
	
	class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
		private static final String DEBUG_TAG="MyGestureListener";
		public boolean onDown(MotionEvent event){
			Log.d(DEBUG_TAG,"onDown: "+event.toString());
			return true;
		}
		public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX, float velocityY){
		Toast.makeText(MainActivity.this,"onFling",Toast.LENGTH_SHORT).show();
		Log.d(DEBUG_TAG,"onFling: "+event1.toString()+event2.toString());

		return true;}

		public void onShowPress(MotionEvent event){
			Toast.makeText(MainActivity.this, "onShowPress", Toast.LENGTH_SHORT).show();
			Log.d(DEBUG_TAG, "onShowPress: "+event.toString());
		}
		
		public boolean onSingleTapUp(MotionEvent event){
			Toast.makeText(MainActivity.this, "onSingleTapUp", Toast.LENGTH_SHORT).show();
			Log.d(DEBUG_TAG,"onSingleTapUp: "+event.toString());
			return true;
		}
		
		public boolean onDoubleTap(MotionEvent event){
			Toast.makeText(MainActivity.this, "onDoubleTap", Toast.LENGTH_SHORT).show();
			Log.d(DEBUG_TAG, "onDoubleTap: "+event.toString());
			return true;
		}
		
		public boolean onDoubleTapEvent(MotionEvent event){
			Toast.makeText(MainActivity.this, "onDoubleTapEvent", Toast.LENGTH_SHORT).show();
			Log.d(DEBUG_TAG, "onDoubleTapEvent: "+event.toString());
			return true;
		}
		
		public boolean onSingleTapConfirmed(MotionEvent event){
			Toast.makeText(MainActivity.this, "onSingleTapConfirmed", Toast.LENGTH_SHORT).show();
			return true;
		}
		

		}
}

