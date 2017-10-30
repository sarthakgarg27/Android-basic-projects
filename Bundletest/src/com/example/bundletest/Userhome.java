package com.example.bundletest;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class Userhome extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_userhome);
	}

	public void getdata(View v)
	{
		Intent i=getIntent();
Bundle bundle=i.getExtras();
String name=bundle.getString("NAME");
int age=bundle.getInt("age");
Toast.makeText(this,"your info "+name+"age:"+age,Toast.LENGTH_LONG).show();
	}
}
