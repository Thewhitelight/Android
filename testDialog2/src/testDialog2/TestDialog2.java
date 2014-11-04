package testDialog2;

import com.example.testdialog2.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TestDialog2 extends Activity {
	final int MYDIALOG=1;
	EditText et=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.testdialog2);
		et=(EditText)findViewById(R.id.EditText1);
		Button btn=(Button)findViewById(R.id.Button);
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				showDialog(MYDIALOG);
				setTitle("你好");
			}
		});
	}
protected Dialog onCreateDialog(int id) {    //重载oncreatDialog方法
	Dialog dialog=null;
	switch (id) {
	case MYDIALOG:
		Builder builder=new AlertDialog.Builder(this);
		builder.setTitle("对话框");
		builder.setMessage("我是一个对话框！");
		builder.setIcon(R.drawable.back);
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO 自动生成的方法存根
				et.setText("我来自于对话框！");
				Toast.makeText(getApplicationContext(), "你点击了确定！", Toast.LENGTH_LONG).show();
			}
		});
		builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO 自动生成的方法存根
				Toast.makeText(getApplicationContext(), "你退出了对话框！", Toast.LENGTH_LONG).show();
			}
		});
		builder.setNeutralButton("中间", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO 自动生成的方法存根
				Toast.makeText(getApplicationContext(), "你点击了中间按钮", Toast.LENGTH_LONG ).show();
			}
		});
		dialog=builder.create();//创建对话框
		break;

	default:
		break;
	}
	return dialog;//返回对话框
	
}
}
