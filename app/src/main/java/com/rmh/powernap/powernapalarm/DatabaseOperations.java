package com.rmh.powernap.powernapalarm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseOperations extends SQLiteOpenHelper {

	public static final int database_version = 1;
	public String CREATE_QUERY = "CREATE TABLE " + TableData.TableInfo.TABLE_NAME + "(" + TableData.TableInfo.HOURS + " INT," + TableData.TableInfo.MINUTES + " INT);";
	private String LOG_KEY = "Database Operation: ";

	public DatabaseOperations(Context context) {
		super(context, TableData.TableInfo.DATABASE_NAME, null, database_version);

		Log.d(LOG_KEY, "Database created");
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_QUERY);
		Log.d(LOG_KEY, "Table created");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

	public void putInformation(DatabaseOperations operations, int hour, int minute){

		SQLiteDatabase database = operations.getWritableDatabase();
		ContentValues contentValues = new ContentValues();

		contentValues.put(TableData.TableInfo.HOURS, hour);
		contentValues.put(TableData.TableInfo.MINUTES, minute);

		long k = database.insert(TableData.TableInfo.TABLE_NAME, null, contentValues);

		Log.d(LOG_KEY, "One raw inserted");
	}

	public Cursor getInformation(DatabaseOperations operations){

		SQLiteDatabase database = operations.getReadableDatabase();
		String[] columns = {TableData.TableInfo.HOURS, TableData.TableInfo.MINUTES};

		Cursor cursor = database.query(TableData.TableInfo.TABLE_NAME, columns, null, null, null, null, null);

		return cursor;

	}

}
