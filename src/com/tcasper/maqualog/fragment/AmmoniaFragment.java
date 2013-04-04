package com.tcasper.maqualog.fragment;

import com.tcasper.maqualog.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class AmmoniaFragment extends Fragment {
	
	public static final String ARG_OBJECT = "object";
	public static final String ARG_SECTION_NUMBER = "section_number";
	Button ammoniaSubmitButton;
	EditText ammoniaEditText;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if(container == null) {
			return null;
		}
		View ammoniaView = inflater.inflate(R.layout.ammonia_fragment, container, false);
		ammoniaSubmitButton = (Button)ammoniaView.findViewById(R.id.ammoniaSubmitButton);
		ammoniaSubmitButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Log.d("AmmoniaFragment", "Button clicked!!!");
			}
		});
		
		ammoniaEditText = (EditText)ammoniaView.findViewById(R.id.ammoniaEditText);
		return (RelativeLayout)inflater.inflate(R.layout.ammonia_fragment, container, false);
	}
}
