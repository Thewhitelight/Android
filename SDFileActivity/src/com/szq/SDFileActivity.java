package com.szq;

import com.example.sdfileactivity.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SDFileActivity extends Activity {
	private final static String TAG = "SDFileActivity";
	private EditText addedt;
	private Button addbtn;
	private Button showbtn;
	private TextView showtv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		addedt = (EditText) findViewById(R.id.addedt);
		addbtn = (Button) findViewById(R.id.addbtn);
		showbtn = (Button) findViewById(R.id.showbtn);
		showtv = (TextView) findViewById(R.id.showtv);
		addbtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SDFileActivity.this.saveFile();

			}
		});
		showbtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SDFileActivity.this.readFile();
			}
		});
	}

	private void saveFile() {
		// TODO Auto-generated method stub
		String str = addedt.getText().toString();
		FileService fileService = new FileService(SDFileActivity.this);
		boolean flag = fileService.saveContentToSdcard("shizhiqiang.txt", str);
		Log.i(TAG, "--->>" + flag);
	}

	private void readFile() {
		// TODO Auto-generated method stub
		FileService fileService = new FileService(SDFileActivity.this);
		String str = fileService.getFileFromSdcard("shizhiqiang.txt");
		showtv.setText(str);
	}
}
