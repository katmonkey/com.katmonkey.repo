package com.tcasper.maqualog.fragment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.tcasper.maqualog.R;
import com.tcasper.maqualog.db.MaquaLogOpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
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
	InputMethodManager imm = null;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if(container == null) {
			return null;
		}
		
		
		View ammoniaView = inflater.inflate(R.layout.ammonia_fragment, container, false);
		ammoniaSubmitButton = (Button)ammoniaView.findViewById(R.id.ammoniaSubmitButton);
		ammoniaEditText = (EditText)ammoniaView.findViewById(R.id.ammoniaEditText);
		ammoniaSubmitButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Log.d(TAG, "Button clicked!!!");
				DateFormat sdf = SimpleDateFormat.getDateTimeInstance();
				String ammoniaVal = ammoniaEditText.getText().toString();
				ContentValues vals = new ContentValues();
				vals.put("value", ammoniaVal);
				vals.put("date", sdf.format(Calendar.getInstance().getTime()));
				dbHelper = MaquaLogOpenHelper.getInstance(getActivity().getApplicationContext());
				SQLiteDatabase db = dbHelper.getWritableDatabase();
				db.insert("ammonia", "", vals);
				
				ammoniaEditText.setText("");
				imm = (InputMethodManager)getActivity().getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(ammoniaSubmitButton.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
				db.close();
			}
		});
		return ammoniaView;
	}
	
	
	
	private void addHistoryRow(View v) {
		LayoutInflater inflater = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View ammoniaView = inflater.inflate(R.layout.ammonia_fragment, null);
		TableLayout ammoniaTableLayout = (TableLayout)ammoniaView.findViewById(R.id.ammoniaTable);
  	  	TableRow ammoniaTableRow = new TableRow(getActivity().getApplicationContext());
  	  	LayoutParams ammoniaLayoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
  	  	ammoniaTableRow.setLayoutParams(ammoniaLayoutParams);

  	  	TextView date = new TextView(getActivity().getApplicationContext());
  	  	TextView value = new TextView(getActivity().getApplicationContext());
  	  	date.setLayoutParams(ammoniaLayoutParams);
  	  	value.setLayoutParams(ammoniaLayoutParams);
  	  	
  	  	date.setBackgroundColor(Color.WHITE);
  	  	value.setBackgroundColor(Color.WHITE);
  	  	date.setText(""/* Get this value from DB */);
  	  	value.setText(""/* Get this value from DB */);

  	  	ammoniaTableRow.addView(date);
  	  	ammoniaTableRow.addView(value);

  	  	ammoniaTableLayout.addView(ammoniaTableRow, new TableLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
	}
}
