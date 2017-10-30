package com.example.register;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class Resgister extends Activity implements OnItemSelectedListener{
EditText us,pw;RadioGroup rg;RadioButton m,f;CheckBox ja,c,php,andro;Spinner dep;
String depa[]={"cs","it","me","civil"};Button log,reg;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_resgister);
		us=(EditText) findViewById(R.id.usern);
		pw=(EditText) findViewById(R.id.PWD);
		rg=(RadioGroup) findViewById(R.id.gender);
		m=(RadioButton) findViewById(R.id.male);
		f=(RadioButton) findViewById(R.id.female);
		ja=(CheckBox) findViewById(R.id.java);
		c=(CheckBox) findViewById(R.id.c);
		php=(CheckBox) findViewById(R.id.php);
		andro=(CheckBox) findViewById(R.id.andro);
		dep=(Spinner) findViewById(R.id.depart);
		ArrayAdapter<String> ad=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,depa);
        dep.setAdapter(ad);
      dep.setOnItemSelectedListener(this);
       log=(Button) findViewById(R.id.LOG);
       reg=(Button) findViewById(R.id.REG);
       log.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i=new Intent(Resgister.this,MainActivity.class);
			startActivity(i);
		}
	});
       reg.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			
			
			Intent i=new Intent(Resgister.this,MainActivity.class);
			startActivity(i);
		}
	});
       
	}
	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		Toast.makeText(this,"selected department"+depa[arg2],Toast.LENGTH_LONG).show();
	}
	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}



}
