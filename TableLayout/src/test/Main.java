package test;

import com.example.tablelayout.R;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class Main extends Activity{
	private TextView tv=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		tv=(TextView) findViewById(R.id.tv_test);
		tv.setMovementMethod(ScrollingMovementMethod.getInstance()) ;//上下文滚动
	}
}
