package com.example.checkboxtest;

import java.util.ArrayList;
import java.util.HashSet;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
CheckBox fb,tn,bd;Button btn;HashSet<String> item=new HashSet<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fb=(CheckBox) findViewById(R.id.f);
        tn=(CheckBox) findViewById(R.id.t);
        bd=(CheckBox) findViewById(R.id.b);
        btn=(Button) findViewById(R.id.select);
        btn.setOnClickListener(this);
        
        
        
        
    }
	@Override
	public void onClick(View v) {HashSet<String> item=new HashSet<String>();
		// TODO Auto-generated method stub
		if(v.getId()==R.id.select){
			if(fb.isChecked())
				item.add(fb.getText().toString());
			if(tn.isChecked())
				item.add(tn.getText().toString());
			if(bd.isChecked())
				item.add(bd.getText().toString());
			
			
		}
		Toast.makeText(this,"selection :"+item,Toast.LENGTH_LONG).show();
	}


   
}
