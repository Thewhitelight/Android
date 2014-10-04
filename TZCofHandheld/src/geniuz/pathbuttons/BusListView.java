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
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class BusListView extends Activity {
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
				if (position == 1) {
					intent.setClass(BusListView.this, BusContent.class);
					intent.putExtra("list_id", id);
					BusListView.this.startActivity(intent);

				}
				if (position == 2) {
					intent.setClass(BusListView.this, BusContent.class);
					intent.putExtra("list_id", id);
					BusListView.this.startActivity(intent);
				}
				if (position == 3) {
					intent.setClass(BusListView.this, BusContent.class);
					intent.putExtra("list_id", id);
					BusListView.this.startActivity(intent);
				}
				if (position == 4) {
					intent.setClass(BusListView.this, BusContent.class);
					intent.putExtra("list_id", id);
					BusListView.this.startActivity(intent);
				}
				if (position == 5) {
					intent.setClass(BusListView.this, BusContent.class);
					intent.putExtra("list_id", id);
					BusListView.this.startActivity(intent);
				}
				if (position == 6) {
					intent.setClass(BusListView.this, BusContent.class);
					intent.putExtra("list_id", id);
					BusListView.this.startActivity(intent);
				}
				if (position == 7) {
					intent.setClass(BusListView.this, BusContent.class);
					intent.putExtra("list_id", id);
					BusListView.this.startActivity(intent);
				}
				if (position == 8) {
					intent.setClass(BusListView.this, BusContent.class);
					intent.putExtra("list_id", id);
					BusListView.this.startActivity(intent);
				}
				if (position == 10) {
					intent.setClass(BusListView.this, BusContent.class);
					intent.putExtra("list_id", id);
					BusListView.this.startActivity(intent);
				}
				if (position == 11) {
					intent.setClass(BusListView.this, BusContent.class);
					intent.putExtra("list_id", id);
					BusListView.this.startActivity(intent);
				}
				if (position == 12) {
					intent.setClass(BusListView.this, BusContent.class);
					intent.putExtra("list_id", id);
					BusListView.this.startActivity(intent);
				}
				if (position == 13) {
					intent.setClass(BusListView.this, BusContent.class);
					intent.putExtra("list_id", id);
					BusListView.this.startActivity(intent);
				}
				if (position == 14) {
					intent.setClass(BusListView.this, BusContent.class);
					intent.putExtra("list_id", id);
					BusListView.this.startActivity(intent);
				}
				if (position == 15) {
					intent.setClass(BusListView.this, BusContent.class);
					intent.putExtra("list_id", id);
					BusListView.this.startActivity(intent);
				}
				if (position == 16) {
					intent.setClass(BusListView.this, BusContent.class);
					intent.putExtra("list_id", id);
					BusListView.this.startActivity(intent);
				}
				if (position == 17) {
					intent.setClass(BusListView.this, BusContent.class);
					intent.putExtra("list_id", id);
					BusListView.this.startActivity(intent);
				}
				if (position == 18) {
					intent.setClass(BusListView.this, BusContent.class);
					intent.putExtra("list_id", id);
					BusListView.this.startActivity(intent);
				}
				if (position == 19) {
					intent.setClass(BusListView.this, BusContent.class);
					intent.putExtra("list_id", id);
					BusListView.this.startActivity(intent);
				}
				if (position == 20) {
					intent.setClass(BusListView.this, BusContent.class);
					intent.putExtra("list_id", id);
					BusListView.this.startActivity(intent);
				}
				if (position == 21) {
					intent.setClass(BusListView.this, BusContent.class);
					intent.putExtra("list_id", id);
					BusListView.this.startActivity(intent);
				}
				if (position == 22) {
					intent.setClass(BusListView.this, BusContent.class);
					intent.putExtra("list_id", id);
					BusListView.this.startActivity(intent);
				}
				if (position == 23) {
					intent.setClass(BusListView.this, BusContent.class);
					intent.putExtra("list_id", id);
					BusListView.this.startActivity(intent);
				}
				if (position == 24) {
					intent.setClass(BusListView.this, BusContent.class);
					intent.putExtra("list_id", id);
					startActivity(intent);
				}
				if (position == 25) {
					intent.setClass(BusListView.this, BusContent.class);
					intent.putExtra("list_id", id);
					BusListView.this.startActivity(intent);
				}
			}

		});
	}

	private List<String> getData() {
		// TODO 自动生成的方法存根
		List<String> data = new ArrayList<String>();
		data.add("途经台州学院公交线路:");
		data.add("101路 客运中心——小芝（大田线）");
		data.add("108路A 客运中心——仙人桥");
		data.add("108路B 客运中心——桐岩岭");
		data.add("108路C 客运中心——西溪");
		data.add("109路 客运中心——屈家");
		data.add("202路 绿化——市区——绿化");
		data.add("202路 三峰寺——市区——三峰寺");
		data.add("205路 大田——市区");
		data.add("市区公交线路:");
		data.add("201路 客运中心——台州医院");
		data.add("202路 绿化——市区——绿化");
		data.add("202路 三峰寺——市区——三峰寺");
		data.add("203路 东塍——市区");
		data.add("204路 牛头山——市区");
		data.add("205路 大田——市区");
		data.add("209路 客运中心——揽胜门");
		data.add("211路 火车站——东湖公园");
		data.add("211路 东湖公园——火车站");
		data.add("215路 松二——老城区");
		data.add("216路 邵家渡——市区");
		data.add("217路 客运中心——紫沙岙——龙潭岙");
		data.add("217路 龙潭岙——紫沙岙——客运中心");
		data.add("218路 崇和门——海山公园");
		data.add("222路 临海监狱——市区");
		data.add("222路 家具城——市区——家具城");

		return data;
	}
}
