package com.rmh.powernap.powernapalarm;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dexafree.materialList.cards.BasicImageButtonsCard;
import com.dexafree.materialList.view.MaterialListView;
import com.special.ResideMenu.ResideMenu;

import java.util.ArrayList;

public class StandardAlarmFragment extends Fragment {

	private View parentView;
	private ResideMenu resideMenu;

	public StandardAlarm theQuickie = new StandardAlarm(
			App.getContext().getString(R.string.ten_minute_image_text),
			App.getContext().getString(R.string.ten_minute_title),
			App.getContext().getString(R.string.ten_minute_subtitle),
			R.drawable.ic_clock_face_45);
	public StandardAlarm theShort = new StandardAlarm(
			App.getContext().getString(R.string.fifteen_minute_image_text),
			App.getContext().getString(R.string.fifteen_minute_title),
			App.getContext().getString(R.string.fifteen_minute_subtitle),
			R.drawable.ic_clock_face_45);
	public StandardAlarm theOriginal = new StandardAlarm(
			App.getContext().getString(R.string.twenty_minute_image_text),
			App.getContext().getString(R.string.twenty_minute_title),
			App.getContext().getString(R.string.twenty_minute_subtitle),
			R.drawable.ic_clock_face_45);
	public StandardAlarm theHalfHour = new StandardAlarm(
			App.getContext().getString(R.string.thirty_minute_image_text),
			App.getContext().getString(R.string.thirty_minute_title),
			App.getContext().getString(R.string.thirty_minute_subtitle),
			R.drawable.ic_clock_face_45);
	public StandardAlarm theThreeQuarters = new StandardAlarm(
			App.getContext().getString(R.string.forty_five_minute_image_text),
			App.getContext().getString(R.string.forty_five_minute_title),
			App.getContext().getString(R.string.forty_five_minute_subtitle),
			R.drawable.ic_clock_face_45);
	public StandardAlarm thePowerHour = new StandardAlarm(
			App.getContext().getString(R.string.sixty_minute_image_text),
			App.getContext().getString(R.string.sixty_minute_title),
			App.getContext().getString(R.string.sixty_minute_subtitle),
			R.drawable.ic_clock_face_45);
	public StandardAlarm[] standardAlarms = {theQuickie, theShort, theOriginal, theHalfHour,
											theThreeQuarters, thePowerHour};


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		parentView = inflater.inflate(R.layout.fragment_standard_alarm, container, false);
		setUpViews();
		buildMaterialCards();
		return parentView;
	}

	private void setUpViews() {
		MainActivity parentActivity = (MainActivity) getActivity();
		resideMenu = parentActivity.getResideMenu();
	}

	private void buildMaterialCards(){

		MaterialListView materialListView = (MaterialListView) parentView.findViewById(R.id.material_list_view);


		for(int i = 0; i < standardAlarms.length; i++){
			materialListView.add(buildMaterialCard(i));
		}

	}

	private BasicImageButtonsCard buildMaterialCard(int i){

		BasicImageButtonsCard card = new BasicImageButtonsCard(this.getActivity());
		card.setTitle(standardAlarms[i].imageText);
		card.setDescription(standardAlarms[i].subTitle);
		card.setDrawable(standardAlarms[i].image);

		return card;

	}

}
