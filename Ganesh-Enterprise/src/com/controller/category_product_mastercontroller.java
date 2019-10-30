package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.category_product_masterbean;
import com.bean.product_belongs;
import com.model.category_product_mastermodel;


@WebServlet("/category_product_mastercontroller")
public class category_product_mastercontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action=request.getParameter("action");
		if(action.equalsIgnoreCase("add Product"))
		{
			category_product_masterbean bean=new category_product_masterbean();
			
			bean.setCP_Desciption(request.getParameter("description"));
			bean.setCP_Name(request.getParameter("pname"));
			bean.setCP_Old_Prize(request.getParameter("poldprize"));
			bean.setCP_Prize(request.getParameter("pnewprize"));
			bean.setCP_Size(request.getParameter("psize"));
			bean.setCP_Display(true);
			
			category_product_mastermodel model=new category_product_mastermodel();
			model.addproduct(bean);
			response.sendRedirect("dashboard.jsp");

		}
		if(action.equalsIgnoreCase("Update Product"))
		{
			category_product_masterbean bean=new category_product_masterbean();
			
			bean.setCP_Desciption(request.getParameter("description"));
			bean.setCP_Name(request.getParameter("pname"));
			bean.setCP_Old_Prize(request.getParameter("poldprize"));
			bean.setCP_Prize(request.getParameter("pnewprize"));
			bean.setCP_Size(request.getParameter("psize"));
			bean.setCP_Display(Boolean.parseBoolean(request.getParameter("pdisplay")));
			bean.setCP_Id(Integer.parseInt(request.getParameter("pid")));
			category_product_mastermodel model=new category_product_mastermodel();
			model.updateproduct(bean);
			response.sendRedirect("showallproducts.jsp");

		}
		if(action.equalsIgnoreCase("Delete"))
		{
			
			int i=Integer.parseInt(request.getParameter("id"));
			category_product_mastermodel model=new category_product_mastermodel();
			model.deleteproduct(i);
			response.sendRedirect("showallproducts.jsp");

		}
		
		else if(action.equalsIgnoreCase("add into category"))
		{
			product_belongs b=new product_belongs();
			b.setCP_Id(Integer.parseInt(request.getParameter("id")));
			b.setC_Id(Integer.parseInt(request.getParameter("cat")));
				
			category_product_mastermodel model=new category_product_mastermodel();
			model.addintocategory(b);
			response.sendRedirect("dashboard.jsp");
	
			
		}
		else if(action.equalsIgnoreCase("remove from category"))
		{
			product_belongs b=new product_belongs();
			b.setCP_Id(Integer.parseInt(request.getParameter("id")));
			b.setC_Id(Integer.parseInt(request.getParameter("cat")));
				
			category_product_mastermodel model=new category_product_mastermodel();
			model.removefromcategory(b);;
			response.sendRedirect("dashboard.jsp");
	
			
		}
		else  if(action.equalsIgnoreCase("Change"))
		{
			int id=Integer.parseInt(request.getParameter("id"));
			boolean d=Boolean.parseBoolean(request.getParameter("display"));
			if(d== true)
				d=false;
			else
				d=true;
			category_product_mastermodel model=new category_product_mastermodel();
			model.changestatus(id,d);
	
			
			
			request.getRequestDispatcher("showallproducts.jsp").forward(request, response);
	
		}
		else  if(action.equalsIgnoreCase("Update"))
		{
			
			
			request.getRequestDispatcher("updateproduct.jsp").forward(request, response);
	
		}
		else if(action.equalsIgnoreCase("Back"))
			
		{
			response.sendRedirect("showallproducts.jsp");
			
		}
		else  if(action.equalsIgnoreCase("Add"))
		{
			request.getRequestDispatcher("newprobelongs.jsp").forward(request, response);
	
		}
		else  if(action.equalsIgnoreCase("Remove"))
		{
			request.getRequestDispatcher("removeprobelongs.jsp").forward(request, response);
	
		}
		
		
	
	
	}

}
