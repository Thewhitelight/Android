package menu;


import com.example.menu.R;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.widget.TextView;
import android.widget.Toast;

public class Menutest extends Activity{
	TextView tv=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		tv=(TextView)findViewById(R.id.textView1);
		tv.setText("设置选项菜单！");
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO 自动生成的方法存根
		MenuItem menu1= menu.add(0, 1, 1, "黑色");
		MenuItem menu2=menu.add(0, 2, 2, "红色");
		SubMenu menu3= menu.addSubMenu(0, 3, 3, "字号");
		menu1.setIcon(R.drawable.ic_launcher);
		menu2.setIcon(R.drawable.ic_launcher);
		menu3.setIcon(R.drawable.ic_launcher);
		MenuItem sub1=menu3.add(1, 4, 4, "10号字体");
		MenuItem sub2=menu3.add(1, 5, 5, "20号字体");
		MenuItem sub3=menu3.add(1, 6, 6, "30号字体");
		MenuItem sub4=menu3.add(1, 7, 7, "返回");
		/**
		 *子菜单sub1点击事件 
		 **/
		sub1.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				// TODO 自动生成的方法存根
				tv.setTextSize(10.0f);
				return false;
			}
		});
		sub4.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				// TODO 自动生成的方法存根
				finish();
				return false;
			}
		});
		return super.onCreateOptionsMenu(menu);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO 自动生成的方法存根
		if (item.getItemId()==1) {
			tv.setTextColor(Color.BLACK);
		}
		else if (item.getItemId()==2) {
			tv.setTextColor(Color.RED);
		}
		/*else if (item.getItemId()==3) {
			//tv.setTextSize(100/2.0f);//设置字体大小 为float
			DisplayMetrics dm = getResources().getDisplayMetrics();
			float value = dm.scaledDensity;		//先得到手机的scaledDecsity
			tv.setTextSize(100/value);   //设置字体大小时
		}*/
		return super.onOptionsItemSelected(item);
	}
	@Override
	public void onOptionsMenuClosed(Menu menu) {
		// TODO 自动生成的方法存根
		Toast.makeText(getApplicationContext(), "关闭选项菜单", Toast.LENGTH_SHORT).show();//点击返回后显示内容
		super.onOptionsMenuClosed(menu);
	}
}
