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

public class NitrateFragment extends Fragment {
	
	private static final String TAG = "NitrateFragment";
	public static final String ARG_SECTION_NUMBER = "section_number";

	Button nitrateSubmitButton;
	EditText nitrateEditText;
	MaquaLogOpenHelper dbHelper;
	InputMethodManager imm = null;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if(container == null) {
			return null;
		}
		View nitrateView = inflater.inflate(R.layout.nitrate_fragment, container, false);
		nitrateSubmitButton = (Button)nitrateView.findViewById(R.id.nitrateSubmitButton);
		nitrateEditText = (EditText)nitrateView.findViewById(R.id.nitrateEditText);
		nitrateSubmitButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Log.d(TAG, "Button clicked!!!");
				DateFormat sdf = SimpleDateFormat.getDateTimeInstance();
				String nitrateVal = nitrateEditText.getText().toString();
				ContentValues vals = new ContentValues();
				vals.put("value", nitrateVal);
				vals.put("date", sdf.format(Calendar.getInstance().getTime()));
				dbHelper = MaquaLogOpenHelper.getInstance(getActivity().getApplicationContext());
				SQLiteDatabase db = dbHelper.getWritableDatabase();
				db.insert("nitrate", "", vals);
				
				nitrateEditText.setText("");
				imm = (InputMethodManager)getActivity().getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(nitrateSubmitButton.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
				db.close();
			}
		});

		return nitrateView;
	}
}
