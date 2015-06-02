package com.rmh.powernap.powernapalarm;


import android.app.FragmentTransaction;
import android.preference.PreferenceFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.special.ResideMenu.ResideMenu;
import com.special.ResideMenu.ResideMenuItem;


public class MainActivity extends FragmentActivity implements View.OnClickListener {

	private MainActivity mContext;
	private ResideMenu resideMenu;
	private ResideMenuItem itemStandardAlarm;
	private ResideMenuItem itemCustomAlarm;
	private ResideMenuItem itemSettings;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mContext = this;

		setUpLayout();

		if(savedInstanceState == null){
			changeFragment(new StandardAlarmFragment(), null);
		}
	}

	private void setUpLayout(){

		resideMenu = new ResideMenu(this);
		resideMenu.attachToActivity(this);
		resideMenu.setBackgroundColor(getResources().getColor(R.color.gray));
		resideMenu.setScaleValue(0.6f);

		itemStandardAlarm = new ResideMenuItem(this, R.mipmap.ic_clock_face_15, "Standard Alarms");
		itemCustomAlarm = new ResideMenuItem(this, R.mipmap.ic_clock_face_45, "Custom Alarms");
		itemSettings = new ResideMenuItem(this, R.drawable.ic_settings, "Settings");

		itemStandardAlarm.setOnClickListener(this);
		itemCustomAlarm.setOnClickListener(this);
		itemSettings.setOnClickListener(this);

		resideMenu.addMenuItem(itemStandardAlarm, ResideMenu.DIRECTION_LEFT);
		resideMenu.addMenuItem(itemCustomAlarm, ResideMenu.DIRECTION_LEFT);
		resideMenu.addMenuItem(itemSettings, ResideMenu.DIRECTION_RIGHT);

	}

	@Override
	public void onClick(View view){

		if(view == itemStandardAlarm){
			changeFragment(new StandardAlarmFragment(), null);
		} else if(view == itemCustomAlarm){
			changeFragment(new CustomAlarmFragment(), null);
		} else if(view == itemSettings){
			changeFragment(null, new SettingsFragment());
		}
		resideMenu.closeMenu();
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev){
		return resideMenu.dispatchTouchEvent(ev);
	}

	private void changeFragment(Fragment targetFragment, PreferenceFragment preferenceFragment){

		if(targetFragment != null) {
			Log.d("FRAGMENT_MANAGER", "Target fragment is not null");
			resideMenu.clearIgnoredViewList();
			getSupportFragmentManager()
					.beginTransaction()
					.replace(R.id.main_fragment, targetFragment, "fragment")
					.setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
					.commit();
		} else if(preferenceFragment != null){
			Log.d("FRAGMENT_MANAGER", "Preference fragment is not null");
			resideMenu.clearIgnoredViewList();
			getFragmentManager()
					.beginTransaction()
					.replace(R.id.main_fragment, preferenceFragment, "fragment")
					.setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
					.commit();
		}

	}

	public ResideMenu getResideMenu(){
		return resideMenu;
	}
}
