package com.example.dbtest;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;



public class UpdateData extends Activity {
	MyAdapter adapter;
	
	EditText un, pass, salary, department;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_update_data);
		adapter = new MyAdapter(this);
		un = (EditText) findViewById(R.id.et_update);
		pass = (EditText) findViewById(R.id.et_pass);
		salary = (EditText) findViewById(R.id.et_salary);
		department = (EditText) findViewById(R.id.et_dept);
		
		
		un.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				Cursor c = adapter.showByUserName(un.getText().toString());
					if(c.moveToNext()){
						pass.setText(c.getString(0));
						salary.setText(c.getString(1));
						department.setText(c.getString(2));
					}else {
						Toast.makeText(UpdateData.this, "No Records found", Toast.LENGTH_LONG).show();
					}
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public void updateUser(View v){
		adapter.updateData(un.getText().toString(), pass.getText().toString(), Integer.parseInt(salary.getText().toString()), department.getText().toString());
	}
}