package com.capacity.smartglass;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Setup1Activity extends BaseSetupActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setup1);
	}
	
	public void next(View view){
		showNext();
	}


	@Override
	public void showPref() {
	}

	@Override
	public void showNext() {
		Intent i=new Intent(Setup1Activity.this,Setup2Activity.class);
		startActivity(i);
		finish();
		overridePendingTransition(R.anim.page_next, R.anim.page_exit);
	}
}
