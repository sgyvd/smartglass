package com.capacity.smartglass.utils;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import com.capacity.smartglass.R;
import com.capacity.smartglass.model.Plan;

public class PlanAdapter extends ArrayAdapter<Plan> {

	private TextView tv_plan_time;
	private TextView tv_plan_waterId;
	private int resourceId;
	
	public PlanAdapter(Context context, int resource, List<Plan> objects) {
		super(context, resource, objects);
		resourceId=resource;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		Plan plan=getItem(position);
		if(convertView==null){
			convertView=View.inflate(getContext(),resourceId , null);
		}
		
		tv_plan_time=(TextView) convertView.findViewById(R.id.tv_plan_time);
		tv_plan_waterId=(TextView) convertView.findViewById(R.id.tv_plan_waterId);

		tv_plan_time.setText(plan.getTime());
		tv_plan_waterId.setText("第"+(position+1)+"杯水");

		return convertView;
	}
	
	

}
