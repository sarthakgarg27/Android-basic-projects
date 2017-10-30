package com.example.mediaplayertest;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Spinner;

public class MainActivity extends Activity {
ImageButton btnplay,btnnext,btnpre;
MediaPlayer sp;MediaPlayer mp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnplay=(ImageButton) findViewById(R.id.btn_play);
		btnpre=(ImageButton) findViewById(R.id.btn_pre);
		// mp=MediaPlayer.create(MainActivity.this,R.raw.mymusic);
		mp=new MediaPlayer();
		
		File sdcard=new File("/sdcard/");
		File listofsongs[]=sdcard.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String filename) {
				// TODO Auto-generated method stub
				String fn=filename.toLowerCase();
				return fn.endsWith(".mp3");
				
			}
		});
		
		
		
		
		
		
		try {
			mp.setDataSource(listofsongs[0].getAbsolutePath());
			mp.prepare();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnnext=(ImageButton) findViewById(R.id.btn_next);
		btnplay.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				if(!mp.isPlaying()){
				mp.start();
				btnplay.setImageResource(android.R.drawable.ic_media_pause);}
				else if(mp.isPlaying())
				{mp.pause();
				btnplay.setImageResource(android.R.drawable.ic_media_play);
					
				}
				
			}
		});
	}
@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		mp.stop();
		mp.release();
	}

}
