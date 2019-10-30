package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.bill_databean;
import com.bean.billbean;
import com.bean.clientbin;
import com.bean.company_masterbean;
import com.model.billmodel;

@WebServlet("/billcontroller")
public class billcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String action=request.getParameter("action");
			response.sendRedirect("dashboard.jsp");
	
				if(action.equalsIgnoreCase("cancel"))
				{
					HttpSession session=request.getSession();
					session.removeAttribute("bill");
					
				}
				else if(action.equalsIgnoreCase("Add New Company Details"))
				{
					request.getRequestDispatcher("addcompany.jsp").forward(request, response);
				}
				else if(action.equalsIgnoreCase("Add Company"))
				{
					company_masterbean bean=new company_masterbean();
					bean.setCompany_Address(request.getParameter("companyadd"));
					bean.setCompany_Bank_Address(request.getParameter("companybankadd"));
					bean.setCompany_Bank_IFSC_Code(request.getParameter("companyifsc"));
					bean.setCompany_Bank_Name(request.getParameter("companybankname"));
					bean.setCompany_Gst_No(request.getParameter("companygstno"));
					bean.setCompany_Name(request.getParameter("companyname"));
					bean.setCompany_Phone(request.getParameter("companyphone"));
					
					billmodel model=new billmodel();
					model.addcompany(bean);
					
					request.getRequestDispatcher("salesbill.jsp").forward(request, response);
				}
				else if(action.equalsIgnoreCase("submit company"))
				{
					int id=Integer.parseInt(request.getParameter("company"));
					if(id==0) {
						response.sendRedirect("salesbill.jsp");
					}
					else
					{
						billmodel model=new billmodel();
						company_masterbean bean=model.getcompanyById(id);
						
						billbean bill=new billbean();
						bill.setCompany(bean);
						
						HttpSession session=request.getSession();
						session.setAttribute("bill", bill);
						
				
						request.getRequestDispatcher("clientbill.jsp").forward(request, response);
							
					}
					
				}
				
				else if(action.equalsIgnoreCase("Add New client Details"))
				{
					request.getRequestDispatcher("addclient.jsp").forward(request, response);
				}
				else if(action.equalsIgnoreCase("Add Client"))
				{
					
					clientbin bean=new clientbin();
					bean.setBI_Client_Name(request.getParameter("clientname"));
					bean.setBI_Client_Address(request.getParameter("clientadd"));
					bean.setBI_Client_Gst_No(request.getParameter("clientgstno"));
					
					billmodel model=new billmodel();
					model.addclient(bean);
					
					request.getRequestDispatcher("clientbill.jsp").forward(request, response);
				}
				else if(action.equalsIgnoreCase("submit client"))
				{
					int id=Integer.parseInt(request.getParameter("client"));
					if(id==0) {
						response.sendRedirect("clientbill.jsp");
					}
					else
					{
						billmodel model=new billmodel();
						clientbin bean=model.getclientById(id);
					
						HttpSession session=request.getSession();
						if(session.getAttribute("bill")!=null)
						{
						
						billbean bill=(billbean)session.getAttribute("bill");
						bill.setClient(bean);
							
						session.removeAttribute("bill");
						session.setAttribute("bill", bill);
						
				
						request.getRequestDispatcher("addbilldata.jsp").forward(request, response);
						}
						else
						{
							response.sendRedirect("salesbill.jsp");
							
						}
						
					}
					
				}

	
	}

}
