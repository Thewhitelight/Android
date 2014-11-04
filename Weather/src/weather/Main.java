package weather;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;


import com.example.weather.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main extends Activity{
	Button btn=null;
	String strUrl="http://m.weather.com.cn/atad/101210610.html";
	TextView city=null;
	TextView temp1=null;
	TextView temp2=null;
	TextView temp3=null;
	TextView weather1=null;
	TextView weather2=null;
	TextView weather3=null;
	int[] tvs={R.id.city,R.id.temp1,R.id.temp2,R.id.temp3,R.id.weather1,R.id.weather2,R.id.weather3};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		city=(TextView) findViewById(R.id.city);
		temp1=(TextView) findViewById(R.id.temp1);
		temp2=(TextView) findViewById(R.id.temp2);
		temp3=(TextView) findViewById(R.id.temp3);
		weather1=(TextView) findViewById(R.id.weather1);
		weather2=(TextView) findViewById(R.id.weather2);
		weather3=(TextView) findViewById(R.id.weather3);
		btn=(Button) findViewById(R.id.btn_down);
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				new Thread(new GetWeatherInfoRunnable()).start();
			}
		});
	}
	Handler handler=new Handler(){
		public void handleMessage(Message msg) {
			String strWeather=msg.getData().getString("strWeather");
			String[] weathers=strWeather.split(",");
			for(int i=0;i<weathers.length;i++){
				String str=weathers[i];
				Log.i("str", str);
				TextView tv=(TextView) findViewById(tvs[i]);
				tv.setText(str);
			}
		};
	};
	class GetWeatherInfoRunnable implements Runnable {
		@Override
		public void run() {
			try {
//				JsonReader jr=new JsonReader(new InputStreamReader(is));//google公司，专门用来解析json的，效率会高。
				URL url=new URL(strUrl);
				InputStream is=url.openStream();
				
				String strWeather=parseWeather(is);//获取当天基础天气
				
				Message msg=new Message();
				Bundle bundle=new Bundle();
				bundle.putString("strWeather", strWeather);
				msg.setData(bundle);
				handler.sendMessage(msg);
				
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	private String parseWeather(InputStream is) {
		String str=Util.convertStreamToString(is);
		Log.i("str",str);
		
		try {
			JSONObject json=new JSONObject(str);
			JSONObject weatherinfo=json.getJSONObject("weatherinfo");
			String city=weatherinfo.getString("city");
			String temp1=weatherinfo.getString("temp1");
			String temp2=weatherinfo.getString("temp2");
			String temp3=weatherinfo.getString("temp3");
			String weather1=weatherinfo.getString("weather1");
			String weather2=weatherinfo.getString("weather2");
			String weather3=weatherinfo.getString("weather3");
//			/*Log.i("city",city );
//			Log.i("temp1", temp1);
//			Log.i("temp2",temp2 );
//			Log.i("weather1",weather1 );*/
			str=city+","+temp1+","+temp2+","+temp3+","+weather1+","+weather2+","+weather3+",";
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return str;
	}
}
