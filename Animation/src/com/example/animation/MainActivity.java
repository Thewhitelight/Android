package com.example.animation;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	private TextView tv_rotate, tv_alpha, tv_translate, tv_scale;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv_rotate = (TextView) this.findViewById(R.id.tv_rotate);
		tv_translate = (TextView) findViewById(R.id.tv_translate);
		tv_alpha = (TextView) findViewById(R.id.tv_alpha);
		tv_scale = (TextView) findViewById(R.id.tv_scale);
		tv_rotate.setOnClickListener(this);
		tv_translate.setOnClickListener(this);
		tv_alpha.setOnClickListener(this);
		tv_scale.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.tv_rotate:
			v.startAnimation(AnimationUtils.loadAnimation(
					getApplicationContext(), R.anim.rotate));
			break;
		case R.id.tv_translate:
			v.startAnimation(AnimationUtils.loadAnimation(
					getApplicationContext(), R.anim.translate));
			break;
		case R.id.tv_alpha:
			v.startAnimation(AnimationUtils.loadAnimation(
					getApplicationContext(), R.anim.alpha));
			break;
		case R.id.tv_scale:
			v.startAnimation(AnimationUtils.loadAnimation(
					getApplicationContext(), R.anim.scale));
			break;
		default:
			break;
		}
	}
}
