package com.example.sharedpreftest;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class Student extends Activity {



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.student, menu);
		return true;
	}
	public void showdata(View v)
	{SharedPreferences pref=getSharedPreferences("student",Context.MODE_PRIVATE);
	String un=pref.getString("username","no records");
	String pass=pref.getString("password","no data found");
	Toast.makeText(this,"username:"+un+"password:"+pass,Toast.LENGTH_LONG).show();
	}

}
