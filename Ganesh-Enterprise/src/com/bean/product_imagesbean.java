package com.bean;

import java.io.InputStream;
import java.sql.Blob;



public class product_imagesbean {

	private int CP_Id;
	private InputStream Product_Image;
	private int Proimg_Id;
	private Blob img;
	public Blob getImg() {
		return img;
	}
	public void setImg(Blob img) {
		this.img = img;
	}
	public int getProimg_Id() {
		return Proimg_Id;
	}
	public void setProimg_Id(int proimg_Id) {
		Proimg_Id = proimg_Id;
	}
	public int getCP_Id() {
		return CP_Id;
	}
	public void setCP_Id(int cP_Id) {
		CP_Id = cP_Id;
	}
	public InputStream getProduct_Image() {
		return Product_Image;
	}
	public void setProduct_Image(InputStream product_Image) {
		Product_Image = product_Image;
	}
	
}
