package com.example.imagebuttontest;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
ImageButton ib;RadioButton m,f;RadioGroup rg;String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
   ib=(ImageButton) findViewById(R.id.my_img_btn);
   m=(RadioButton) findViewById(R.id.male);
   f=(RadioButton) findViewById(R.id.female);
   rg=(RadioGroup) findViewById(R.id.gender);
   ib.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		Toast.makeText(MainActivity.this, "imagebutton is clicked",Toast.LENGTH_LONG).show();
	ib.setImageResource(R.drawable.da);	
	}
});
   
    m.setOnClickListener(this);
    f.setOnClickListener(this);
    
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId()==R.id.male)
		{gender="male";
		
	}
		else 
			{gender="female";}

    Toast.makeText(MainActivity.this,"your gender is :" +gender,Toast.LENGTH_LONG).show();
    
}}
