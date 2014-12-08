package com.szq;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.sqloperate.R;

public class MainActivity extends Activity implements OnClickListener {
	public static final String TAG = "MainActivity";
	public static final String DB_NAME = "students.db";
	private EditText edt_id;
	private EditText edt_name;
	private EditText edt_age;
	private Button btn_insert;
	private Button btn_find;
	private Button btn_update;
	private Button btn_delete;
	private Button btn_show;
	public ListView lv_data;
	SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		init();
		openCreateDB();
	}

	private void openCreateDB() {
		// TODO Auto-generated method stub
		db = openOrCreateDatabase(DB_NAME, MODE_PRIVATE, null);
		db.execSQL("drop table if exists students");
		db.execSQL("create table if not exists students(id integer primary key autoincrement,name varchar ,age integer)");
	}

	private void insertData() {
		// TODO Auto-generated method stub
		String name = edt_name.getText().toString();
		String id = edt_id.getText().toString();
		String age = edt_age.getText().toString();
		ContentValues cv = new ContentValues();
		cv.put("id", id);
		cv.put("name", name);
		cv.put("age", age);
		db.insert("students", null, cv);
		edt_age.setText("");
		edt_id.setText("");
		edt_name.setText("");
	}

	private void showData() {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		Cursor cursor = db.rawQuery("select * from students", null);
		while (cursor.moveToNext()) {
			int id = cursor.getInt(cursor.getColumnIndex("id"));
			String name = cursor.getString(cursor.getColumnIndex("name"));
			int age = cursor.getInt(cursor.getColumnIndex("age"));
			String str = "ID:" + id + " NAME:" + name + " AGE:" + age;
			list.add(str);

		}
		cursor.close();
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_expandable_list_item_1, list);
		lv_data.setAdapter(adapter);
	}

	private void deleteData() {
		// TODO Auto-generated method stub

		db.execSQL("delete from students where id="
				+ edt_id.getText().toString());

	}

	private void updateData() {
		// TODO Auto-generated method stub
		ContentValues cv = new ContentValues();
		cv.put("name", edt_name.getText().toString());
		cv.put("age", edt_age.getText().toString());
		db.update("students", cv, "id=?", new String[] { edt_id.getText()
				.toString() });
	}

	private void selectData() {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		Cursor cursor = db.rawQuery("select * from students where id=?",
				new String[] { edt_id.getText().toString() });
		while (cursor.moveToNext()) {
			int id = cursor.getInt(cursor.getColumnIndex("id"));
			String name = cursor.getString(cursor.getColumnIndex("name"));
			int age = cursor.getInt(cursor.getColumnIndex("age"));
			String str = "ID:" + id + " NAME:" + name + " AGE:" + age;
			list.add(str);
		}
		cursor.close();
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_expandable_list_item_1, list);
		lv_data.setAdapter(adapter);
	}

	private void init() {
		// TODO Auto-generated method stub
		edt_id = (EditText) findViewById(R.id.edt_id);
		edt_name = (EditText) findViewById(R.id.edt_name);
		edt_age = (EditText) findViewById(R.id.edt_age);
		lv_data = (ListView) findViewById(R.id.lv_data);
		btn_delete = (Button) findViewById(R.id.btn_delete);
		btn_find = (Button) findViewById(R.id.btn_find);
		btn_insert = (Button) findViewById(R.id.btn_insert);
		btn_show = (Button) findViewById(R.id.btn_show);
		btn_update = (Button) findViewById(R.id.btn_update);
		btn_delete.setOnClickListener(this);
		btn_find.setOnClickListener(this);
		btn_insert.setOnClickListener(this);
		btn_show.setOnClickListener(this);
		btn_update.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_delete:
			deleteData();
			break;
		case R.id.btn_find:
			selectData();
			break;
		case R.id.btn_insert:
			insertData();
			break;
		case R.id.btn_show:
			showData();
			break;
		case R.id.btn_update:
			updateData();
			break;

		default:
			break;
		}
	}
}
