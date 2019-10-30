package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.category_product_masterbean;
import com.bean.product_belongs;
import com.bean.product_imagesbean;
import com.utils.projectutils;

public class category_product_mastermodel {

	
	public category_product_masterbean getproductbyId(int id)
	{
		category_product_masterbean bean=null;
		try {
			String query="select * from category_product_master where CP_Id=?";
			Connection con=projectutils.createConnection();
			PreparedStatement stmt=con.prepareStatement(query);	
			stmt.setInt(1, id);
			ResultSet rs=stmt.executeQuery();
		if(rs.next())
			{
			bean=new category_product_masterbean();
			
			bean.setCP_Desciption(rs.getString("CP_Description"));
			bean.setCP_Display(rs.getBoolean("CP_Display"));
			bean.setCP_Id(rs.getInt("CP_Id"));
			bean.setCP_Name(rs.getString("CP_Name"));
			bean.setCP_Old_Prize(rs.getString("CP_Old_Prize"));
			bean.setCP_Prize(rs.getString("CP_Prize"));
			bean.setCP_Size(rs.getString("CP_Size"));
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
	public List<category_product_masterbean> getallproducts()
	{
		List<category_product_masterbean> list=new ArrayList<category_product_masterbean>();
		
		try {
			String query="select * from category_product_master";
			Connection con=projectutils.createConnection();
			PreparedStatement stmt=con.prepareStatement(query);	
			ResultSet rs=stmt.executeQuery();
		while(rs.next())
			{
			category_product_masterbean bean=new category_product_masterbean();
			bean.setCP_Desciption(rs.getString("CP_Description"));
			bean.setCP_Display(rs.getBoolean("CP_Display"));
			bean.setCP_Id(rs.getInt("CP_Id"));
			bean.setCP_Name(rs.getString("CP_Name"));
			bean.setCP_Old_Prize(rs.getString("CP_Old_Prize"));
			bean.setCP_Prize(rs.getString("CP_Prize"));
			bean.setCP_Size(rs.getString("CP_Size"));
			
			list.add(bean);
			}
			
		} 
			catch (Exception e) {
				e.printStackTrace();
			}
		return list;
		}
	public void addproduct(category_product_masterbean bean)
		{
		
		try {
			String query="insert into category_product_master(CP_Name,CP_Description,CP_Size,CP_Old_Prize,CP_Prize,CP_Display) values(?,?,?,?,?,?)";
			Connection con=projectutils.createConnection();
			PreparedStatement stmt=con.prepareStatement(query);	
			stmt.setString(1, bean.getCP_Name());
			stmt.setString(2, bean.getCP_Desciption());
			stmt.setString(3, bean.getCP_Size());
			stmt.setString(5, bean.getCP_Prize());
			stmt.setString(4, bean.getCP_Old_Prize());
			stmt.setBoolean(6, bean.getCP_Display());
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void addintocategory(product_belongs b) {
		try {
			String query="insert into product_belongs(C_Id,CP_Id) values(?,?)";
			Connection con=projectutils.createConnection();
			PreparedStatement stmt=con.prepareStatement(query);	
			stmt.setInt(1, b.getC_Id());
			stmt.setInt(2, b.getCP_Id());
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void addimage(product_imagesbean b) {
		try {
			String query="insert into product_images(CP_Id,Product_Image) values(?,?)";
			Connection con=projectutils.createConnection();
			PreparedStatement stmt=con.prepareStatement(query);	
			stmt.setInt(1, b.getCP_Id());
			stmt.setBlob(2, b.getProduct_Image());
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void removefromcategory(product_belongs b) {
		try {
			String query="delete from product_belongs where C_Id=? and CP_Id=?";
			Connection con=projectutils.createConnection();
			PreparedStatement stmt=con.prepareStatement(query);	
			stmt.setInt(1, b.getC_Id());
			stmt.setInt(2, b.getCP_Id());
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	public void changestatus(int id, boolean d) {

		try {
			String query="update category_product_master set CP_Display=? where CP_Id=?";
			Connection con=projectutils.createConnection();
			PreparedStatement stmt=con.prepareStatement(query);	
			stmt.setBoolean(1, d);
			stmt.setInt(2, id);
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void updateproduct(category_product_masterbean bean) {
		// TODO Auto-generated method stub
		
		try {
			String query="update category_product_master set CP_Name = ? ,CP_Description = ? , CP_Size = ? , CP_Old_Prize = ? , CP_Prize = ? , CP_Display = ? where CP_Id=?";
			Connection con=projectutils.createConnection();
			PreparedStatement stmt=con.prepareStatement(query);	
			stmt.setString(1, bean.getCP_Name());
			stmt.setString(2, bean.getCP_Desciption());
			stmt.setString(3, bean.getCP_Size());
			stmt.setString(5, bean.getCP_Prize());
			stmt.setString(4, bean.getCP_Old_Prize());
			stmt.setBoolean(6, bean.getCP_Display());
			stmt.setInt(7, bean.getCP_Id());
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	public List<product_imagesbean> getimagebyid(int id)
	{
		List<product_imagesbean> list=new ArrayList<product_imagesbean>();
		try {
			String query="select * from product_images where CP_Id=?";
			Connection con=projectutils.createConnection();
			PreparedStatement stmt=con.prepareStatement(query);	
			stmt.setInt(1, id);
			ResultSet rs=stmt.executeQuery();
		while(rs.next())
			{
			product_imagesbean bean=new product_imagesbean();
				bean.setCP_Id(rs.getInt("CP_Id"));
				bean.setProduct_Image( rs.getBlob("Product_Image").getBinaryStream());
				bean.setProimg_Id(rs.getInt("Proimg_Id"));
				
				bean.setImg(rs.getBlob("Product_Image"));
			list.add(bean);
			}
			
		} 
			catch (Exception e) {
				e.printStackTrace();
			}
		
		
		return list;
	}
	
	public void deleteproduct(int id) {
		// TODO Auto-generated method stub
		

		try {
		
			
			String query="delete from product_belongs where CP_Id=?";
			Connection con=projectutils.createConnection();
			PreparedStatement stmt=con.prepareStatement(query);	
			stmt.setInt(1, id);
			stmt.executeUpdate();
			
			query="delete from product_images where CP_Id=?";
			
			stmt=con.prepareStatement(query);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			
			query="delete from category_product_master where CP_Id=?";
			
			stmt=con.prepareStatement(query);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			
				con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void removeimage(int id) {
		// TODO Auto-generated method stub
		
		try {
			String query="delete from product_images where Proimg_Id=?";
			Connection con=projectutils.createConnection();
			PreparedStatement stmt=con.prepareStatement(query);	
			stmt.setInt(1, id);
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
}
