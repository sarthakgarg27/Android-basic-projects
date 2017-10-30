package com.example.animationtest;

import com.example.animationtest.R.anim;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends Activity implements AnimationListener {
TextView start;
Animation anim;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		start=(TextView) findViewById(R.id.btn_start);
		anim=AnimationUtils.loadAnimation(this,R.anim.zoom_in);
		start.startAnimation(anim);
		anim.setAnimationListener(this);
	}
	@Override
	public void onAnimationEnd(Animation animation) {
		// TODO Auto-generated method stub
		startActivity(new Intent(MainActivity.this,Home.class));
	}
	@Override
	public void onAnimationRepeat(Animation animation) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onAnimationStart(Animation animation) {
		// TODO Auto-generated method stub
		
	}


}
