package test;

import android.R;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;

public class ListView extends ListActivity implements OnItemClickListener {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		android.widget.ListView mListView = getListView();
		mListView
				.setAdapter(new ArrayAdapter<String>(this,
						R.layout.simple_list_item_1, new String[] { "Item0",
								"Item1", "Item2", "Item3", "Item4", "Item5",
								"Item6", "Item7", "Item8", "Item9", "Item10",
								"Item11", "Item12", "Item13" }));
		mListView.setOnItemClickListener(this);

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO 自动生成的方法存根
		Intent intent = new Intent();
		intent.setClass(this, test.Main.class);
		intent.putExtra("lv_item_id", id);
		startActivity(intent);
	}
}
