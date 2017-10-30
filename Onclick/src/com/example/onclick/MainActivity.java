package com.example.onclick;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


  public void add(View v){
 Toast.makeText(this,"button clicked", Toast.LENGTH_LONG).show();
 Intent i=new Intent(this,Second.class);
 startActivity(i);
 finish();//to destroy current activity
}
}