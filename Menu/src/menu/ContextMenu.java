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
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contextmenu);
		tv=(TextView)findViewById(R.id.textView1);
		ed=(EditText)findViewById(R.id.editText1);
		this.registerForContextMenu(tv);//ע�������Ĳ˵�
		this.registerForContextMenu(ed);//ע�������Ĳ˵�
	    btn=(Button)findViewById(R.id.button01);
		btn.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO �Զ����ɵķ������
		Intent intent=new Intent();
		intent.setClass(this, Menutest.class);
		startActivity(intent);
	}
		@Override
		public void onCreateContextMenu(android.view.ContextMenu menu, View v,
				ContextMenuInfo menuInfo) {
			// TODO �Զ����ɵķ������
			menu.setHeaderIcon(R.drawable.ic_launcher);//����ͼ��
			if (v==tv) {
				menu.add(0, 1, 1, "10������");
				menu.add(0, 2, 2, "20������");
				menu.add(0, 3, 3, "30������");
				menu.add(0, 4, 4, "40������");
				menu.add(0, 5, 5, "10������");
			}
			else if (v==ed) {
				menu.add(1, 6, 6, "20������");
				menu.add(1, 7, 6, "30������");
			}
			super.onCreateContextMenu(menu, v, menuInfo);
		}
}
