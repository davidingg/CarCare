package com.david.car.knowledge.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;

import com.david.car.R;
import com.david.car.knowledge.model.knowledgeContentManager;
import com.david.car.knowledge.model.knowledgeContentManagerImpl;

public class knowledge_content_active extends Activity implements OnClickListener {
	private WebView knowledgetext = null;
	private Button login_reback_btn = null;
	private knowledgeContentManager kManager=new knowledgeContentManagerImpl();
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);  
        setContentView(R.layout.knowledge_content);
        try {
        	Intent intent = getIntent();
        	int _id = Integer.parseInt(intent.getStringExtra("_id"));
        	initView();
        	knowledgetext.loadDataWithBaseURL("",kManager.getKnowledge(this,_id),"text/html", "UTF-8","");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	public void initView()
    {
		this.knowledgetext = (WebView)findViewById(R.id.knowledgetext);
		this.login_reback_btn = (Button)findViewById(R.id.login_reback_btn);
		this.login_reback_btn.setOnClickListener(this);
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
