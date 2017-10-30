package com.newworld.addition;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
EditText n1,n2;TextView a;Button but;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        n1=(EditText) findViewById(R.id.num1);
        n2=(EditText) findViewById(R.id.num2);
        a=(TextView) findViewById(R.id.answer);
        but=(Button) findViewById(R.id.add_b);
        but.setOnClickListener(this);
        
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
		int number1=Integer.parseInt(n1.getText().toString());
		int number2=Integer.parseInt(n2.getText().toString());
		int q=number1+number2;
		a.setText(Integer.toString(q));
		
		
	}
    
}
