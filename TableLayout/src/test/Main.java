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
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		tv=(TextView) findViewById(R.id.tv_test);
		tv.setMovementMethod(ScrollingMovementMethod.getInstance()) ;//�����Ĺ���
	}
}
