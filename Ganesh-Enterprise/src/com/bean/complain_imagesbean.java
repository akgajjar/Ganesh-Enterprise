package com.bean;

import java.sql.Blob;

public class complain_imagesbean {

	private int CO_Id;
	private Blob CO_Image;
	public int getCO_Id() {
		return CO_Id;
	}
	public void setCO_Id(int cO_Id) {
		CO_Id = cO_Id;
	}
	public Blob getCO_Image() {
		return CO_Image;
	}
	public void setCO_Image(Blob cO_Image) {
		CO_Image = cO_Image;
	}
	
}
