package com.example.register;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
EditText us,pwd;
Button log,reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        us=(EditText) findViewById(R.id.usern);
        pwd=(EditText) findViewById(R.id.PWD);
        log=(Button) findViewById(R.id.LOG);
        reg=(Button) findViewById(R.id.REG);
        reg.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i=new Intent(MainActivity.this,Resgister.class);
				startActivity(i);
				
			}
		});
        log.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String a,pw;
				a=(us.getText().toString());
				pw=pwd.getText().toString();
					if(a.equalsIgnoreCase("java")&&pw.equals("android"))
						{
					
						 Intent i=new Intent(MainActivity.this,Welcome.class);
						 startActivity(i);
						 finish();
						}
					else
					{Toast.makeText(MainActivity.this,"incorrect id or password",Toast.LENGTH_LONG).show();}
			}
		});
    }


   
    
}
