package com.szq;

import com.example.serviceplaymusic.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * @author SZQ ����serviceͨ��ʱ Ӧ���ڵ���service��activity���class�޸�Ϊpublic ��������޷�����
 */
public class ServicePlayMusic extends Activity {
	private Button btn_start;
	private Button btn_stop;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		btn_start = (Button) findViewById(R.id.btn_start);
		btn_stop = (Button) findViewById(R.id.btn_stop);
		btn_start.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startService(new Intent("com.szq.Android.MUSIC"));
			}
		});
		btn_stop.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				stopService(new Intent("com.szq.Android.MUSIC"));
			}
		});
	}
}
