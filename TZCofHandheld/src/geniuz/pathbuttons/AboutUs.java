package geniuz.pathbuttons;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
//test
public class AboutUs extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);

		setContentView(R.layout.aboutus);
		overridePendingTransition(android.R.anim.fade_in,
				android.R.anim.fade_out);// ���뵭��Ч��
		Window window = getWindow();
		WindowManager.LayoutParams layoutparams = window.getAttributes();
		layoutparams.width = LayoutParams.MATCH_PARENT;
		layoutparams.height = LayoutParams.MATCH_PARENT;
		layoutparams.alpha = 0.5f;
		window.setAttributes(layoutparams);
	}
}
