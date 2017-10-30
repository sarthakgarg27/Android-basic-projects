package com.example.dbtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	MyAdapter adapter;
	EditText userName, userPassword, salary, department;
	Button register;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		adapter = new MyAdapter(this);
		
		userName = (EditText) findViewById(R.id.user_name);
		userPassword = (EditText) findViewById(R.id.user_password);
		salary = (EditText) findViewById(R.id.user_salary);
		department = (EditText) findViewById(R.id.user_department);
		register = (Button) findViewById(R.id.btn_register);
		
		
		
		register.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String un = userName.getText().toString();
				String pass = userPassword.getText().toString();
				int sal = Integer.parseInt(salary.getText().toString());
				String dept = department.getText().toString();
				long l = adapter.insertData(un, pass, sal, dept);
					if(l>0){
						Toast.makeText(MainActivity.this, "Data Inserted Successfully !", Toast.LENGTH_LONG).show();
					}else{
						Toast.makeText(MainActivity.this, "Some Errors Occurs !", Toast.LENGTH_LONG).show();
					}
			}
		});
		
	}
	
	public void loginPage(View v){
		startActivity(new Intent(MainActivity.this, LoginPage.class));
	}
}



