package geniuz.pathbuttons;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class WeatherMain extends Activity {

	String strUrl = "http://113.108.239.116/atad/101210610.html";

	Button btn = null;
	TextView city = null;
	TextView date_y = null;
	TextView date = null;
	TextView temp1 = null;
	TextView temp2 = null;
	TextView temp3 = null;
	TextView temp4 = null;
	TextView weather1 = null;
	TextView weather2 = null;
	TextView weather3 = null;
	TextView weather4 = null;
	TextView wind1 = null;
	TextView fl1 = null;
	TextView index_d = null;
	TextView index_uv = null;
	TextView index_co = null;
	TextView index_ls = null;
	private TextView onedaytemp = null;
	private TextView twodaytemp = null;
	private TextView threedaytemp = null;
	private TextView fourdaytemp = null;
	private TextView onedayweather = null;
	private TextView twodayweather = null;
	private TextView threedayweather = null;
	private TextView fourdayweather = null;
	private String one = null;
	private String two = null;
	private String three = null;
	private String four = null;
	final Calendar c = Calendar.getInstance();
	int[] tvs = { R.id.city, R.id.date_y, R.id.date, R.id.temp1, R.id.wind1,
			R.id.index_d, R.id.index_uv, R.id.index_co, R.id.index_ls,
			R.id.weather1, R.id.temp2, R.id.weather2, R.id.temp3,
			R.id.weather3, R.id.temp4, R.id.weather4 };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.weather_main);
		overridePendingTransition(android.R.anim.fade_in,
				android.R.anim.fade_out);// ���뵭��Ч��
		city = (TextView) findViewById(R.id.city);
		date_y = (TextView) findViewById(R.id.date_y);
		temp1 = (TextView) findViewById(R.id.temp1);
		temp2 = (TextView) findViewById(R.id.temp2);
		temp3 = (TextView) findViewById(R.id.temp3);
		temp4 = (TextView) findViewById(R.id.temp4);
		weather1 = (TextView) findViewById(R.id.weather1);
		weather2 = (TextView) findViewById(R.id.weather2);
		weather3 = (TextView) findViewById(R.id.weather3);
		weather4 = (TextView) findViewById(R.id.weather4);
		wind1 = (TextView) findViewById(R.id.wind1);
		date = (TextView) findViewById(R.id.date);
		index_d = (TextView) findViewById(R.id.index_d);
		index_uv = (TextView) findViewById(R.id.index_uv);
		index_co = (TextView) findViewById(R.id.index_co);
		index_ls = (TextView) findViewById(R.id.index_ls);
		onedaytemp = (TextView) findViewById(R.id.onedaytemp);
		twodaytemp = (TextView) findViewById(R.id.twodaytemp);
		threedaytemp = (TextView) findViewById(R.id.threedaytemp);
		fourdaytemp = (TextView) findViewById(R.id.fourdaytemp);
		onedayweather = (TextView) findViewById(R.id.onedayweather);
		twodayweather = (TextView) findViewById(R.id.twodayweather);
		threedayweather = (TextView) findViewById(R.id.threedayweather);
		fourdayweather = (TextView) findViewById(R.id.fourdayweather);
		one = String.valueOf(c.get(Calendar.DAY_OF_WEEK));
		two = String.valueOf((c.get(Calendar.DAY_OF_WEEK) + 1) % 7);
		three = String.valueOf((c.get(Calendar.DAY_OF_WEEK) + 2) % 7);
		four = String.valueOf((c.get(Calendar.DAY_OF_WEEK) + 3) % 7);
		if (one.equals("0")) {
			one = "��";
		}
		if (two.equals("0")) {
			two = "��";
		}
		if (three.equals("0")) {
			three = "��";
		}
		if (four.equals("0")) {
			four = "��";
		}
		if ("1".equals(one)) {
			one = "��";
		} else if ("2".equals(one)) {
			one = "һ";
		} else if ("3".equals(one)) {
			one = "��";
		} else if ("4".equals(one)) {
			one = "��";
		} else if ("5".equals(one)) {
			one = "��";
		} else if ("6".equals(one)) {
			one = "��";
		} else if ("7".equals(one)) {
			one = "��";
		}
		if ("1".equals(two)) {
			two = "��";
		} else if ("2".equals(two)) {
			two = "һ";
		} else if ("3".equals(two)) {
			two = "��";
		} else if ("4".equals(two)) {
			two = "��";
		} else if ("5".equals(two)) {
			two = "��";
		} else if ("6".equals(two)) {
			two = "��";
		} else if ("7".equals(two)) {
			two = "��";
		}
		if ("1".equals(three)) {
			three = "��";
		} else if ("2".equals(three)) {
			three = "һ";
		} else if ("3".equals(three)) {
			three = "��";
		} else if ("4".equals(three)) {
			three = "��";
		} else if ("5".equals(three)) {
			three = "��";
		} else if ("6".equals(three)) {
			three = "��";
		} else if ("7".equals(three)) {
			three = "��";
		}
		if ("1".equals(four)) {
			four = "��";
		} else if ("2".equals(four)) {
			four = "һ";
		} else if ("3".equals(four)) {
			four = "��";
		} else if ("4".equals(four)) {
			four = "��";
		} else if ("5".equals(four)) {
			four = "��";
		} else if ("6".equals(four)) {
			four = "��";
		} else if ("7".equals(four)) {
			four = "��";
		}
		onedaytemp.setText("����" + one + "�¶ȣ�");
		twodaytemp.setText("����" + two + "�¶ȣ�");
		threedaytemp.setText("����" + three + "�¶ȣ�");
		fourdaytemp.setText("����" + four + "�¶ȣ�");
		onedayweather.setText("����" + one + "������");
		twodayweather.setText("����" + two + "������");
		threedayweather.setText("����" + three + "������");
		fourdayweather.setText("����" + four + "������");
		Thread newThread; // ����һ�����߳�
		newThread = new Thread(new Runnable() {
			@Override
			public void run() {
				new Thread(new GetWeatherInfoRunnable()).start();
			}
		});
		newThread.start(); // �����߳�
	}

	Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			String strWeather = msg.getData().getString("strWeather");
			String[] weathers = strWeather.split(",");
			for (int i = 0; i < weathers.length; i++) {
				String str = weathers[i];
				TextView tv = (TextView) findViewById(tvs[i]);
				tv.setText(str);
			}
		};
	};

	class GetWeatherInfoRunnable implements Runnable {
		@Override
		public void run() {
			try {
				// JsonReader jr=new JsonReader(new
				// InputStreamReader(is));google��˾��ר����������json�ģ�Ч�ʻ�ߡ�
				URL url = new URL(strUrl);
				InputStream is = url.openStream();

				String strWeather = parseWeather(is);// ��ȡ�����������

				Message msg = new Message();
				Bundle bundle = new Bundle();
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
		String str = WeatherUtil.convertStreamToString(is);

		try {
			JSONObject json = new JSONObject(str);
			JSONObject weatherinfo = json.getJSONObject("weatherinfo");
			String city = weatherinfo.getString("city");
			String temp1 = weatherinfo.getString("temp1");
			String temp2 = weatherinfo.getString("temp2");
			String temp3 = weatherinfo.getString("temp3");
			String temp4 = weatherinfo.getString("temp4");
			String date_y = weatherinfo.getString("date_y");
			String wind1 = weatherinfo.getString("wind1");
			String date = weatherinfo.getString("date");
			String index_d = weatherinfo.getString("index_d");
			String index_uv = weatherinfo.getString("index_uv");
			String index_co = weatherinfo.getString("index_co");
			String index_ls = weatherinfo.getString("index_ls");
			String weather1 = weatherinfo.getString("weather1");
			String weather2 = weatherinfo.getString("weather2");
			String weather3 = weatherinfo.getString("weather3");
			String weather4 = weatherinfo.getString("weather4");
			str = city + "," + date_y + "," + date + "," + temp1 + "," + wind1
					+ "," + index_d + "," + index_uv + "," + index_co + ","
					+ index_ls + "," + weather1 + "," + temp2 + "," + weather2
					+ "," + temp3 + "," + weather3 + "," + temp4 + ","
					+ weather4 + ",";
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return str;
	}
}
