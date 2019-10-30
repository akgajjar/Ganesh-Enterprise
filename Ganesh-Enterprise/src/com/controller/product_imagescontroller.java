package com.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.bean.product_imagesbean;
import com.model.category_product_mastermodel;

@WebServlet("/product_imagescontroller")
public class product_imagescontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		String action=request.getParameter("action");
		if(action.equalsIgnoreCase("add"))
		{
			HttpSession session = request.getSession(true);
			session.setAttribute("id", Integer.parseInt(request.getParameter("id")));
			request.getRequestDispatcher("addimages.jsp").forward(request, response);
		}
		else if(action.equalsIgnoreCase("remove"))
		{
			request.getRequestDispatcher("removeimage.jsp").forward(request, response);
				
		}
		else if(action.equalsIgnoreCase("remove image"))
		{
			int id=Integer.parseInt(request.getParameter("id"));
			
			category_product_mastermodel model=new category_product_mastermodel();
			model.removeimage(id);
			request.getRequestDispatcher("showallproducts.jsp").forward(request, response);
				
		}
		else if(action.equalsIgnoreCase("Back"))
			
		{
			response.sendRedirect("showallproducts.jsp");
			
		}
	
	}

}
