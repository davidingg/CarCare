package com.david.car.carmessage.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.david.car.R;
import com.david.car.carmessage.model.CarMessageListManager;
import com.david.car.carmessage.model.CarMessageListManagerImpl;
import com.david.car.knowledge.activity.knowledge_car_active;
import com.david.car.knowledge.activity.knowledge_content_active;

public class CarMessageListActivity extends Activity implements OnClickListener{
	private Button car_message_add_btn = null; //新增汽车信息
	private int REQUEST_CODE = 1;
	private Button login_reback_btn = null;
	private ListView car_message_list = null;
	private List carslist_item = new ArrayList();
	private CarMessageListManager cManager=new CarMessageListManagerImpl();
	public void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
		 requestWindowFeature(Window.FEATURE_NO_TITLE);//取消页面标题  
		 setContentView(R.layout.carmessage_list);//定义画面对应的xml布局
		 initView();
		 try {
			getCarMessagesList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 private void initView()//读取视图控件
	{
		 this.login_reback_btn = (Button)findViewById(R.id.login_reback_btn);
		 this.login_reback_btn.setOnClickListener(this);
		 //this.car_message_add_btn=(Button) findViewById(R.id.car_message_add_btn);
		 //this.car_message_add_btn.setOnClickListener(this);
		 this.car_message_list = (ListView) findViewById(R.id.car_message_list); 
		 this.car_message_list.setDivider(null);
		 this.car_message_list.setSelector(android.R.color.transparent);
	}
	 public void onClick(View v) {
			switch(v.getId())
			{
			case R.id.login_reback_btn:
				finish();
				break;
			//case R.id.car_message_add_btn:
			//	send();
			//	break;
			}
	}
	//跳转页面
    public void send(){
    	Intent intent=new Intent();//申请传值
		intent.setClass(CarMessageListActivity.this, CarMessageSetActivity.class);//画面跳转到knowledge_car_active 保养页面
		setResult(REQUEST_CODE,intent);
		startActivity(intent);
    }
    public void getCarMessagesList() throws Exception{
    	carslist_item=cManager.getCarMessagesList(this);//获取数据库列表数据
    	car_message_list.setAdapter(new SimpleAdapter(this,carslist_item,R.layout.carmessage_list_item,new String[]{"plate_number"},new int[]{R.id.car_item}));		
    	car_message_list.setOnItemClickListener(new AdapterView.OnItemClickListener()
    	{
    		@Override
    		public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
    		{
	        	HashMap list_item_map=(HashMap)CarMessageListActivity.this.carslist_item.get(paramAnonymousInt);
	        	Intent intent=new Intent();
				intent.setClass(CarMessageListActivity.this, CarMessageSetActivity.class);
				intent.putExtra("_id", list_item_map.get("_id").toString());
				intent.putExtra("plate_number", list_item_map.get("plate_number").toString());
				intent.putExtra("car_type", list_item_map.get("car_type").toString());
				intent.putExtra("travel_mileage", list_item_map.get("travel_mileage").toString());
				intent.putExtra("last_carcare_time", list_item_map.get("last_carcare_time").toString());
				intent.putExtra("care_period", list_item_map.get("care_period").toString());
				intent.putExtra("care_mileage", list_item_map.get("care_mileage").toString());
				setResult(REQUEST_CODE,intent);
				startActivityForResult(intent, REQUEST_CODE);
    		}
    	});
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		Log.v("dwei","resutlddd");
		if(requestCode==REQUEST_CODE){
			try {
				getCarMessagesList();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
    
}
