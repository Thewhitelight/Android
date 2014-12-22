package com.szq;

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

import com.example.fragment_fragment_communication.R;

public class LeftFragment extends Fragment {
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
		View mView = inflater.inflate(R.layout.left, null);
		Button btn_left = (Button) mView.findViewById(R.id.btn_left);
		btn_left.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				RightFragment rightFragment = (RightFragment) manager
						.findFragmentByTag("right");
				String edt = ((EditText) rightFragment.getView().findViewById(
						R.id.edt_right)).getText().toString();
				Toast.makeText(getActivity(), "-RightFragment->>" + edt,
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
