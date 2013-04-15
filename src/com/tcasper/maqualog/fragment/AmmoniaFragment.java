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
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SimpleCursorAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;

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
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if(container == null) {
			return null;
		}
		
		dbHelper = MaquaLogOpenHelper.getInstance(getActivity().getApplicationContext());
		db = dbHelper.getWritableDatabase();
		View ammoniaView = inflater.inflate(R.layout.ammonia_fragment, container, false);
		ammoniaSubmitButton = (Button)ammoniaView.findViewById(R.id.ammoniaSubmitButton);
		ammoniaEditText = (EditText)ammoniaView.findViewById(R.id.ammoniaEditText);
		ammoniaHistoryList = (ListView)ammoniaView.findViewById(R.id.ammoniaList);
		String[] fromColumns = {"date", "value"};
		int[] toViews = {R.id.dateView, R.id.valueView};
		
		//Grab the past values from the DB
		Cursor cursor = db.query("ammonia", null, null, null, null, null, "date asc", null);
		SimpleCursorAdapter cAdapter = new SimpleCursorAdapter(getActivity().getApplicationContext(), 
				R.layout.ammonia_fragment, cursor, fromColumns, toViews);
		Log.d(TAG, "Queried the DB, Cursor size is " + cursor.getCount());
		while(cursor.moveToNext()) {
			//addHistoryRow(cursor.getString(cursor.getColumnIndex("date")), cursor.getString(cursor.getColumnIndex("value")));
		}
		
		
		ammoniaSubmitButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Log.d(TAG, "Button clicked!!!");
				DateFormat sdf = SimpleDateFormat.getDateTimeInstance();
				String ammoniaVal = ammoniaEditText.getText().toString();
				ContentValues vals = new ContentValues();
				vals.put("value", ammoniaVal);
				vals.put("date", sdf.format(Calendar.getInstance().getTime()));
				
				
				db.insert("ammonia", "", vals);
				
				ammoniaEditText.setText("");
				imm = (InputMethodManager)getActivity().getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(ammoniaSubmitButton.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
				db.close();
			}
		});
		return ammoniaView;
	}
	
	
	/*
	private void addHistoryRow(String dateStr, String valueStr) {
		LayoutInflater inflater = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View ammoniaView = inflater.inflate(R.layout.ammonia_fragment, null);
		TableLayout ammoniaTableLayout = (TableLayout)ammoniaView.findViewById(R.id.ammoniaTable);
  	  	TableRow ammoniaTableRow = new TableRow(getActivity().getApplicationContext());
  	  	TableLayout.LayoutParams ammoniaLayoutParams = new TableLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
  	  	ammoniaTableRow.setLayoutParams(ammoniaLayoutParams);

  	  	TextView date = new TextView(getActivity().getApplicationContext());
  	  	TextView value = new TextView(getActivity().getApplicationContext());
  	  	date.setLayoutParams(ammoniaLayoutParams);
  	  	value.setLayoutParams(ammoniaLayoutParams);
  	  	
  	  	date.setBackgroundColor(Color.BLUE);
  	  	value.setBackgroundColor(Color.BLUE);
  	  	date.setText(dateStr);
  	  	value.setText(valueStr);

  	  	ammoniaTableRow.addView(date);
  	  	ammoniaTableRow.addView(value);

  	  	ammoniaTableLayout.addView(ammoniaTableRow, ammoniaLayoutParams);
	}*/
}
