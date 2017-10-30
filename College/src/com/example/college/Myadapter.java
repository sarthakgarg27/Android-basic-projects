package com.example.college;



import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;





	public class Myadapter {
		
		Myhelper helper;
		
		Context Context;
		public Myadapter(Context Context)
		{
			this.Context=Context;
			helper=new Myhelper(Context);
		}
		
		long insertData(String un ,String pass,String gender )
		{
			SQLiteDatabase db = helper.getWritableDatabase();
			ContentValues cv =new ContentValues();
			cv.put(Myhelper.uname, un);
			cv.put(Myhelper.pass, pass);
			cv.put(Myhelper.gender, gender);
		
		   long id =	db.insert(Myhelper.tname, null, cv);
			return id;
		}
	
		
		
		
		
		
		class Myhelper extends SQLiteOpenHelper{
	        private static final String dbname ="Studentdb";
	        private static final int dv =1;
	        
	        private static final String tname="student";
	        private static final String id="_id";
	        private static final String uname="username";
	        private static final String pass="password";
	        private static final String gender="gender";
	      
	        
	        private static final String drop="DROP TABLE "+tname;
	        private static final String Query = "create table "+tname+"("+id+" integer,"+uname+" varchar (20),"+pass+" varchar (20),"+gender+" String);";
			public Myhelper(Context context) {
				super(context,dbname , null, dv);
				
			}

			@Override
			public void onCreate(SQLiteDatabase db) {
				try {
					db.execSQL(Query);
					onCreate(db);
				} catch (SQLException e) {
					
				}
			}

			@Override
			public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
				
				try {
					db.execSQL(drop);
					
				} catch (SQLException e) {
					
				}
				
			}
			
			
			
		}
		
	}

	
	
	

	

	
	
	

