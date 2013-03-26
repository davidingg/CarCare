package com.david.car.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.david.car.util.BaseDataEntities;
import com.david.car.util.BaseDataEntity;

/**
 * 数据库操作实现类. 
 * @author david
 */
public class BaseDaoImpl  implements BaseDao  {
	@Override
	/**
	 * 执行查询sql语句
	 * @param sql语句
	 */
	public BaseDataEntities sqlQuery(String sql,Context context) throws Exception {
		SQLiteDatabase localSQLiteDatabase = new DatabaseHelper(context).getReadableDatabase();
		// TODO Auto-generated method stub
		BaseDataEntities rows = new BaseDataEntities();//申请查询结果容器	
		Cursor localCursor;
	    localCursor = localSQLiteDatabase.rawQuery(sql, null);//执行查询语句
	    while(localCursor.moveToNext()){
	    	localCursor.getColumnCount();
	    	BaseDataEntity row = new BaseDataEntity();
	    	for(int i = 0;i<localCursor.getColumnCount();i++){
	    		Log.v("dwei",localCursor.getString(i));
	    		row.spsv(localCursor.getColumnName(i), localCursor.getString(i));
	    	}
	    	rows.add(row);
	    }
	    localCursor.close();
	    localSQLiteDatabase.close();
		return rows;
	}
	/**
	 * 执行新增sql语句
	 * @param cv 新增数值
	 */
	public long sqlInsert(String table,ContentValues cv,Context context)throws Exception{
		SQLiteDatabase localSQLiteDatabase = new DatabaseHelper(context).getReadableDatabase();
		long row = localSQLiteDatabase.insert(table,null,cv); 
		localSQLiteDatabase.close();
		return row;
	}
	/**
	 * 执行更新sql语句
	 * @return
	 * @throws Exception
	 */

	public long sqlUpdsert(String table,ContentValues cv, String sqlcondition,
			String[] sqlconditionvalue, Context context) throws Exception {
		SQLiteDatabase localSQLiteDatabase = new DatabaseHelper(context).getReadableDatabase();
		long row = localSQLiteDatabase.update(table,cv,sqlcondition,sqlconditionvalue);
		localSQLiteDatabase.close();
		return row;
	}
	/**
	 * 执行删除
	 */
	public long sqlDelete(String table, String sqlcondition,
			String[] sqlconditionvalue, Context context) throws Exception {
		SQLiteDatabase localSQLiteDatabase = new DatabaseHelper(context).getReadableDatabase();
		long row = localSQLiteDatabase.delete(table, sqlcondition, sqlconditionvalue);
		localSQLiteDatabase.close();
		return row;
	}
}
