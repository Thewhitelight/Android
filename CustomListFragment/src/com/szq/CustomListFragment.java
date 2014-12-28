package com.szq;

import java.util.ArrayList;
import java.util.List;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.customlistfragment.R;

public class CustomListFragment extends ListFragment {
	private MyAdapter adapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		adapter = new MyAdapter();
		adapter.BindData(getData());
	}

	public List<String> getData() {
		List<String> list = new ArrayList<String>();
		for (int i = 1; i <= 20; i++) {
			list.add("Hello World!!!" + i);
		}
		return list;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.right, container, false);
		setListAdapter(adapter);
		return view;
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String item = adapter.getItem(position).toString();
		Toast.makeText(getActivity(), item, Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	class MyAdapter extends BaseAdapter {
		private List<String> list;

		public void BindData(List<String> list) {
			this.list = list;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return list.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return list.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			View view = null;
			if (convertView == null) {
				view = LayoutInflater.from(getActivity()).inflate(
						R.layout.item, parent, false);
			} else {
				view = convertView;
			}
			TextView tv = (TextView) view.findViewById(R.id.tv);
			tv.setText(list.get(position).toString());
			return view;
		}
	}
}
