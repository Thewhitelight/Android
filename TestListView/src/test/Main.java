package test;

import com.example.testlistview.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class Main extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		long lv_item_id=getIntent().getLongExtra("lv_item_id", -1);
		if (lv_item_id==0) {
			Toast.makeText(getApplication(),"������˵�"+lv_item_id+"��", Toast.LENGTH_SHORT).show();
		}
		if (lv_item_id==1) {
			Toast.makeText(getApplication(),"������˵�"+lv_item_id+"��", Toast.LENGTH_SHORT).show();
		}
	}
}
