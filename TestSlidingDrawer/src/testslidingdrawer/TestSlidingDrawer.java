package testslidingdrawer;

import com.example.testslidingdrawer.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SlidingDrawer;

public class TestSlidingDrawer extends Activity {
	private GridView gv;
	@SuppressWarnings("deprecation")
	private SlidingDrawer sd;
	private ImageView im;
	private int[] icons={R.drawable.a,R.drawable.b,
			   			 R.drawable.c,R.drawable.d,
			   			 R.drawable.e,R.drawable.g};
	private String[] items={"a","b","c","d","e","f"};
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		gv=(GridView)findViewById(R.id.myContent01);
		im=(ImageView)findViewById(R.id.tv01);
		sd=(SlidingDrawer)findViewById(R.id.drawer01);
		MyGridViewAdapter adapter=new MyGridViewAdapter(this,items,icons);
		gv.setAdapter(adapter);
		sd.setOnDrawerOpenListener(new SlidingDrawer.OnDrawerOpenListener() {
			
			@Override
			public void onDrawerOpened() {
				// TODO 自动生成的方法存根
				im.setImageResource(R.drawable.cc);
				
			}
		});
		sd.setOnDrawerCloseListener(new SlidingDrawer.OnDrawerCloseListener() {
			
			@Override
			public void onDrawerClosed() {
				// TODO 自动生成的方法存根
				im.setImageResource(R.drawable.cc);
			}
		});
	}
}
