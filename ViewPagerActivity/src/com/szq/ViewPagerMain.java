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
	private ArrayList<Fragment> fragmentlist;// ҳ���б�
	ArrayList<String> titlelist = new ArrayList<String>();// �����б�
	private PagerTabStrip pagertabstrip;// ���ñ�������

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_viewpager);
		viewpager = (ViewPager) findViewById(R.id.viewpager);
		pagertabstrip = (PagerTabStrip) findViewById(R.id.pagertabstrip);
		pagertabstrip.setTabIndicatorColor(getResources().getColor(
				android.R.color.holo_blue_dark));// �»�����ɫ
		pagertabstrip.setBackgroundResource(android.R.color.holo_orange_dark);// ������ɫ
		fragmentlist = new ArrayList<Fragment>();
		fragment1 = new Fragment1();
		fragment2 = new Fragment2();
		fragment3 = new Fragment3();
		fragment1.onSaveInstanceState(savedInstanceState);
		fragmentlist.add(fragment1);
		fragmentlist.add(fragment2);
		fragmentlist.add(fragment3);
		titlelist.add("��һҳ");
		titlelist.add("�ڶ�ҳ");
		titlelist.add("����ҳ");
		viewpager
				.setAdapter(new ViewPagerActivity(getSupportFragmentManager()));
		viewpager.setOffscreenPageLimit(2);// Ԥ����2ҳ��
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
