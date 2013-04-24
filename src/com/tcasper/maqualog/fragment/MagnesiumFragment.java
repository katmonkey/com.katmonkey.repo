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

public class MagnesiumFragment extends Fragment {

	public static final String TAG = "MagnesiumFragment";

	public static final String ARG_SECTION_NUMBER = "section_number";

	Button magnesiumSubmitButton;
	EditText magnesiumEditText;
	MaquaLogOpenHelper dbHelper;
	InputMethodManager imm = null;
	
	public static MagnesiumFragment newInstance(int index) {
		MagnesiumFragment af = new MagnesiumFragment();
		Bundle args = new Bundle();
		args.putInt(ARG_SECTION_NUMBER, index);
		af.setArguments(args);
		return af;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (container == null) {
			return null;
		}
		View magnesiumView = inflater.inflate(R.layout.magnesium_fragment,
				container, false);
		magnesiumSubmitButton = (Button) magnesiumView.findViewById(R.id.magnesiumSubmitButton);
		magnesiumEditText = (EditText) magnesiumView.findViewById(R.id.magnesiumEditText);
		magnesiumSubmitButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Log.d(TAG, "Button clicked!!!");
				DateFormat sdf = SimpleDateFormat.getDateTimeInstance();
				String magnesiumVal = magnesiumEditText.getText().toString();
				ContentValues vals = new ContentValues();
				vals.put("value", magnesiumVal);
				vals.put("date", sdf.format(Calendar.getInstance().getTime()));
				SQLiteDatabase db = MaquaLogOpenHelper.getInstance(getActivity().getApplicationContext());
				db.insert("magnesium", "", vals);
				
				magnesiumEditText.setText("");
				imm = (InputMethodManager)getActivity().getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(magnesiumSubmitButton.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
				db.close();
			}
		});
		return magnesiumView;
	}
}