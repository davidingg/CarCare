package com.david.car.carmessage.activity;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.david.car.R;
import com.david.car.carmessage.model.CarMessageSetManager;
import com.david.car.carmessage.model.CarMessageSetManagerImpl;

public class CarMessageSetActivity extends Activity implements OnClickListener,OnFocusChangeListener{
	private Button login_reback_btn = null;
	private Button save_btn = null; //保存按钮
	private Button delete_btn = null;//删除按钮
	private EditText plate_number = null; //车牌号
	private EditText cartype = null;	//汽車型號
	private EditText travel_mileage = null; //當前里程
	private EditText last_carcare_time = null;//上次保養
	private EditText care_period = null;//保養週期
	private EditText care_mileage = null;//保養里程
	private AlertDialog.Builder alertdialog = null;//提示框
	private int _id=0;//主键值
	private CarMessageSetManager cManager=new CarMessageSetManagerImpl();
	
	public void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
		 requestWindowFeature(Window.FEATURE_NO_TITLE);//取消页面标题  
		 setContentView(R.layout.carmessage_set);//定义画面对应的xml布局
		 initView();
		 Intent intent = getIntent();
		 if(intent.getStringExtra("_id")!=null){
	     	_id = Integer.parseInt(intent.getStringExtra("_id"));
	     	if(_id!=0){
	     		this.plate_number.setText(intent.getStringExtra("plate_number"));
	     	} else {
	     		this.plate_number.setText("");
	     	}
	     	this.cartype.setText(intent.getStringExtra("car_type"));
	     	this.travel_mileage.setText(intent.getStringExtra("travel_mileage"));
	     	this.last_carcare_time.setText(intent.getStringExtra("last_carcare_time"));
	     	this.care_period.setText(intent.getStringExtra("care_period"));
	     	this.care_mileage.setText(intent.getStringExtra("care_mileage"));
		 }
	}
	/**
	 * 读取视图控件
	 */
	private void initView()
	{
		this.login_reback_btn = (Button)findViewById(R.id.login_reback_btn);
		this.login_reback_btn.setOnClickListener(this);
		this.save_btn = (Button)findViewById(R.id.save_button);
		this.delete_btn = (Button)findViewById(R.id.delete_button);
		this.save_btn.setOnClickListener(this);
		this.delete_btn.setOnClickListener(this);
		this.plate_number = (EditText)findViewById(R.id.plate_number);
		this.cartype = (EditText)findViewById(R.id.cartype);
		this.travel_mileage = (EditText)findViewById(R.id.travel_mileage);
		
		this.last_carcare_time = (EditText)findViewById(R.id.last_carcare_time);
		this.last_carcare_time.setCursorVisible(false);//只讀
		this.last_carcare_time.setFocusable(false);
		this.last_carcare_time.setFocusableInTouchMode(false);
		this.last_carcare_time.setOnClickListener(this);
		
		this.care_period = (EditText)findViewById(R.id.care_period);
		this.care_mileage=(EditText)findViewById(R.id.care_mileage);
		//初始化提示框。
		this.alertdialog = new Builder(CarMessageSetActivity.this);
		alertdialog.setMessage("确认删除吗？");
		alertdialog.setTitle("提示");
		alertdialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
		   public void onClick(DialogInterface dialog, int which) {
			   dialog.dismiss();
			   deleteCarMessage();
			   finish();
		   }
		});

		alertdialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
			 public void onClick(DialogInterface dialog, int which) {
				    dialog.dismiss();
			 }
		});
		
	}
	/**
	 * 处理点击事件
	 */
	public void onClick(View v) {
		switch(v.getId())
		{
		case R.id.login_reback_btn:
			finish();
			break;
		case R.id.save_button:
			saveCarMessage();
			break;
		case R.id.delete_button:
			alertdialog.create().show();
			break;
		case R.id.last_carcare_time:
			showDateDialog(v);
			break;
		}
				
	}
	/**
	 * 處理焦點事件
	 */
	public void onFocusChange(View v, boolean hasFocus) {
		switch(v.getId())
		{
		}	
	}
	/**
	 * 储存汽车基本信息
	 */
	public void saveCarMessage(){
		String plate_number = this.plate_number.getText().toString();
		String cartype = this.cartype.getText().toString();
		String travel_mileage = this.travel_mileage.getText().toString();
		String last_carcare_time = this.last_carcare_time.getText().toString();
		String care_period = this.care_period.getText().toString();
		String care_mileage = this.care_mileage.getText().toString();
		
		try {
			if(_id==0){//当主键值是零新增
				String result = cManager.addCarMessage(this,plate_number,cartype,travel_mileage,last_carcare_time,care_period,care_mileage);
				if("success".equals(result)){
					Toast.makeText(this, "新增成功!", Toast.LENGTH_LONG).show(); 
				} else {
					Toast.makeText(this, "新增失败!", Toast.LENGTH_LONG).show(); 
				}
			} else {
				String result = cManager.updCarMessage(this,_id,plate_number,cartype,travel_mileage,last_carcare_time,care_period,care_mileage);
				if("success".equals(result)){
					Toast.makeText(this, "修改成功!", Toast.LENGTH_LONG).show(); 
				} else {
					Toast.makeText(this, "修改失败!", Toast.LENGTH_LONG).show(); 
				}
			}	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 删除汽车信息
	 */
	public void deleteCarMessage(){
		if(_id!=0){//当主键值是零删除
			try {
				String result = cManager.delCarMessage(this,_id);
				if("success".equals(result)){
					Toast.makeText(this, "删除成功!", Toast.LENGTH_LONG).show(); 
				} else {
					Toast.makeText(this, "删除失败!", Toast.LENGTH_LONG).show(); 
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			Toast.makeText(this, "不需要删除!", Toast.LENGTH_LONG).show(); 
		}
	}
	
	/**
	 * 彈出日期輸入控件
	 */
	public void showDateDialog(View v){
		Log.v("dwei", "2222222222222222");
		Calendar myCalendar = Calendar.getInstance(Locale.CHINA);
        Date myDate=new Date();                //获取当前日期Date对象
        myCalendar.setTime(myDate);              //为Calendar对象设置时间为当前日期
        int year=myCalendar.get(Calendar.YEAR);                //获取Calendar对象中的年
        int month=myCalendar.get(Calendar.MONTH);
        int day=myCalendar.get(Calendar.DAY_OF_MONTH);         //获取这个月的第几天
		DatePickerDialog dpd = new DatePickerDialog(CarMessageSetActivity.this,new OnDateSetListener(){
			 public void onDateSet(DatePicker view, int myyear,int monthOfYear,int dayOfMonth) {
				 last_carcare_time.setText(myyear+"-"+(monthOfYear+1)+"-"+dayOfMonth);
         }},year,month,day);	
		dpd.show(); 
	}

}
