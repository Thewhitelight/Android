package listview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.listview.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class Main extends Activity {
	private String[] title = { "姓名", "性别", "年龄", "居住地", "邮箱" };
	private String[] subtitle = { "雨松MOMO", "男", "25", "北京",
			"xuanyusong@gmail.com" };
	ListView lv = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		lv = (ListView) findViewById(R.id.MyListView);
		List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < title.length; i++) {
			Map<String, Object> listItem = new HashMap<String, Object>();
			listItem.put("image", R.drawable.ic_launcher);
			listItem.put("title", title[i]);
			listItem.put("subtilte", subtitle[i]);
			//listItem.put("time", R.id.digitalClock1);
			listItems.add(listItem);

		}
		SimpleAdapter adapter = new SimpleAdapter(this, listItems,
				R.layout.list, new String[] { "image", "title", "subtilte", },
				new int[] { R.id.imageView1, R.id.ItemTitle, R.id.ItemText });
		lv.setAdapter(adapter);
		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> adapterView, View view,
					int position, long id) {

				Intent intent = new Intent();
				if (position == 0) {

					intent.setClass(Main.this, Activity01.class);
					Main.this.startActivity(intent);
				} else if (position == 1) {
					intent.setClass(Main.this, Activity01.class);
					Main.this.startActivity(intent);
				}

				// Toast.makeText(getApplication(),"您选择了标题：" + title[position] +
				// "内容："+subtitle[position], Toast.LENGTH_LONG).show();
			}
		});
	}

}
