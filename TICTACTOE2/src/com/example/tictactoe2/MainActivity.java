package com.example.tictactoe2;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.app.Activity; 
import android.os.Bundle; 
  
public class MainActivity extends Activity { 
    private Game game1; 
  
    /** Called when the activity is first created. */ 
    @Override 
    public void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState); 
        game1 = new Game(this); 
        setContentView(game1); 
    } 
} 
