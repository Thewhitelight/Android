package menu;


import com.example.menu.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ContextMenu extends Activity implements OnClickListener{
	TextView tv=null;
	EditText ed=null;
	private Button btn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contextmenu);
		tv=(TextView)findViewById(R.id.textView1);
		ed=(EditText)findViewById(R.id.editText1);
		this.registerForContextMenu(tv);//注册上下文菜单
		this.registerForContextMenu(ed);//注册上下文菜单
	    btn=(Button)findViewById(R.id.button01);
		btn.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO 自动生成的方法存根
		Intent intent=new Intent();
		intent.setClass(this, Menutest.class);
		startActivity(intent);
	}
		@Override
		public void onCreateContextMenu(android.view.ContextMenu menu, View v,
				ContextMenuInfo menuInfo) {
			// TODO 自动生成的方法存根
			menu.setHeaderIcon(R.drawable.ic_launcher);//设置图标
			if (v==tv) {
				menu.add(0, 1, 1, "10号字体");
				menu.add(0, 2, 2, "20号字体");
				menu.add(0, 3, 3, "30号字体");
				menu.add(0, 4, 4, "40号字体");
				menu.add(0, 5, 5, "10号字体");
			}
			else if (v==ed) {
				menu.add(1, 6, 6, "20号字体");
				menu.add(1, 7, 6, "30号字体");
			}
			super.onCreateContextMenu(menu, v, menuInfo);
		}
}
