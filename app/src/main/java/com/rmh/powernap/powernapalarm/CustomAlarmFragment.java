package com.rmh.powernap.powernapalarm;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.dexafree.materialList.cards.OnButtonPressListener;
import com.dexafree.materialList.controller.OnDismissCallback;
import com.dexafree.materialList.model.Card;
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
	private View cardView;

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

		parentView = inflater.inflate(R.layout.fragment_custom_alarm, container, false);
		cardView = inflater.inflate(R.layout.custom_card_layout, container, false);
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

		DatabaseOperations databaseOperations = new DatabaseOperations(App.getContext());
		Cursor cursor = databaseOperations.getInformation(databaseOperations);
		cursor.moveToFirst();
		int size = cursor.getCount();
		int HOUR;
		int MINUTE;
		if(size >= 1) {
			do {
				HOUR = cursor.getInt(0);
				MINUTE = cursor.getInt(1);
				addCardsFromDatabase(HOUR, MINUTE);
			} while(cursor.moveToNext());
		}

	}

	private void setUpLayout(int h, int m){

		CustomCard newCard = createCards(h, m);

			// Add the card to the ListView so it will be displayed on the screen
			listView.add(newCard);

	}

	private CustomCard createCards(int h, int m){

		final int hrs = h;
		final int mts = m;

		// Create the card and add the content
		CustomCard card = new CustomCard(this.getActivity());
		card.setDividerVisible(true);
		card.setTitle(h + " hours");
		card.setLeftButtonText("Set Alarm");
		card.setRightButtonText("Cancel Alarm");
		card.setDescription(h + " hours and " + m + " minutes.");
		card.setDismissible(true);

		card.setOnRightButtonPressedListener(new OnButtonPressListener() {

			@Override
			public void onButtonPressedListener(View view, Card card) {

				// Delete the card from the SQLite Database
				DatabaseOperations dop = new DatabaseOperations(App.getContext());
				dop.deleteCard(dop, hrs, mts);

				// Dismiss the card from the view
				listView.remove(card);

				Toast.makeText(App.getContext(), "Alarm is cancelled", Toast.LENGTH_SHORT).show();
			}
		});

		// Add the card info to the database
		DatabaseOperations databaseOperations = new DatabaseOperations(App.getContext());
		databaseOperations.putInformation(databaseOperations, h, m);

		return card;

	}

	private void addCardsFromDatabase(int h, int m){

		CustomCard newCard = makeCardsFromDatabase(h, m);

		listView.add(newCard);

	}

	private CustomCard makeCardsFromDatabase(int h, int m){

		final int hrs = h;
		final int mts = m;

		// Create the card and add the content
		CustomCard card = new CustomCard(this.getActivity());
		card.setDividerVisible(true);
		card.setTitle(h + " hours");
		card.setLeftButtonText("Set Alarm");
		card.setRightButtonText("Cancel Alarm");
		card.setDescription(h + " hours and " + m + " minutes.");

		card.setOnRightButtonPressedListener(new OnButtonPressListener() {

			@Override
			public void onButtonPressedListener(View view, Card card) {
				DatabaseOperations dop = new DatabaseOperations(App.getContext());
				dop.deleteCard(dop, hrs, mts);

				// Dismiss the card from the view
				listView.remove(card);

				Toast.makeText(App.getContext(), "Alarm is cancelled", Toast.LENGTH_SHORT).show();
			}
		});

		card.setDismissible(true);

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

						setUpLayout(hour, minute);
					}
				}).show();

	}

}
