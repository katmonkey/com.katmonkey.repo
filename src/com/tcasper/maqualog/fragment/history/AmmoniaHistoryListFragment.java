package com.tcasper.maqualog.fragment.history;

import com.tcasper.maqualog.R;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class AmmoniaHistoryListFragment extends ListFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View ammoniaHistoryListView = inflater.inflate(R.layout.ammonia_history_list_fragment, container, false);
		
		return super.onCreateView(inflater, container, savedInstanceState);
	}
	
	

}
