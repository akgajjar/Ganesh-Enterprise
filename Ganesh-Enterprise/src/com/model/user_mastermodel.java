package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bean.user_masterbean;
import com.utils.projectutils;

public class user_mastermodel {

	
	public user_masterbean checklogin(user_masterbean bean)
	{
		user_masterbean b=null;
		
		try {
			String query="select * from user_master where U_Username=? and U_Password=?";
			Connection con=projectutils.createConnection();
			PreparedStatement stmt=con.prepareStatement(query);
			stmt.setString(1, bean.getU_Username());
			stmt.setString(2, bean.getU_Password());
			
			ResultSet rs=stmt.executeQuery();
			if(rs.next())
			{
				
				b=new user_masterbean();
				b.setU_Address(rs.getString("U_Address"));
				b.setU_Block(rs.getBoolean("U_Block"));
				b.setU_Email(rs.getString("U_Email"));
				b.setU_Id(rs.getInt("U_Id"));
				b.setU_Image(rs.getBlob("U_Image"));
				b.setU_Mobile(rs.getString("U_Mobile"));
				b.setU_Name(rs.getString("U_Name"));
				b.setU_Password(rs.getString("U_Password"));
				b.setU_Username(rs.getString("U_Username"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
}
