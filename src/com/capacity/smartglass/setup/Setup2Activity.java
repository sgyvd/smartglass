package com.capacity.smartglass.setup;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.capacity.smartglass.BaseSetupActivity;
import com.capacity.smartglass.R;

public class Setup2Activity extends BaseSetupActivity {

	private static final String TAG = "HomeActivity";

	private GridView gv_setup_gridview;
	private MyAdapter adapter;

	private String names[] = { "性别", "生日", "身高", "体重", "场景", "体质" };

	private String contents[] = { "男", "15-8-24", "180cm", "68kg", "办公室", "良好" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setup2);
		gv_setup_gridview = (GridView) findViewById(R.id.gv_setup_gridview);
		adapter = new MyAdapter();
		gv_setup_gridview.setAdapter(adapter);

		// 为gridview添加监听器
		gv_setup_gridview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				switch (position) {
				case 0:
					// 性别选项(单选框)
					checkDialog("性别选择", new String[] { "男", "女" });
					break;
				case 1:
					// 生日选项（日期控件）
					dateDialog();
					break;
				case 2:
					// 身高选项（输入框）
					inputDialog(R.layout.dialog_height, "请输入身高数值（cm）");
					break;
				case 3:
					// 体重选项（输入框）
					inputDialog(R.layout.dialog_height, "请输入体重数值（kg）");
					break;
				case 4:
					// 场景设置（单选框）
					checkDialog("场景设置", new String[] { "办公室", "家", "室外" });
					break;
				case 5:
					// 体质设置（单选框）
					checkDialog("体质设置", new String[] { "良好", "优秀", "较弱" });
				default:
					break;
				}
			}

			/**
			 * 输入框
			 */
			private void inputDialog(int view, String title) {
				View v = View.inflate(getApplicationContext(), view, null);
				AlertDialog.Builder input = new AlertDialog.Builder(
						Setup2Activity.this);
				input.setTitle(title);
				input.setView(v);
				input.setPositiveButton("确定", null);
				input.show();
			}

			/**
			 * 日期控件
			 */
			private void dateDialog() {
				View v = View.inflate(getApplicationContext(),
						R.layout.dialog_date, null);
				AlertDialog.Builder dateDialog = new AlertDialog.Builder(
						Setup2Activity.this);
				dateDialog.setTitle("日期选择");
				dateDialog.setView(v);
				dateDialog.setPositiveButton("确定", null);
				dateDialog.show();
			}

			/**
			 * 单选框
			 */
			private void checkDialog(String title, String[] strs) {
				AlertDialog.Builder sexDialog = new AlertDialog.Builder(
						Setup2Activity.this);
				sexDialog.setTitle(title);
				sexDialog.setSingleChoiceItems(strs, 0, null);
				sexDialog.setPositiveButton("确定", null);
				sexDialog.setNegativeButton("取消", null);
				sexDialog.show();
			}
		});
	}

	public void next(View view) {
		showNext();
	}

	/**
	 * 配置GridView的适配器
	 * 
	 * @author master
	 * 
	 */
	private class MyAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			return names.length;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = View.inflate(getApplicationContext(),
						R.layout.list_item_setup2, null);
			}

			TextView textViewName = (TextView) convertView
					.findViewById(R.id.tv_top_item);
			TextView textViewContent = (TextView) convertView
					.findViewById(R.id.tv_center_item);

			textViewName.setText(names[position]);
			textViewContent.setText(contents[position]);
			return convertView;
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

	}

	@Override
	public void showPref() {
		Intent i = new Intent(Setup2Activity.this, Setup1Activity.class);
		startActivity(i);
		finish();
		overridePendingTransition(R.anim.page_pref, R.anim.page_exit2);
	}

	@Override
	public void showNext() {
		Intent i = new Intent(Setup2Activity.this, Setup3Activity.class);
		startActivity(i);
		finish();
		overridePendingTransition(R.anim.page_next, R.anim.page_exit);
	}
}
