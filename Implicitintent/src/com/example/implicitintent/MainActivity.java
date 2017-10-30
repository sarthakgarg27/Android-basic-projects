package com.example.implicitintent;

import com.example.implicitintent.R.string;

import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
Button fb,mp,con,dial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fb=(Button) findViewById(R.id.fb);
        mp=(Button) findViewById(R.id.map);
        con=(Button) findViewById(R.id.con);;
      dial=(Button) findViewById(R.id.num);
      fb.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i =new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.fb.com"));
			startActivity(i);
			
		}
	});
      dial.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			String number="123456";
			Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("tel+"+number));
			startActivity(i);
			
		}
	});
        mp.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String lat="23.4545";
				String lon="89.2324";
				Intent i =new Intent(Intent.ACTION_VIEW, Uri .parse("geo"+lat+","+lon));
			}
		});
        con.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i=new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
				
			}
		});
    }

    
}
