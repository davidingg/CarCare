package com.david.car.carmessage.model;

import java.util.ArrayList;

import android.content.Context;

public interface CarMessageListManager {
	/**
	 * 查詢车辆登记列表
	 * @param context
	 * @return
	 * @throws Exception
	 */
	public ArrayList getCarMessagesList(Context context)throws Exception;
}
