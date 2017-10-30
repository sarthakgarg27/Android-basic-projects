package com.example.calculator1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;

public class Mainactivity extends Activity {
Button b1,b2,b3,b4,b5,b6,b7,b8,b9,add,clear,div,mul,b0,equals,bdeci;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainactivity);
        b1=(Button) findViewById(R.id.btn1);
        b0=(Button) findViewById(R.id.btn0);
        b2=(Button) findViewById(R.id.btn2);
    }


   
}
