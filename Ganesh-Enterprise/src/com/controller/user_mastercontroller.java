package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.user_masterbean;
import com.model.user_mastermodel;


@WebServlet("/user_mastercontroller")
public class user_mastercontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	static int flag = 0;

	private static String generateHash(String input) {
		StringBuilder hash = new StringBuilder();

		try {
			MessageDigest sha = MessageDigest.getInstance("SHA-256");
			byte[] hashedBytes = sha.digest(input.getBytes("UTF-8"));
			char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
			for (int idx = 0; idx < hashedBytes.length; ++idx) {
				byte b = hashedBytes[idx];
				hash.append(digits[(b & 0xf0) >> 4]);
				hash.append(digits[b & 0x0f]);
			}
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			flag = 1;
			e.printStackTrace();
		}

		return hash.toString();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String action=request.getParameter("action");
	
		if(action.equalsIgnoreCase("login"))
		{
			
			user_masterbean u=new user_masterbean();
			
			u.setU_Username(request.getParameter("email"));
			u.setU_Password(generateHash(request.getParameter("password")));
				
			user_mastermodel model=new  user_mastermodel();
			
			user_masterbean result;
			result=model.checklogin(u);
			if (result == null) {
		
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Your Username Or Password Is Incorrect!')");
				out.println("location='index.jsp';");
				out.println("</script>");
				response.sendRedirect("index.jsp");
				
			} else {
				HttpSession session = request.getSession(true);
				session.setAttribute("user", result);
				
				request.getRequestDispatcher("dashboard.jsp").forward(request, response);

			}

		}
	
	}

}
