package com.szq;

import com.example.framelayoutactivity.R;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class Frame extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.frame);
		final ImageView img1=(ImageView) findViewById(R.id.imageView1);
		final ImageView img2=(ImageView) findViewById(R.id.imageView2);
		final ImageView img3=(ImageView) findViewById(R.id.imageView3);
		 ActionBar actionBar = getActionBar();
		 actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
		 
		img1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				img2.setVisibility(View.VISIBLE);
				v.setVisibility(View.GONE);
			}
		});
		img2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				img3.setVisibility(View.VISIBLE);
				v.setVisibility(View.GONE);
			}
		});
		img3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				img1.setVisibility(View.VISIBLE);
				v.setVisibility(View.GONE);
			}
		});
	}
}
