package com.example.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

public class MyAdapter {
	MyHelper helper;
	
	Context context;
	public MyAdapter(Context context) {
		this.context=context;
		helper=new MyHelper(context);
	}
	long insertData(String un,String pass,int salary,String dept)
	{SQLiteDatabase db=helper.getWritableDatabase();
	ContentValues cv=new ContentValues();
	cv.put(MyHelper.USER_NAME,un);
	cv.put(MyHelper.PASSWORD,pass);

	cv.put(MyHelper.SALARY,salary);
	cv.put(MyHelper.DEPARTMENT,dept);
	long id=db.insert(MyHelper.TABLE_NAME,null,cv);
	
		return id;
	}
	
	
	
	
	
	
	
public class MyHelper extends SQLiteOpenHelper{
	private static final String DATABASE_NAME="employee"; 
	private static final int DATABASE_VERSION=1;
	private static final String TABLE_NAME="employee";
	private static final String ID="_id";
	private static final String USER_NAME="username";
	private static final String PASSWORD="password";
	private static final String SALARY="salary";
	private static final String DEPARTMENT="department";
	private static final String TABLE_DROP="DROP TABLE "+TABLE_NAME;
	private static final String TABLE_CREATE ="create table "+TABLE_NAME+"("+ID+" integer,"+USER_NAME+" varchar(30),"+PASSWORD+" varchar(30),"+SALARY+" integer,"+DEPARTMENT+" varchar(20));";
	
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
		
	}}

}
