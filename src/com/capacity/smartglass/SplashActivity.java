package com.capacity.smartglass;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;

public class SplashActivity extends Activity {

    private TextView tv_splash_version;

    private Handler handler=new Handler(){

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
		}
    	
    };
    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        tv_splash_version = (TextView) findViewById(R.id.tv_splash_version);
		tv_splash_version.setText(getVersionName());
		AlphaAnimation aa = new AlphaAnimation(0.2f, 1.0f);
		aa.setDuration(2000);
		findViewById(R.id.rl_root_splash).startAnimation(aa);
		//可以理解为异步延时
		handler.postDelayed(new Runnable() {
			
			@Override
			public void run() {
				jumpSetup();
			}
		},2000);
        
    }

	private String getVersionName() {
		PackageManager pm=getPackageManager();
		try {
			PackageInfo info=pm.getPackageInfo(getPackageName(), 0);
			return "版本号"+info.versionName;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
			return "";
		}
	}

	private void jumpSetup() {
		Intent i=new Intent(this,Setup1Activity.class);
		startActivity(i);
		finish();
	}
}
