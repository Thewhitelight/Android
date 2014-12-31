package com.sweetvvck.fakezhihu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements
		NavigationDrawerFragment.NavigationDrawerCallbacks {

	/**
	 * 左侧划出抽屉内部fragment
	 */
	private NavigationDrawerFragment mNavigationDrawerFragment;

	/**
	 * 存放上次显示在action bar中的title {@link #restoreActionBar()}.
	 */
	private CharSequence mTitle;

	private Fragment currentFragment;
	private static Fragment lastFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mNavigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager()
				.findFragmentById(R.id.navigation_drawer);
		mTitle = getTitle();

		// 设置抽屉
		mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
				(DrawerLayout) findViewById(R.id.drawer_layout));
	}

	@Override
	public void onNavigationDrawerItemSelected(String title, int postion) {
		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction ft = fragmentManager.beginTransaction();
		currentFragment = fragmentManager.findFragmentByTag(title);
		if (currentFragment == null) {
			currentFragment = ContentFragment.newInstance(title, postion);
			ft.add(R.id.container, currentFragment, title);
		}
		if (lastFragment != null) {
			ft.hide(lastFragment);
		}
		if (currentFragment.isDetached()) {
			ft.attach(currentFragment);
		}
		ft.show(currentFragment);
		lastFragment = currentFragment;
		ft.commit();
		onSectionAttached(title);
	}

	public void onSectionAttached(String title) {
		mTitle = title;
	}

	public void restoreActionBar() {
		ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setTitle(mTitle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if (!mNavigationDrawerFragment.isDrawerOpen()) {
			getMenuInflater().inflate(R.menu.main, menu);
			restoreActionBar();
			return true;
		}
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * 内容fragment
	 */
	public static class ContentFragment extends Fragment {

		private static final String ARG_SECTION_TITLE = "section_title";
		private static final String POSTION = "section_postion";

		/**
		 * 返回根据title参数创建的fragment
		 */
		public static ContentFragment newInstance(String title, int postion) {
			ContentFragment fragment = new ContentFragment();
			Bundle args = new Bundle();
			args.putString(ARG_SECTION_TITLE, title);
			args.putInt(POSTION, postion);
			fragment.setArguments(args);
			return fragment;
		}

		public ContentFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			TextView textView = (TextView) rootView
					.findViewById(R.id.section_label);
			textView.setText(getArguments().getString(ARG_SECTION_TITLE));
			if (getArguments().getInt(POSTION) == 0) {
				textView.setText("chenggong");
				textView.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						TestFragment tFragment = new TestFragment();
						FragmentManager manager = getFragmentManager();
						FragmentTransaction transcation = manager
								.beginTransaction();
						transcation.addToBackStack(null);
						transcation.remove(lastFragment);
						transcation.replace(R.id.container, tFragment);
						transcation.commit();
					}
				});
			}
			if (getArguments().getInt(POSTION) == 1) {
				textView.setText("Hello Word");
				textView.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						TestFragment tFragment = new TestFragment();
						FragmentManager manager = getFragmentManager();
						FragmentTransaction transcation = manager
								.beginTransaction();
						transcation.addToBackStack(null);
						transcation.remove(lastFragment);
						transcation.replace(R.id.container, tFragment);
						transcation.commit();
					}
				});
			}
			return rootView;
		}
	}

}
