package com.rmh.powernap.powernapalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.SystemClock;

/**
 * AlarmClock is a manager for creating, setting, and cancelling all alarms.
 */
public class AlarmClock {

	private PendingIntent pendingIntent;
	public AlarmManager alarmManager;

	public AlarmClock(AlarmManager alarmManager){

		this.alarmManager = alarmManager;

	}

	// Set an alarm for 1 minute from the current time
	public void setAlarm(){

		Intent intent = new Intent(App.getContext(), AlarmReceiver.class);
		pendingIntent = PendingIntent.getBroadcast(App.getContext(), 0, intent, 0);
		alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,
				SystemClock.elapsedRealtime() + 60 * 1000,
				pendingIntent);

	}

	// If the alarm is set, cancel it. This is called when the "Cancel" button on the card is clicked
	public void cancelAlarm(){

		if(alarmManager != null){
			alarmManager.cancel(pendingIntent);
		}

	}

}
