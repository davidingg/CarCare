package com.david.car.carmessage.model;

import java.util.Date;

import android.content.ContentValues;
import android.content.Context;

import com.david.car.dao.BaseDao;
import com.david.car.dao.BaseDaoImpl;


/**
 * 汽车保养知识实现类
 * 
 * @author
 */
public class CarMessageSetManagerImpl implements CarMessageSetManager {
	private BaseDao dao = new BaseDaoImpl();
	/**
	 * 新增汽车基本信息
	 * @param 
	 * @return
	 * @throws Exception
	 */
	public String addCarMessage(Context context,String plate_number,String cartype,String travel_mileage,String last_carcare_time,String care_period,String care_mileage)throws Exception{
		ContentValues cv = new ContentValues(); 
		cv.put("plate_number", plate_number);
		cv.put("car_type", cartype);
		cv.put("travel_mileage", travel_mileage);
		cv.put("last_carcare_time", last_carcare_time);
		cv.put("care_period", care_period);
		cv.put("care_mileage", care_mileage);
		cv.put("crt_date", String.valueOf(new Date()));
		cv.put("crt_usr", "丁伟");
		long rows = dao.sqlInsert("car_message",cv,context);
		if(rows>0){
			return "success";
		} else {
			return "fail";
		}	
	}
	
	public String updCarMessage(Context context,int _id,String plate_number,String cartype,String travel_mileage,String last_carcare_time,String care_period,String care_mileage)throws Exception{
		ContentValues cv = new ContentValues();
		String[]sqlconditionvalue={String.valueOf(_id)};
		cv.put("plate_number", plate_number);
		cv.put("car_type", cartype);
		cv.put("travel_mileage", travel_mileage);
		cv.put("last_carcare_time", last_carcare_time);
		cv.put("care_period", care_period);
		cv.put("care_mileage", care_mileage);
		cv.put("upd_date", String.valueOf(new Date()));
		cv.put("upd_usr", "丁伟");
		long rows = dao.sqlUpdsert("car_message",cv,"_id=?",sqlconditionvalue,context);
		if(rows>0){
			return "success";
		} else {
			return "fail";
		}	
	}

	/**
	 * 删除汽车基本信息
	 */
	public String delCarMessage(Context context, int _id) throws Exception {
		String[]sqlconditionvalue={String.valueOf(_id)};
		long rows = dao.sqlDelete("car_message","_id=?",sqlconditionvalue,context);
		if(rows>0){
			return "success";
		} else {
			return "fail";
		}	
	}

}
