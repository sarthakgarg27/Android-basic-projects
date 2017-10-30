package com.example.dbtest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class MyAdapter {
	
	MyHelper helper;
	
	Context context;
	public MyAdapter(Context context) {
		this.context = context;
		helper = new MyHelper(context);
	}
	
	
	Cursor showByUserName(String un){
		SQLiteDatabase db = helper.getWritableDatabase();
		String columns[] = {MyHelper.PASSWORD, MyHelper.SALARY,MyHelper.DEPARTMENT};
		String selection = MyHelper.USER_NAME+" = ? ";
		String selectionArgs[] = {un};
		Cursor c = db.query(MyHelper.TABLE_NAME, columns, selection, selectionArgs, null, null, null);
		return c;
	}
	
	boolean updateData(String un, String pass, int salary, String dept){
		SQLiteDatabase db = helper.getWritableDatabase();
		
		ContentValues cv = new ContentValues();
		cv.put(MyHelper.PASSWORD, pass);
		cv.put(MyHelper.SALARY, salary);
		cv.put(MyHelper.DEPARTMENT, dept);
		String whereClause = MyHelper.USER_NAME + " = ? ";
		String whereArgs[] = {un};
		int i = db.update(MyHelper.TABLE_NAME, cv, whereClause, whereArgs);
		return i>0 ;
	}
	
	boolean deleteData(String un){
		boolean status = false;
		SQLiteDatabase db = helper.getWritableDatabase();
		String whereClause = MyHelper.USER_NAME+" = ? ";
		String whereArgs[] = {un};
		int id = db.delete(MyHelper.TABLE_NAME, whereClause, whereArgs);
			if(id > 0){
				status = true;
			}else{
				status = false;
			}
		return status;
	}
	
	
	long insertData(String un, String pass, int salary, String dept){
		SQLiteDatabase db = helper.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put(MyHelper.USER_NAME, un);
		cv.put(MyHelper.PASSWORD, pass);
		cv.put(MyHelper.SALARY, salary);
		cv.put(MyHelper.DEPARTMENT, dept);
		
		long id = db.insert(MyHelper.TABLE_NAME, null, cv);
		return id;
	}
	
	
	Cursor showData(){
		SQLiteDatabase db = helper.getWritableDatabase();
		Cursor c = db.query(MyHelper.TABLE_NAME, null, null, null, null, null, null);
		return c;
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
		private static final String DATABASE_NAME = "employee3";
		private static final int DATABASE_VERSION = 7;
		
		private static final String TABLE_NAME = "employee3";
		private static final String ID = "_id";
		private static final String USER_NAME = "username";
		private static final String PASSWORD = "password";
		private static final String SALARY = "salary";
		private static final String DEPARTMENT  = "department";
		

		private static final String TABLE_CREATE = "create table "+TABLE_NAME+"("+ID+" integer, "+USER_NAME+" varchar(20), "+PASSWORD+" varchar(20), "+SALARY+" integer(10), "+DEPARTMENT+" varchar(20));";
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