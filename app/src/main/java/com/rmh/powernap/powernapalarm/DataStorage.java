package com.rmh.powernap.powernapalarm;


import com.dexafree.materialList.model.Card;

import java.util.ArrayList;

public class DataStorage {

	private ArrayList<Card> arrayList = new ArrayList<>();
	public int length = arrayList.size();

	public DataStorage(){

	}

	/**
	 * Add a Card object to the arrayList.
	 */
	public void add(Card card){
		arrayList.add(card);
	}

	/**
	 * Deletes the Card that is at index position.
	 */
	public void delete(int position){
		if(position <= length) {
			arrayList.remove(position);
		}
	}

	/**
	 * Returns the entire arrayList.
	 */
	public ArrayList<Card> getCards(){
		return arrayList;
	}

	/**
	 * Returns the Card at index position.
	 *
	 * If the position given is out of bounds of the arrayList, it returns null.
	 */
	public Card getCard(int position){
		if(position < length) {
			return arrayList.get(position);
		}
		return null;
	}

	/**
	 * If the arrayList has been initialized with cards, this will return true. If the arrayList
	 * is null, this will return false.
	 */
	public boolean hasCards(){
		return length > 0;
	}

}
