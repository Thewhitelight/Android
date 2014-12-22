package com.szq;

import com.example.fragment_fragment_communication.R;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RightFragment extends Fragment {
	private FragmentManager manager;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		manager = getFragmentManager();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View mView = inflater.inflate(R.layout.right, null);
		Button btn_right = (Button) mView.findViewById(R.id.btn_right);
		btn_right.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				LeftFragment leftFragment = (LeftFragment) manager
						.findFragmentByTag("left");
				String edt = ((EditText) leftFragment.getView().findViewById(
						R.id.edt_left)).getText().toString();
				Toast.makeText(getActivity(), "-LeftFragment->>" + edt,
						Toast.LENGTH_SHORT).show();
			}
		});
		return mView;
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}
}
