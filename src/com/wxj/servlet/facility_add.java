package com.wxj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wxj.bean.Facility;
import com.wxj.jdbc.ConnectionFactory;


public class facility_add extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public facility_add() {
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
		
		String facilityName=req.getParameter("facilityName");
		String num=req.getParameter("num");
		String content=req.getParameter("content");
		
		PrintWriter out=resp.getWriter();
		
		Facility facility=new Facility();
		facility.setFacilityName(facilityName);
		facility.setNum(num);
		facility.setContent(content);
		
		boolean flag=ConnectionFactory.insertFacility(facility);
		if(flag){
			out.print("success");
		}else{
			out.print("failed");
		}
	}

	
}
