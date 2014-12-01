package listview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.listview.R;

public class Main extends Activity {
	private String[] title = { "����", "�Ա�", "����", "��ס��", "����" };
	private String[] subtitle = { "Tom", "��", "22", "�㽭",
			"szq921618920@gmail.com" };
	ListView lv = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		lv = (ListView) findViewById(R.id.MyListView);
		List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < title.length; i++) {
			Map<String, Object> listItem = new HashMap<String, Object>();
			listItem.put("image", R.drawable.ic_launcher);
			listItem.put("title", title[i]);
			listItem.put("subtilte", subtitle[i]);
			listItems.add(listItem);

		}
		SimpleAdapter adapter = new SimpleAdapter(this, listItems,
				R.layout.list, new String[] { "image", "title", "subtilte", },
				new int[] { R.id.imageView1, R.id.ItemTitle, R.id.ItemText });
		lv.setAdapter(adapter);
		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> adapterView, View view,
					int position, long id) {
				Intent i = new Intent();
				i.setClass(getApplicationContext(), Activity01.class);
				i.putExtra("postion", position);
				for (int j = 0; j <= position; j++) {
					i.putExtra("subtitle", subtitle[j]);
				}
				Main.this.startActivity(i);
			}
		});
	}
}
