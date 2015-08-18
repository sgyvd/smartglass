package com.capacity.smartglass;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.capacity.smartglass.model.Plan;
import com.capacity.smartglass.utils.PlanAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dellpc on 2015-08-18.
 */
public class PlanActivity extends Activity {


    private List<Plan> planList = new ArrayList<Plan>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_plan);

        initPlan();
        ListView listView= (ListView) findViewById(R.id.list_item);
        PlanAdapter planAdapter=new PlanAdapter(this,R.layout.plantime_item,planList);
        listView.setAdapter(planAdapter);
    }


    private void initPlan() {
        Plan p1 = new Plan("08:00", true);
        planList.add(p1);
        Plan p2 = new Plan("09:00", false);
        planList.add(p2);
    }

}
