package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.category_masterbean;
import com.model.category_mastermodel;

@WebServlet("/category_mastercontroller")
public class category_mastercontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		String action=request.getParameter("action");
		if(action.equalsIgnoreCase("add category"))
		{
			category_masterbean bean=new category_masterbean();
			
			bean.setC_Name(request.getParameter("cname"));
			bean.setC_Description(request.getParameter("description"));
			bean.setC_Parent_Id(Integer.parseInt(request.getParameter("parentcat")));
			category_mastermodel model=new category_mastermodel();
			model.addcategory(bean);
			response.sendRedirect("dashboard.jsp");

		}
		else if(action.equalsIgnoreCase("update Category"))
		{
			category_masterbean bean=new category_masterbean();
			
			bean.setC_Name(request.getParameter("cname"));
			bean.setC_Description(request.getParameter("description"));
			bean.setC_Parent_Id(Integer.parseInt(request.getParameter("parentcat")));
			bean.setC_Id(Integer.parseInt(request.getParameter("id")));
			category_mastermodel model=new category_mastermodel();
			
			System.out.println("id : "+bean.getC_Id()+" cname : "+bean.getC_Name()+" desc : "+ bean.getC_Description()+" parent cat : "+ bean.getC_Parent_Id());
			model.updatecategory(bean);
			response.sendRedirect("dashboard.jsp");

		}
		else if(action.equalsIgnoreCase("update"))
		{
			request.getRequestDispatcher("updatecat.jsp").forward(request, response);
		
		}

	}

}
