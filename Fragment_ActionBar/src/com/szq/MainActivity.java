package com.szq;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.example.fragment_actionbar.R;

@SuppressWarnings("deprecation")
public class MainActivity extends Activity {
	private ActionBar actiongbar;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		actiongbar = getActionBar();
		actiongbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actiongbar.setTitle("ActionBar");
		actiongbar.setLogo(getResources().getDrawable(R.drawable.two));
		actiongbar.addTab(actiongbar.newTab().setText("Fragment1")
				.setIcon(getResources().getDrawable(R.drawable.one)).setTag(1)
				.setTabListener(new MyLinstener()));
		actiongbar.addTab(actiongbar.newTab().setText("Fragment2")
				.setIcon(getResources().getDrawable(R.drawable.three))
				.setTag(2).setTabListener(new MyLinstener()));
		actiongbar.addTab(actiongbar.newTab().setText("Fragment3")
				.setIcon(getResources().getDrawable(R.drawable.four)).setTag(3)
				.setTabListener(new MyLinstener()));
	}

	public class MyLinstener implements ActionBar.TabListener {

		@Override
		public void onTabSelected(Tab tab, FragmentTransaction ft) {

			// TODO Auto-generated method stub
			// 无需调用FragmentTransaction的beginTransaction()和commit()
			int postion = Integer.parseInt(tab.getTag().toString());
			switch (postion) {
			case 1:
				Fragment1 fragment1 = new Fragment1();
				ft.replace(R.id.main, fragment1);
				break;
			case 2:
				Fragment2 fragment2 = new Fragment2();
				ft.replace(R.id.main, fragment2);
				break;
			case 3:
				Fragment3 fragment3 = new Fragment3();
				ft.replace(R.id.main, fragment3);
				break;
			}
		}

		@Override
		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onTabReselected(Tab tab, FragmentTransaction ft) {
			// TODO Auto-generated method stub

		}

	}
}
