package com.example.college;




import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity  {
Button sub;
EditText pass,un;
RadioGroup rg;long l;
RadioButton male,female;
Myadapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	sub=(Button) findViewById(R.id.sub);
	pass=(EditText) findViewById(R.id.pass);
	un=(EditText) findViewById(R.id.un);
	rg=(RadioGroup) findViewById(R.id.rg);
	male=(RadioButton) findViewById(R.id.male);
	female=(RadioButton) findViewById(R.id.female);
    sub.setOnClickListener(new View.OnClickListener() {
		
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String us=un.getText().toString();
		        String pas=pass.getText().toString();
		        String gen=" ";
		      
		        if(male.isChecked())
		        {gen="m";}
		        if(female.isChecked())
		        {gen="f";}
			l=adapter.insertData(us,pas,gen);
				if(l>0){
					Toast.makeText(MainActivity.this,"submitted",Toast.LENGTH_LONG).show();
				}
				else
				{
					Toast.makeText(MainActivity.this,"error",Toast.LENGTH_LONG).show();
				}
			}
		});
	
	
	}

	

}
