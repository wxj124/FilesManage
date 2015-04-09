package com.wxj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.persistence.metamodel.SetAttribute;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wxj.bean.Facility;
import com.wxj.jdbc.ConnectionFactory;

public class facility_select extends HttpServlet {
	private static final String CONTENT_TYPE = "text/html; charset=utf-8 "; 
	/**
	 * Constructor of the object.
	 */
	public facility_select() {
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
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		
		String facilityName = req.getParameter("facilityName");	
		PrintWriter out=resp.getWriter();		
		String content="";
		try {
			content=ConnectionFactory.getFacility(facilityName);
			
			if(null!=content&&!"".equals(content)){
				RequestDispatcher rd=req.getRequestDispatcher("selectresult.jsp");
				req.setAttribute("content", content);
				rd.forward(req, resp);
				out.print(content);
			}else{ 
				req.setAttribute("content", content);
				RequestDispatcher rd=req.getRequestDispatcher("selectresult.jsp");	
				rd.forward(req, resp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
