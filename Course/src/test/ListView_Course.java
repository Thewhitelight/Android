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
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		list = new ListView(this);
		list.setAdapter(new ArrayAdapter<String>(this,
				R.layout.simple_list_item_1, getData()));
		setContentView(list);
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO �Զ����ɵķ������
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
		// TODO �Զ����ɵķ������
		data.add("����һ");
		data.add("���ڶ�");
		data.add("������");
		data.add("������");
		data.add("������");
		return data;
	}

}
