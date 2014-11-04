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
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gallerytest);
		final Integer[] image={R.drawable.aa,R.drawable.qq,R.drawable.ss,R.drawable.ww};//图片资源组  integer可实现循环
		final Gallery g1=(Gallery)findViewById(R.id.gallery01);//获取对象
		BaseAdapter adapter=new BaseAdapter() {   //初始化适配器
			
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// TODO 自动生成的方法存根
				ImageView iv=new ImageView(GalleryTest.this);   //获取view
				iv.setImageResource(image[position%image.length]);  //设置图片资源
				iv.setScaleType(ImageView.ScaleType.FIT_XY);   //设置填充方式
				iv.setLayoutParams(new Gallery.LayoutParams(720,1280));  //布局
				return iv;
			}
			
			@Override
			public long getItemId(int position) {
				// TODO 自动生成的方法存根
				return position%image.length;//修正
			}
			
			@Override
			public Object getItem(int position) {
				// TODO 自动生成的方法存根
				return image[position%image.length];//修正
			}
			
			@Override
			public int getCount() {
				// TODO 自动生成的方法存根
				return Integer.MAX_VALUE;//返回图片个数
			}
		};
		g1.setSpacing(0);//设置图片间距
		g1.setGravity(Gravity.CENTER);//设置图片填充方式
		g1.setAnimationDuration(10);//设置图片切换时间;
		g1.setAdapter(adapter);  //设置适配器
	}

}
