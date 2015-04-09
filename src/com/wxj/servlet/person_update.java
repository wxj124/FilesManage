package com.wxj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wxj.bean.Servicestaff;
import com.wxj.jdbc.ConnectionFactory;

public class person_update extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public person_update() {
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
		
	 // int id=Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String mark = req.getParameter("mark");
		int id = 0;

		PrintWriter out = resp.getWriter();
		Servicestaff person = new Servicestaff();
		person.setName(name);
		person.setMark(mark);
		try {
			id = ConnectionFactory.findOnePerson(name);	
			boolean flag = ConnectionFactory.updatePerson(id, person);
			if (flag) {
				out.print("update success!");
			} else {
				out.print("update fail");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
