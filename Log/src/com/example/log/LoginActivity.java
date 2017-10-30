package com.example.log;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
EditText a,b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        a=(EditText) findViewById(R.id.u);
      b=(EditText) findViewById(R.id.pr);
      Toast.makeText(this,"oncreate", Toast.LENGTH_SHORT).show();
         }
    @Override
    	protected void onStart() {
    		// TODO Auto-generated method stub
    		super.onStart();
    		Toast.makeText(this,"onstart", Toast.LENGTH_LONG).show();
    	}
    @Override
    	protected void onResume() {
    		// TODO Auto-generated method stub
    		super.onResume();
    		Toast.makeText(this,"resume", Toast.LENGTH_LONG).show();
    	}
    @Override
    	protected void onPause() {
    		// TODO Auto-generated method stub
    		super.onPause();
    	Toast.makeText(this,"onpause", Toast.LENGTH_LONG).show();}
    
    
public void change(View v)
{String us,pw;
us=(a.getText().toString());
pw=b.getText().toString();
	if(us.equalsIgnoreCase("java")&&pw.equalsIgnoreCase("android"))
		{
	
		 Intent i=new Intent(this,Welcomeactivity.class);
		 startActivity(i);
		 finish();
		}
	else
	{Toast.makeText(this,"incorrect id or password", Toast.LENGTH_LONG).show();}
}
    
}
