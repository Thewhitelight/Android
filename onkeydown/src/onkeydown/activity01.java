package onkeydown;

import com.example.onkeydown.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class activity01 extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity01);
		Button btn01=(Button)findViewById(R.id.button);
		TextView tv=(TextView)findViewById(R.id.txt);
		Intent intent=this.getIntent();
		String name=intent.getStringExtra("name");
		String key=intent.getStringExtra("key");
		tv.append("���������Ϣ���£�\n");
		tv.append("�û�����"+name+"\n");
		tv.append("���룺"+key+"\n");
		setTitle("��Ϣ");
		btn01.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
				finish();
			}
		});
	}

}
