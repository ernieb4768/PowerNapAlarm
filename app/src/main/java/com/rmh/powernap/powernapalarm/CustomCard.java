package com.rmh.powernap.powernapalarm;

import android.content.Context;

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

}
