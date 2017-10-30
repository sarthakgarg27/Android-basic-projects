package com.example.bundletest;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
EditText age ,name;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		age=(EditText) findViewById(R.id.age);
		name=(EditText) findViewById(R.id.name);
	}

	public void savedata(View v)
	{
		Bundle bundle =new Bundle();
		bundle.putInt("age",Integer.parseInt(age.getText().toString()));
		bundle.putString("NAME",name.getText().toString());
		Intent i=new Intent(this,Userhome.class);
		i.putExtras(bundle);
		startActivity(i);
		Toast.makeText(this,"data saved",Toast.LENGTH_LONG).show();
		
		
	}

}
