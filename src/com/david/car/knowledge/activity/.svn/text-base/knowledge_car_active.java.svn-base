package com.david.car.knowledge.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.david.car.R;
import com.david.car.dao.DatabaseHelper;
import com.david.car.knowledge.model.KnowledgeCarManager;
import com.david.car.knowledge.model.KnowledgeCarManagerImpl;

public class knowledge_car_active extends Activity  implements OnClickListener{
	private Button mChannelOneButton=null;
	private Button mChannelTwoButton=null;
	private Button mChannelThreeButton=null;
	private Button mChannelFourButton=null;
	private Button mChannelFiveButton=null;
	private ListView knowledges_list = null;
	private List newslist_item = new ArrayList();
	private Vector<Button> mVector;
	private ArrayList buttonTextList=new ArrayList();
	private int REQUEST_CODE = 1;
	private KnowledgeCarManagerImpl kManager=new KnowledgeCarManagerImpl();
	private Button login_reback_btn = null;
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //去除页面标题 
        setContentView(R.layout.knowledge_carcare);//定义画面对应的xml布局
        try {
	        ListAdapter adapter;
	        initView();
	        mVector=new Vector<Button>();//导航栏按钮聚集
	        mVector.add(mChannelOneButton);
	        mVector.add(mChannelTwoButton);
	        mVector.add(mChannelThreeButton);
	        mVector.add(mChannelFourButton);
	        mVector.add(mChannelFiveButton);
			buttonTextList = kManager.getKnowledgeTypesList(this);
	        for(int i = 0;i<buttonTextList.size();i++){//增加保養知識導航欄
	        	addChannelButton(buttonTextList.get(i).toString(),i);
	        }
	        //頁面剛載入時需要顯示第一個類別的列表
	        getKnowledgesList(buttonTextList.get(0).toString());
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void initView()//读取视图控件
	{
		this.mChannelOneButton=(Button) findViewById(R.id.knowledges_list_channel_one);//获取第一个分类按钮
		this.mChannelTwoButton=(Button) findViewById(R.id.knowledges_list_channel_two);//获取第二个分类按钮
		this.mChannelThreeButton=(Button) findViewById(R.id.knowledges_list_channel_three);//获取第三个分类按钮
		this.mChannelFourButton=(Button) findViewById(R.id.knowledges_list_channel_four);//获取第四个分类按钮
		this.mChannelFiveButton=(Button) findViewById(R.id.knowledges_list_channel_five);//获取第五个分类按钮
		knowledges_list = (ListView) findViewById(R.id.knowledges_list);
		this.login_reback_btn = (Button)findViewById(R.id.login_reback_btn);
		this.login_reback_btn.setOnClickListener(this);
	}
	/**
	 * 顯示每個類別對應的保養知識列表
	 * @param knowledgetype
	 * @throws Exception 
	 */
	private void getKnowledgesList(String knowledgetype) throws Exception{
		newslist_item=kManager.getKnowledgesList(this,knowledgetype);
        knowledges_list.setAdapter(new SimpleAdapter(this,newslist_item,R.layout.knowledge_list_item,new String[]{"newslist_item_title","newslist_item_zhaiyao","newslist_item_zuozhe","newslist_item_datatime"},new int[]{R.id.news_news_list_item_title,R.id.news_news_list_item_content,R.id.news_news_list_item_image,R.id.news_news_list_item_time}));	
        knowledges_list.setOnItemClickListener(new AdapterView.OnItemClickListener()
	      {
	        @Override
	        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
	        {
	        	HashMap list_item_map=(HashMap)knowledge_car_active.this.newslist_item.get(paramAnonymousInt);
	        	Intent intent=new Intent();
				intent.setClass(knowledge_car_active.this, knowledge_content_active.class);
				Log.v("dw",list_item_map.get("_id").toString());
				intent.putExtra("_id", list_item_map.get("_id").toString());
				setResult(REQUEST_CODE,intent);
				startActivity(intent);
	        }
	      });
	}
	/**
	 * 增加保養知識導航欄
	 * @param paramString1
	 * @param paramInt
	 */
	private void addChannelButton(final String paramString1, final int paramInt){
		Button currentButton = mVector.get(paramInt); 
		if(paramInt==0){
			currentButton.setVisibility(0);
			currentButton.setTextColor(-1);
			currentButton.setBackgroundResource(R.drawable.news_channel_button_on);
			currentButton.setText(paramString1);
		} else {
			currentButton.setVisibility(0);
			currentButton.setTextColor(getResources().getColor(R.color.news_channel_color));
			currentButton.setBackgroundResource(R.drawable.news_channel_button);
			currentButton.setText(paramString1);
		}
		//導航欄添加點擊事件
		currentButton.setOnClickListener(new View.OnClickListener()
	      {
	        @Override
			public void onClick(View paramAnonymousView)
	        {
	        	for(int i=0;i<mVector.size();i++){
	        		Button otherButton = mVector.get(i);
	        		if(i!=paramInt){
	        			otherButton.setBackgroundResource(R.drawable.news_channel_button);
	        			otherButton.setTextColor(getResources().getColor(R.color.news_channel_color));
	        		} else {
	        			otherButton.setBackgroundResource(R.drawable.news_channel_button_on);
	        			otherButton.setTextColor(-1);
	        		} 
	        	}
	        	try {
	        		getKnowledgesList(buttonTextList.get(paramInt).toString());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	      });
	}
	
	public void onClick(View v) {
		switch(v.getId())
		{
		case R.id.login_reback_btn:
			finish();
			break;
		}
	}
}
