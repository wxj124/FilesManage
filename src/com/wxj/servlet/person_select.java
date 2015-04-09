package com.wxj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wxj.bean.Servicestaff;
import com.wxj.jdbc.ConnectionFactory;

public class person_select extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public person_select() {
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
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		List<Servicestaff> list;
		try {
			list = ConnectionFactory.findAllPerson();
			req.setAttribute("list", list);
			System.out.print("success");
			req.getRequestDispatcher("person_select.jsp").forward(req, resp);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		String name = req.getParameter("name");		
//		PrintWriter out=resp.getWriter();
//		Servicestaff person=new Servicestaff();
//		
//		try {
//			person=ConnectionFactory.findOnePerson(name);
//			List<Servicestaff> list = new ArrayList<Servicestaff>();
//			if(person!=null){
///*				out.println("此学生名为"+person.getName());
//				
//				list.add(person);
//			}	
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	

}
