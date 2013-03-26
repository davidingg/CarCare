package com.david.car.carmessage.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import com.david.car.dao.BaseDao;
import com.david.car.dao.BaseDaoImpl;
import com.david.car.util.BaseDataEntities;
import com.david.car.util.BaseDataEntity;


/**
 * 汽车保养知识实现类
 * 
 * @author
 */
public class CarMessageListManagerImpl implements CarMessageListManager {
	private BaseDao dao = new BaseDaoImpl();
	/**
	 * 查詢车辆登记列表
	 * @param context
	 * @return
	 * @throws Exception
	 */
	public ArrayList getCarMessagesList(Context context)throws Exception{
		ArrayList list = new ArrayList();
		HashMap<String, String> list_item_map = new HashMap();
		String sql = " select _id,plate_number,car_type,travel_mileage,last_carcare_time,care_period,care_mileage from car_message ";
		BaseDataEntities rows = dao.sqlQuery(sql,context);
		for(int i = 0;i<rows.size();i++){
			BaseDataEntity row = rows.get(i);
			list_item_map = new HashMap();
			list_item_map.put("_id", row.gpsv("_id"));
			list_item_map.put("plate_number", row.gpsv("plate_number"));
			list_item_map.put("car_type", row.gpsv("car_type"));
			list_item_map.put("travel_mileage", row.gpsv("travel_mileage"));
			list_item_map.put("last_carcare_time", row.gpsv("last_carcare_time"));
			list_item_map.put("care_period", row.gpsv("care_period"));
			list_item_map.put("care_mileage", row.gpsv("care_mileage"));
			list.add(list_item_map);
		}
		//新增汽车
		list_item_map = new HashMap();
		list_item_map.put("_id","0");
		list_item_map.put("plate_number","添加车辆");
		list_item_map.put("car_type", "");
		list_item_map.put("travel_mileage", "");
		list_item_map.put("last_carcare_time", "");
		list_item_map.put("care_period", "");
		list_item_map.put("care_mileage", "");
		list.add(list_item_map);
		return list;
	}
}
