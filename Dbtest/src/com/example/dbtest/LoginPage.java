package com.example.dbtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPage extends Activity {
	EditText userName;
	EditText password;
	Button btnLogin;
	MyAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_page);
		adapter = new MyAdapter(this);
		userName = (EditText) findViewById(R.id.et_username);
		password = (EditText) findViewById(R.id.et_password);
		btnLogin = (Button) findViewById(R.id.btn_login);
		
		btnLogin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				boolean b = adapter.validate(userName.getText().toString(), password.getText().toString());
				if(b){
					startActivity(new Intent(LoginPage.this, HomeActivity.class));
					Toast.makeText(LoginPage.this, "Login Successfull", Toast.LENGTH_LONG).show();
				}else{
					Toast.makeText(LoginPage.this, "Invalid User id or Password !!", Toast.LENGTH_LONG).show();
				}
			}
		});
		
	}
}