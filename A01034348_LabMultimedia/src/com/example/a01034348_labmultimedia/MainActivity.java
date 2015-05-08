package com.example.a01034348_labmultimedia;

import android.app.Activity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends Activity {
	
	VideoView mVideoView;
	MediaController mMediaController;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mVideoView=(VideoView) findViewById(R.id.videoView1);
		//mVideoView.set
		mMediaController=new MediaController(MainActivity.this,true);
		
	}
}
