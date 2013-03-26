package com.david.car.knowledge.model;

import android.content.Context;

import com.david.car.dao.BaseDao;
import com.david.car.dao.BaseDaoImpl;
import com.david.car.util.BaseDataEntities;

public class knowledgeContentManagerImpl implements knowledgeContentManager {
	private BaseDao dao = new BaseDaoImpl();
	/**
	 * 獲取保養常識正文
	 */
	public String getKnowledge(Context context,int id) throws Exception {
		// TODO Auto-generated method stub
		String knowledge_text = "";
		String sql = "select knowledge_title,knowledge_text from knowledge_text  where _id='"+id+"'";
		BaseDataEntities rows = dao.sqlQuery(sql,context);
		if(rows.size()>0){
			knowledge_text = rows.get(0).gpsv("knowledge_text");
		}
		return knowledge_text;
	}

}
