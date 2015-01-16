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

		ed.setText("�γ�����:" + "\n" + "�Ͽ�ʱ��:" + "\n" + "�Ͽεص�:");
	}

	protected void onResume() {
		super.onResume();

		SharedPreferences prefs = getPreferences(0); // ��ȡĬ�ϵ�SharedPreferences
														// Xml�ļ�
		String restoredText = prefs.getString("text", null);// ��ȡ��Ϊtext��ֵ��Ҳ����EditText�����ݣ�
		if (restoredText != null) {// �ж���������ݾ�ȡ�������ø�EditText��BufferType.EDITABLE�����൱������������ַ���ΪStringBuffer���ͣ�Ҳ����˵getText��ɵ���append���������ı�����

			ed.setText(restoredText);

			int selectionStart = prefs.getInt("selection-start", -1);// ��ȡ���Ŀ�ʼλ�ã����û�з���-1
			int selectionEnd = prefs.getInt("selection-end", -1);// ��ȡ���Ľ���λ�ã����û�з���-1
			if (selectionStart != -1 && selectionEnd != -1) {
				ed.setSelection(selectionStart, selectionEnd);// ͨ�����Ŀ�ʼ�ͽ���λ��ȷ��������ȷλ��
			}
		}
	}

	protected void onPause() {
		super.onPause();

		// ��ȡ�༭SharedPreferences Xml�ļ���Ȩ��

		SharedPreferences.Editor editor = getPreferences(0).edit();

		// ����text����Ӧ��ֵΪEditText������
		editor.putString("text", ed.getText().toString());

		// ��ȡEditText��mSaved���й��Ŀ�ʼ�ͽ���λ�ò��ֱ𱣴����selection-start��selection-end
		editor.putInt("selection-start", ed.getSelectionStart());
		editor.putInt("selection-end", ed.getSelectionEnd());

		// �ύ�޸�
		editor.commit();
	}
}
