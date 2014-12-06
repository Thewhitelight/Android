package com.szq.datasystem;

import com.szq.datasystemandroid.R;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button btn_add;
	private Button btn_del;
	private Button btn_sel;
	private Button btn_update;
	private Button btn_selall;
	private ListView lv_data;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		btn_add = (Button) findViewById(R.id.btn_add);
		btn_del = (Button) findViewById(R.id.btn_del);
		btn_sel = (Button) findViewById(R.id.btn_sel);
		btn_update = (Button) findViewById(R.id.btn_update);
		btn_selall = (Button) findViewById(R.id.btn_selall);
		lv_data = (ListView) findViewById(R.id.lv_data);
		btn_add.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				addDialog();
			}
		});
		btn_del.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			}
		});
		btn_sel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			}
		});
		btn_update.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			}
		});
		btn_selall.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			}
		});
	}

	/**
	 * 增加数据Dialog
	 */
	public void addDialog() {

		final Dialog addDialog = new Dialog(MainActivity.this);
		addDialog.setContentView(R.layout.adddialog_layout);
		addDialog.setTitle("请填写需增加数据");
		Window dialogWindow = addDialog.getWindow();
		WindowManager.LayoutParams wl = dialogWindow.getAttributes();
		dialogWindow.setGravity(Gravity.CENTER);
		dialogWindow.setAttributes(wl);
		final EditText et_inst_id = (EditText) findViewById(R.id.et_inst_id);
		final EditText et_inst_name = (EditText) findViewById(R.id.et_inst_name);
		final EditText et_inst_type = (EditText) findViewById(R.id.et_inst_type);
		final EditText et_user_name = (EditText) findViewById(R.id.et_user_name);
		final EditText et_buy = (EditText) findViewById(R.id.et_buy);
		Button btn_addcomfirm = (Button) addDialog
				.findViewById(R.id.btn_addcomfirm);
		Button btn_cancel = (Button) addDialog.findViewById(R.id.btn_cancel);
		btn_addcomfirm.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "test", 1).show();
			}
		});
		btn_cancel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				addDialog.dismiss();
			}
		});
		addDialog.show();
	}

}
