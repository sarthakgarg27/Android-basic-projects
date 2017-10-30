package com.example.sharedpreftest;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
EditText usern,pass;int c=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		usern=(EditText) findViewById(R.id.username);
		pass=(EditText) findViewById(R.id.password);
	}

	public void savedata(View v){
		SharedPreferences pref =getSharedPreferences("student",Context.MODE_PRIVATE);
		Editor editor=pref.edit();
		editor.putString("username",usern.getText().toString());
		editor.putString("password",pass.getText().toString());
		if(editor.commit()){
		Toast.makeText(this,"data saved",Toast.LENGTH_LONG).show();
	}
		else
		{
			Toast.makeText(this,"error",Toast.LENGTH_LONG).show();
		}	}

public void studentportal(View v) {
	startActivity(new Intent(this,Student.class));
}


}


