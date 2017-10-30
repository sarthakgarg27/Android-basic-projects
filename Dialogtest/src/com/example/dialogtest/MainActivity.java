package com.example.dialogtest;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
Button simple,single,doubl,list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        	simple=(Button) findViewById(R.id.simple);
        	single=(Button) findViewById(R.id.single);
        	doubl=(Button) findViewById(R.id.doubl);
        	list=(Button) findViewById(R.id.list);
        	simple.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					AlertDialog.Builder ab=new AlertDialog.Builder(MainActivity.this);
					ab.setTitle("simple dialog");
					ab.setMessage("this is simple dialog");
					ab.show();
					
				}
			});
        	single.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					AlertDialog.Builder ab=new AlertDialog.Builder(MainActivity.this);
					ab.setTitle("error");
					ab.setMessage("error occured");
					ab.setPositiveButton("ok",new DialogInterface.OnClickListener() {
						
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
						Toast.makeText(MainActivity.this,"ok button",Toast.LENGTH_LONG).show();	
						}
					});
						
					
					ab.show();
				}
			});
        	doubl.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					AlertDialog.Builder ab=new AlertDialog.Builder(MainActivity.this);
					ab.setTitle("Alert");
					ab.setMessage("do you want to continue");
					ab.setPositiveButton("yes",new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							Toast.makeText(MainActivity.this,"welcome page",Toast.LENGTH_LONG).show();
							
						}
					});
					ab.setNegativeButton("no",new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							Toast.makeText(MainActivity.this,"home page",Toast.LENGTH_LONG).show();
						}
					}
				);
				ab.show();
				}});
        	list.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					AlertDialog.Builder ab=new AlertDialog.Builder(MainActivity.this);
					ab.setTitle("select days");
					final CharSequence[] days = {"sunday","monday","tuesday"};
					ab.setSingleChoiceItems(days,0,new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							
							Toast.makeText(MainActivity.this,"you selected"+days,Toast.LENGTH_LONG).show();
						}
					});
					
					
				ab.show(); }
				
				}
        	
    );
			
		}
        	
        	
        	
}


   
    

