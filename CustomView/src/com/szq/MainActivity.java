package com.szq;

import com.example.customview.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends Activity {
	View view;

	@SuppressLint("InlinedApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		view = findViewById(R.id.cv2);
		view.setBackgroundColor(getResources().getColor(
				android.R.color.holo_blue_bright));
		view.setAlpha(0.3f);
		view.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(),
						"Äúµã»÷ÁË" + getApplicationInfo(), Toast.LENGTH_SHORT)
						.show();
				view.setX(100);
			}
		});
	}
}
