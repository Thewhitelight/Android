package welcome;

import com.example.welcome.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.widget.ImageView;

public class WelcomeActivity extends Activity{
	private final int SPLASH_DISPLAY_LENGHT=2000;//˯��2����
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);//��������û����
		setContentView(R.layout.welcome);
		ImageView image=(ImageView)findViewById(R.id.imageview01);
		image.setImageDrawable(getResources().getDrawable(R.drawable.qq));
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
				// TODO �Զ����ɵķ������
				Intent mainintent=new Intent(WelcomeActivity.this,Mainactivity.class);
				WelcomeActivity.this.startActivity(mainintent);
				WelcomeActivity.this.finish();
			}
		}, SPLASH_DISPLAY_LENGHT);
	}
}
