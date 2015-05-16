package com.rmh.powernap.powernapalarm;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
	private MaterialListView listView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		parentView = inflater.inflate(R.layout.fragment_custom_alarm, container, false);
		setUpViews();
		setUpLayout();
		return parentView;
	}

	private void setUpViews(){
		MainActivity parentActivity = (MainActivity) getActivity();
		resideMenu = parentActivity.getResideMenu();
	}

	private void setUpLayout(){

		// Initialize the list view
		listView = (MaterialListView) parentView.findViewById(R.id.custom_alarm_list);

		FloatingActionButton fab = (FloatingActionButton) parentView.findViewById(R.id.fab);
		fab.attachToRecyclerView(listView);
		fab.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				alertDialogBox();
			}
		});

	}

	private BasicButtonsCard createCards(String heading){

		BasicButtonsCard card = new BasicButtonsCard(this.getActivity());

		card.setDividerVisible(true);
		card.setTitle(heading);
		card.setLeftButtonText("Set Alarm");
		card.setRightButtonText("Cancel Alarm");
		card.setDescription("I am a card!");

		return card;

	}

	private void alertDialogBox(){

		MaterialDialog dialog =
		new MaterialDialog.Builder(this.getActivity())
				.title("New Alarm")
				.content("How long do you want to set your alarm for?")
				.inputType(InputType.TYPE_CLASS_NUMBER)
				.input("Hours", null, true, new MaterialDialog.InputCallback() {

					@Override
					public void onInput(MaterialDialog materialDialog, CharSequence charSequence) {

					}
				}).show();

	}


}
