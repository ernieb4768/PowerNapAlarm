package com.rmh.powernap.powernapalarm;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.dexafree.materialList.cards.ExtendedCard;
import com.dexafree.materialList.cards.OnButtonPressListener;

/**
 * A Custom Card based off of dexafree Card library. This will be nearly identical to his BasicButtonsCard
 * except with a small menu in the top right corner.
 */

public class CustomCard extends ExtendedCard {

	private View menuView;
	private ImageButton button;
	private String popupLog = "POPUP_MENU";
	protected OnButtonPressListener onOverflowButtonPressedListener;

	public CustomCard(final Context context){
		super(context);
		LayoutInflater inflater = (LayoutInflater) App.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		menuView = inflater.inflate(R.layout.custom_card_layout, null, false);
		Log.d(popupLog, "Layout inflated");
	}

	@Override
	public int getLayout(){
		return R.layout.custom_card_layout;
	}

	public void setOnOverflowButtonPressedListener(OnButtonPressListener onOverflowButtonPressedListener){
		this.onOverflowButtonPressedListener = onOverflowButtonPressedListener;
	}









	/*public void setOnPopupMenuClickListener(){

		button = (ImageButton) menuView.findViewById(R.id.settings_button);
		button.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// Create the popup menu
				PopupMenu popupMenu = new PopupMenu(App.getContext(), button);
				// Inflate the popup with the menu resource file
				popupMenu.getMenuInflater().inflate(R.menu.menu_overflow, popupMenu.getMenu());
				Log.d(popupLog, "Popup Menu created and inflated");

				// Add menu item click listener
				popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

					@Override
					public boolean onMenuItemClick(MenuItem item) {
						Toast.makeText(App.getContext(), "You clicked " + item.getTitle(), Toast.LENGTH_SHORT).show();
						return false;
					}
				});
			}
		});

	}*/

}
