package com.example.reg;





import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {
	EditText userName;
	EditText password;
	Button btnLogin;
	Myadapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		adapter = new Myadapter(this);
		userName = (EditText) findViewById(R.id.user);
		password = (EditText) findViewById(R.id.pw);
		btnLogin = (Button) findViewById(R.id.newlog);

		btnLogin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				boolean b = adapter.validate(userName.getText().toString(), password.getText().toString());
				if(b){
					
					Toast.makeText(Login.this, "Login Successfull", Toast.LENGTH_LONG).show();
					AlertDialog.Builder ab=new AlertDialog.Builder(Login.this);
					ab.setTitle("Are you sure");
					ab.setMessage("do you want to go to home page??");
					ab.setPositiveButton("OK",new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							startActivity(new Intent(Login.this,Afterlogin.class));
							
						}
					});
					ab.setNegativeButton("REGISTRATION PAGE",new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							startActivity(new Intent(Login.this,MainActivity.class));
						}
					}
				);
				ab.show();
					
				}else{
					AlertDialog.Builder ab=new AlertDialog.Builder(Login.this);
					ab.setTitle("Alert");
					ab.setMessage("wrong id or password");
ab.setPositiveButton("OK",new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							startActivity(new Intent(Login.this,MainActivity.class));
							
						}
					});
					ab.show();
					
				}
			}
		});
		
	}


	

}
