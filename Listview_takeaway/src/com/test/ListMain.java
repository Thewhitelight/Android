package com.test;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListMain extends Activity {

	private ListView listview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		listview = new ListView(this);
		listview.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, getData()));
		setContentView(listview);
		//listview.setDivider(null);//ȥ��item֮��ĺ���
		listview.setVerticalScrollBarEnabled(false);//ȥ��listview������
		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO �Զ����ɵķ������
				Intent intent = new Intent();
				if (position == 0) {
					intent.setClass(ListMain.this, Activity01.class);
					intent.putExtra("list_item_id", id);
					ListMain.this.startActivity(intent);
				}
				if (position == 1) {
					intent.setClass(ListMain.this, Activity01.class);
					intent.putExtra("list_item_id", id);// ��item_id��Activity01
					ListMain.this.startActivity(intent);
				}
			}
		});
	}

	private List<String> getData() {
		// TODO �Զ����ɵķ������
		List<String> data = new ArrayList<String>();
		data.add("1");
		data.add("2");
		data.add("3");
		data.add("4");
		data.add("5");
		data.add("6");
		data.add("7");
		data.add("8");
		data.add("9");
		data.add("10");
		data.add("11");
		data.add("12");
		data.add("13");
		data.add("14");
		data.add("15");
		return data;
	}
}
