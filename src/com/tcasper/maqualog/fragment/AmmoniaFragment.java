package com.tcasper.maqualog.fragment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.tcasper.maqualog.R;
import com.tcasper.maqualog.db.MaquaLogOpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class AmmoniaFragment extends Fragment {
	
	public static final String TAG = "AmmoniaFragment";
	public static final String ARG_OBJECT = "object";
	public static final String ARG_SECTION_NUMBER = "section_number";
	Button ammoniaSubmitButton;
	EditText ammoniaEditText;
	MaquaLogOpenHelper dbHelper;
	SQLiteDatabase db;
	InputMethodManager imm = null;
	ListView ammoniaHistoryList;
	
	public static AmmoniaFragment newInstance(int index) {
		AmmoniaFragment af = new AmmoniaFragment();
		Bundle args = new Bundle();
		args.putInt(ARG_SECTION_NUMBER, index);
		af.setArguments(args);
		return af;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if(container == null) {
			return null;
		}
		
		db = MaquaLogOpenHelper.getInstance(getActivity().getApplicationContext());
		View ammoniaView = inflater.inflate(R.layout.ammonia_fragment, container, false);
		ammoniaSubmitButton = (Button)ammoniaView.findViewById(R.id.ammoniaSubmitButton);
		ammoniaEditText = (EditText)ammoniaView.findViewById(R.id.ammoniaEditText);
		
		//Grab the past values from the DB
		Cursor cursor = db.query("ammonia", null, null, null, null, null, "date asc", null);
		Log.d(TAG, "Queried the DB, Cursor size is " + cursor.getCount());
		
		/*
		FragmentManager fm = getActivity().getSupportFragmentManager();
		if (fm.findFragmentById(R.id.ammoniaHistoryListView) == null) {
			ListFragment list = new ListFragment();
			FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.ammoniaHistoryListView, list);
            ft.commit();
        }*/
		
		ammoniaSubmitButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				DateFormat sdf = SimpleDateFormat.getDateTimeInstance();
				String ammoniaVal = ammoniaEditText.getText().toString();
				ContentValues vals = new ContentValues();
				vals.put("value", ammoniaVal);
				vals.put("date", sdf.format(Calendar.getInstance().getTime()));
				
				
				db.insert("ammonia", "", vals);
				
				ammoniaEditText.setText("");
				imm = (InputMethodManager)getActivity().getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(ammoniaSubmitButton.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
				//db.close();
			}
		});
		if(cursor != null) {
			cursor.close();
		}
		return ammoniaView;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.d(TAG, "Entering onDestroy()");
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		Log.d(TAG, "Entering onDestroyView()");
	}

	@Override
	public void onStop() {
		super.onStop();
		Log.d(TAG, "Entering onStop()");
	}
}
