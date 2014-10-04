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
		// TODO �Զ����ɵķ������
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		listview = new ListView(this);
		listview.setAdapter(new ArrayAdapter<String>(this,
				R.layout.simple_list_item_1, getData()));
		setContentView(listview);
		overridePendingTransition(android.R.anim.fade_in,
				android.R.anim.fade_out);// ���뵭��Ч��
		Resources res = getResources();
		Drawable drawable = res
				.getDrawable(geniuz.pathbuttons.R.drawable.listbackgroundcolor);
		this.getWindow().setBackgroundDrawable(drawable);

		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO �Զ����ɵķ������
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
		// TODO �Զ����ɵķ������
		List<String> data = new ArrayList<String>();
		data.add(";��̨��ѧԺ������·:");
		data.add("101· �������ġ���С֥�������ߣ�");
		data.add("108·A �������ġ���������");
		data.add("108·B �������ġ���ͩ����");
		data.add("108·C �������ġ�����Ϫ");
		data.add("109· �������ġ�������");
		data.add("202· �̻��������������̻�");
		data.add("202· �����¡�����������������");
		data.add("205· ���������");
		data.add("����������·:");
		data.add("201· �������ġ���̨��ҽԺ");
		data.add("202· �̻��������������̻�");
		data.add("202· �����¡�����������������");
		data.add("203· ���󡪡�����");
		data.add("204· ţͷɽ��������");
		data.add("205· ���������");
		data.add("209· �������ġ�����ʤ��");
		data.add("211· ��վ����������԰");
		data.add("211· ������԰������վ");
		data.add("215· �ɶ������ϳ���");
		data.add("216· �ۼҶɡ�������");
		data.add("217· �������ġ�����ɳᮡ�����̶�");
		data.add("217· ��̶ᮡ�����ɳᮡ�����������");
		data.add("218· ����š�����ɽ��԰");
		data.add("222· �ٺ�������������");
		data.add("222· �Ҿ߳ǡ������������Ҿ߳�");

		return data;
	}
}
