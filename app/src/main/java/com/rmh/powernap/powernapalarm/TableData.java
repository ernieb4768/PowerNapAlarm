package com.rmh.powernap.powernapalarm;


import android.provider.BaseColumns;

public class TableData {

	public TableData(){

	}

	public static abstract class TableInfo implements BaseColumns {

		public static final String HOURS = "hours";
		public static final String MINUTES = "minutes";
		public static final String DATABASE_NAME = "card_info";
		public static final String TABLE_NAME = "all_cards";

	}

}
