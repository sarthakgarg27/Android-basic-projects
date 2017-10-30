package com.example.onclick;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Toast;

public class Second extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		Toast.makeText(this,"welcome to 2nd activity",Toast.LENGTH_LONG).show();
	}

	

}
