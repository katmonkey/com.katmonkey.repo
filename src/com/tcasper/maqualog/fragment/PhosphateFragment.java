package com.tcasper.maqualog.fragment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.tcasper.maqualog.R;
import com.tcasper.maqualog.db.MaquaLogOpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class PhosphateFragment extends Fragment {

	public static final String TAG = "PhosphateFragment";

	public static final String ARG_SECTION_NUMBER = "section_number";

	Button phosphateSubmitButton;
	EditText phosphateEditText;
	MaquaLogOpenHelper dbHelper;
	InputMethodManager imm = null;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (container == null) {
			return null;
		}
		View phosphateView = inflater.inflate(R.layout.phosphate_fragment,
				container, false);
		phosphateSubmitButton = (Button) phosphateView.findViewById(R.id.phosphateSubmitButton);
		phosphateEditText = (EditText) phosphateView.findViewById(R.id.phosphateEditText);
		phosphateSubmitButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Log.d(TAG, "Button clicked!!!");
				DateFormat sdf = SimpleDateFormat.getDateTimeInstance();
				String phosphateVal = phosphateEditText.getText().toString();
				ContentValues vals = new ContentValues();
				vals.put("value", phosphateVal);
				vals.put("date", sdf.format(Calendar.getInstance().getTime()));
				dbHelper = MaquaLogOpenHelper.getInstance(getActivity().getApplicationContext());
				SQLiteDatabase db = dbHelper.getWritableDatabase();
				db.insert("phosphate", "", vals);
				
				phosphateEditText.setText("");
				imm = (InputMethodManager)getActivity().getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(phosphateSubmitButton.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
				db.close();
			}
		});
		return (RelativeLayout) phosphateView;
	}
}