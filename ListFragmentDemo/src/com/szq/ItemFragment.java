package com.szq;

import java.util.ArrayList;
import java.util.List;
import com.example.listfragmentdemo.R;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ItemFragment extends ListFragment {
	private ArrayAdapter<String> adapter;
	private List<String> data;
	private FragmentManager manager;
	private FragmentTransaction transition;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		data = new ArrayList<String>();
		for (int i = 1; i <= 20; i++) {
			data.add("Hello Word!!!" + i);
		}
		adapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, data);
		setListAdapter(adapter);
		manager = getFragmentManager();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return super.onCreateView(inflater, container, savedInstanceState);
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		int itemPostion = position;
		String itemPosition = adapter.getItem(position);
		transition = manager.beginTransaction();
		ContentFragment contentFragment = new ContentFragment();
		transition.replace(R.id.right, contentFragment, "ContentFragment");
		Bundle b = new Bundle();
		b.putInt("itemPostion", itemPostion);
		contentFragment.setArguments(b);
		transition.commit();

		Toast.makeText(getActivity(), "" + itemPosition, Toast.LENGTH_SHORT)
				.show();
	}
}
