package com.example.colorchange;

import android.R.color;
import android.os.Bundle;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends Activity implements android.view.View.OnClickListener{
Button b;RelativeLayout r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=(Button) findViewById(R.id.c);
        r=(RelativeLayout) findViewById(R.id.x);
        b.setOnClickListener(MainActivity.this);
    }
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		r.setBackgroundColor(Color.BLUE);

	}
    
    
}
