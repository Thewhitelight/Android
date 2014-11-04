package test;

import com.example.test.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class Test extends Activity {
	/** Called when the activity is first created. */
	public static final String TAG = "ShowDialog";
	public static final int ID_EXIT_DIALOG = 1;
	public static final int ID_LIST_DIALOG = 2;
	public static final int ID_RADIO_DIALOG = 3;
	public static final int ID_CHECKBOX_DIALOG = 4;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		showDialog(ID_EXIT_DIALOG);
		showDialog(ID_LIST_DIALOG);
		showDialog(ID_RADIO_DIALOG);
		showDialog(ID_CHECKBOX_DIALOG);
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		// TODO Auto-generated method stub
		Dialog dialog = null;
		switch (id) {
		case ID_EXIT_DIALOG:
			dialog = createExitDialog();
			break;
		case ID_LIST_DIALOG:
			dialog = createListDialog();
			break;
		case ID_RADIO_DIALOG:
			dialog = createRadioDialog();
			break;
		case ID_CHECKBOX_DIALOG:
			dialog = createCheckboxDialog();
			break;
		default:
			break;
		}
		if (dialog != null) {
			Log.i(TAG, dialog.toString());
		} else {
			Log.i(TAG, "dialog = null");
		}
		return dialog;
	}

	@Override
	protected void onPrepareDialog(int id, Dialog dialog) {
		// TODO Auto-generated method stub
		super.onPrepareDialog(id, dialog);
	}

	// 创建简单Dialog
	public Dialog createExitDialog() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("Are you sure you want to exit?")
				.setCancelable(false)
				.setPositiveButton("Yes",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								Test.this.finish();
							}
						})
				.setNegativeButton("No", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						dialog.cancel();
					}
				});
		return builder.create();
	}

	// 创建ListDialog
	public Dialog createListDialog() {
		final CharSequence[] items = { "Red", "Green", "Blue" };

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Pick a color");
		builder.setItems(items, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int item) {
				Toast.makeText(getApplicationContext(), items[item],
						Toast.LENGTH_SHORT).show();
			}
		});
		return builder.create();
	}

	// 创建单选Dialog
	public Dialog createRadioDialog() {
		final CharSequence[] items = { "Red", "Green", "Blue" };

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Pick a color");
		builder.setSingleChoiceItems(items, -1,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int position) {
						Toast.makeText(getApplicationContext(),
								position + " -> " + items[position],
								Toast.LENGTH_SHORT).show();
						dialog.dismiss();
					}
				});
		return builder.create();
	}

	// 创建多选Dialog
	public Dialog createCheckboxDialog() {
		final CharSequence[] items = { "Red", "Green", "Blue" };
		final boolean[] checked = new boolean[] { false, false, false };

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Pick a color");
		builder.setMultiChoiceItems(items, checked,
				new DialogInterface.OnMultiChoiceClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which,
							boolean isChecked) {
						// TODO Auto-generated method stub

					}
				});

		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				Test.this.finish();
			}
		}).setNegativeButton("取消", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				dialog.cancel();
			}
		});

		return builder.create();

	}
}
