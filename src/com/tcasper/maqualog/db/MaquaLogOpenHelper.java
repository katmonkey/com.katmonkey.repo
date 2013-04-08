package com.tcasper.maqualog.db;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MaquaLogOpenHelper extends SQLiteOpenHelper {
	
	private final static int DB_VERSION = 4;
	private final static String DB_NAME = "mqlog.s3db";
	private static MaquaLogOpenHelper dbHelperInstance = null;
	private Context context;

	private MaquaLogOpenHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
		Log.d("MaquaLogOpenHelper", "Entering MaquaLogOpenHelper");
		this.context = context;
	}
	
	public static MaquaLogOpenHelper getInstance(Context context) {
		if(dbHelperInstance == null) {
			dbHelperInstance = new MaquaLogOpenHelper(context.getApplicationContext());
		}
		return dbHelperInstance;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.d("MaquaLogOpenHelper", "Entering onCreate!");
		executeSQLScript(db, "mqCreateSql.sql");
		Log.d("MaquaLogOpenHelper", "Created the DB!");
	}
	
	private void executeSQLScript(SQLiteDatabase db, String dbName) {
		Log.d("MaquaLogOpenHelper", "********Entering executeSQLScript!");
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len;
		AssetManager assetManager = context.getAssets();
		InputStream inStream = null;
		try {
			inStream = assetManager.open(dbName);
			while((len = inStream.read(buffer)) != -1) {
				outStream.write(buffer, 0, len);
			}
			outStream.close();
			inStream.close();
			String[] createScript = outStream.toString().split(";");
			for(String str : createScript) {
				String statement = str.trim();
				if(statement.length() > 0) {
					db.execSQL(statement + ";");
				}
			}
		} catch(IOException ioe) {
			ioe.printStackTrace();
		} catch(SQLException se) {
			se.printStackTrace();
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	
	

}
