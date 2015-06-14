package com.rmh.powernap.powernapalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;

/**
 * AlarmClock is a manager for creating, setting, and cancelling all alarms.
 */
public class AlarmClock {

	private AlarmManager alarmManager;
	private int alarmLength;

	public AlarmClock(AlarmManager alarmManager, int length){

		this.alarmManager = alarmManager;
		alarmLength = length;

	}

	// Set an alarm for 1 minute from the current time
	public void setAlarm(){

		Intent intent = new Intent(App.getContext(), AlarmReceiver.class);
		PendingIntent pendingIntent = PendingIntent.getActivity(App.getContext(), 2, intent, PendingIntent.FLAG_CANCEL_CURRENT);
		if(Build.VERSION.SDK_INT >= 19){
			alarmManager.setExact(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (alarmLength * 1000), pendingIntent);
		} else {
			alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (alarmLength * 1000), pendingIntent);
		}
	}

	// If the alarm is set, cancel it. This is called when the "Cancel" button on the card is clicked
	public void cancelAlarm(){

	}

}
