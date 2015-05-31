package com.rmh.powernap.powernapalarm;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import com.dexafree.materialList.cards.BasicButtonsCard;
/**
 * A Custom Card based off of dexafree Card library. This will be nearly identical to his BasicButtonsCard
 * except with a small menu in the top right corner.
 */

public class CustomCard extends BasicButtonsCard {

	protected int mPopupMenu = NO_POPUP_MENU;
	public static int NO_POPUP_MENU = -1;
	protected OnClickCardHeaderPopupMenuListener mPopupMenuListener;
	protected OnPrepareCardHeaderPopupMenuListener mPopupMenuPrepareListener;

	public CustomCard(final Context context){
		super(context);
	}

	@Override
	public int getLayout(){
		return R.layout.custom_card_layout;
	}

	public interface OnClickCardHeaderPopupMenuListener {
		void onMenuItemClick(View view, MenuItem item);
	}

	public interface OnPrepareCardHeaderPopupMenuListener {

		boolean onPreparePopupMenu(CustomCard card, PopupMenu popupMenu);
	}

	public void setPopupMenu(int menuRes, OnClickCardHeaderPopupMenuListener listener, OnPrepareCardHeaderPopupMenuListener prepareListener) {
		mPopupMenu = menuRes;
		mPopupMenuListener = listener;
		mPopupMenuPrepareListener = prepareListener;
	}


	public void setPopupMenu(int menuRes, OnClickCardHeaderPopupMenuListener listener) {
		setPopupMenu(menuRes, listener, null);
	}


	public OnClickCardHeaderPopupMenuListener getPopupMenuListener() {
		return mPopupMenuListener;
	}

	public OnPrepareCardHeaderPopupMenuListener getPopupMenuPrepareListener() {
		return mPopupMenuPrepareListener;
	}

	public void setPopupMenuListener(OnClickCardHeaderPopupMenuListener popupMenuListener) {
		mPopupMenuListener = popupMenuListener;
	}

	public void setPopupMenuPrepareListener(OnPrepareCardHeaderPopupMenuListener popupMenuListener) {
		mPopupMenuPrepareListener = popupMenuListener;
	}

	public int getPopupMenu() {
		return mPopupMenu;
	}

}
