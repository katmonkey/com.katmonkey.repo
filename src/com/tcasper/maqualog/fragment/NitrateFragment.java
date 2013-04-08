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

public class NitrateFragment extends Fragment {
	
	public static final String ARG_SECTION_NUMBER = "section_number";

	Button nitrateSubmitButton;
	EditText nitrateEditText;
	MaquaLogOpenHelper dbHelper;
	
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
				Log.d("NitrateFragment", "Button clicked!!!");
				DateFormat sdf = SimpleDateFormat.getDateTimeInstance();
				String editTextValue = nitrateEditText.getText().toString();
				ContentValues vals = new ContentValues();
				vals.put("nitrate", editTextValue);
				vals.put("date", sdf.format(Calendar.getInstance().getTime()));
				dbHelper = MaquaLogOpenHelper.getInstance(getActivity().getApplicationContext());
				SQLiteDatabase db = dbHelper.getWritableDatabase();
				//dbHelper.close();
				db.insert("test_entries", "", vals);
			}
		});

		return nitrateView;
	}
}
