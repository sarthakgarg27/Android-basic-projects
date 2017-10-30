package com.example.activityforresult;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Homeactivity extends Activity {
Button prev;EditText un ,pas;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_homeactivity);
		prev=(Button) findViewById(R.id.btn_pre);
		un=(EditText) findViewById(R.id.et_username);
		pas=(EditText) findViewById(R.id.Et_pass);
		prev.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i=new Intent(Homeactivity.this,MainActivity.class);
				Bundle b=new Bundle();
				b.putString("USERNAME",un.getText().toString());
				b.putString("PASSWORD",pas.getText().toString());
			setResult(RESULT_OK,i);
			i.putExtras(b);
			startActivity(i);
			
					
				
			}
		});
	}


}
