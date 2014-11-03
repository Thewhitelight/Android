package com.szq;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.viewpageractivity.R;

public class Fragment2 extends Fragment {

	private View mView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		LayoutInflater inflater = getActivity().getLayoutInflater();
		mView = inflater.inflate(R.layout.fragment2, (ViewGroup) getActivity()
				.findViewById(R.id.viewpager), false);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		ViewGroup viewgproup = (ViewGroup) mView.getParent();
		if (viewgproup != null) {
			viewgproup.removeAllViewsInLayout();
		}
		return mView;
	}

}
