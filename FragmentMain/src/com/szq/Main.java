package com.szq;

import com.example.fragmentmain.R;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

public class Main extends FragmentActivity{
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.newmain);
		TextView tv=(TextView) findViewById(R.id.tv);
		tv.setText(getTitle());
	}
}
