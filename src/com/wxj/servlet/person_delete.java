package com.wxj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wxj.jdbc.ConnectionFactory;


public class person_delete extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public person_delete() {
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
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		// TODO Auto-generated method stub
		String name=req.getParameter("name");
		PrintWriter out=resp.getWriter();
		try {
			boolean flag=ConnectionFactory.deletePerson(name);
			if(flag){
				out.print("delete success£¡");
			}else{
				out.print("delete fail!!!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
