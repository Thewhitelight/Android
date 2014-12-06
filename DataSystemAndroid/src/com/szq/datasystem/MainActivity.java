package com.szq.datasystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.szq.datasystemandroid.R;

public class MainActivity extends Activity implements OnClickListener {
	private Button btn_add;
	private Button btn_del;
	private Button btn_sel;
	private Button btn_update;
	private Button btn_selall;
	private ListView lv_data;
	private Dialog dialog;
	private SimpleAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		init();
	}

	private void showAllInfo() {
		// TODO Auto-generated method stub
		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		adapter = new SimpleAdapter(MainActivity.this, list,
				R.layout.list_item, new String[] { "id", "inst_id",
						"inst_name", "inst_type", "user_name", "buy_date" },
				new int[] {});
		lv_data.setAdapter(adapter);
	}

	/**
	 * 增加数据Dialog
	 */
	public void addShowDialog() {
		dialog = new Dialog(MainActivity.this);
		dialog.setContentView(R.layout.adddialog_layout);
		dialog.setTitle("请输入添加数据");
		Window dialogWindow = dialog.getWindow();
		WindowManager.LayoutParams wl = dialogWindow.getAttributes();
		dialogWindow.setGravity(Gravity.CENTER);
		dialogWindow.setAttributes(wl);

		EditText et_inst_id = (EditText) findViewById(R.id.et_inst_id);
		EditText et_inst_name = (EditText) findViewById(R.id.et_inst_name);
		EditText et_inst_type = (EditText) findViewById(R.id.et_inst_type);
		EditText et_user_name = (EditText) findViewById(R.id.et_user_name);
		EditText et_buy = (EditText) findViewById(R.id.et_buy_date);
		Button btn_addcomfirm = (Button) dialog
				.findViewById(R.id.btn_addcomfirm);
		btn_addcomfirm.setOnClickListener(this);
		Button btn_cancel = (Button) dialog.findViewById(R.id.btn_cancel);
		btn_cancel.setOnClickListener(this);
		dialog.show();
	}

	private void deleteShowDialog() {
		// TODO Auto-generated method stub
		dialog = new Dialog(MainActivity.this);
		dialog.setContentView(R.layout.deldialog_layout);
		dialog.setTitle("请输入删除数据");
		Window dialogWindow = dialog.getWindow();
		WindowManager.LayoutParams wl = dialogWindow.getAttributes();
		dialogWindow.setGravity(Gravity.CENTER);
		dialogWindow.setAttributes(wl);
		Button btn_cancel = (Button) dialog.findViewById(R.id.btn_cancel);
		btn_cancel.setOnClickListener(this);
		dialog.show();
		EditText et_inst_id = (EditText) findViewById(R.id.et_inst_id);
		Button btn_delcomfirm = (Button) dialog
				.findViewById(R.id.btn_delcomfirm);
		btn_delcomfirm.setOnClickListener(this);

	}

	private void selShowDialog() {
		// TODO Auto-generated method stub
		dialog = new Dialog(MainActivity.this);
		dialog.setContentView(R.layout.seldialog_layout);
		dialog.setTitle("请输入查询数据");
		Window dialogWindow = dialog.getWindow();
		WindowManager.LayoutParams wl = dialogWindow.getAttributes();
		dialogWindow.setGravity(Gravity.CENTER);
		dialogWindow.setAttributes(wl);
		Button btn_cancel = (Button) dialog.findViewById(R.id.btn_cancel);
		btn_cancel.setOnClickListener(this);
		EditText et_inst_id = (EditText) dialog.findViewById(R.id.et_inst_id);
		Button btn_selcomfirm = (Button) dialog
				.findViewById(R.id.btn_selcomfirm);
		btn_selcomfirm.setOnClickListener(this);
		dialog.show();
	}

	private void updateShowDialog() {
		// TODO Auto-generated method stub
		dialog = new Dialog(MainActivity.this);
		dialog.setContentView(R.layout.updatedialog_layout);
		dialog.setTitle("请输入更新数据");
		Window dialogWindow = dialog.getWindow();
		WindowManager.LayoutParams wl = dialogWindow.getAttributes();
		dialogWindow.setGravity(Gravity.CENTER);
		dialogWindow.setAttributes(wl);
		Button btn_cancel = (Button) dialog.findViewById(R.id.btn_cancel);
		btn_cancel.setOnClickListener(this);
		EditText et_inst_id = (EditText) dialog.findViewById(R.id.et_inst_id);
		Button btn_updatecomfirm = (Button) dialog
				.findViewById(R.id.btn_updatecomfirm);
		btn_updatecomfirm.setOnClickListener(this);
		dialog.show();
	}

	private void init() {
		// TODO Auto-generated method stub
		btn_add = (Button) findViewById(R.id.btn_add);
		btn_del = (Button) findViewById(R.id.btn_del);
		btn_sel = (Button) findViewById(R.id.btn_sel);
		btn_update = (Button) findViewById(R.id.btn_update);
		btn_selall = (Button) findViewById(R.id.btn_selall);
		lv_data = (ListView) findViewById(R.id.lv_data);
		btn_add.setOnClickListener(this);
		btn_del.setOnClickListener(this);
		btn_sel.setOnClickListener(this);
		btn_update.setOnClickListener(this);
		btn_selall.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_add:
			addShowDialog();
			break;
		case R.id.btn_del:
			deleteShowDialog();
			break;
		case R.id.btn_sel:
			selShowDialog();
			break;
		case R.id.btn_update:
			updateShowDialog();
			break;
		case R.id.btn_selall:
			showAllInfo();
			Toast.makeText(MainActivity.this, "showdata", Toast.LENGTH_SHORT)
					.show();
			break;
		case R.id.btn_addcomfirm:
			Toast.makeText(MainActivity.this, "test1", Toast.LENGTH_SHORT)
					.show();
			break;
		case R.id.btn_cancel:
			dialog.dismiss();
			break;
		case R.id.btn_delcomfirm:
			Toast.makeText(MainActivity.this, "test2", Toast.LENGTH_SHORT)
					.show();
			break;
		case R.id.btn_selcomfirm:
			Toast.makeText(MainActivity.this, "test3", Toast.LENGTH_SHORT)
					.show();
			break;
		case R.id.btn_updatecomfirm:
			Toast.makeText(MainActivity.this, "test4", Toast.LENGTH_SHORT)
					.show();
			break;
		}

	}
}
