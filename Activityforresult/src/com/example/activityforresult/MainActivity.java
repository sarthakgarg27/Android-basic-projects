package com.example.activityforresult;

import android.R.string;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
Button next;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		next=(Button) findViewById(R.id.next);
		next.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i=new Intent(MainActivity.this,Homeactivity.class);
				startActivityForResult(i,1);//1 is request code
			}
		});
		}


@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode==1)
		{
			//somedata
			Bundle b=data.getExtras();
		String	name=b.getString("USERNAME");
		String	 pass=b.getString("PASSWORD");
			Toast.makeText(this,"username :"+name+"\npassword:"+pass, Toast.LENGTH_LONG).show();
			
		}
		else{
		//nodata
			}
		}
	}

