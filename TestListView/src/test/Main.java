package test;

import com.example.testlistview.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class Main extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		long lv_item_id=getIntent().getLongExtra("lv_item_id", -1);
		if (lv_item_id==0) {
			Toast.makeText(getApplication(),"您点击了第"+lv_item_id+"个", Toast.LENGTH_SHORT).show();
		}
		if (lv_item_id==1) {
			Toast.makeText(getApplication(),"您点击了第"+lv_item_id+"个", Toast.LENGTH_SHORT).show();
		}
	}
}
