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

public class IodineFragment extends Fragment {

	public static final String TAG = "IodineFragment";

	public static final String ARG_SECTION_NUMBER = "section_number";

	Button iodineSubmitButton;
	EditText iodineEditText;
	MaquaLogOpenHelper dbHelper;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (container == null) {
			return null;
		}
		View iodineView = inflater.inflate(R.layout.iodine_fragment,
				container, false);
		iodineSubmitButton = (Button) iodineView.findViewById(R.id.iodineSubmitButton);
		iodineEditText = (EditText) iodineView.findViewById(R.id.iodineEditText);
		iodineSubmitButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Log.d(TAG, "Button clicked!!!");
				DateFormat sdf = SimpleDateFormat.getDateTimeInstance();
				String iodineVal = iodineEditText.getText().toString();
				ContentValues vals = new ContentValues();
				vals.put("iodine", iodineVal);
				vals.put("date", sdf.format(Calendar.getInstance().getTime()));
				dbHelper = MaquaLogOpenHelper.getInstance(getActivity().getApplicationContext());
				SQLiteDatabase db = dbHelper.getWritableDatabase();
				db.insert("iodine", "", vals);
			}
		});
		return (RelativeLayout) iodineView;
	}
}
