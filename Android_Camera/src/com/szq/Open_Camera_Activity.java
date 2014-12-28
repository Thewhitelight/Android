package com.szq;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import com.example.android_camera.R;

public class Open_Camera_Activity extends Activity {
	private Button btn;
	private ImageView img;
	private Button btn_photo;
	private ImageView img_photo;
	private static final int CAMEAEA_CODE = 1;
	private static final int PHOTO_CODE = 2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		btn = (Button) findViewById(R.id.btn);
		img = (ImageView) findViewById(R.id.img);
		btn_photo = (Button) findViewById(R.id.btn_photo);
		img_photo = (ImageView) findViewById(R.id.img_photo);
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(
						android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
				startActivityForResult(intent, CAMEAEA_CODE);
			}
		});
		btn_photo.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(
						Intent.ACTION_PICK,
						android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
				startActivityForResult(intent, PHOTO_CODE);
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		switch (requestCode) {
		case CAMEAEA_CODE:
			if (resultCode == RESULT_OK) {
				Bundle b = data.getExtras();
				Bitmap bitmap = (Bitmap) b.get("data");
				img.setImageBitmap(bitmap);
			}

			break;

		case PHOTO_CODE:
			if (resultCode == RESULT_OK) {
				Uri uri = data.getData();
				img_photo.setImageURI(uri);
			}

			break;
		}

		super.onActivityResult(requestCode, resultCode, data);
	}
}
