package com.szq;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.example.fragment_fragment_communication.R;

public class MainActivity extends Activity {
	private FragmentManager manager;
	private FragmentTransaction transition;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		manager = getFragmentManager();
		transition = manager.beginTransaction();
		LeftFragment leftFragment = new LeftFragment();
		transition.add(R.id.left, leftFragment, "left");
		RightFragment rightFragment = new RightFragment();
		transition.add(R.id.right, rightFragment, "right");
		transition.commit();
	}
}
