package com.szq;


import android.app.ListActivity;
import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ListViewLinkMan extends ListActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ListView lv=getListView();
		Cursor c = managedQuery(
				android.provider.ContactsContract.Contacts.CONTENT_URI, null,
				null, null,
				android.provider.ContactsContract.Contacts.DISPLAY_NAME);
		String[] cols = new String[] { android.provider.ContactsContract.Contacts.DISPLAY_NAME };
		int[] views = new int[] { android.R.id.text1 };
		SimpleCursorAdapter simple = new SimpleCursorAdapter(this,
				android.R.layout.simple_list_item_1, c, cols, views);
		this.setListAdapter(simple);
		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Uri selectPerson=ContentUris.withAppendedId(android.provider.ContactsContract.Contacts.CONTENT_URI, id);
				Intent intent=new Intent(Intent.ACTION_VIEW,selectPerson);
				startActivity(intent);
			}
		});
	}
}
