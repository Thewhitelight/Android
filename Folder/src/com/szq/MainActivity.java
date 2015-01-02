package com.szq;

import java.io.File;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.folder.R;

/**
 * @author SZQ �����ļ�����ʱӦ�������Ȩ�� <uses-permission
 *         android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
 *         <uses-permission
 *         android:name="android.permission.MOUNT_UNMOUNT_FILESYSTEMS" />
 */
public class MainActivity extends Activity {
	private Button btn_new;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		btn_new = (Button) findViewById(R.id.btn_new);
		String status = Environment.getExternalStorageState();
		if (status.equals(Environment.MEDIA_MOUNTED)) {
			btn_new.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					String path = Environment.getExternalStorageDirectory()
							.getPath() + "/szq/test"; // �ļ���·��Ӧʹ��Linuxϵͳ��ʽ
					File nFile = new File(path);
					if (!nFile.exists()) {
						nFile.mkdirs();
						Toast.makeText(getApplicationContext(), path,
								Toast.LENGTH_SHORT).show();
					}
				}
			});
		} else {
			Toast.makeText(getApplicationContext(), "���Ȳ����ڴ濨",
					Toast.LENGTH_SHORT).show();
		}

	}
}
