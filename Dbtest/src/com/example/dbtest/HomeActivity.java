package com.example.dbtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class HomeActivity extends Activity {
	MyAdapter adapter;
	EditText un;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		adapter = new MyAdapter(this);
		un = (EditText) findViewById(R.id.et_delete);
	}
	public void deleteUser(View v){
		boolean b = adapter.deleteData(un.getText().toString());
			if(b){
				Toast.makeText(HomeActivity.this, "Data Deleted Successfully ", Toast.LENGTH_LONG).show();
			}else{
				Toast.makeText(HomeActivity.this, "Some Error Occurs !! ", Toast.LENGTH_LONG).show();
			}
	}
	
	public void updateUser(View v){
		startActivity(new Intent(HomeActivity.this, UpdateData.class));
	}
}

