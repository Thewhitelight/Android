package com.szq;

import org.json.JSONObject;

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
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.volley.R;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
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
	private Button btn_json;
	private TextView tv_json;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		btn_ok = (Button) findViewById(R.id.btn_ok);
		tv_show = (TextView) findViewById(R.id.tv_show);
		btn_pic = (Button) findViewById(R.id.btn_pic);
		img_pic = (ImageView) findViewById(R.id.img_pic);
		btn_json = (Button) findViewById(R.id.btn_json);
		tv_json = (TextView) findViewById(R.id.tv_json);
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
		btn_json.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				getJson();
			}
		});
	}

	private void netImg() {
		// TODO Auto-generated method stub

		/*
		 * 获取网络图片适合获取少量图片
		 */
		// RequestQueue request =
		// Volley.newRequestQueue(getApplicationContext());
		// ImageRequest imgr = new ImageRequest(
		// "http://thewhitelight.github.io//images/avatar.jpg",
		// new Response.Listener<Bitmap>() {
		//
		// @Override
		// public void onResponse(Bitmap arg0) {
		// // TODOAuto-generated method stub
		// img_pic.setImageBitmap(arg0);
		// }
		// }, 600, 600, Config.ARGB_8888, new ErrorListener() {
		//
		// @Override
		// public void onErrorResponse(VolleyError arg0) {
		// // TODO Auto-generated method stub
		//
		// }
		// });
		// request.add(imgr);

		/*
		 * 适合同时获取大量图片，如瀑布流
		 */
		int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);// 获取手机内存；
		int imgsize = maxMemory / 8;// 内存的1/8作为图片缓存
		RequestQueue mRequestQueue = Volley
				.newRequestQueue(getApplicationContext());
		final LruCache<String, Bitmap> mImageCache = new LruCache<String, Bitmap>(
				imgsize);// 设置缓存，3.1以后的版本能用
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

		// 第一个参数ImageView实例
		// 第二个参数是为获取到网络图片时显示的图片
		// 第三个参数是请求失败时候的资源id
		ImageListener listener = ImageLoader
				.getImageListener(img_pic, android.R.drawable.ic_menu_rotate,
						android.R.drawable.ic_delete);
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
					public void onResponse(String arg0) { // 更新UI
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

	private void getJson() {
		// TODO Auto-generated method stub
		RequestQueue rq = Volley.newRequestQueue(getApplicationContext());
		String url = "http://fanyi.youdao.com/openapi.do?keyfrom=testhttpclient&key=1320375195&type=data&doctype=json&version=1.1&q=good";
		final ProgressDialog pd = ProgressDialog.show(this, "获取JSON",
				"downloading...");
		JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url,
				null, new Listener<JSONObject>() {

					@Override
					public void onResponse(JSONObject arg0) {
						// TODO Auto-generated method stub
						tv_json.setText(arg0.toString());
						if (pd != null && pd.isShowing()) {
							pd.dismiss();
						}
					}
				}, new ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError arg0) {
						// TODO Auto-generated method stub
						arg0.printStackTrace();
					}
				});
		rq.add(jor);
	}
}
