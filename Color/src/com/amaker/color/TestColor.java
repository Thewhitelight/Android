package com.amaker.color;

import com.example.color.R;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class TestColor extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		setContentView(R.layout.textcolor);
		TextView textview=(TextView)findViewById(R.id.tv01);
		textview.setMovementMethod(ScrollingMovementMethod.getInstance());//ʹ�ı����»���
		getWindow().setBackgroundDrawableResource(R.color.red_bg);
	}
}
