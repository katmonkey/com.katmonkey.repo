package com.tcasper.maqualog.fragment.history;

import com.tcasper.maqualog.R;
import com.tcasper.maqualog.db.MaquaLogOpenHelper;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class AmmoniaHistoryListFragment extends ListFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		//View ammoniaHistoryListView = inflater.inflate(R.layout.ammonia_history_list_fragment, container, false);
		SQLiteDatabase db = MaquaLogOpenHelper.getInstance(getActivity().getApplicationContext());
		String[] columns = {"date", "value"};
		int[] toColumns = {R.id.ammoniaHistoryDate, R.id.ammoniaHistoryValue};
		Cursor cursor = db.query("ammonia", columns, "", null, "", "", "date asc", "");
		getActivity().startManagingCursor(cursor);
		SimpleCursorAdapter adapter = new SimpleCursorAdapter(getActivity(), R.layout.ammonia_history_list_item, cursor, columns, toColumns);
		setListAdapter(adapter);
		return super.onCreateView(inflater, container, savedInstanceState);
	}
	
	
	
	

}
