package com.szq;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

public class FileService {
	private final static String TAG = "FileService";
	private Context context;

	public FileService(Context context) {
		// TODO Auto-generated constructor stub
		this.context = context;
	}

	public FileService() {
		// TODO Auto-generated constructor stub
	}

	public String getFileFromSdcard(String fileName) {
		// TODO Auto-generated method stub
		FileInputStream inputSream = null;
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		File file = new File(Environment.getExternalStorageDirectory(),
				fileName);
		if (Environment.MEDIA_MOUNTED.equals(Environment
				.getExternalStorageState())) {
			try {
				inputSream = new FileInputStream(file);
				int length = 0;
				byte[] buffer = new byte[1024];
				while ((length = (inputSream.read(buffer))) != -1) {
					outputStream.write(buffer, 0, length);
				}

			} catch (FileNotFoundException e) {
				// TODO: handle exception
				e.printStackTrace();
				Log.i(TAG, "getFileFromSdcard");
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				if (inputSream != null) {
					try {
						inputSream.close();
					} catch (IOException e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
			}
		} else {
			Toast.makeText(context, "Please input SD card", Toast.LENGTH_SHORT)
					.show();
		}
		return new String(outputStream.toByteArray());
	}

	public boolean saveContentToSdcard(String fileName, String content) {
		boolean flag = false;
		// TODO Auto-generated method stub
		FileOutputStream fileOutputStream = null;
		File file = new File(Environment.getExternalStorageDirectory(),
				fileName);
		if (Environment.MEDIA_MOUNTED.equals(Environment
				.getExternalStorageState())) {
			try {
				fileOutputStream = new FileOutputStream(file);
				fileOutputStream.write(content.getBytes());
				flag = true;
			} catch (FileNotFoundException e) {
				// TODO: handle exception
				e.printStackTrace();
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				if (fileOutputStream != null) {
					try {
						fileOutputStream.close();
					} catch (IOException e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
			}
		}
		return flag;
	}

}
