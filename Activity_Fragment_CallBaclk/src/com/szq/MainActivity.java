package com.szq;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.example.activity_fragment_callbaclk.R;
import com.szq.FragmentContent.CallBack;

public class MainActivity extends Activity {
	private FragmentManager manager;
	private FragmentTransaction transition;
	private FragmentContent fragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		fragment = new FragmentContent();
		manager = getFragmentManager();
		transition = manager.beginTransaction();
		transition.add(R.id.fragment1, fragment);
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button btn = (Button) findViewById(R.id.btn_act);
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				fragment.getFragmentEditText(new CallBack() {

					@Override
					public void getResult(String result) {
						// TODO Auto-generated method stub
						Toast.makeText(getApplicationContext(),
								"-->>" + result, Toast.LENGTH_SHORT).show();
					}
				});
			}
		});
		transition.commit();
	}
}
