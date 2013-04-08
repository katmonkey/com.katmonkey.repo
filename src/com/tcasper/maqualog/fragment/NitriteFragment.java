package com.tcasper.maqualog.fragment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.tcasper.maqualog.R;
import com.tcasper.maqualog.db.MaquaLogOpenHelper;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class NitriteFragment extends Fragment {
	
	public static final String ARG_SECTION_NUMBER = "section_number";

	Button nitriteSubmitButton;
	EditText nitriteEditText;
	MaquaLogOpenHelper dbHelper;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if(container == null) {
			return null;
		}
		View nitriteView = inflater.inflate(R.layout.nitrite_fragment, container, false);
		nitriteSubmitButton = (Button)nitriteView.findViewById(R.id.nitriteSubmitButton);
		nitriteEditText = (EditText)nitriteView.findViewById(R.id.nitriteEditText);
		nitriteSubmitButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Log.d("NitriteFragment", "Button clicked!!!");
				DateFormat sdf = SimpleDateFormat.getDateTimeInstance();
				String editTextValue = nitriteEditText.getText().toString();
				ContentValues vals = new ContentValues();
				vals.put("nitrite", editTextValue);
				vals.put("date", sdf.format(Calendar.getInstance().getTime()));
				dbHelper = MaquaLogOpenHelper.getInstance(getActivity().getApplicationContext());
				SQLiteDatabase db = dbHelper.getWritableDatabase();
				//dbHelper.close();
				db.insert("test_entries", "", vals);
			}
		});
		
		
		return (RelativeLayout)nitriteView;
	}

}
