package com.rmh.powernap.powernapalarm;


import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.content.WakefulBroadcastReceiver;

public class AlarmReceiver extends WakefulBroadcastReceiver {

	@Override
	public void onReceive(final Context context, Intent intent){

		Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
		if(alarmUri == null){
			alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
		}
		Ringtone ringtone = RingtoneManager.getRingtone(App.getContext(), alarmUri);
		ringtone.play();

	}

}
