package com.bean;

import java.sql.Timestamp;

public class complain_commentbean {

	private int COM_Id,CO_Id,U_Id;
	private String COM_Desciption;
	private Timestamp COM_Date_Time;
	public int getCOM_Id() {
		return COM_Id;
	}
	public void setCOM_Id(int cOM_Id) {
		COM_Id = cOM_Id;
	}
	public int getCO_Id() {
		return CO_Id;
	}
	public void setCO_Id(int cO_Id) {
		CO_Id = cO_Id;
	}
	public int getU_Id() {
		return U_Id;
	}
	public void setU_Id(int u_Id) {
		U_Id = u_Id;
	}
	public String getCOM_Desciption() {
		return COM_Desciption;
	}
	public void setCOM_Desciption(String cOM_Desciption) {
		COM_Desciption = cOM_Desciption;
	}
	public Timestamp getCOM_Date_Time() {
		return COM_Date_Time;
	}
	public void setCOM_Date_Time(Timestamp cOM_Date_Time) {
		COM_Date_Time = cOM_Date_Time;
	}
	
}
