package gallery;

import com.example.gallery.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class GalleryTest extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gallerytest);
		final Integer[] image={R.drawable.aa,R.drawable.qq,R.drawable.ss,R.drawable.ww};//ͼƬ��Դ��  integer��ʵ��ѭ��
		final Gallery g1=(Gallery)findViewById(R.id.gallery01);//��ȡ����
		BaseAdapter adapter=new BaseAdapter() {   //��ʼ��������
			
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// TODO �Զ����ɵķ������
				ImageView iv=new ImageView(GalleryTest.this);   //��ȡview
				iv.setImageResource(image[position%image.length]);  //����ͼƬ��Դ
				iv.setScaleType(ImageView.ScaleType.FIT_XY);   //������䷽ʽ
				iv.setLayoutParams(new Gallery.LayoutParams(720,1280));  //����
				return iv;
			}
			
			@Override
			public long getItemId(int position) {
				// TODO �Զ����ɵķ������
				return position%image.length;//����
			}
			
			@Override
			public Object getItem(int position) {
				// TODO �Զ����ɵķ������
				return image[position%image.length];//����
			}
			
			@Override
			public int getCount() {
				// TODO �Զ����ɵķ������
				return Integer.MAX_VALUE;//����ͼƬ����
			}
		};
		g1.setSpacing(0);//����ͼƬ���
		g1.setGravity(Gravity.CENTER);//����ͼƬ��䷽ʽ
		g1.setAnimationDuration(10);//����ͼƬ�л�ʱ��;
		g1.setAdapter(adapter);  //����������
	}

}
