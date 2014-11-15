package com.szq;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import com.example.xml_phone_number.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Mian extends Activity {
	private EditText et;
	private Button btn_ok;
	private TextView tv_show;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		et = (EditText) findViewById(R.id.et_num);
		tv_show = (TextView) findViewById(R.id.tv_show);
		btn_ok = (Button) findViewById(R.id.btn_ok);
		btn_ok.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String phoneNum = et.getText().toString().trim();
				if ("".equals(phoneNum) || phoneNum.length() < 7) {
					Toast.makeText(getApplicationContext(), "�����ֻ��Ų��Ϲ淶",
							Toast.LENGTH_SHORT).show();
					et.requestFocus();
				}
				tv_show.setText(getInfo(phoneNum));
			}
		});
	}

	public String getInfo(String phoneSec) {
		// TODO Auto-generated method stub
		String nameSpace = "http://WebXml.com.cn/";//�����ռ�
		String methodName = "getMobileCodeInfo";//���÷�������
		String endPoint = "http://webservice.webxml.com.cn/WebServices/MobileCodeWS.asmx";//EndPoint
		String soapAction = "http://WebXml.com.cn/getMobileCodeInfo";//SOAP Action
		SoapObject so = new SoapObject(nameSpace, methodName);//ָ��WebService�������ռ�͵��õķ���
		so.addProperty("mobileCode", phoneSec);//���õ���WebService�ӿ���Ҫ������������mobileCode��userId 
		so.addProperty("userId", "");
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);//���ɵ���WebService������SOAP������Ϣ��ָ��SOAP�汾
		envelope.bodyOut = so;
		envelope.dotNet = true;//�Ƿ����.Net������WebService
		envelope.setOutputSoapObject(so);
		HttpTransportSE transport = new HttpTransportSE(endPoint);
		try {
			transport.call(soapAction, envelope);//����WebService
		} catch (Exception e) {
			// TODO: handle exception
			Log.i("eception", e.getMessage().toString());
		}
		SoapObject object = (SoapObject) envelope.bodyIn;//��ȡ���ص�����
		String result = object.getProperty("getMobileCodeInfoResult")
				.toString();//��ȡ���صĽ��
		return result;
	}
}
