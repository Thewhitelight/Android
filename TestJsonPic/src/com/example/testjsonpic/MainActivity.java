package com.example.testjsonpic;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.ImageView;

public class MainActivity extends Activity
{

	public static final String DATA="http://www.baidu.com/img/baidu_sylogo1.gif";
	public static final String DATA_="http://www.baidu.com/img/baidu_sylogo1.gif";
	ImageView image = null,image02 = null;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initsView();
	}
	public void initsView()
	{
		//通过第一种方法获取
		this.image = (ImageView) findViewById(R.id.image);
		image.setImageBitmap(getHttpBitmap(DATA));
		
		//通过第二种方法获取
		this.image02 = (ImageView) findViewById(R.id.image02);
		image02.setImageBitmap(getBitmap(DATA_));
		
	}
	
	//第一种方法
	public Bitmap getHttpBitmap(String data)
	{
		Bitmap bitmap = null;
		try
		{
			//初始化一个URL对象
			URL url = new URL(data);
			//获得HTTPConnection网络连接对象
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setConnectTimeout(5*1000);
			connection.setDoInput(true);
			connection.connect();
			//得到输入流
			InputStream is = connection.getInputStream();
			Log.i("TAG", "*********inputstream**"+is);
			bitmap = BitmapFactory.decodeStream(is);
			Log.i("TAG", "*********bitmap****"+bitmap);
			//关闭输入流
			is.close();
			//关闭连接
			connection.disconnect();
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bitmap;
	}
	
	//第二种方法
	public Bitmap getBitmap(String s)
	{
		Bitmap bitmap = null;
		try
		{
			URL url = new URL(s);
			bitmap = BitmapFactory.decodeStream(url.openStream());
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bitmap;
	}

}
