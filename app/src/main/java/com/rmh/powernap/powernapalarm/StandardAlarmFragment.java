package com.rmh.powernap.powernapalarm;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.special.ResideMenu.ResideMenu;

import java.util.ArrayList;

import it.gmariotti.cardslib.library.cards.actions.BaseSupplementalAction;
import it.gmariotti.cardslib.library.cards.actions.TextSupplementalAction;
import it.gmariotti.cardslib.library.cards.material.MaterialLargeImageCard;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.view.CardViewNative;



/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link StandardAlarmFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link StandardAlarmFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StandardAlarmFragment extends Fragment {

	private View parentView;
	private ResideMenu resideMenu;
	private CardViewNative cardViewNative;


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

	private MaterialLargeImageCard buildMaterialCards(){

		ArrayList<BaseSupplementalAction> actions = new ArrayList<>();
		TextSupplementalAction t1 = new TextSupplementalAction(getActivity(), R.id.text1);
		t1.setOnActionClickListener(new BaseSupplementalAction.OnActionClickListener() {

			@Override
			public void onClick(Card card, View view) {

				Toast.makeText(getActivity(), "Alarm is set", Toast.LENGTH_SHORT).show();
			}
		});
		actions.add(t1);
		TextSupplementalAction t2 = new TextSupplementalAction(getActivity(), R.id.text2);
		t2.setOnActionClickListener(new BaseSupplementalAction.OnActionClickListener() {

			@Override
			public void onClick(Card card, View view) {

				Toast.makeText(getActivity(), "Alarm is cancelled", Toast.LENGTH_SHORT).show();
			}
		});

		MaterialLargeImageCard card = MaterialLargeImageCard.with(getActivity())
				.setTextOverImage("10 minutes")
				.useDrawableId(R.drawable.card_background)
				.setupSupplementalActions(R.layout.card_native_material_supplemental_actions_large, actions)
				.build();

		cardViewNative = (CardViewNative) this.parentView.findViewById(R.id.materialCard);
		cardViewNative.setCard(card);

		return card;

	}

}
