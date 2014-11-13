package com.szq;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.example.httpclient.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class HttpClientPost extends Activity{
	private TextView tv_content;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.http);
		tv_content=(TextView) findViewById(R.id.tv);
		String httpUrl="http://10.64.130.101:8080/JspDemo/PostFile.jsp";
		HttpPost httpRequest=new HttpPost(httpUrl);//http连接对象
		List<NameValuePair> params=new ArrayList<NameValuePair>();//使用NameValuePair来保存要传递的post参数
		params.add(new BasicNameValuePair("par", "HttpClient_Post"));
		try {
			HttpEntity httpentity=new UrlEncodedFormEntity(params,"gb2312");//设置字符集
			httpRequest.setEntity(httpentity);//请求httprequest
			HttpClient httpclient=new DefaultHttpClient();//取得默认的httpclient
			HttpResponse httpResponse=httpclient.execute(httpRequest);//取得httpresponse
			if (httpResponse.getStatusLine().getStatusCode()==HttpStatus.SC_OK) {
				String strResulT=EntityUtils.toString(httpResponse.getEntity());//取得返回的字符串
				tv_content.setText(strResulT);
			}
			else {
				tv_content.setText("请求错误");
			}
		}catch(ClientProtocolException e){
			tv_content.setTag(e.getMessage().toString());
		} catch (IOException e) {
			// TODO: handle exception
			tv_content.setText(e.getMessage().toString());
		}
		catch (Exception e) {
			// TODO: handle exception
			tv_content.setText(e.getMessage().toString());
		}
	}
}
