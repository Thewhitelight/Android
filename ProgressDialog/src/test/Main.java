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
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		btn = (Button) findViewById(R.id.btn01);
		btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
				final ProgressDialog dialog = ProgressDialog.show(Main.this,
						"������...", "���Ե�...", true, false);
				new Thread(new Runnable() {

					@Override
					public void run() {
						// TODO �Զ����ɵķ������
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
