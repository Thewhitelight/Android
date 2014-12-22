package com.szq;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fragmenttest.R;

public class FragmentConent extends Fragment {
	private View mView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		mView = inflater.inflate(R.layout.fragment, container, false);
		TextView tv = (TextView) mView.findViewById(R.id.textView1);
		tv.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				TestFragment fragment = new TestFragment();
				getFragmentManager().beginTransaction()
						.replace(R.id.fragment1, fragment).commit();
			}
		});
		return mView;
	}
}
