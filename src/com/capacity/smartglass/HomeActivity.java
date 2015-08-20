package com.capacity.smartglass;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TabHost;

import com.capacity.smartglass.model.ChartRender;

import org.achartengine.ChartFactory;

public class HomeActivity extends TabActivity implements CompoundButton.OnCheckedChangeListener {


    private TabHost tabHost;
    private Intent alarmIntent;
    private Intent planIntent;
    private Intent chartIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ChartRender render = new ChartRender();

        this.alarmIntent = new Intent(this, AlarmActivity.class);
        this.planIntent = new Intent(this, PlanActivity.class);
        this.chartIntent = render.execute(this);

        ((RadioButton) findViewById(R.id.tab_alarm)).setChecked(true);

        ((RadioButton) findViewById(R.id.tab_alarm)).setOnCheckedChangeListener(this);
        ((RadioButton) findViewById(R.id.tab_plan)).setOnCheckedChangeListener(this);
        ((RadioButton) findViewById(R.id.tab_chart)).setOnCheckedChangeListener(this);
        ((RadioButton) findViewById(R.id.tab_more)).setOnCheckedChangeListener(this);

        setupIntent();
    }

    private void setupIntent() {
        //调用tabactivity的getTabHost()方法获取TabHost对象
        this.tabHost = getTabHost();

        TabHost localTabHost = this.tabHost;

        //添加属性
        localTabHost.addTab(buildTabSpec("ALARM_TAB", R.string.home_alarm, R.drawable.back_alarm, this
                .alarmIntent));
        localTabHost.addTab(buildTabSpec("PLAN_TAB", R.string.home_plan, R.drawable.back_plan, this
                .planIntent));
        localTabHost.addTab(buildTabSpec("CHART_TAB", R.string.home_chart, R.drawable.back_chart,
                this
                .chartIntent));


    }

    private TabHost.TabSpec buildTabSpec(String tag, int resLabel, int resIcon,
                                         final Intent content) {
        return this.tabHost.newTabSpec(tag).setIndicator(getString(resLabel),
                getResources().getDrawable(resIcon)).setContent(content);
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            switch (buttonView.getId()) {
                case R.id.tab_alarm:
                    this.tabHost.setCurrentTabByTag("ALARM_TAB");
                    break;
                case R.id.tab_plan:
                    this.tabHost.setCurrentTabByTag("PLAN_TAB");
                    break;
                case R.id.tab_chart:
                    this.tabHost.setCurrentTabByTag("CHART_TAB");
                    break;
                case R.id.tab_more:
                    this.tabHost.setCurrentTabByTag("MORE_TAB");
                    break;
            }
        }
    }


}
