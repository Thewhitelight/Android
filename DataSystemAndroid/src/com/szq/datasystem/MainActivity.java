package com.szq.datasystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.AndroidHttpTransport;
import android.app.Activity;
import android.app.Dialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
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
	private EditText et_add_inst_id;
	private EditText et_add_inst_name;
	private EditText et_add_inst_type;
	private EditText et_add_user_name;
	private EditText et_add_buy_date;
	private EditText et_del_inst_id;
	private EditText et_sel_inst_id;
	private EditText et_update_inst_id;
	private EditText et_update_inst_name;
	private EditText et_update_inst_type;
	private EditText et_update_user_name;
	private EditText et_update_buy_date;
	private ListView lv_data;
	private Dialog dialog;
	private SimpleAdapter adapter;
	private List<HashMap<String, String>> listItems;
	private String nameSpace = "http://tempuri.org/";
	private String WSDL = "http://10.64.130.88:10800";

	/**
	 * 获取全部信息的AsyncTask
	 * 
	 * @author SZQ
	 *
	 */
	class ShowDataAsyncTask extends AsyncTask<Object, Object, String> {
		private String methodName = "selectAllInfo";

		@Override
		protected String doInBackground(Object... params) {
			listItems.clear();
			// TODO Auto-generated method stub
			SoapObject soapObject = new SoapObject(nameSpace, methodName);
			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
					SoapEnvelope.VER10);
			envelope.dotNet = true;
			envelope.setOutputSoapObject(soapObject);
			AndroidHttpTransport transport = new AndroidHttpTransport(WSDL);
			transport.debug = true;
			try {
				transport.call(nameSpace + methodName, envelope);
				SoapObject resultObject = (SoapObject) envelope.getResponse();
				int count = resultObject.getPropertyCount();
				for (int i = 0; i < count; i += 6) {
					HashMap<String, String> listItem = new HashMap<String, String>();
					listItem.put("id", resultObject.getProperty(i).toString());
					listItem.put("inst_id", resultObject.getProperty(i + 1)
							.toString());
					listItem.put("inst_name", resultObject.getProperty(i + 2)
							.toString());
					listItem.put("inst_type", resultObject.getProperty(i + 3)
							.toString());
					listItem.put("user_name", resultObject.getProperty(i + 4)
							.toString());
					listItem.put("buy_date", resultObject.getProperty(i + 5)
							.toString());
					listItems.add(listItem);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return "success";
		}

		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			if (result.equals("success")) {
				adapter = new SimpleAdapter(MainActivity.this, listItems,
						R.layout.list_item, new String[] { "id", "inst_id",
								"inst_name", "inst_type", "user_name",
								"buy_date" }, new int[] { R.id.tv_id,
								R.id.tv_inst_id, R.id.tv_inst_name,
								R.id.tv_inst_type, R.id.tv_user_name,
								R.id.tv_buy_date });
				lv_data.setAdapter(adapter);
			}
		}
	}

	/**
	 * 添加信息的AsyncTask
	 * 
	 * @author SZQ
	 *
	 */
	class AddDataAsyncTask extends AsyncTask<Object, Object, String> {
		private String methodName = "insertInfo";

		@Override
		protected String doInBackground(Object... params) {
			listItems.clear();
			// TODO Auto-generated method stub
			SoapObject soapObject = new SoapObject(nameSpace, methodName);
			soapObject.addProperty("inst_id", et_add_inst_id.getText()
					.toString());
			soapObject.addProperty("inst_name", et_add_inst_name.getText()
					.toString());
			soapObject.addProperty("inst_type", et_add_inst_type.getText()
					.toString());

			soapObject.addProperty("user_name", et_add_user_name.getText()
					.toString());
			soapObject.addProperty("buy_date", et_add_buy_date.getText()
					.toString());
			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
					SoapEnvelope.VER10);
			envelope.dotNet = true;
			envelope.setOutputSoapObject(soapObject);
			AndroidHttpTransport transport = new AndroidHttpTransport(WSDL);
			transport.debug = true;
			try {
				transport.call(nameSpace + methodName, envelope);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return "success";
		}

		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			if (result.equals("success")) {
				Toast.makeText(MainActivity.this, "增添数据成功", Toast.LENGTH_SHORT)
						.show();
			}
		}
	}

	/**
	 * 删除信息的AsyncTask
	 * 
	 * @author SZQ
	 *
	 */
	class delDataAsyncTask extends AsyncTask<Object, Object, String> {
		private String methodName = "deleteInfo";

		@Override
		protected String doInBackground(Object... params) {
			listItems.clear();
			// TODO Auto-generated method stub
			SoapObject soapObject = new SoapObject(nameSpace, methodName);
			soapObject.addProperty("inst_id", et_del_inst_id.getText()
					.toString());
			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
					SoapEnvelope.VER10);
			envelope.dotNet = true;
			envelope.setOutputSoapObject(soapObject);
			AndroidHttpTransport transport = new AndroidHttpTransport(WSDL);
			transport.debug = true;
			try {
				transport.call(nameSpace + methodName, envelope);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return "success";
		}

		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			if (result.equals("success")) {
				Toast.makeText(MainActivity.this, "删除数据成功", Toast.LENGTH_SHORT)
						.show();
			}
		}
	}

	/**
	 * 查询信息的AsyncTask
	 * 
	 * @author SZQ
	 *
	 */
	class selDataAsyncTask extends AsyncTask<Object, Object, String> {
		private String methodName = "selectInfo";

		@Override
		protected String doInBackground(Object... params) {
			listItems.clear();
			// TODO Auto-generated method stub
			SoapObject soapObject = new SoapObject(nameSpace, methodName);
			soapObject.addProperty("inst_id", et_sel_inst_id.getText()
					.toString());
			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
					SoapEnvelope.VER10);
			envelope.dotNet = true;
			envelope.setOutputSoapObject(soapObject);
			AndroidHttpTransport transport = new AndroidHttpTransport(WSDL);
			transport.debug = true;
			try {
				transport.call(nameSpace + methodName, envelope);
				SoapObject resultObject = (SoapObject) envelope.getResponse();
				int count = resultObject.getPropertyCount();
				for (int i = 0; i < count; i += 6) {
					HashMap<String, String> listItem = new HashMap<String, String>();
					listItem.put("id", resultObject.getProperty(i).toString());
					listItem.put("inst_id", resultObject.getProperty(i + 1)
							.toString());
					listItem.put("inst_name", resultObject.getProperty(i + 2)
							.toString());
					listItem.put("inst_type", resultObject.getProperty(i + 3)
							.toString());
					listItem.put("user_name", resultObject.getProperty(i + 4)
							.toString());
					listItem.put("buy_date", resultObject.getProperty(i + 5)
							.toString());
					listItems.add(listItem);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return "success";
		}

		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			if (result.equals("success")) {
				adapter = new SimpleAdapter(MainActivity.this, listItems,
						R.layout.list_item, new String[] { "id", "inst_id",
								"inst_name", "inst_type", "user_name",
								"buy_date" }, new int[] { R.id.tv_id,
								R.id.tv_inst_id, R.id.tv_inst_name,
								R.id.tv_inst_type, R.id.tv_user_name,
								R.id.tv_buy_date });
				lv_data.setAdapter(adapter);
			}
		}
	}

	/**
	 * 更新信息AsyncTask
	 * 
	 * @author SZQ
	 *
	 */
	class UpdateDataAsyncTask extends AsyncTask<Object, Object, String> {
		private String methodName = "updataInfo";

		@Override
		protected String doInBackground(Object... params) {
			listItems.clear();
			// TODO Auto-generated method stub
			SoapObject soapObject = new SoapObject(nameSpace, methodName);
			soapObject.addProperty("inst_id", et_update_inst_id.getText()
					.toString());
			soapObject.addProperty("inst_name", et_update_inst_name.getText()
					.toString());
			soapObject.addProperty("inst_type", et_update_inst_type.getText()
					.toString());
			soapObject.addProperty("user_name", et_update_user_name.getText()
					.toString());
			soapObject.addProperty("buy_date", et_update_buy_date.getText()
					.toString());
			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
					SoapEnvelope.VER10);
			envelope.dotNet = true;
			envelope.setOutputSoapObject(soapObject);
			AndroidHttpTransport transport = new AndroidHttpTransport(WSDL);
			transport.debug = true;
			try {
				transport.call(nameSpace + methodName, envelope);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return "success";
		}

		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			if (result.equals("success")) {
				Toast.makeText(MainActivity.this, "更新数据成功", Toast.LENGTH_SHORT)
						.show();
			}
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		listItems = new ArrayList<HashMap<String, String>>();
		init();
	}

	/**
	 * 增加数据Dialog
	 */
	private void addShowDialog() {
		dialog = new Dialog(MainActivity.this);
		dialog.setContentView(R.layout.adddialog_layout);
		dialog.setTitle("请输入添加数据");
		Window dialogWindow = dialog.getWindow();
		WindowManager.LayoutParams wl = dialogWindow.getAttributes();
		dialogWindow.setGravity(Gravity.CENTER);
		dialogWindow.setAttributes(wl);

		et_add_inst_id = (EditText) dialog.findViewById(R.id.et_add_inst_id);
		et_add_inst_name = (EditText) dialog
				.findViewById(R.id.et_add_inst_name);
		et_add_inst_type = (EditText) dialog
				.findViewById(R.id.et_add_inst_type);
		et_add_user_name = (EditText) dialog
				.findViewById(R.id.et_add_user_name);
		et_add_buy_date = (EditText) dialog.findViewById(R.id.et_add_buy_date);
		Button btn_addcomfirm = (Button) dialog
				.findViewById(R.id.btn_addcomfirm);
		btn_addcomfirm.setOnClickListener(this);
		Button btn_cancel = (Button) dialog.findViewById(R.id.btn_cancel);
		btn_cancel.setOnClickListener(this);
		dialog.show();
	}

	/**
	 * 通过inst_id删除数据Dialog
	 */
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
		et_del_inst_id = (EditText) dialog.findViewById(R.id.et_del_inst_id);
		Button btn_delcomfirm = (Button) dialog
				.findViewById(R.id.btn_delcomfirm);
		btn_delcomfirm.setOnClickListener(this);

	}

	/**
	 * 通过instead_id查询数据Dialog
	 */
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
		et_sel_inst_id = (EditText) dialog.findViewById(R.id.et_sel_inst_id);
		Button btn_selcomfirm = (Button) dialog
				.findViewById(R.id.btn_selcomfirm);
		btn_selcomfirm.setOnClickListener(this);
		dialog.show();
	}

	/**
	 * 通过inst_id更新数据Dialog
	 */
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
		et_update_inst_id = (EditText) dialog
				.findViewById(R.id.et_update_inst_id);
		et_update_inst_name = (EditText) dialog
				.findViewById(R.id.et_update_inst_name);
		et_update_inst_type = (EditText) dialog
				.findViewById(R.id.et_update_inst_type);
		et_update_user_name = (EditText) dialog
				.findViewById(R.id.et_update_inst_name);
		et_update_buy_date = (EditText) dialog
				.findViewById(R.id.et_update_buy_date);
		Button btn_updatecomfirm = (Button) dialog
				.findViewById(R.id.btn_updatecomfirm);
		btn_updatecomfirm.setOnClickListener(this);
		dialog.show();
	}

	/**
	 * 初始化主界面
	 */
	private void init() {
		// TODO Auto-generated method stub
		btn_add = (Button) this.findViewById(R.id.btn_add);
		btn_del = (Button) this.findViewById(R.id.btn_del);
		btn_sel = (Button) this.findViewById(R.id.btn_sel);
		btn_update = (Button) this.findViewById(R.id.btn_update);
		btn_selall = (Button) this.findViewById(R.id.btn_selall);
		lv_data = (ListView) this.findViewById(R.id.lv_data);
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
			new ShowDataAsyncTask().execute();
			break;
		case R.id.btn_addcomfirm:
			new AddDataAsyncTask().execute();
			dialog.dismiss();
			break;
		case R.id.btn_delcomfirm:
			new delDataAsyncTask().execute();
			dialog.dismiss();
			break;
		case R.id.btn_selcomfirm:
			new selDataAsyncTask().execute();
			dialog.dismiss();
			break;
		case R.id.btn_updatecomfirm:
			new UpdateDataAsyncTask().execute();
			dialog.dismiss();
			break;
		case R.id.btn_cancel:
			dialog.dismiss();
			break;
		}

	}
}
