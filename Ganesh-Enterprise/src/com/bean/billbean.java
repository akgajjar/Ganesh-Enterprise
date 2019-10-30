package com.bean;

import java.util.List;

public class billbean {

	private company_masterbean company;
	private bill_masterbean bill;
	private List<bill_databean> billdata;
	private clientbin client;
	public clientbin getClient() {
		return client;
	}
	public void setClient(clientbin client) {
		this.client = client;
	}
	public billbean() {
			company=null;
			bill=null;
			billdata = null;
			client=null;
	}
	public company_masterbean getCompany() {
		return company;
	}
	public void setCompany(company_masterbean company) {
		this.company = company;
	}
	public bill_masterbean getBill() {
		return bill;
	}
	public void setBill(bill_masterbean bill) {
		this.bill = bill;
	}
	public List<bill_databean> getBilldata() {
		return billdata;
	}
	public void setBilldata(List<bill_databean> billdata) {
		this.billdata = billdata;
	}
	
}
