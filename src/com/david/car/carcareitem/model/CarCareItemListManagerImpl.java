package com.david.car.carcareitem.model;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.util.Log;

import com.david.car.dao.BaseDao;
import com.david.car.dao.BaseDaoImpl;
import com.david.car.util.BaseDataEntities;
import com.david.car.util.BaseDataEntity;
import com.david.car.util.Utils;


/**
 * 汽车保养知识实现类
 * 
 * @author
 */
public class CarCareItemListManagerImpl implements CarCareItemListManager {
	private BaseDao dao = new BaseDaoImpl();
	private String sql = "";//执行sql 语句
	private BaseDataEntities rows = null;//sql查询结果
	private Utils utils = null;
	/**
	 * 查詢车辆登记列表
	 * @param context
	 * @return
	 * @throws Exception
	 */
	public ArrayList getCarCareItemList(Context context)throws Exception{
		int item_id = 0;//保养项目ID
		String care_item = "";//保养项目
		int care_time = 0;//项目检查时间间隔
		int care_mile = 0;//项目检查里程间隔
		int change_time = 0;//项目更换时间间隔
		int change_mile = 0;//项目更换里程间隔

		int care_period = 0;//汽车保养间隔时间
		int care_mileage = 0;//汽车保养间隔里程
		String recent_care_time = "";//最近保养时间
		int recent_care_mile = 0;//最近保养里程
		String last_carcare_time = "";//上次保养时间
		int travel_mileage = 0;//当前行驶里程 
		String careYn = "";
		String changeYn = "";
		Log.v("dwei:","11111111111");
		ArrayList list = new ArrayList();
		HashMap<String, String> list_item_map = new HashMap();
		sql = "select a.item_id,a.care_item,a.care_time,a.care_mile,a.change_time,a.change_mile,a.care_price "
			+ "	,b.last_carcare_time,a.recent_care_time "
			+ "	,b.travel_mileage,a.recent_care_mile  "
			+ "	,b.care_period,b.care_mileage  "
			+ "	 from ( "
			+ "	    select a._id as item_id,a.care_item,a.care_time,a.care_mile,a.change_time,a.change_mile,a.care_price "
			+ "	    ,ifnull(b.recent_care_time,0) as recent_care_time "
			+ "	    ,ifnull(b.recent_care_mile,0) as recent_care_mile "
			+ "	   ,ifnull(b.care_message_id,1) as care_message_id "
			+ "	   from care_item a left join ( "
			+ "	      select a.care_message_id,b.item_id,max(a.recent_care_time) as recent_care_time,max(a.recent_care_mile) as recent_care_mile " 
			+ "	      from care_record a join care_record_mx b on a._id=b.record_id "
			+ "	      where care_message_id=1  group by b.item_id "
			+ "	    ) b on a._id=b.item_id  ) a join "
			+ "	car_message b on a.care_message_id=b._id";
		rows = dao.sqlQuery(sql,context);
		for(int i = 0;i<rows.size();i++){
			Log.v("dwei:","22222222222222");
			BaseDataEntity row = rows.get(i);		
			Log.v("dwei:",row.gpsv("care_item"));
			item_id = row.gpiv("item_id");//保养项目ID
			care_item = row.gpsv("care_item");//保养项目
			care_time = row.gpiv("care_time");//项目检查时间间隔
			care_mile = row.gpiv("care_mile");//项目检查里程间隔
			change_time = row.gpiv("change_time");//项目更换时间间隔
			change_mile = row.gpiv("change_mile");//项目更换里程间隔

			care_period = row.gpiv("care_period");//汽车保养间隔时间
			care_mileage = row.gpiv("care_mileage");//汽车保养间隔里程
			recent_care_time = row.gpsv("recent_care_time");//最近保养时间
			recent_care_mile = row.gpiv("recent_care_mile");//最近保养里程
			
			last_carcare_time = row.gpsv("last_carcare_time");
			travel_mileage = row.gpiv("travel_mileage");
			
			//第一步计算出最近保养里程，最近保养日期
			if(recent_care_mile==0){//当最近保养里程
				recent_care_mile=travel_mileage/care_mileage*care_mileage;	
			}
			if("".equals(recent_care_time)){
				recent_care_time = last_carcare_time;
			};
			
			//第二步通过里程计算出下次该项目是否要检查
			
			if((travel_mileage+care_mileage)>=(recent_care_mile+care_mile)){//行驶里程+汽车保养间隔里程>=最近保养里程+项目检查里程间隔
				careYn = "Y";
			}
			//第三步通过里程计算出下次保养该项目是否要更换
			if((travel_mileage+care_mileage)>=(recent_care_mile+change_mile)){//行驶里程+汽车保养间隔里程>=最近保养里程+项目更换里程间隔
				changeYn = "Y";
			}
			//第四步通过时间计算出下次该项目是否要检查
			String itemCareDate=utils.formatDate(last_carcare_time,Utils.MONTH,care_time); //零件下次保养时间
			String carCareDate=	utils.formatDate(recent_care_time,Utils.MONTH,care_period);//汽车下次保养时间
			if(utils.diffDate(carCareDate,itemCareDate)>=0){
				careYn = "Y";
			}
			String itemChangeDate=utils.formatDate(recent_care_time,Utils.MONTH,change_time);//零件下次更换时间
			
			//第五部通过时间计算出下次该项目是否要更换
			if(utils.diffDate(carCareDate,itemChangeDate)>=0){
				changeYn = "Y";
			}
			if("Y".equals(careYn)||"Y".equals(changeYn)){
				list_item_map = new HashMap();
				list_item_map.put("item_id",String.valueOf(item_id));
				list_item_map.put("care_item", care_item);
				list_item_map.put("care_price", row.gpsv("care_price"));
				list_item_map.put("changeYn", changeYn);
				list.add(list_item_map);
			}
		}
		//新增汽车
		
		return list;
	}
}
