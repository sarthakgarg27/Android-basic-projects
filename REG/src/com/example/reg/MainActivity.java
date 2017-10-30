package com.example.reg;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemSelectedListener{
EditText un,pas;Spinner state;String seletedstate=null;Button reg; Myadapter adapter;
String states[]={"andhra pradesh","assam","up","jammu","kerela","maharastra"};
RadioButton male,female; String gender=null;String hobbies="";CheckBox games,sleep,books;
String u,p;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		adapter = new Myadapter(this);
		un=(EditText) findViewById(R.id.un);
		pas=(EditText) findViewById(R.id.pass);
		male=(RadioButton) findViewById(R.id.male);
		female=(RadioButton) findViewById(R.id.female); 
		games=(CheckBox) findViewById(R.id.game);
		books=(CheckBox) findViewById(R.id.read);
		sleep=(CheckBox) findViewById(R.id.sleep);
		reg=(Button) findViewById(R.id.reg);
	 
		  state=(Spinner) findViewById(R.id.state);
	        state.setOnItemSelectedListener(this);
	        ArrayAdapter<String> ad=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,states);
	        state.setAdapter(ad);
	        reg.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					 u = un.getText().toString();
					 p = pas.getText().toString();
						if(games.isChecked())
						{hobbies=hobbies + " playing games";
						}
						if(sleep.isChecked())
						{hobbies=hobbies+" sleeping";
						}
						if(books.isChecked())
						{hobbies=hobbies+" reading";
						}
						if(male.isChecked())
						{
							gender="male";
						}if(female.isChecked())
						{
							gender="female";
						}
				
					
					long l = adapter.insertData(u, p, gender,hobbies,seletedstate);
						if(l>0){
							Toast.makeText(MainActivity.this, "Data Inserted Successfully !", Toast.LENGTH_LONG).show();
							AlertDialog.Builder ab=new AlertDialog.Builder(MainActivity.this);
							ab.setTitle("REGISTRATION SUCCESSFUL");
							ab.setMessage("USERNAME:"+u+"\n password:"+p+"\n hobbies"+hobbies+"\n gender:"+gender+"\n state:"+seletedstate);
							ab.setPositiveButton("ok",new DialogInterface.OnClickListener() {
								
								
								@Override
								public void onClick(DialogInterface dialog, int which) {
									// TODO Auto-generated method stub
									Intent i=new Intent(MainActivity.this,Login.class);
									startActivity(i);
								}
							});
							ab.show();
						
						}else{
							Toast.makeText(MainActivity.this, "Error !", Toast.LENGTH_LONG).show();
						}
					
						
				
				}
			});
	        
		
	}

	public void login(View v)
	{
		Intent i=new Intent(MainActivity.this,Login.class);
		startActivity(i);
		
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		seletedstate=states[arg2];
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}

}
