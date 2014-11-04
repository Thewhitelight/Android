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
		//ͨ����һ�ַ�����ȡ
		this.image = (ImageView) findViewById(R.id.image);
		image.setImageBitmap(getHttpBitmap(DATA));
		
		//ͨ���ڶ��ַ�����ȡ
		this.image02 = (ImageView) findViewById(R.id.image02);
		image02.setImageBitmap(getBitmap(DATA_));
		
	}
	
	//��һ�ַ���
	public Bitmap getHttpBitmap(String data)
	{
		Bitmap bitmap = null;
		try
		{
			//��ʼ��һ��URL����
			URL url = new URL(data);
			//���HTTPConnection�������Ӷ���
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setConnectTimeout(5*1000);
			connection.setDoInput(true);
			connection.connect();
			//�õ�������
			InputStream is = connection.getInputStream();
			Log.i("TAG", "*********inputstream**"+is);
			bitmap = BitmapFactory.decodeStream(is);
			Log.i("TAG", "*********bitmap****"+bitmap);
			//�ر�������
			is.close();
			//�ر�����
			connection.disconnect();
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bitmap;
	}
	
	//�ڶ��ַ���
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
