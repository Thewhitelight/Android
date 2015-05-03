package com.example.encryption;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements OnClickListener {
	private EditText edit;
	private Button md5, aes, hmac, sha, decrypt;
	private TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		edit = (EditText) findViewById(R.id.editText1);
		md5 = (Button) findViewById(R.id.MD5);
		aes = (Button) findViewById(R.id.AES);
		hmac = (Button) findViewById(R.id.HMAC);
		sha = (Button) findViewById(R.id.SHA);
		tv = (TextView) findViewById(R.id.tv);
		decrypt = (Button) findViewById(R.id.decryt_AES);
		md5.setOnClickListener(this);
		aes.setOnClickListener(this);
		sha.setOnClickListener(this);
		hmac.setOnClickListener(this);
		decrypt.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String str = edit.getText().toString();
		String key = "0102030405060708";// AES key必须为16位
		switch (v.getId()) {
		case R.id.MD5:

			try {
				tv.setText(Encryption.MD5(str).toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			edit.setText("");
			break;
		case R.id.SHA:
			try {
				tv.setText(Encryption.SHA(str));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			edit.setText("");
			break;
		case R.id.HMAC:
			try {
				tv.setText(Encryption.Encryption_HMAC(str,
						Encryption.initMacKey()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			edit.setText("");
			break;
		case R.id.AES:
			try {
				tv.setText(Encryption.AES(str, key));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			edit.setText("");
			break;
		case R.id.decryt_AES:
			try {
				if (tv.getText().toString() != "") {
					tv.setText(Encryption.decrypt_AES(tv.getText().toString(),
							key));
				}
				if (tv.getText().toString() == "") {
					Toast.makeText(getApplicationContext(), "输入不能为空",
							Toast.LENGTH_SHORT).show();
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			edit.setText("");
			break;
		}
	}
}
