package test;

import java.util.ArrayList;
import java.util.List;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListView_Course extends Activity {
	private ListView list = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		list = new ListView(this);
		list.setAdapter(new ArrayAdapter<String>(this,
				R.layout.simple_list_item_1, getData()));
		setContentView(list);
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO 自动生成的方法存根
				Intent intent = new Intent();
				if (position == 0) {
					intent.setClass(getApplicationContext(), Course.class);
					intent.putExtra("list_id", id);
					startActivity(intent);
				}
				if (position == 1) {
					intent.setClass(getApplicationContext(), Course.class);
					intent.putExtra("list_id", id);
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
