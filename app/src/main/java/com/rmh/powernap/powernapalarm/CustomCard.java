package com.rmh.powernap.powernapalarm;

import android.content.Context;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.dexafree.materialList.cards.BasicButtonsCard;
/**
 * A Custom Card based off of dexafree Card library. This will be nearly identical to his BasicButtonsCard
 * except with a small menu in the top right corner.
 */

public class CustomCard extends BasicButtonsCard {

	public CustomCard(final Context context){
		super(context);
	}

	@Override
	public int getLayout(){
		return R.layout.custom_card_layout;
	}


	// Custom onClickListener to open the overflow menu
	public static class OnCardOverflowSelectedListener implements View.OnClickListener {

		private CustomCard customCard;
		private Context mContext;
		private PopupMenu.OnMenuItemClickListener listener;

		public OnCardOverflowSelectedListener(Context context, CustomCard card){
			mContext = context;
			customCard = card;
		}

		@Override
		public void onClick(View view){
			listener = new PopupMenu.OnMenuItemClickListener() {

				@Override
				public boolean onMenuItemClick(MenuItem item) {

					if(item.getItemId() == R.id.overflow_delete){
						Toast.makeText(App.getContext(), "I'm working", Toast.LENGTH_SHORT).show();
						return true;
					}
					return false;
				}
			};

		}

	}

}
