package com.david.car.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
public class DatabaseHelper extends SQLiteOpenHelper {
	private static final int VERSION = 1;
	private static final String DBNAME = "carcare.db";
	private Context context; 
	public DatabaseHelper(Context context) {
		super(context, DBNAME, null, VERSION);
		this.context=context;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		Log.e("DatabaseHelper", "onCreate");
		//dbHelper = new DBManager(this.context); 
        //dbHelper.openDatabase(); 
        //dbHelper.closeDatabase(); 

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
