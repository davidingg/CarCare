package com.david.car.knowledge.model;

import java.util.ArrayList;

import android.content.Context;


public interface KnowledgeCarManager {
	/**
	 * 查詢保養知識分類列表
	 * @param context
	 * @return
	 * @throws Exception
	 */
	public ArrayList getKnowledgeTypesList(Context context)throws Exception;
	/**
	 * 查詢保養知識列表
	 * @param context
	 * @return
	 * @throws Exception
	 */
	public ArrayList getKnowledgesList(Context context,String knowledgetype)throws Exception;
}
