package com.david.car.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

import com.david.car.R;
import com.david.car.carcareitem.activity.CarCareItemListActivity;
import com.david.car.carmessage.activity.CarMessageListActivity;
import com.david.car.dao.DBManager;
import com.david.car.knowledge.activity.knowledge_car_active;

public class CareCare extends Activity implements OnClickListener{
	/** Called when the activity is first created. */
	private Button knowledgeBtn = null;//定义汽车保养按钮
	private Button carmessageBtn = null;//定义汽车信息注册按钮
	private Button caritemBtn = null;//定义汽车保养项目按钮
	private int REQUEST_CODE = 1;
	private Button login_reback_btn = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//取消页面标题  
        setContentView(R.layout.main_carcare);//定义画面对应的xml布局
        DBManager dbHelper = new DBManager(this); //载入数据库
        dbHelper.openDatabase(); 
        dbHelper.closeDatabase();
        initView();
    }
    private void initView()//读取视图控件
	{
    	this.login_reback_btn = (Button)findViewById(R.id.login_reback_btn);
		this.login_reback_btn.setOnClickListener(this);
    	this.knowledgeBtn = (Button) findViewById(R.id.knowledge);//获取汽车保养按钮对象
    	knowledgeBtn.setOnClickListener(this);//添加点击事件
    	this.carmessageBtn = (Button) findViewById(R.id.carmessage);//获取汽车信息注册按钮对象
    	carmessageBtn.setOnClickListener(this);
    	this.caritemBtn = (Button) findViewById(R.id.careitem);//获取汽车信息注册按钮对象
    	caritemBtn.setOnClickListener(this);
	}   
    public void onClick(View v) {
		switch(v.getId())
		{
		case R.id.login_reback_btn:
			finish();
			break;
		case R.id.knowledge:
			sendKnowledge();
			break;
		case R.id.carmessage:
			sendCarmessage();
			break;
		case R.id.careitem:
			sendCareItem();
			break;
		}
	}
    //跳转页面
    public void sendKnowledge(){
    	Intent intent=new Intent();//申请传值
		intent.setClass(CareCare.this, knowledge_car_active.class);//画面跳转到knowledge_car_active 保养页面
		setResult(REQUEST_CODE,intent);
		startActivity(intent);
    }
   //跳转页面
    public void sendCarmessage(){
    	Intent intent=new Intent();//申请传值
		intent.setClass(CareCare.this, CarMessageListActivity.class);//画面跳转到knowledge_car_active 保养页面
		setResult(REQUEST_CODE,intent);
		startActivity(intent);
    }
   //跳转保养项目页面
    public void sendCareItem(){
    	Intent intent=new Intent();//申请传值
		intent.setClass(CareCare.this, CarCareItemListActivity.class);//画面跳转到knowledge_car_active 保养页面
		setResult(REQUEST_CODE,intent);
		startActivity(intent);
    }
}