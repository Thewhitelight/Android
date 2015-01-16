package test;

import com.example.course.R;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class NewCourse extends Activity {
	private EditText ed = null;
	private SharedPreferences prefs;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.newcourse);
		ed = (EditText) findViewById(R.id.ed);

		ed.setText("课程名称:" + "\n" + "上课时间:" + "\n" + "上课地点:");
	}

	protected void onResume() {
		super.onResume();

		SharedPreferences prefs = getPreferences(0); // 获取默认的SharedPreferences
														// Xml文件
		String restoredText = prefs.getString("text", null);// 获取键为text的值（也就是EditText的内容）
		if (restoredText != null) {// 判断如果有内容就取出并设置给EditText，BufferType.EDITABLE属性相当于设置里面的字符串为StringBuffer类型，也就是说getText后可调用append方法设置文本内容

			ed.setText(restoredText);

			int selectionStart = prefs.getInt("selection-start", -1);// 获取光标的开始位置，如果没有返回-1
			int selectionEnd = prefs.getInt("selection-end", -1);// 获取光标的结束位置，如果没有返回-1
			if (selectionStart != -1 && selectionEnd != -1) {
				ed.setSelection(selectionStart, selectionEnd);// 通过光标的开始和结束位置确定光标的正确位置
			}
		}
	}

	protected void onPause() {
		super.onPause();

		// 获取编辑SharedPreferences Xml文件的权限

		SharedPreferences.Editor editor = getPreferences(0).edit();

		// 设置text键对应的值为EditText的内容
		editor.putString("text", ed.getText().toString());

		// 获取EditText（mSaved）中光标的开始和结束位置并分别保存给键selection-start和selection-end
		editor.putInt("selection-start", ed.getSelectionStart());
		editor.putInt("selection-end", ed.getSelectionEnd());

		// 提交修改
		editor.commit();
	}
}
