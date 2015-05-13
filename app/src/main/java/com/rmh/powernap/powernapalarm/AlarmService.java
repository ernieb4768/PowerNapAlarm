package com.rmh.powernap.powernapalarm;


import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

public class AlarmService extends Service {

	@Override
	public IBinder onBind(Intent intent){
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startID){
		AlarmReceiver.setAlarm(App.getContext());
		return super.onStartCommand(intent, flags, startID);
	}

}
