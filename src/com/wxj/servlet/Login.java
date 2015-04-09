package com.wxj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wxj.bean.Admin;
import com.wxj.jdbc.ConnectionFactory;


public class Login extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Login() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//ªÒµ√’ ∫≈
//		String id=req.getParameter("id").trim();
		String AdminName = req.getParameter("AdminName");
		String PassWord=req.getParameter("PassWord");
		PrintWriter out=resp.getWriter();
		out.print(AdminName);
			Admin admin=new Admin();
			try {
				admin=ConnectionFactory.getAdmin(AdminName,PassWord);
				
				if(admin!=null){					
					resp.sendRedirect("area.jsp");
					
				}else{
					resp.sendRedirect("login.jsp");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	
}
