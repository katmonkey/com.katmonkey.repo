package com.tcasper.maqualog.fragment;

import com.tcasper.maqualog.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class NitriteFragment extends Fragment {
	
	public static final String ARG_SECTION_NUMBER = "section_number";

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if(container == null) {
			return null;
		}
		return (RelativeLayout)inflater.inflate(R.layout.nitrite_fragment, container, false);
	}

}
