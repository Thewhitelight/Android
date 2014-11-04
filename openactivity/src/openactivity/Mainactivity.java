package openactivity;

import com.example.openactivity.R;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Mainactivity extends Activity implements OnClickListener {
	private Button btn_one;
	private Button btn_two;
	private Button btn_three;
	private Button btn_four;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn_one=(Button)findViewById(R.id.btn_one);
		btn_two=(Button)findViewById(R.id.btn_two);
		btn_three=(Button)findViewById(R.id.btn_three);
		btn_four=(Button)findViewById(R.id.btn_four);
		btn_one.setOnClickListener(this);
		btn_two.setOnClickListener(this);
		btn_three.setOnClickListener(this);
		btn_four.setOnClickListener(this);
		
	}
	@Override
	public void onClick(View v) {
		// TODO 自动生成的方法存根
		switch (v.getId()) {
		case R.id.btn_one:
			Intent intent1=new Intent();
			intent1.setClass(this, Activity01.class);
			startActivity(intent1);
			break;
		case R.id.btn_two:
			Intent intent2=new Intent();
			intent2.setClassName(this, "openactivity.Activity01");
			startActivity(intent2);
			break;
		case R.id.btn_three:
			Intent intent3=new Intent();
			intent3.setClassName("com.example.openactivity", "openactivity.Activity01");//openactivity.Activity01
			startActivity(intent3);
			break;
		case R.id.btn_four:
			Intent intent4=new Intent();
			intent4.setClassName("com.example.color", "com.amaker.color.TestColor");//打开其他应用的界面
			startActivity(intent4);
			break;

		default:
			break;
		}
	}

}
