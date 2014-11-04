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
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity01);
		Button btn01=(Button)findViewById(R.id.button);
		TextView tv=(TextView)findViewById(R.id.txt);
		Intent intent=this.getIntent();
		String name=intent.getStringExtra("name");
		String key=intent.getStringExtra("key");
		tv.append("您输入的信息如下：\n");
		tv.append("用户名："+name+"\n");
		tv.append("密码："+key+"\n");
		setTitle("信息");
		btn01.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				finish();
			}
		});
	}

}
