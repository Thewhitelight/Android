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
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		setContentView(R.layout.testdialog2);
		et=(EditText)findViewById(R.id.EditText1);
		Button btn=(Button)findViewById(R.id.Button);
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
				showDialog(MYDIALOG);
				setTitle("���");
			}
		});
	}
protected Dialog onCreateDialog(int id) {    //����oncreatDialog����
	Dialog dialog=null;
	switch (id) {
	case MYDIALOG:
		Builder builder=new AlertDialog.Builder(this);
		builder.setTitle("�Ի���");
		builder.setMessage("����һ���Ի���");
		builder.setIcon(R.drawable.back);
		builder.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO �Զ����ɵķ������
				et.setText("�������ڶԻ���");
				Toast.makeText(getApplicationContext(), "������ȷ����", Toast.LENGTH_LONG).show();
			}
		});
		builder.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO �Զ����ɵķ������
				Toast.makeText(getApplicationContext(), "���˳��˶Ի���", Toast.LENGTH_LONG).show();
			}
		});
		builder.setNeutralButton("�м�", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO �Զ����ɵķ������
				Toast.makeText(getApplicationContext(), "�������м䰴ť", Toast.LENGTH_LONG ).show();
			}
		});
		dialog=builder.create();//�����Ի���
		break;

	default:
		break;
	}
	return dialog;//���ضԻ���
	
}
}
