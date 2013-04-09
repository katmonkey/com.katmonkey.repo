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

public class AlkilinityFragment extends Fragment {

	public static final String TAG = "AlkilinityFragment";

	public static final String ARG_SECTION_NUMBER = "section_number";

	Button alkilinitySubmitButton;
	EditText alkilinityEditText;
	MaquaLogOpenHelper dbHelper;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (container == null) {
			return null;
		}
		View alkilinityView = inflater.inflate(R.layout.alkilinity_fragment,
				container, false);
		alkilinitySubmitButton = (Button) alkilinityView.findViewById(R.id.alkilinitySubmitButton);
		alkilinityEditText = (EditText) alkilinityView.findViewById(R.id.alkilinityEditText);
		alkilinitySubmitButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Log.d(TAG, "Button clicked!!!");
				DateFormat sdf = SimpleDateFormat.getDateTimeInstance();
				String alkilinityVal = alkilinityEditText.getText().toString();
				ContentValues vals = new ContentValues();
				vals.put("alkilinity", alkilinityVal);
				vals.put("date", sdf.format(Calendar.getInstance().getTime()));
				dbHelper = MaquaLogOpenHelper.getInstance(getActivity().getApplicationContext());
				SQLiteDatabase db = dbHelper.getWritableDatabase();
				db.insert("alkilinity", "", vals);
			}
		});
		return (RelativeLayout) alkilinityView;
	}
}
