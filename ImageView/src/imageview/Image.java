package imageview;

import com.example.imageview.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class Image extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		//requestWindowFeature(Window.FEATURE_NO_TITLE);//ȡ��Title
		setContentView(R.layout.image);
/*		ImageView image1=(ImageView)findViewById(R.id.ige1);
		ImageView image2=(ImageView)findViewById(R.id.ige2);
		ImageView image3=(ImageView)findViewById(R.id.ige3);
		image1.setImageDrawable(getResources().getDrawable(R.drawable.ww));*/
/*		image2.setImageDrawable(getResources().getDrawable(R.drawable.aa));
		image3.setImageDrawable(getResources().getDrawable(R.drawable.qq));
		image.setScaleType(ScaleType.FIT_XY);
		image2.setAlpha(100); //����ͼƬ��͸���ȣ��뱳����ɫ��� 0~255͸����ֵ
*/	}

}
