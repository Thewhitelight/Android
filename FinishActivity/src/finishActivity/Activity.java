package finishActivity;

import com.example.finishactivity.R;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity extends android.app.Activity {
	public static final String MY_ACTION="finishActivity.MY_ACTION";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity);
		Button btn1=(Button)findViewById(R.id.button1);
		Button btn2=(Button)findViewById(R.id.button2);
		Button btn3=(Button)findViewById(R.id.button3);
		Button btn4=(Button)findViewById(R.id.button4);
		btn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
				finish();		
			}
		});
		btn2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
				Uri uri=Uri.parse("tel:10086");
				Intent intent= new Intent(Intent.ACTION_DIAL,uri);
				startActivity(intent);
			}
		});
		btn3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
				setTitle("�������ñ���");
			}
		});
		btn4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
				ComponentName componentName=new ComponentName(finishActivity.Activity.this, "finishActivity.activity01");
				Intent intent=new Intent();
				intent.setAction(intent.ACTION_MAIN);
				intent.addCategory(Intent.CATEGORY_HOME);
				startActivity(intent);
			}
		});
	}
}
