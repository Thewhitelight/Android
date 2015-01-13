package com.szq;

import com.example.listviewarticlefragment.R;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity implements
		HeadFragment.OnHeadSelectListener {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		if (findViewById(R.id.framelayout) != null) {
			if (savedInstanceState != null) {
				return;
			}
			HeadFragment headFragment = new HeadFragment();
			headFragment.setArguments(getIntent().getExtras());
			getFragmentManager().beginTransaction()
					.add(R.id.framelayout, headFragment, "headFragment")
					.commit();
		}
		Log.i("MainActivity", "-->>onCreate");
	}

	@Override
	public void OnArticleSelect(int position) {
		ArticleFragment articleFrag = (ArticleFragment) getFragmentManager()
				.findFragmentById(R.id.articlefragment);
		if (articleFrag != null) {
			articleFrag.updateArticleView(position);
		} else {
			ArticleFragment newFragment = new ArticleFragment();
			Bundle args = new Bundle();
			args.putInt(ArticleFragment.POSITION, position);
			newFragment.setArguments(args);
			FragmentTransaction transaction = getFragmentManager()
					.beginTransaction();
			transaction.replace(R.id.framelayout, newFragment);
			transaction.addToBackStack(null);
			transaction.commit();
		}
		Log.i("MainActivity", "-->>OnArticleSelect");
	}
}
