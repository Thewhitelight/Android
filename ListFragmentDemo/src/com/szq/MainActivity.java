package com.szq;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.listfragmentdemo.R;

public class MainActivity extends Activity {
	private FragmentManager manager;
	private FragmentTransaction transition;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button btn = (Button) findViewById(R.id.btn);
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				manager = getFragmentManager();
				transition = manager.beginTransaction();
				ItemFragment itemFragment = new ItemFragment();
				transition.add(R.id.center, itemFragment, "itemFragment");
				transition.commit();
			}
		});
	}
}
