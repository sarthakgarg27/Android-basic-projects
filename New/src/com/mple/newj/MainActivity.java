package com.mple.newj;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClick
+Listener{
	EditText n; TextView tv;Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    n=   findViewById(R.id.name)
    tv=(TextView)findViewById(R.id.msg);
    b=(button)findViewById(R.id.btn_submit);
    b.setOnClickListener(this); 
   
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		  String name=n.getText().toString();
		tv.setText(name);
	}
    
}
