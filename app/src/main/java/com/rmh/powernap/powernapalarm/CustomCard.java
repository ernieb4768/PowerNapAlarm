package com.rmh.powernap.powernapalarm;

import android.content.Context;
import android.support.v7.internal.view.menu.MenuBuilder;
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

public class CustomCard extends ExtendedCard implements View.OnClickListener {

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

	@Override
	public void onClick(View view){

		PopupMenu popupMenu = new PopupMenu(App.getContext(), view);

		popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
			@Override
			public boolean onMenuItemClick(MenuItem item){
				switch(item.getItemId()){
					case R.id.overflow_delete:
						Toast.makeText(App.getContext(), "Alarm is deleted", Toast.LENGTH_SHORT).show();
						return true;
					default:
						return false;
				}
			}
		});

		popupMenu.inflate(R.menu.menu_overflow);
		popupMenu.show();

	}

}
