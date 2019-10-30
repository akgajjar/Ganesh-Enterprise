package com.bean;

import java.sql.Blob;

public class user_masterbean {

	
	private int U_Id;
	private String U_Name,U_Address,U_Mobile,U_Email,U_Username,U_Password;
	private Blob U_Image;
	private Boolean U_Block;
	
	
	public int getU_Id() {
		return U_Id;
	}
	public void setU_Id(int u_Id) {
		U_Id = u_Id;
	}
	public String getU_Name() {
		return U_Name;
	}
	public void setU_Name(String u_Name) {
		U_Name = u_Name;
	}
	public String getU_Address() {
		return U_Address;
	}
	public void setU_Address(String u_Address) {
		U_Address = u_Address;
	}
	public String getU_Mobile() {
		return U_Mobile;
	}
	public void setU_Mobile(String u_Mobile) {
		U_Mobile = u_Mobile;
	}
	public String getU_Email() {
		return U_Email;
	}
	public void setU_Email(String u_Email) {
		U_Email = u_Email;
	}
	public String getU_Username() {
		return U_Username;
	}
	public void setU_Username(String u_Username) {
		U_Username = u_Username;
	}
	public String getU_Password() {
		return U_Password;
	}
	public void setU_Password(String u_Password) {
		U_Password = u_Password;
	}
	public Blob getU_Image() {
		return U_Image;
	}
	public void setU_Image(Blob u_Image) {
		U_Image = u_Image;
	}
	public Boolean getU_Block() {
		return U_Block;
	}
	public void setU_Block(Boolean u_Block) {
		U_Block = u_Block;
	}
	
}
