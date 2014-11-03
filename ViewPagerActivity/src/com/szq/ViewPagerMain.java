package com.szq;

import java.util.ArrayList;

import com.example.viewpageractivity.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;

public class ViewPagerMain extends FragmentActivity {
	private ViewPager viewpager;
	private Fragment1 fragment1;
	private Fragment2 fragment2;
	private Fragment3 fragment3;
	private ArrayList<Fragment> fragmentlist;// 页面列表
	ArrayList<String> titlelist = new ArrayList<String>();// 标题列表
	private PagerTabStrip pagertabstrip;// 设置标题属性

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_viewpager);
		viewpager = (ViewPager) findViewById(R.id.viewpager);
		pagertabstrip = (PagerTabStrip) findViewById(R.id.pagertabstrip);
		pagertabstrip.setTabIndicatorColor(getResources().getColor(
				android.R.color.holo_blue_dark));// 下划线颜色
		pagertabstrip.setBackgroundResource(android.R.color.holo_orange_dark);// 背景颜色
		fragmentlist = new ArrayList<Fragment>();
		fragment1 = new Fragment1();
		fragment2 = new Fragment2();
		fragment3 = new Fragment3();
		fragment1.onSaveInstanceState(savedInstanceState);
		fragmentlist.add(fragment1);
		fragmentlist.add(fragment2);
		fragmentlist.add(fragment3);
		titlelist.add("第一页");
		titlelist.add("第二页");
		titlelist.add("第三页");
		viewpager
				.setAdapter(new ViewPagerActivity(getSupportFragmentManager()));
		viewpager.setOffscreenPageLimit(2);// 预加载2页面
	}

	public class ViewPagerActivity extends FragmentPagerAdapter {

		public ViewPagerActivity(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}

		@Override
		public Fragment getItem(int arg0) {
			return fragmentlist.get(arg0);
		}

		@Override
		public int getCount() {
			return fragmentlist.size();
		}

		@Override
		public CharSequence getPageTitle(int position) {
			// TODO Auto-generated method stub
			return titlelist.get(position);
		}

	}
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		
	}
}
