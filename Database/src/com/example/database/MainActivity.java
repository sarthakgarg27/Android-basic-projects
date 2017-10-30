package com.example.database;

import android.R.string;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
Button sub;MyAdapter adapter;
EditText username,pwd,depart,salary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter=new MyAdapter(this);
        username=(EditText) findViewById(R.id.user_name);
        pwd=(EditText) findViewById(R.id.pwds);
        depart=(EditText) findViewById(R.id.pwds);
        salary=(EditText) findViewById(R.id.sal);
        sub=(Button) findViewById(R.id.sub);
       
        sub.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String un=username.getText().toString();
		        String pass=pwd.getText().toString();
		        int sal=Integer.parseInt(salary.getText().toString());
		        String dept=depart.getText().toString();
				long l=adapter.insertData(un, pass, sal, dept);
				if(l>0){
					Toast.makeText(MainActivity.this,"submitted",Toast.LENGTH_LONG).show();
				}
				else
				{
					Toast.makeText(MainActivity.this,"error",Toast.LENGTH_LONG).show();
				}
			}
		});
    }


   
}