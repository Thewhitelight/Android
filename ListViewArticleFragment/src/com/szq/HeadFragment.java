package com.szq;

import com.example.listviewarticlefragment.R;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HeadFragment extends ListFragment {
	OnHeadSelectListener mCallBack;

	public interface OnHeadSelectListener {
		public void OnArticleSelect(int position);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_expandable_list_item_1, Content.title));
		Log.i("HeadFragment", "-->>onCreate");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Log.i("HeadFragment", "-->>onCreateView");
		return super.onCreateView(inflater, container, savedInstanceState);
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		// super.onListItemClick(l, v, position, id);
		mCallBack.OnArticleSelect(position);
		getListView().setItemChecked(position, true);
		Log.i("HeadFragment", "-->>onListItemClick");
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		if (getFragmentManager().findFragmentById(R.id.articlefragment) != null) {
			getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		}
		Log.i("HeadFragment", "-->>onStart");
	}

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		try {
			mCallBack = (OnHeadSelectListener) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " must implement OnHeadlineSelectedListener");
		}
		Log.i("HeadFragment", "-->>onAttach");
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.i("HeadFragment", "-->>onPause");
	}
}
