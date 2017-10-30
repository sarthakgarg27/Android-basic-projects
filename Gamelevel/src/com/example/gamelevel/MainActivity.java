package com.example.gamelevel;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
Button start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start=(Button) findViewById(R.id.sgame);
        start.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog.Builder ab=new AlertDialog.Builder(MainActivity.this);
				ab.setMessage("select level");
				ab.setPositiveButton("easy",new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Intent i=new Intent(MainActivity.this,Easy.class);
						startActivity(i);
						
					}
				});ab.setNegativeButton("medium", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Intent i=new Intent(MainActivity.this,Med.class);
						startActivity(i);
					}
				});
				ab.setNeutralButton("expert",new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Intent i=new Intent(MainActivity.this,Exp.class);
						startActivity(i);
						
					}
				});
				
			ab.show();}
		});
    }


  
    
}
