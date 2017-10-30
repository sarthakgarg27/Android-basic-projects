package com.example.reg;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class Myadapter {
MyHelper helper;

Context context;
public Myadapter(Context context) {
	this.context = context;
	helper = new MyHelper(context);
}









long insertData(String un, String pass,String gender,String hobbies,String state ){
	SQLiteDatabase db = helper.getWritableDatabase();
	ContentValues cv = new ContentValues();
	cv.put(MyHelper.USER_NAME, un);
	cv.put(MyHelper.PASSWORD, pass);
	cv.put(MyHelper.GENDER, gender);
	cv.put(MyHelper.HOBBIES, hobbies);
	cv.put(MyHelper.STATES, state);
	
	long id = db.insert(MyHelper.TABLE_NAME, null, cv);
	return id;
}





boolean validate(String un, String pass){
	SQLiteDatabase db = helper.getWritableDatabase();
	//selcet username and passord from employee where 
	//MyHelper.USER_NAME+ " = ? and "+MyHelper.PASSWORD +" = ? 
	boolean status = false;
	String columns[] = {MyHelper.USER_NAME, MyHelper.PASSWORD};
	
	String selection = MyHelper.USER_NAME + " =  ?  and "+MyHelper.PASSWORD + " = ? ";
	String selectionArgs[] = {un, pass};
	Cursor c = db.query(MyHelper.TABLE_NAME, columns, selection, selectionArgs, null, null, null);
		if(c.moveToNext()){
			status = true;
		}else {
			status = false;
		}
	return status;
}




class MyHelper extends SQLiteOpenHelper{
	private static final String DATABASE_NAME = "USER";
	private static final int DATABASE_VERSION = 7;
	
	private static final String TABLE_NAME = "REGISTER";
	private static final String USER_NAME = "username";
	private static final String PASSWORD = "password";
	private static final String GENDER = "gender";
	private static final String HOBBIES  = "hobbies";
	private static final String STATES  = "STATE";
	

	private static final String TABLE_CREATE = "create table "+TABLE_NAME+"("+USER_NAME+" varchar(20), "+PASSWORD+" varchar(20), "+GENDER+" String(10), "+HOBBIES+" String(120), "+STATES+" String(120));";
	private static final String TABLE_DROP = "DROP TABLE "+TABLE_NAME;
	
	public MyHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		try {
			db.execSQL(TABLE_CREATE);
		} catch (SQLException e) {
			
		}
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		try {
			db.execSQL(TABLE_DROP);
			onCreate(db);
		} catch (SQLException e) {
			
		}
	}
}

}
