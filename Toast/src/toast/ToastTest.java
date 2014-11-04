package toast;

import com.example.toast.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ToastTest extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		setContentView(R.layout.toast);
		Button btn01=(Button)findViewById(R.id.button1);
		Button btn02=(Button)findViewById(R.id.button2);
		Button btn03=(Button)findViewById(R.id.button3);
		Button btn04=(Button)findViewById(R.id.button4);
		Button btn05=(Button)findViewById(R.id.button5);
		btn01.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
				Toast msg;
			    msg=Toast.makeText(getApplicationContext(), "Toast��ʾ��Ϣ", Toast.LENGTH_SHORT);
				msg.setText("�Զ����ı���");//������ʾ�ı�����
			    msg.show();
			}
		});
		btn02.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
				Toast toast=new Toast(getApplicationContext());
				ImageView view= new ImageView(getApplicationContext());
				view.setImageResource(R.drawable.ic_launcher);
				toast.setView(view);
				toast.setDuration(Toast.LENGTH_LONG);//������ʾ����ʱ��
				toast.show();
			}
		});
		btn03.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
			Toast toast=Toast.makeText(getApplicationContext(), "ͼ����ʾ", Toast.LENGTH_LONG);
			LinearLayout mLayout=new LinearLayout(getApplicationContext());//����ˮƽ����
			mLayout.setOrientation(LinearLayout.HORIZONTAL);
			ImageView image=new ImageView(getApplicationContext());//������ʾͼ���imageview
			image.setImageResource(R.drawable.ic_launcher);
			View toastView=toast.getView(); //��ȡ��ʾ���ֵ�toastview
			mLayout.addView(image); //��ӵ�����
			mLayout.addView(toastView); // ��ӵ�����
			toast.setView(mLayout); //����view����
			toast.show();
			}
		});
		
		btn04.setOnClickListener(new View.OnClickListener() { //��Ҫ��toast����
			
			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
				Toast msg;
				msg=Toast.makeText(getApplicationContext(), "��ͼƬ��Toas", Toast.LENGTH_LONG);
				msg.setGravity(Gravity.CENTER,0,0);//������ʾλ��
				LinearLayout toastview=(LinearLayout)msg.getView(); //����ˮƽ����
				ImageView imageCodeProject=new ImageView(getApplicationContext());
				imageCodeProject.setImageResource(R.drawable.ic_launcher);//ͼƬ
				toastview.addView(imageCodeProject,0);//���view 1:�������� 0��ͼƬ����
				msg.show();
			}
		});
		btn05.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
				Toast toast=Toast.makeText(getApplicationContext(), "ͼ����ʾ", Toast.LENGTH_LONG);
				LinearLayout mLayout=new LinearLayout(getApplicationContext());//����ˮƽ����
				mLayout.setOrientation(LinearLayout.HORIZONTAL);
				ImageView image=new ImageView(getApplicationContext());//������ʾͼ���imageview
				image.setImageResource(R.drawable.ic_launcher);
				View toastView=toast.getView(); //��ȡ��ʾ���ֵ�toastview
				mLayout.addView(image); //��ӵ�����
				mLayout.addView(toastView); // ��ӵ�����
				toast.setView(mLayout); //����view����
				toast.setGravity(Gravity.CENTER, 0, 0);//����toast��ʾλ��
				toast.show();
			}
		});
	}

}
