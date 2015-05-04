package com.rmh.powernap.powernapalarm;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.special.ResideMenu.ResideMenu;

public class CustomAlarmFragment extends Fragment {

	private View parentView;
	private ResideMenu resideMenu;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		parentView = inflater.inflate(R.layout.fragment_custom_alarm, container, false);
		setUpViews();
		return parentView;
	}

	private void setUpViews(){
		MainActivity parentActivity = (MainActivity) getActivity();
		resideMenu = parentActivity.getResideMenu();
	}
}
