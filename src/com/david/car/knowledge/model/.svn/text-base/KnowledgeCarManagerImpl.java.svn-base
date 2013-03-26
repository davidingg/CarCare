package com.david.car.knowledge.model;

import java.util.ArrayList;
import java.util.HashMap;

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
public class KnowledgeCarManagerImpl implements KnowledgeCarManager {
	private BaseDao dao = new BaseDaoImpl();
	/**
	 * 查詢保養知識分類列表 
	 * @param context
	 * @return
	 * @throws Exception
	 */
	public ArrayList getKnowledgeTypesList(Context context) throws Exception {
		ArrayList list = new ArrayList();
		String sql = "select type from knowledge_type";
		BaseDataEntities rows = dao.sqlQuery(sql,context);

		for(int i = 0;i<rows.size();i++){
			BaseDataEntity row = rows.get(i);
			list.add(row.gpsv("type"));
		}
		return list;
	}
	/**
	 * 查詢保養知識列表
	 * @param context
	 * @return
	 * @throws Exception
	 */
	public ArrayList getKnowledgesList(Context context,String knowledgetype) throws Exception {
		ArrayList list = new ArrayList();
		HashMap<String, String> list_item_map = new HashMap();
		String sql = "select _id,knowledge_title,knowledge_msg from knowledge_text  where type='"+knowledgetype+"'";
		BaseDataEntities rows = dao.sqlQuery(sql,context);
		for(int i = 0;i<rows.size();i++){
			BaseDataEntity row = rows.get(i);
			list_item_map = new HashMap();
			list_item_map.put("_id", row.gpsv("_id"));
			list_item_map.put("newslist_item_title", row.gpsv("knowledge_title"));
			list_item_map.put("newslist_item_zhaiyao", row.gpsv("knowledge_msg"));
			list_item_map.put("newslist_item_zuozhe", "david");
			list_item_map.put("newslist_item_datatime", "");
			list.add(list_item_map);
		}
		return list;
	}

}
