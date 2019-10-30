package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.category_masterbean;
import com.utils.projectutils;

public class category_mastermodel {


	public category_masterbean getcatbyId(int id)
	{
		category_masterbean bean=null;
		try {
			String query="select * from category_master where C_Id=?";
			Connection con=projectutils.createConnection();
			PreparedStatement stmt=con.prepareStatement(query);	
			stmt.setInt(1, id);
			ResultSet rs=stmt.executeQuery();
		if(rs.next())
			{
			bean=new category_masterbean();
			
			bean.setC_Id(rs.getInt("C_Id"));
			bean.setC_Name(rs.getString("C_Name"));
			bean.setC_Description(rs.getString("C_Description"));
			bean.setC_Parent_Id(rs.getInt("C_Parent_Id"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
	public List<category_masterbean> getallcategories()
	{
		List<category_masterbean> list=new ArrayList<category_masterbean>();
		
		try {
			String query="select * from category_master";
			Connection con=projectutils.createConnection();
			PreparedStatement stmt=con.prepareStatement(query);	
			ResultSet rs=stmt.executeQuery();
		while(rs.next())
			{
			category_masterbean c=new category_masterbean();
			
			c.setC_Id(rs.getInt("C_Id"));
			c.setC_Name(rs.getString("C_Name"));
			c.setC_Description(rs.getString("C_Description"));
			c.setC_Parent_Id(rs.getInt("C_Parent_Id"));
			list.add(c);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public List<category_masterbean> getallcategoriesByProductid(int id)
	{
		List<category_masterbean> list=new ArrayList<category_masterbean>();
		
		try {
			String query="select * from category_master where C_Id In (select C_Id from product_belongs where CP_Id=? )";
			Connection con=projectutils.createConnection();
			PreparedStatement stmt=con.prepareStatement(query);	
			stmt.setInt(1, id);
			ResultSet rs=stmt.executeQuery();
		while(rs.next())
			{
			category_masterbean c=new category_masterbean();
			
			c.setC_Id(rs.getInt("C_Id"));
			c.setC_Name(rs.getString("C_Name"));
			c.setC_Description(rs.getString("C_Description"));
			c.setC_Parent_Id(rs.getInt("C_Parent_Id"));
			list.add(c);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public void addcategory(category_masterbean bean)
	{
		
		try {
			String query="insert into category_master(C_Name,C_Description,C_Parent_Id) values(?,?,?)";
			Connection con=projectutils.createConnection();
			PreparedStatement stmt=con.prepareStatement(query);	
			stmt.setString(1, bean.getC_Name());
			stmt.setString(2, bean.getC_Description());
			stmt.setInt(3, bean.getC_Parent_Id());
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void updatecategory(category_masterbean bean)
	{
		
		try {
			String query="update category_master set C_Name=?,C_Description=?,C_Parent_Id=? where C_Id=?";
			Connection con=projectutils.createConnection();
			PreparedStatement stmt=con.prepareStatement(query);	
			stmt.setString(1, bean.getC_Name());
			stmt.setString(2, bean.getC_Description());
			stmt.setInt(3, bean.getC_Parent_Id());
			stmt.setInt(4, bean.getC_Id());
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
