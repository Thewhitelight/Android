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
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		tv=(TextView)findViewById(R.id.textView1);
		tv.setText("����ѡ��˵���");
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO �Զ����ɵķ������
		MenuItem menu1= menu.add(0, 1, 1, "��ɫ");
		MenuItem menu2=menu.add(0, 2, 2, "��ɫ");
		SubMenu menu3= menu.addSubMenu(0, 3, 3, "�ֺ�");
		menu1.setIcon(R.drawable.ic_launcher);
		menu2.setIcon(R.drawable.ic_launcher);
		menu3.setIcon(R.drawable.ic_launcher);
		MenuItem sub1=menu3.add(1, 4, 4, "10������");
		MenuItem sub2=menu3.add(1, 5, 5, "20������");
		MenuItem sub3=menu3.add(1, 6, 6, "30������");
		MenuItem sub4=menu3.add(1, 7, 7, "����");
		/**
		 *�Ӳ˵�sub1����¼� 
		 **/
		sub1.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				// TODO �Զ����ɵķ������
				tv.setTextSize(10.0f);
				return false;
			}
		});
		sub4.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				// TODO �Զ����ɵķ������
				finish();
				return false;
			}
		});
		return super.onCreateOptionsMenu(menu);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO �Զ����ɵķ������
		if (item.getItemId()==1) {
			tv.setTextColor(Color.BLACK);
		}
		else if (item.getItemId()==2) {
			tv.setTextColor(Color.RED);
		}
		/*else if (item.getItemId()==3) {
			//tv.setTextSize(100/2.0f);//���������С Ϊfloat
			DisplayMetrics dm = getResources().getDisplayMetrics();
			float value = dm.scaledDensity;		//�ȵõ��ֻ���scaledDecsity
			tv.setTextSize(100/value);   //���������Сʱ
		}*/
		return super.onOptionsItemSelected(item);
	}
	@Override
	public void onOptionsMenuClosed(Menu menu) {
		// TODO �Զ����ɵķ������
		Toast.makeText(getApplicationContext(), "�ر�ѡ��˵�", Toast.LENGTH_SHORT).show();//������غ���ʾ����
		super.onOptionsMenuClosed(menu);
	}
}
