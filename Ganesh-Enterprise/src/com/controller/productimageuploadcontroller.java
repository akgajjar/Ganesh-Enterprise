package com.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.bean.product_imagesbean;
import com.model.category_product_mastermodel;


@WebServlet("/productimageuploadcontroller")
public class productimageuploadcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 final String UPLOAD_DIRECTORY = getServletContext().getInitParameter("uploadproductimage");
		if(ServletFileUpload.isMultipartContent(request))
		{
			category_product_mastermodel model=new category_product_mastermodel();
			product_imagesbean bean=new product_imagesbean();
			HttpSession session = request.getSession(true);
			int id=(int)session.getAttribute("id");
			bean.setCP_Id(id);
			try
			{
				List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				for(FileItem item : multiparts)
				{
					if(!(item.getName()==null))
					{
					bean.setProduct_Image(item.getInputStream());
					model.addimage(bean);
					
					
					String name = new File(item.getName()).getName();
					item.write(new File(UPLOAD_DIRECTORY + File.separator + name));
					}
				}
				request.setAttribute("message", "File uploaded successfully.");
				request.getRequestDispatcher("showallproducts.jsp").forward(request, response);
				
			}
			catch(Exception ex)
			{
				request.setAttribute("message", "File upload failed due to : " + ex);
			}
		}
		else
		{
			request.setAttribute("message", "Sorry this servlet only handles file upload request.");
		}
	}

}
