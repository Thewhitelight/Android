package com.tzc.course;

import geniuz.pathbuttons.R;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class CourseFive extends Activity {
	private EditText ed = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.course);
		overridePendingTransition(android.R.anim.slide_in_left,
				android.R.anim.slide_out_right);// 由左向右划入
		ed = (EditText) findViewById(R.id.ed);
		ed.setText("课程名称:" + "\n" + "上课时间:" + "\n" + "上课地点:" + "\n" + "\n"
				+ "课程名称:" + "\n" + "上课时间:" + "\n" + "上课地点:" + "\n" + "\n"
				+ "课程名称:" + "\n" + "上课时间:" + "\n" + "上课地点:" + "\n"
				+ "可以根据您的需求自己编辑课表（此段文字可删除）");
	}

	@Override
	protected void onResume() {
		// TODO 自动生成的方法存根
		super.onResume();
		SharedPreferences share = getPreferences(0);
		String restoredText = share.getString("text", null);
		if (restoredText != null) {
			ed.setText(restoredText);
			int selectionStrat = share.getInt("selection-start", -1);
			int selectionEnd = share.getInt("selection-end", -1);
			if (selectionStrat != -1 && selectionEnd != -1) {
				ed.setSelection(selectionStrat, selectionEnd);
			}
		}
	}

	@Override
	protected void onPause() {
		// TODO 自动生成的方法存根
		super.onPause();
		SharedPreferences.Editor editor = getPreferences(0).edit();
		editor.putString("text", ed.getText().toString());
		editor.putInt("selection-start", ed.getSelectionStart());
		editor.putInt("selection-end", ed.getSelectionEnd());
		editor.commit();
	}

}
