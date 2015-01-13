package com.szq;

import com.example.listviewarticlefragment.R;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ArticleFragment extends Fragment {
	public final static String POSITION = "position";
	int nowPosition = -1;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Log.i("ArticleFragment", "-->>onCreate");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Log.i("ArticleFragment", "-->>onCreateView");
		return inflater.inflate(R.layout.article, container, false);
	}

	public void updateArticleView(int position) {
		TextView tv = (TextView) getActivity().findViewById(R.id.textView1);
		tv.setText(Content.content[position]);
		nowPosition = position;
		Log.i("ArticleFragment", "-->>updateArticleView");
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.i("ArticleFragment", "-->>onPause");
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Bundle b = getArguments();
		if (b != null) {
			updateArticleView(b.getInt(POSITION));
		} else if (nowPosition != -1) {
			updateArticleView(nowPosition);
		}
		Log.i("ArticleFragment", "-->>onStart");
	}
}
