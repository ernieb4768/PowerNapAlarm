package com.rmh.powernap.powernapalarm;

import android.app.AlarmManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dexafree.materialList.cards.BasicImageButtonsCard;
import com.dexafree.materialList.cards.OnButtonPressListener;
import com.dexafree.materialList.model.Card;
import com.dexafree.materialList.view.MaterialListView;
import com.special.ResideMenu.ResideMenu;



public class StandardAlarmFragment extends Fragment {

	private View parentView;
	private ResideMenu resideMenu;
	private AlarmManager alarmManager =
			(AlarmManager)(App.getContext().getSystemService(Context.ALARM_SERVICE));
	private AlarmClock alarmClock = new AlarmClock(alarmManager);

	public StandardAlarm theQuickie = new StandardAlarm(
			App.getContext().getString(R.string.ten_minute_image_text),
			App.getContext().getString(R.string.ten_minute_title),
			App.getContext().getString(R.string.ten_minute_subtitle),
			R.mipmap.ic_clock_face_45);
	public StandardAlarm theShort = new StandardAlarm(
			App.getContext().getString(R.string.fifteen_minute_image_text),
			App.getContext().getString(R.string.fifteen_minute_title),
			App.getContext().getString(R.string.fifteen_minute_subtitle),
			R.mipmap.ic_clock_face_15);
	public StandardAlarm theOriginal = new StandardAlarm(
			App.getContext().getString(R.string.twenty_minute_image_text),
			App.getContext().getString(R.string.twenty_minute_title),
			App.getContext().getString(R.string.twenty_minute_subtitle),
			R.mipmap.ic_clock_face_45);
	public StandardAlarm theHalfHour = new StandardAlarm(
			App.getContext().getString(R.string.thirty_minute_image_text),
			App.getContext().getString(R.string.thirty_minute_title),
			App.getContext().getString(R.string.thirty_minute_subtitle),
			R.mipmap.ic_clock_face_30);
	public StandardAlarm theThreeQuarters = new StandardAlarm(
			App.getContext().getString(R.string.forty_five_minute_image_text),
			App.getContext().getString(R.string.forty_five_minute_title),
			App.getContext().getString(R.string.forty_five_minute_subtitle),
			R.mipmap.ic_clock_face_45);
	public StandardAlarm thePowerHour = new StandardAlarm(
			App.getContext().getString(R.string.sixty_minute_image_text),
			App.getContext().getString(R.string.sixty_minute_title),
			App.getContext().getString(R.string.sixty_minute_subtitle),
			R.mipmap.ic_clock_face_45);
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

		int len = standardAlarms.length;

		MaterialListView materialListView = (MaterialListView) parentView.findViewById(R.id.material_list_view);

		for(int i = 0; i < len; i++){
			materialListView.add(buildMaterialCard(i));
		}

	}

	private BasicImageButtonsCard buildMaterialCard(int i){

		BasicImageButtonsCard card = new BasicImageButtonsCard(this.getActivity());
		card.setTitle(standardAlarms[i].imageText);
		card.setDescription(standardAlarms[i].subTitle);
		card.setDrawable(standardAlarms[i].image);
		card.setLeftButtonText(R.string.card_button_set);
		card.setRightButtonText(R.string.card_button_cancel);
		card.setDividerVisible(true);

		card.setOnLeftButtonPressedListener(new OnButtonPressListener() {

			@Override
			public void onButtonPressedListener(View view, Card card) {

				alarmClock.setAlarm();

				Toast.makeText(App.getContext(), "Alarm is set", Toast.LENGTH_SHORT).show();

			}
		});

		card.setOnRightButtonPressedListener(new OnButtonPressListener() {

			@Override
			public void onButtonPressedListener(View view, Card card) {

				alarmClock.cancelAlarm();

				Toast.makeText(App.getContext(), "Alarm is cancelled", Toast.LENGTH_SHORT).show();

			}
		});

		return card;

	}

}
