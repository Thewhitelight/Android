package com.szq;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.example.fileacitvity.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FileActivity extends Activity {
	private Button addBtn;
	private Button showBtn;
	private EditText addText;
	private TextView showText;
	private String fileName = "shizhiqiang_android.txt";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		addBtn = (Button) findViewById(R.id.addButton);
		showBtn = (Button) findViewById(R.id.showButton);
		addText = (EditText) findViewById(R.id.addText);
		showText = (TextView) findViewById(R.id.showText);
		addBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				save();
			}
		});
		showBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				read();
			}
		});
	}

	private void save() {
		String content = addText.getText().toString();
		try {
			FileOutputStream outputStream = openFileOutput(fileName,
					Activity.MODE_PRIVATE);
			outputStream.write(content.getBytes());
			outputStream.flush();
			outputStream.close();
			Toast.makeText(getApplicationContext(), "±£´æ³É¹¦", Toast.LENGTH_SHORT)
					.show();

		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private void read() {
		// TODO Auto-generated method stub
		try {
			FileInputStream inputStream = this.openFileInput(fileName);
			byte[] bytes = new byte[1024];
			ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
			while (inputStream.read(bytes) != -1) {
				arrayOutputStream.write(bytes, 0, bytes.length);
			}
			inputStream.close();
			arrayOutputStream.close();
			String content = new String(arrayOutputStream.toByteArray());
			showText.setText(content);
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
