package com.capacity.smartglass.setup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.capacity.smartglass.BaseSetupActivity;
import com.capacity.smartglass.HomeActivity;
import com.capacity.smartglass.R;

public class Setup3Activity extends BaseSetupActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setup3);
	}

	public void next(View view) {
		showNext();
	}
	
	@Override
	public void showPref() {
		Intent i = new Intent(Setup3Activity.this, Setup2Activity.class);
		startActivity(i);
		finish();
		overridePendingTransition(R.anim.page_pref, R.anim.page_exit2);
	}

	@Override
	public void showNext() {
		Intent i = new Intent(Setup3Activity.this, HomeActivity.class);
		startActivity(i);
		finish();
		overridePendingTransition(R.anim.page_next, R.anim.page_exit);
	}
}
