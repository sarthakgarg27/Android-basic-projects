package com.example.library;

import android.R.string;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Showdata extends Activity {
EditText id;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_showdata);
		id=(EditText) findViewById(R.id.id);
	}

	public void show(View v){
		SharedPreferences pref=getSharedPreferences("library",Context.MODE_PRIVATE);
		long un= pref.getLong("id",0);
		String idn=id.getText().toString();
		long idn2=Integer.parseInt(idn);
		if(idn2==un)
		{int idd=(int) un;
			String btt=pref.getString("book type","no data found");
			String btl=pref.getString("book title","no data found");
			String p=pref.getString("publisher","no data found");
			Toast.makeText(Showdata.this,"id:"+idd+"book type:"+btt+"book title"+btl+"publisher"+p,Toast.LENGTH_LONG).show();
		}
		
	
	}

}
