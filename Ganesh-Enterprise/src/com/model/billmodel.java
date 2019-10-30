package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.bean.bill_masterbean;
import com.bean.category_masterbean;
import com.bean.clientbin;
import com.bean.company_masterbean;
import com.utils.projectutils;

public class billmodel {

	
	public List<company_masterbean> getallcompanies()
	{
		List<company_masterbean> list=new ArrayList<company_masterbean>();
		
		try {
			String query="select distinct * from company_master";
			Connection con=projectutils.createConnection();
			PreparedStatement stmt=con.prepareStatement(query);	
			ResultSet rs=stmt.executeQuery();
		while(rs.next())
			{
			company_masterbean c=new company_masterbean();
			c.setCompany_Id(rs.getInt("Company_Id"));
			c.setCompany_Bank_IFSC_Code(rs.getString("Comapny_Bank_IFSC_Code"));
			c.setCompany_Address(rs.getString("Company_Address"));
			c.setCompany_Bank_Address(rs.getString("Company_Bank_Address"));
			c.setCompany_Bank_Name(rs.getString("Company_Bank_Name"));
			c.setCompany_Gst_No(rs.getString("Company_Gst_No"));
			c.setCompany_Name(rs.getString("Company_Name"));
			c.setCompany_Phone(rs.getString("Company_Phone"));
			
			list.add(c);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<clientbin> getallclients()
	{
		List<clientbin> list=new ArrayList<clientbin>();
		
		try {
			String query="select distinct * from bill_master ";
			Connection con=projectutils.createConnection();
			PreparedStatement stmt=con.prepareStatement(query);	
			ResultSet rs=stmt.executeQuery();
		while(rs.next())
			{
			clientbin c=new clientbin();
			c.setBI_Id(rs.getInt("BI_Id"));
			c.setBI_Client_Address(rs.getString("BI_Client_Address"));
			c.setBI_Client_Gst_No(rs.getString("BI_Client_GST_No"));
			c.setBI_Client_Name(rs.getString("BI_Client_Name"));
			list.add(c);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}


	public clientbin getclientById(int id)
	{
		clientbin c=null;
		try {
			String query="select distinct * from bill_master where BI_Id=? ";
			Connection con=projectutils.createConnection();
			PreparedStatement stmt=con.prepareStatement(query);	
			stmt.setInt(1, id);
			ResultSet rs=stmt.executeQuery();
		if(rs.next())
			{
			 c=new clientbin();
			c.setBI_Client_Address(rs.getString("BI_Client_Address"));
			c.setBI_Client_Gst_No(rs.getString("BI_Client_GST_No"));
			c.setBI_Client_Name(rs.getString("BI_Client_Name"));
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}
	public bill_masterbean getBillById(int id)
	{
		bill_masterbean c=null;
		try {
			String query="select  * from bill_master where BI_Id=? ";
			Connection con=projectutils.createConnection();
			PreparedStatement stmt=con.prepareStatement(query);	
			stmt.setInt(1, id);
			ResultSet rs=stmt.executeQuery();
		if(rs.next())
			{
			 c=new bill_masterbean();
			 c.setBI_Date(rs.getDate("BI_Date"));
			 c.setBI_Basic_Ammount(rs.getDouble("BI_Basic_Ammount"));
			 c.setBI_Carting(rs.getDouble("BI_Carting"));
			 c.setBI_CGST(rs.getDouble("BI_CGST"));
			 c.setBI_Cutout(rs.getDouble("BI_Cutout"));
			 c.setBI_Pcs(rs.getInt("BI_Pcs"));
			 c.setBI_Id(rs.getInt("BI_Id"));
			 c.setBI_Round(rs.getDouble("BI_Round"));
			 c.setBI_SGST(rs.getDouble("BI_SGST"));
			 c.setBI_Taxable_Ammount(rs.getDouble("BI_Taxable_Ammount"));
			 c.setBI_Total_Ammount(rs.getDouble("BI_Total_Ammount"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}
			
	public void addcompany(company_masterbean bean)
		{
		
		try {
			String query="insert into company_master(Company_Bank_IFSC_Code,Company_Address,Company_Bank_Name,Company_Gst_No,Company_Name,Company_Phone) values(?,?,?,?,?,?)";
			Connection con=projectutils.createConnection();
			PreparedStatement stmt=con.prepareStatement(query);	
			stmt.setString(1, bean.getCompany_Bank_IFSC_Code());
			stmt.setString(2, bean.getCompany_Address());
			stmt.setString(3, bean.getCompany_Bank_Name());
			stmt.setString(4, bean.getCompany_Gst_No());
			stmt.setString(5, bean.getCompany_Name());
			stmt.setString(6, bean.getCompany_Phone());
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addclient(clientbin bean)
	{
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		   LocalDateTime now = LocalDateTime.now();
		try {
			
			
			String query="insert into bill_master(BI_Client_Name,BI_Client_Address,BI_Client_GST_No,BI_Date)values(?,?,?,?)";
			Connection con=projectutils.createConnection();
			PreparedStatement stmt=con.prepareStatement(query);	
			stmt.setString(1, bean.getBI_Client_Name());
			stmt.setString(2, bean.getBI_Client_Address());
			stmt.setString(3, bean.getBI_Client_Gst_No());
			stmt.setDate(4, Date.valueOf(dtf.format(now)));
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

 public company_masterbean getcompanyById(int id)
	{ 
		company_masterbean c=null;
		try {
			String query="select * from company_master where Company_Id=?";
			Connection con=projectutils.createConnection();
			PreparedStatement stmt=con.prepareStatement(query);	
			stmt.setInt(1, id);
			ResultSet rs=stmt.executeQuery();
		while(rs.next())
			{
			c=new company_masterbean();
			c.setCompany_Id(rs.getInt("Company_Id"));
			c.setCompany_Bank_IFSC_Code(rs.getString("Comapny_Bank_IFSC_Code"));
			c.setCompany_Address(rs.getString("Company_Address"));
			c.setCompany_Bank_Address(rs.getString("Company_Bank_Address"));
			c.setCompany_Bank_Name(rs.getString("Company_Bank_Name"));
			c.setCompany_Gst_No(rs.getString("Company_Gst_No"));
			c.setCompany_Name(rs.getString("Company_Name"));
			c.setCompany_Phone(rs.getString("Company_Phone"));
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}
	
}
