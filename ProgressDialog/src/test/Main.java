package test;

import com.example.progressdialog.R;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main extends Activity {
	Button btn = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		btn = (Button) findViewById(R.id.btn01);
		btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				final ProgressDialog dialog = ProgressDialog.show(Main.this,
						"载入中...", "请稍等...", true, false);
				new Thread(new Runnable() {

					@Override
					public void run() {
						// TODO 自动生成的方法存根
						try {
							Thread.sleep(3000);
							dialog.dismiss();
						} catch (InterruptedException e) {
							// TODO: handle exception
							e.printStackTrace();
						}
					}
				}).start();
			}
		});
	}
}
