package com.test;

import com.example.listview_takeaway.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Activity01 extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main01);
		TextView tv = (TextView) findViewById(R.id.tv);
		long list_item_id = getIntent().getLongExtra("list_item_id", 0);// �õ�item_id���ظ�����Activity01
		if (list_item_id == 0) {
			tv.append("paomadeng\npaomadeng\n");
		}
		if (list_item_id == 1) {
			tv.append("fengfudewenbenxianshi\n15267698089\n658089");
		}
	}
}
