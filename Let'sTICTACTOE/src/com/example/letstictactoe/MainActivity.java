package com.example.letstictactoe;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.TextView;




public class MainActivity extends Activity implements AnimationListener {

	TextView ttt;
	Animation anim;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			requestWindowFeature(Window.FEATURE_NO_TITLE);
			setContentView(R.layout.activity_main);
			ttt=(TextView) findViewById(R.id.ttt);
			ttt.setTextScaleX(1.5f);
			ttt.setTypeface(Typeface.MONOSPACE);
			anim=AnimationUtils.loadAnimation(this,R.anim.zoom_in);
			ttt.startAnimation(anim);
			anim.setAnimationListener(this);
			
		}
		public void onAnimationEnd(Animation animation){
		startActivity(new Intent(MainActivity.this,Shubhi.class));
		
			finish();
		}
		public void onAnimationRepeat(Animation animation) {
			// TODO Auto-generated method stub
			
		}
		public void onAnimationStart(Animation animation) {
			// TODO Auto-generated method stub
			
		}

		

	}
