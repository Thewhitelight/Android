package geniuz.pathbuttons;

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

public class ResterauntListView extends Activity {
	private ListView listview = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		listview = new ListView(this);
		listview.setAdapter(new ArrayAdapter<String>(this,
				R.layout.simple_list_item_1, getData()));
		setContentView(listview);
		overridePendingTransition(android.R.anim.fade_in,
				android.R.anim.fade_out);// 淡入淡出效果
		Resources res = getResources();
		Drawable drawable = res
				.getDrawable(geniuz.pathbuttons.R.drawable.listbackgroundcolor);
		this.getWindow().setBackgroundDrawable(drawable);

		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO 自动生成的方法存根
				Intent intent = new Intent();
				if (position == 0) {
					intent.setClass(ResterauntListView.this,
							ResterauntContent.class);
					intent.putExtra("list_id", id);
					startActivity(intent);
				}
				if (position == 1) {
					intent.setClass(ResterauntListView.this,
							ResterauntContent.class);
					intent.putExtra("list_id", id);
					startActivity(intent);
				}
				if (position == 2) {
					intent.setClass(ResterauntListView.this,
							ResterauntContent.class);
					intent.putExtra("list_id", id);
					startActivity(intent);
				}
				if (position == 3) {
					intent.setClass(ResterauntListView.this,
							ResterauntContent.class);
					intent.putExtra("list_id", id);
					startActivity(intent);
				}
				if (position == 4) {
					intent.setClass(ResterauntListView.this,
							ResterauntContent.class);
					intent.putExtra("list_id", id);
					startActivity(intent);
				}
				if (position == 5) {
					intent.setClass(ResterauntListView.this,
							ResterauntContent.class);
					intent.putExtra("list_id", id);
					startActivity(intent);
				}
				if (position == 6) {
					intent.setClass(ResterauntListView.this,
							ResterauntContent.class);
					intent.putExtra("list_id", id);
					startActivity(intent);
				}
				if (position == 7) {
					intent.setClass(ResterauntListView.this,
							ResterauntContent.class);
					intent.putExtra("list_id", id);
					startActivity(intent);
				}
				if (position == 8) {
					intent.setClass(ResterauntListView.this,
							ResterauntContent.class);
					intent.putExtra("list_id", id);
					startActivity(intent);
				}
				if (position == 9) {
					intent.setClass(ResterauntListView.this,
							ResterauntContent.class);
					intent.putExtra("list_id", id);
					startActivity(intent);
				}
				if (position == 10) {
					intent.setClass(ResterauntListView.this,
							ResterauntContent.class);
					intent.putExtra("list_id", id);
					startActivity(intent);
				}
				if (position == 11) {
					intent.setClass(ResterauntListView.this,
							ResterauntContent.class);
					intent.putExtra("list_id", id);
					startActivity(intent);
				}
				if (position == 12) {
					intent.setClass(ResterauntListView.this,
							ResterauntContent.class);
					intent.putExtra("list_id", id);
					startActivity(intent);
				}
				if (position == 13) {
					intent.setClass(ResterauntListView.this,
							ResterauntContent.class);
					intent.putExtra("list_id", id);
					startActivity(intent);
				}
				if (position == 14) {
					intent.setClass(ResterauntListView.this,
							ResterauntContent.class);
					intent.putExtra("list_id", id);
					startActivity(intent);
				}
				if (position == 15) {
					intent.setClass(ResterauntListView.this,
							ResterauntContent.class);
					intent.putExtra("list_id", id);
					startActivity(intent);
				}
				if (position == 16) {
					intent.setClass(ResterauntListView.this,
							ResterauntContent.class);
					intent.putExtra("list_id", id);
					startActivity(intent);
				}
				if (position == 17) {
					intent.setClass(ResterauntListView.this,
							ResterauntContent.class);
					intent.putExtra("list_id", id);
					startActivity(intent);
				}
				if (position == 18) {
					intent.setClass(ResterauntListView.this,
							ResterauntContent.class);
					intent.putExtra("list_id", id);
					startActivity(intent);
				}
				if (position == 19) {
					intent.setClass(ResterauntListView.this,
							ResterauntContent.class);
					intent.putExtra("list_id", id);
					startActivity(intent);
				}
				if (position == 20) {
					intent.setClass(ResterauntListView.this,
							ResterauntContent.class);
					intent.putExtra("list_id", id);
					startActivity(intent);
				}
				if (position == 21) {
					intent.setClass(ResterauntListView.this,
							ResterauntContent.class);
					intent.putExtra("list_id", id);
					startActivity(intent);
				}
				if (position == 22) {
					intent.setClass(ResterauntListView.this,
							ResterauntContent.class);
					intent.putExtra("list_id", id);
					startActivity(intent);
				}

			}

		});
	}

	private List<String> getData() {
		// TODO 自动生成的方法存根
		List<String> data = new ArrayList<String>();
		data.add("八仟八");
		data.add("菜芽桶");
		data.add("茶余饭后");
		data.add("大田排面");
		data.add("大嘴巴风味美食");
		data.add("顶好美味");
		data.add("东北大馅水饺");
		data.add("饭宝宝");
		data.add("云南过桥米线");
		data.add("豪大大香鸡排");
		data.add("荷香特色饭");// 10
		data.add("华莱士");
		data.add("劲道拉面");
		data.add("拉面大王");
		data.add("美味苑");
		data.add("米宝宝");// 15
		data.add("秘方排骨饭");
		data.add("农嫂坛子菜");
		data.add("壹间餐馆");
		data.add("意大利铁板饭");
		data.add("遇见寿司坊");
		data.add("杂酱饭小吃");
		return data;
	}
}
