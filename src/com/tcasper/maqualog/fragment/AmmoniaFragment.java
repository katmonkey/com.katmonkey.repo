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
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class AmmoniaFragment extends Fragment {
	
	public static final String TAG = "AmmoniaFragment";
	public static final String ARG_OBJECT = "object";
	public static final String ARG_SECTION_NUMBER = "section_number";
	Button ammoniaSubmitButton;
	EditText ammoniaEditText;
	MaquaLogOpenHelper dbHelper;
	
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
				vals.put("ammonia", ammoniaVal);
				vals.put("date", sdf.format(Calendar.getInstance().getTime()));
				dbHelper = MaquaLogOpenHelper.getInstance(getActivity().getApplicationContext());
				SQLiteDatabase db = dbHelper.getWritableDatabase();
				db.insert("ammonia", "", vals);
			}
		});
		return (RelativeLayout)ammoniaView;
	}
}
