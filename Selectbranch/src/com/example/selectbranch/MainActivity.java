package com.example.selectbranch;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity  {
EditText u,p;RadioButton c,m,e,ci; RadioGroup r;Button s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        u=(EditText) findViewById(R.id.user);
        p=(EditText) findViewById(R.id.pwd);
        c=(RadioButton) findViewById(R.id.cs);
        m=(RadioButton) findViewById(R.id.mech);
        e=(RadioButton) findViewById(R.id.ele);
        ci=(RadioButton) findViewById(R.id.civ);
        r=(RadioGroup) findViewById(R.id.rg1);
        s=(Button) findViewById(R.id.sub);
        
        
    }
	public void change(View v){
		String us,pw;
		us=u.getText().toString();
		pw=p.getText().toString();
		
			if((v.getId()==R.id.cs) && (us.equalsIgnoreCase("java")&&pw.equalsIgnoreCase("android")))
			{Toast.makeText(this,"cs", Toast.LENGTH_LONG).show();
				Intent i=new Intent(MainActivity.this,Cs.class);
				 startActivity(i);
				 finish();
			}
			else if((v.getId()==R.id.civ) && (us.equalsIgnoreCase("java")&&pw.equalsIgnoreCase("android")))
			{Toast.makeText(this,"civ", Toast.LENGTH_LONG).show();
				Intent i=new Intent(MainActivity.this,Civil.class);
				 startActivity(i);
				 finish();
			}
			else if((v.getId()==R.id.ele) && (us.equalsIgnoreCase("java")&&pw.equalsIgnoreCase("android")))
			{Toast.makeText(this,"ele", Toast.LENGTH_LONG).show();
			Intent	 i=new Intent(MainActivity.this,Electrical.class);
				 startActivity(i);
				 finish();
			}
			else if((v.getId()==R.id.mech) && (us.equalsIgnoreCase("java")&&pw.equalsIgnoreCase("android")))
			{Toast.makeText(this,"mech", Toast.LENGTH_LONG).show();
			Intent	 i=new Intent(MainActivity.this,Mech.class);
				 startActivity(i);
				 finish();
			}
			
		
		else
		{Toast.makeText(this,"incorrect id or password", Toast.LENGTH_LONG).show();}
	}
		
		
		
		
	}


    

