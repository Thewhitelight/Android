package com.szq;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.activity_fragment_callbaclk.R;

public class FragmentContent extends Fragment {
	private EditText edt;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View mView = inflater.inflate(R.layout.fragment, container, false);
		edt = (EditText) mView.findViewById(R.id.editText1);
		Button btn = (Button) mView.findViewById(R.id.button1);
		final EditText edtact = (EditText) getActivity().findViewById(
				R.id.edt_act); // MainActivity中的EditText
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getActivity(),
						"-->>" + edtact.getText().toString(),
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

	/**
	 * 宿主Activity回调Fragment控件接口
	 * 
	 * @author SZQ
	 *
	 */
	public interface CallBack {
		public void getResult(String result);
	}

	public void getFragmentEditText(CallBack callback) {
		String msg = edt.getText().toString();
		callback.getResult(msg);
	}
}
