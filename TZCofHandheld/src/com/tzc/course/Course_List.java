package com.tzc.course;

import java.util.ArrayList;
import java.util.List;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Course_List extends Activity {
	private ListView list = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		list = new ListView(this);
		list.setAdapter(new ArrayAdapter<String>(this,
				R.layout.simple_list_item_1, getData()));
		setContentView(list);
		overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);//淡入淡出效果
		Resources res = getResources();
		Drawable drawable = res
				.getDrawable(geniuz.pathbuttons.R.drawable.listbackgroundcolor);
		this.getWindow().setBackgroundDrawable(drawable);
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO 自动生成的方法存根
				Intent intent = new Intent();
				if (position == 0) {
					intent.setClass(getApplicationContext(), CourseOne.class);
					startActivity(intent);
				}
				if (position == 1) {
					intent.setClass(getApplicationContext(), CourseTwo.class);
					startActivity(intent);
				}
				if (position == 2) {
					intent.setClass(getApplicationContext(), CourseThree.class);
					startActivity(intent);
				}
				if (position == 3) {
					intent.setClass(getApplicationContext(), CourseFour.class);
					startActivity(intent);
				}
				if (position == 4) {
					intent.setClass(getApplicationContext(), CourseFive.class);
					startActivity(intent);
				}
			}
		});
	}

	private List<String> getData() {
		List<String> data = new ArrayList<String>();
		// TODO 自动生成的方法存根
		data.add("星期一");
		data.add("星期二");
		data.add("星期三");
		data.add("星期四");
		data.add("星期五");
		return data;
	}
}
