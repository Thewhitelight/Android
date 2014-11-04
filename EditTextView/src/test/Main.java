package test;

import android.app.Activity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.LinearLayout;

public class Main extends Activity {
	private EditText tv = null;
	private LinearLayout layout=null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		Display display=getWindowManager().getDefaultDisplay();//获取屏幕尺寸
		int W=display.getWidth();
		int H=display.getHeight();
/*		setContentView(com.example.edittextview.R.layout.main);
		tv = (TextView) findViewById(R.id.tv);*/
		
		layout=new LinearLayout(this);
		tv=new EditText(this);
		tv.setLayoutParams(new LayoutParams(W/6,160));//wrap_content
		tv.setText("nihaoffgsdfgsdfsgsdfgsdgsdgsds");
		//et = (EditText) findViewById(R.id.et);
		layout.addView(tv);
		setContentView(layout);
		tv.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
			}
		});

		/*Window window=getWindow();
		WindowManager.LayoutParams layoutparams=window.getAttributes();
		layoutparams.width=W/6;
		layoutparams.height=H/6;
		layoutparams.alpha=0.5f;
		window.setAttributes(layoutparams);*/
	}
}
