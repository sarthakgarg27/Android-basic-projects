package com.example.library;

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
EditText bn,bt,pub;static int id=1001;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bn=(EditText) findViewById(R.id.btitle);
		bt=(EditText) findViewById(R.id.btype);
		pub=(EditText) findViewById(R.id.pub);
	}

	public void show(View v){
		startActivity(new Intent(MainActivity.this,Showdata.class));
	}
	
	public void save(View v){
		
			SharedPreferences pref =getSharedPreferences("library",Context.MODE_PRIVATE);
			Editor editor=pref.edit();
			editor.putInt("id",id++);
			editor.putString("book type",bt.getText().toString());
			editor.putString("book title",bn.getText().toString());
			editor.putString("publisher",pub.getText().toString());
			if(editor.commit()){
			Toast.makeText(this,"data saved",Toast.LENGTH_LONG).show();
	

}
}}