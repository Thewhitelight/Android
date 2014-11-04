package testslidingdrawer;

import com.example.testslidingdrawer.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyGridViewAdapter extends BaseAdapter{
	private Context _con;
	private String[] _items;
	private int[] _icons;
	public MyGridViewAdapter(Context con, String[] items, int[] icons ) {
		// TODO �Զ����ɵĹ��캯�����
		_con=con;
		_items=items;
		_icons=icons;
		
	}
	@Override
	public int getCount() {
		// TODO �Զ����ɵķ������
		return _items.length;
	}
	@Override
	public Object getItem(int arg0) {
		// TODO �Զ����ɵķ������
		return _items[arg0];
	}
	@Override
	public long getItemId(int position) {
		// TODO �Զ����ɵķ������
		return position;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO �Զ����ɵķ������
		LayoutInflater factory=LayoutInflater.from(_con);
		View v=factory.inflate(R.layout.grid, null);
		ImageView iv=(ImageView) v.findViewById(R.id.icon);
		TextView tv=(TextView) v.findViewById(R.id.text);
		iv.setImageResource(_icons[position]);
		tv.setText(_items[position]);
		return v;
	}
}
