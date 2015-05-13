package com.rmh.powernap.powernapalarm;

public class StandardAlarm {

	public String imageText;
	public String title;
	public String subTitle;
	public int image;

	public StandardAlarm(String largeImageText, String titleString, String subTitleString, int largeImage){

		imageText = largeImageText;
		title = titleString;
		subTitle = subTitleString;
		image = largeImage;

	}

	public int getImage(){
		return image;
	}

	public String getImageText(){
		return imageText;
	}

	public String getTitle(){
		return title;
	}

	public String getSubTitle(){
		return subTitle;
	}

}
