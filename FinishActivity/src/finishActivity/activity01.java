package finishActivity;

import com.example.finishactivity.R;

import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class activity01 extends Activity{
	private TextView tv=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity01);
		tv=(TextView) findViewById(R.id.tv);
		tv.setText(Html.fromHtml("TEL:"+"<a href=\"tel:15267698089\">15267698089</a>"));
		//tv.setText("TEl:"+"<a href=\"tel:15267698089\">15267698089</a>");
		tv.setMovementMethod(LinkMovementMethod.getInstance());
	}

}
