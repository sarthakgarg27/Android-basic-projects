package com.example.tictactoe2;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Point;

public abstract class shell extends Point {
	public shell(int x, int y){
		super(x,y);
	}
	abstract public void draw(Canvas g,Resources res, int x,int y, int w, int h);
}
