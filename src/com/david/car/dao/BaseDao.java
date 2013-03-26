package com.david.car.dao;

import android.content.ContentValues;
import android.content.Context;

import com.david.car.util.BaseDataEntities;

public interface BaseDao {
	
	public BaseDataEntities sqlQuery(String hsql,Context context) throws Exception;
	public long sqlInsert(String table,ContentValues cv,Context context)throws Exception;
	public long sqlUpdsert(String table,ContentValues cv,String sqlcondition,String[] sqlconditionvalue,Context context)throws Exception;
	public long sqlDelete(String table,String sqlcondition,String[] sqlconditionvalue,Context context)throws Exception;
	
}
