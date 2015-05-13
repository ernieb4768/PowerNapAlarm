package com.rmh.powernap.powernapalarm;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AlarmReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent){

		setAlarm(context);

	}

	public static void setAlarm(Context context){

	}

	public static void cancelAlarm(Context context){

	}

	private static PendingIntent createPendingIntent(Context context, AlarmClock clock){
		return null;
	}

}
