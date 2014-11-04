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
		// TODO 自动生成的方法存根
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
				// TODO 自动生成的方法存根
				Toast msg;
			    msg=Toast.makeText(getApplicationContext(), "Toast提示信息", Toast.LENGTH_SHORT);
				msg.setText("自定义文本！");//设置显示文本内容
			    msg.show();
			}
		});
		btn02.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				Toast toast=new Toast(getApplicationContext());
				ImageView view= new ImageView(getApplicationContext());
				view.setImageResource(R.drawable.ic_launcher);
				toast.setView(view);
				toast.setDuration(Toast.LENGTH_LONG);//设置显示持续时间
				toast.show();
			}
		});
		btn03.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
			Toast toast=Toast.makeText(getApplicationContext(), "图文显示", Toast.LENGTH_LONG);
			LinearLayout mLayout=new LinearLayout(getApplicationContext());//创建水平布局
			mLayout.setOrientation(LinearLayout.HORIZONTAL);
			ImageView image=new ImageView(getApplicationContext());//用于显示图像的imageview
			image.setImageResource(R.drawable.ic_launcher);
			View toastView=toast.getView(); //获取显示文字的toastview
			mLayout.addView(image); //添加到布局
			mLayout.addView(toastView); // 添加到布局
			toast.setView(mLayout); //设置view对象
			toast.show();
			}
		});
		
		btn04.setOnClickListener(new View.OnClickListener() { //重要的toast方法
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				Toast msg;
				msg=Toast.makeText(getApplicationContext(), "带图片的Toas", Toast.LENGTH_LONG);
				msg.setGravity(Gravity.CENTER,0,0);//设置显示位置
				LinearLayout toastview=(LinearLayout)msg.getView(); //创建水平布局
				ImageView imageCodeProject=new ImageView(getApplicationContext());
				imageCodeProject.setImageResource(R.drawable.ic_launcher);//图片
				toastview.addView(imageCodeProject,0);//添加view 1:文字在上 0：图片在上
				msg.show();
			}
		});
		btn05.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				Toast toast=Toast.makeText(getApplicationContext(), "图文显示", Toast.LENGTH_LONG);
				LinearLayout mLayout=new LinearLayout(getApplicationContext());//创建水平布局
				mLayout.setOrientation(LinearLayout.HORIZONTAL);
				ImageView image=new ImageView(getApplicationContext());//用于显示图像的imageview
				image.setImageResource(R.drawable.ic_launcher);
				View toastView=toast.getView(); //获取显示文字的toastview
				mLayout.addView(image); //添加到布局
				mLayout.addView(toastView); // 添加到布局
				toast.setView(mLayout); //设置view对象
				toast.setGravity(Gravity.CENTER, 0, 0);//设置toast显示位置
				toast.show();
			}
		});
	}

}
