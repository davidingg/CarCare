package com.david.car.carcareitem.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.david.car.R;
import com.david.car.carcareitem.model.CarCareItemListManager;
import com.david.car.carcareitem.model.CarCareItemListManagerImpl;

public class CarCareItemListActivity extends Activity implements OnClickListener{
	private Button login_reback_btn = null;//返回按钮
	private ListView carcare_item_list = null;//保养项目显示列表
	private List carcareslist_item = new ArrayList();
	private CarCareItemListManager cManager=new CarCareItemListManagerImpl();
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);//取消页面标题  
		setContentView(R.layout.carmessage_list);//定义画面对应的xml布局
		initView();
		try {
			getCarCareItemList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void initView()//读取视图控件
	{
		 this.login_reback_btn = (Button)findViewById(R.id.login_reback_btn);
		 this.login_reback_btn.setOnClickListener(this);
		 this.carcare_item_list = (ListView) findViewById(R.id.carcare_item_list); 
	}
	public void onClick(View v) {
			switch(v.getId())
			{
			case R.id.login_reback_btn:
				finish();
				break;
			}
	}
	public void getCarCareItemList()throws Exception{
		carcareslist_item=cManager.getCarCareItemList(this);
		carcare_item_list.setAdapter(new SimpleAdapter(this,carcareslist_item,R.layout.carcareitem_list_item,new String[]{"care_item","care_price","changeYn"},new int[]{R.id.carcareitem_list_item_title,R.id.carcareitem_list_item_money,R.id.carcareitem_list_item_change}));
	}
}
