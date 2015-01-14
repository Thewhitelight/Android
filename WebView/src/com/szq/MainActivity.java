package com.szq;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.example.webview.R;

public class MainActivity extends Activity {
	private WebView webview;
	static final String URL = "https://money.11185.cn/";// 加载网络页面

	static final String URL2 = "file:///android_asset/test.html";// 加载本地assets文件夹中的html页面

	@SuppressLint({ "SetJavaScriptEnabled", "JavascriptInterface" })
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_PROGRESS);
		setContentView(R.layout.main);
		final Activity activity = this;
		webview = (WebView) findViewById(R.id.webview);
		webview.setWebViewClient(new MyWebChromeClient());
		webview.setBackgroundColor(getResources().getColor(
				android.R.color.holo_orange_light));
		// webview.setWebChromeClient(new WebChromeClient() {
		// @Override
		// public boolean onJsAlert(WebView view, String url, String message,
		// final JsResult result) {
		// // TODO Auto-generated method stub
		// new AlertDialog.Builder(MainActivity.this)
		// .setTitle("JavaScript对话框")
		// .setMessage(message)
		// .setPositiveButton(android.R.string.ok,
		// new OnClickListener() {
		//
		// @Override
		// public void onClick(DialogInterface dialog,
		// int which) {
		// // TODO Auto-generated method stub
		// result.confirm();
		// }
		// }).setCancelable(false).create().show();
		//
		// return super.onJsAlert(view, url, message, result);
		// }
		//
		// });
		webview.setWebChromeClient(new WebChromeClient() {
			@Override
			// 加载进度条
			public void onProgressChanged(WebView view, int newProgress) {
				// TODO Auto-generated method stub
				activity.setProgress(newProgress * 100);
			}
		});
		webview.loadUrl(URL);
		WebSettings webSetting = webview.getSettings();
		webSetting.setJavaScriptEnabled(true);
		webSetting.setSupportZoom(true);
		webSetting.setBuiltInZoomControls(true);
		webSetting.setUseWideViewPort(true);
		webSetting.setDefaultFontSize(1);
		webSetting.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
	}

	public class MyWebChromeClient extends WebViewClient {
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			// TODO Auto-generated method stub
			view.loadUrl(url);
			return true;
		}

		@Override
		public void onReceivedError(WebView view, int errorCode,
				String description, String failingUrl) {
			// TODO Auto-generated method stub
			Toast.makeText(MainActivity.this, "Sorry" + description,
					Toast.LENGTH_SHORT).show();
			view.loadUrl(URL2);
		}

		@Override
		public void onReceivedSslError(WebView view, SslErrorHandler handler,
				SslError error) {
			// TODO Auto-generated method stub
			handler.proceed();
		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		// 加入回退
		if ((keyCode == KeyEvent.KEYCODE_BACK) && webview.canGoBack()) {
			webview.goBack();
			return true;
		} else {
			return super.onKeyDown(keyCode, event);
		}

	}
}
