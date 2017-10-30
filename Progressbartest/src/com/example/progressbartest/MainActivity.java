package com.example.progressbartest;

import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
Button login;ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=(Button) findViewById(R.id.button1);
        login.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				pd=new ProgressDialog(v.getContext());
				pd.setMessage("loading");
				pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
				pd.setCanceledOnTouchOutside(true);
				pd.setProgress(0);
				pd.setMax(100);
				pd.show();
				Thread t=new Thread(){
					public void run()
					{
						for(int i=0;i<10;i++){
							try{
								Thread.sleep(1000);
								pd.incrementProgressBy(10);
							}catch(InterruptedException e){}
						}pd.dismiss();
						startActivity(new Intent(MainActivity.this,Welcome.class));
					}
				};t.start();
			}
		});
    }


    
}
