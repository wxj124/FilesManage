package com.wxj.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wxj.bean.Admin;
import com.wxj.bean.Facility;
import com.wxj.bean.Servicestaff;

public class ConnectionFactory {
	private static final String url = "jdbc:mysql://localhost:3306/sanatorium?useUnicode=true&characterEncoding=UTF-8";
	private static final String username = "root";
	private static final String password = "root";

	public static Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	//管理员登陆
		public static Admin getAdmin(String AdminName,String PassWord) throws SQLException{	
			Connection conn=null;
			conn=getConnection();
			String sql="select * from t_admin where AdminName=? and PassWord=?";
			PreparedStatement st=null;
			ResultSet rs=null;
			st=conn.prepareStatement(sql);
			st.setString(1, AdminName);
			st.setString(2, PassWord);
			rs=st.executeQuery();
			Admin admin=new Admin();
			while(rs.next()) {
				admin.setAdminName(rs.getString("AdminName"));
				admin.setPassword(rs.getString("PassWord"));
				return admin;
			}
			return null;	
		}
		
	//具体设施查询
     public static String getFacility(String facilityName) throws SQLException {
    	 Connection conn=null;
    	 conn=getConnection();
    	 String sql="select content from t_facility where facility=?";
    	 PreparedStatement st=null;
    	 ResultSet rs=null;
    	 st=conn.prepareStatement(sql);
    	 st.setString(1, facilityName);
    	 rs=st.executeQuery();
//    	 System.out.println("wxj");
//    	 Facility facility=new Facility();
    	 String content="";
    	 if (rs.next()) {
			content=rs.getString("content");
			System.out.println(content);
			return content;	
		}
		return null;
		
	}
     
    //删除设施
     public static boolean deleteFacility(String facilityName) throws SQLException{
			Connection conn=getConnection();
			PreparedStatement pre=null;
			String sql="delete from t_facility where facility=?";
			pre=conn.prepareStatement(sql);
			pre.setString(1, facilityName);
			int i=pre.executeUpdate();
			if(i>0){
				return true;
			}else{
				return false;
			}	
		}
 //增加设施
     public static boolean insertFacility(Facility facility) {
 		Connection conn;
 		int i = 0;
 		try {
 			conn = getConnection();
 			PreparedStatement pre = null;
 			String sql = "insert into t_facility(facility,num,content) values(?,?,?)";
 			pre = conn.prepareStatement(sql);
 			pre.setString(1, facility.getFacilityName());
 			pre.setString(2, facility.getNum());
 			pre.setString(3, facility.getContent());
 			i = pre.executeUpdate();
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		if(i>0){
 			return true;
 		}else{
 			return false;
 		}
 	} 
        
 //增加人员
     public static boolean insertPerson(Servicestaff person){
    	 Connection conn;
    	 int i=0;
    	 try {
			conn=getConnection();
			 PreparedStatement pre=null;
	    	 String sql="insert into t_servicestaff(name,mark) value(?,?)";
	    	 pre=conn.prepareStatement(sql);
	    	 pre.setString(1, person.getName());
	    	 pre.setString(2, person.getMark());
	    	 i=pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	 if(i>0){
    		 return true;
    	 }else{
    		 return false;
    	 }	 
     }
     
 //删除人员
     public static boolean deletePerson(String name) throws SQLException{
    	 Connection conn=getConnection();
    	 PreparedStatement pre=null;
    	 String sql="delete from t_servicestaff where name=?";
    	 pre=conn.prepareStatement(sql);
    	 pre.setString(1, name);
    	 int i=pre.executeUpdate();
    	 if(i>0){
    		 return true;
    	 }else{
    		 return false;
    	 } 
     }
 
 //查找某个人员
     public static int findOnePerson(String name) throws SQLException{
    	 Connection conn=null;
    	 conn=getConnection();
    	 String sql="select id from t_servicestaff where name=?";
    	 PreparedStatement st=null;
    	 ResultSet rs=null;
    	 st=conn.prepareStatement(sql);
    	 st.setString(1, name);
    	 rs=st.executeQuery();
    	 int id=0;
    	 if (rs.next()) {
			id=rs.getInt("id");
			return id;
		}
		return id;
		
    	 
     }
 //查找所有人员
     public static List<Servicestaff> findAllPerson() throws SQLException{
 		Connection conn=getConnection();
 		PreparedStatement pre=null;
 		ResultSet rs=null;
 		String sql="select * from t_servicestaff";
 		List<Servicestaff> list=new ArrayList<Servicestaff>();
 		pre=conn.prepareStatement(sql);
 		rs=pre.executeQuery();
 		
 		while(rs.next()){
 			Servicestaff person=new Servicestaff();
 			person.setId(new Integer(rs.getString("Id")));
 			person.setName(rs.getString("name"));
 			person.setMark(rs.getString("mark"));
 			list.add(person);
 		}
 		if(conn!=null){
 			conn.close();
 		}
 		if(pre!=null){
 			pre.close();
 		}
 		if(rs!=null){
 			rs.close();
 		}
 		return list;	
 	}
   
     
 //修改人员信息
     public static boolean updatePerson(int id,Servicestaff person) throws SQLException{
			Connection conn=getConnection();
			PreparedStatement pre=null;
			String sql="update t_servicestaff set name=?,mark=? where id=?";
			pre=conn.prepareStatement(sql);
			pre.setInt(3, id);
			pre.setString(1, person.getName());
			pre.setString(2, person.getMark());
			int i=pre.executeUpdate();
			if(i>0){
				return true;
			}else{
				return false;
			}
		}     
}
