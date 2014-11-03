package com.szq;

import com.example.roundrectangle.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.provider.Settings.System;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Round extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		GradientDrawable roundrectangle = (GradientDrawable) this
				.getResources().getDrawable(R.drawable.my_round_rectangle);
		final TextView tv = (TextView) findViewById(R.id.tv);
		tv.setBackgroundDrawable(roundrectangle);
		tv.setText("µã»÷");
		tv.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "successs",
						Toast.LENGTH_SHORT).show();
				finish();
			}
		});
	}
}
