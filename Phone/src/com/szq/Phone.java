/***
 * 获取联系人姓名
 */
package com.szq;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.PhoneLookup;
import android.widget.TextView;

public class Phone extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		TextView tv = new TextView(this);
		String string = "";
		super.onCreate(savedInstanceState);
		ContentResolver cr = getContentResolver();
		Cursor cursor = cr.query(Contacts.CONTENT_URI, null,
				null, null, null);
		while (cursor.moveToNext()) {
			int namefie = cursor.getColumnIndex(PhoneLookup.DISPLAY_NAME);
			String contact = cursor.getString(namefie);
			//int numberfie = cursor.getColumnIndex(PhoneLookup.NUMBER);
			//String number = cursor.getString(numberfie);
			string += (contact + ":" + "\n");
		}
		cursor.close();
		tv.setText(string);
		setContentView(tv);
	}
}
