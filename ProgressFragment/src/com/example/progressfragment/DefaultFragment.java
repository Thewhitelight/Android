package com.example.progressfragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DefaultFragment extends ProgressFragment {

	private View mContentView;
	private Handler mHandler;
	private Runnable mShowContentRunnable = new Runnable() {

		@Override
		public void run() {
			setContentShown(true);
		}

	};

	private void obtainData() {
		// Show indeterminate progress
		setContentShown(false);

		mHandler = new Handler();
		mHandler.postDelayed(mShowContentRunnable, 3000);
	}

	public static DefaultFragment newInstance() {
		DefaultFragment fragment = new DefaultFragment();
		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setHasOptionsMenu(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mContentView = inflater
				.inflate(R.layout.view_content, container, false);
		return super.onCreateView(inflater, container, savedInstanceState);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		// Setup content view
		setContentView(mContentView);
		// Setup text for empty content
		setEmptyText("Пе");
		obtainData();
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		mHandler.removeCallbacks(mShowContentRunnable);
	}

	// @Override
	// public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
	// inflater.inflate(R.menu.main, menu);
	// }
	//
	// @Override
	// public boolean onOptionsItemSelected(MenuItem item) {
	// switch (item.getItemId()) {
	// case R.id.action_settings:
	// obtainData();
	// return true;
	// default:
	// return super.onOptionsItemSelected(item);
	// }
	// }

}
