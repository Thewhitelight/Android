package testDialog;

import com.example.testdialog.R;


//import android.R.string;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;

public class Dialog extends Activity{
	//String tag="Lifecycle";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		//requestWindowFeature(Window.FEATURE_NO_TITLE); 取消Title
		setContentView(R.layout.dialog); 
		//Log.d(tag, "In the onCreat() event");
	}
}
