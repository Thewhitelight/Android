package listview;

import com.example.listview.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity01 extends Activity {
	private TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main1);
		tv = (TextView) findViewById(R.id.textView1);
		long postion = getIntent().getLongExtra("postion", 0);
		if (postion == 0) {
			tv.setText(getIntent().getStringExtra("title"));
		}
	}
}
