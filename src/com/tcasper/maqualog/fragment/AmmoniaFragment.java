package com.tcasper.maqualog.fragment;

import com.tcasper.maqualog.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class AmmoniaFragment extends Fragment {
	
	public static final String ARG_OBJECT = "object";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if(container == null) {
			return null;
		}
		return (RelativeLayout)inflater.inflate(R.layout.ammonia_fragment, container, false);
	}
}
