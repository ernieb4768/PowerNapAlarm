package com.rmh.powernap.powernapalarm;

import android.os.Bundle;
import android.preference.PreferenceFragment;





public class SettingsFragment extends PreferenceFragment {

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);

		// Load the preferences from an xml resource
		addPreferencesFromResource(R.layout.fragment_settings);

	}

}
