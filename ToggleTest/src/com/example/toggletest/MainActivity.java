package com.example.toggletest;

import android.R.color;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.ToggleButton;

public class MainActivity extends Activity implements OnCheckedChangeListener{
RelativeLayout r;ToggleButton tb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r=(RelativeLayout) findViewById(R.id.rl);
        tb=(ToggleButton) findViewById(R.id.tb);
        tb.setOnCheckedChangeListener(this);
    }
	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		// TODO Auto-generated method stub
		if(isChecked)
		{
			r.setBackgroundColor(Color.BLACK);
		}
		else
			r.setBackgroundColor(Color.WHITE);
	}


    
    
}
