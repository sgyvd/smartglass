package com.capacity.smartglass.model;

public class Plan {
	
	//显示时间
	private String time;
	//说明第几杯水
	private String waterId;
	//是否开启
	private boolean isCheck;
	
	public Plan(String time,boolean isCheck){
		this.time=time;
		this.isCheck=isCheck;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getWaterId() {
		return waterId;
	}

	public void setWaterId(String waterId) {
		this.waterId = waterId;
	}

	public boolean isCheck() {
		return isCheck;
	}

	public void setCheck(boolean isCheck) {
		this.isCheck = isCheck;
	}
}
