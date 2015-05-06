package com.rmh.powernap.powernapalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;

import java.util.Calendar;

/**
 * AlarmClock is a manager for creating, setting, and cancelling all alarms.
 */
public class AlarmClock {

	private PendingIntent pendingIntent;
	public AlarmManager alarmManager;

	public AlarmClock(AlarmManager alarmManager){
		this.alarmManager = alarmManager;
	}

	public void setAlarm(){

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 10);

		Intent intent = new Intent(App.getContext(), AlarmReceiver.class);
		pendingIntent = PendingIntent.getBroadcast(App.getContext(), 0, intent, 0);
		alarmManager.set(AlarmManager.RTC, calendar.getTimeInMillis(), pendingIntent);

	}

	public void cancelAlarm(){

		alarmManager.cancel(pendingIntent);

	}

}
