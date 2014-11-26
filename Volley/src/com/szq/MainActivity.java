package com.szq;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageCache;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.volley.R;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.util.LruCache;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
	private Button btn_ok;
	private TextView tv_show;
	private Button btn_pic;
	private ImageView img_pic;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		btn_ok = (Button) findViewById(R.id.btn_ok);
		tv_show = (TextView) findViewById(R.id.tv_show);
		btn_pic = (Button) findViewById(R.id.btn_pic);
		img_pic = (ImageView) findViewById(R.id.img_pic);
		btn_ok.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				netWork();
			}
		});
		btn_pic.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				netImg();
			}
		});
	}

	private void netImg() {
		// TODO Auto-generated method stub

		/*
		 * ��ȡ����ͼƬ�ʺϻ�ȡ����ͼƬ RequestQueue request =
		 * Volley.newRequestQueue(getApplicationContext()); ImageRequest imgr =
		 * new ImageRequest(
		 * "http://thewhitelight.github.io//images/avatar.jpg", new
		 * Response.Listener<Bitmap>() {
		 * 
		 * @Override public void onResponse(Bitmap arg0) { // TODO
		 * Auto-generated method stub img_pic.setImageBitmap(arg0); } }, 600,
		 * 600, Config.ARGB_8888, new ErrorListener() {
		 * 
		 * @Override public void onErrorResponse(VolleyError arg0) { // TODO
		 * Auto-generated method stub
		 * 
		 * } }); request.add(imgr);
		 */

		/*
		 * �ʺ�ͬʱ��ȡ����ͼƬ�����ٲ���
		 */
		int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);// ��ȡ�ֻ��ڴ棻
		int imgsize = maxMemory / 8;// �ڴ��1/8��ΪͼƬ����
		RequestQueue mRequestQueue = Volley
				.newRequestQueue(getApplicationContext());
		final LruCache<String, Bitmap> mImageCache = new LruCache<String, Bitmap>(
				imgsize);
		ImageCache imageCache = new ImageCache() {
			@Override
			public void putBitmap(String key, Bitmap value) {
				mImageCache.put(key, value);
			}

			@Override
			public Bitmap getBitmap(String key) {
				return mImageCache.get(key);
			}
		};

		// ��һ������ImageViewʵ��
		// �ڶ���������Ϊ��ȡ������ͼƬʱ��ʾ��ͼƬ
		// ����������������ʧ��ʱ�����Դid
		ImageListener listener = ImageLoader.getImageListener(img_pic,
				R.drawable.ic_launcher, android.R.drawable.ic_delete);// android.R.drawable.ic_menu_rotate
		ImageLoader mImageLoader = new ImageLoader(mRequestQueue, imageCache);
		mImageLoader.get("http://thewhitelight.github.io//images/avatar.jpg",
				listener);
	}

	private void netWork() {
		// TODO Auto-generated method stub

		RequestQueue rq = Volley.newRequestQueue(getApplicationContext());
		// TODO Auto-generated method stub
		StringRequest request = new StringRequest(Request.Method.GET,
				"http://www.baidu.com", new Listener<String>() {

					@Override
					public void onResponse(String arg0) { // ����UI
						// TODO Auto-generated method stub
						tv_show.setText(arg0);
					}
				}, new ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError arg0) {
						// TODO Auto-generated method stub
						arg0.printStackTrace();
					}
				});
		rq.add(request);

	}
}
