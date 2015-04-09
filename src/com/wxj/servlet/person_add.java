package com.wxj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wxj.bean.Servicestaff;
import com.wxj.jdbc.ConnectionFactory;

public class person_add extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public person_add() {
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
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8"); 
		String name=req.getParameter("name");
		String mark=req.getParameter("mark");
		PrintWriter out=resp.getWriter();
		Servicestaff person=new Servicestaff();
		person.setName(name);
		person.setMark(mark);
		boolean flag=ConnectionFactory.insertPerson(person);
		if(flag){
			out.print("success");
		}else{
			out.print("fail");
		}
	}

}
