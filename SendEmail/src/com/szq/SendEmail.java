package com.szq;

import com.example.sendemail.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;

public class SendEmail extends Activity {
	private int micount = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		micount = 100;
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			Uri uri = Uri.parse("mailto:921618920@qq.com");
			Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
			intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "数据");// 设置主题
			intent.putExtra(android.content.Intent.EXTRA_TEXT, "发送" + micount);// 设置发送内容
			startActivity(intent);
			this.finish();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
}
