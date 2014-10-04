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
		// TODO �Զ����ɵķ������
		List<String> data = new ArrayList<String>();
		data.add("��Ǫ��");
		data.add("��ѿͰ");
		data.add("���෹��");
		data.add("��������");
		data.add("����ͷ�ζ��ʳ");
		data.add("������ζ");
		data.add("��������ˮ��");
		data.add("������");
		data.add("���Ϲ�������");
		data.add("������㼦��");
		data.add("������ɫ��");// 10
		data.add("����ʿ");
		data.add("��������");
		data.add("�������");
		data.add("��ζԷ");
		data.add("�ױ���");// 15
		data.add("�ط��ŹǷ�");
		data.add("ũɩ̳�Ӳ�");
		data.add("Ҽ��͹�");
		data.add("��������巹");
		data.add("������˾��");
		data.add("�ӽ���С��");
		return data;
	}
}
