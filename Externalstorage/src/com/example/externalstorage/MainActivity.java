package com.example.externalstorage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
EditText edata;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		edata=(EditText) findViewById(R.id.data);  
	}

public void savedata(View v){
File sdcard=getExternalFilesDir(null);
File file=new File(sdcard+"/Bookdetails");
file.mkdirs();
File f=new File(file, "books.txt");
try {
	PrintWriter pw=new PrintWriter(f);
	pw.write(edata.getText().toString());
	pw.close();
	Toast.makeText(this,"data written",Toast.LENGTH_LONG).show();
} catch (FileNotFoundException e) {
	Toast.makeText(this,"error"+e,Toast.LENGTH_LONG).show();
	
}
}
public void getdata(View v)
{File sdcard=getExternalFilesDir(null);
File file=new File(sdcard+"/Bookdetails");
file.mkdirs();
File f=new File(file, "books.txt");
try {
	FileReader fr=new FileReader(f);
	BufferedReader br=new BufferedReader(fr);
	String data=br.readLine();
	Toast.makeText(this,""+data,Toast.LENGTH_LONG).show();
	br.close();
} catch (FileNotFoundException e) {
	
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} 
	}

}
