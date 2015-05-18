package com.rmh.powernap.powernapalarm;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.dexafree.materialList.cards.BasicButtonsCard;
import com.dexafree.materialList.view.MaterialListView;
import com.melnykov.fab.FloatingActionButton;
import com.special.ResideMenu.ResideMenu;

public class CustomAlarmFragment extends Fragment {

	private View parentView;
	private ResideMenu resideMenu;
	private String title;
	private int hour;
	private int minute;
	private MaterialListView listView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

		parentView = inflater.inflate(R.layout.fragment_custom_alarm, container, false);
		setUpViews();

		return parentView;

	}

	@Override
	public void onSaveInstanceState(Bundle savedState){
		super.onSaveInstanceState(savedState);

	}

	@Override
	public void onViewStateRestored(Bundle savedState){
		super.onViewStateRestored(savedState);

	}

	private void setUpViews(){
		MainActivity parentActivity = (MainActivity) getActivity();
		resideMenu = parentActivity.getResideMenu();

		// Initialize the list view
		listView = (MaterialListView) parentView.findViewById(R.id.custom_alarm_list);

		FloatingActionButton fab = (FloatingActionButton) parentView.findViewById(R.id.fab);
		fab.attachToRecyclerView(listView);
		fab.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				alertDialogBoxHour();
			}
		});

	}

	private void setUpLayout(){

		BasicButtonsCard newCard = createCards(hour + " hours");

			// Add the card to the ListView so it will be displayed on the screen
			listView.add(newCard);

	}

	private BasicButtonsCard createCards(String heading){

		BasicButtonsCard card = new BasicButtonsCard(this.getActivity());

		card.setDividerVisible(true);
		card.setTitle(heading);
		card.setLeftButtonText("Set Alarm");
		card.setRightButtonText("Cancel Alarm");
		card.setDescription(hour + " hours and " + minute + " minutes.");

		return card;

	}

	private void alertDialogBoxHour(){

		new MaterialDialog.Builder(this.getActivity())
				.title(R.string.dialog_title)
				.content(R.string.dialog_content)
				.positiveText("Next")
				.negativeText(R.string.dialog_negative)
				.inputType(InputType.TYPE_CLASS_NUMBER)
				.input("Hours", null, false, new MaterialDialog.InputCallback() {

					@Override
					public void onInput(MaterialDialog materialDialog, CharSequence charSequence) {

						hour = Integer.parseInt(charSequence.toString());
						Log.d("CHAR_SEQUENCE_HOUR", charSequence.toString());

						alertDialogBoxMinute();
					}
				}).show();

	}

	private void alertDialogBoxMinute(){

		new MaterialDialog.Builder(this.getActivity())
				.title(R.string.dialog_title)
				.content(R.string.dialog_content)
				.positiveText(R.string.dialog_positive)
				.negativeText(R.string.dialog_negative)
				.inputType(InputType.TYPE_CLASS_NUMBER)
				.input("Minutes", null, false, new MaterialDialog.InputCallback() {

					@Override
					public void onInput(MaterialDialog materialDialog, CharSequence charSequence) {

						minute = Integer.parseInt(charSequence.toString());
						Log.d("CHAR_SEQUENCE_MINUTE", charSequence.toString());

						setUpLayout();
					}
				}).show();

	}

}
