<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>天津河西疗养院</title>
    
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<!-- <script language="javascript">
	function success(AdminName){
		alert(AdminName + "登录成功！");
	}
	</script>
	 -->
	
  </head>
  
  <body>

 <img src="./logo.jpg" alt="欢迎您进入天津河西疗养院" align="top" ><br>
  <form action="login" method="post">
      <br>
    <table width="30%" border="1" cellpadding="0" cellspacing="0" align="center" style="background-color:99CCCC" cellpadding="10">
    <tr>
    <td class="mycss" width="60" >管理员姓名&nbsp;</td>
    <td class="mycss" width="50">&nbsp;<input name="AdminName" type="text"></td>
    </tr>
    <tr>
    <td></td>
    </tr>
    <tr>
    <td class="mycss">登陆密码</td>
    <td class="mycss">&nbsp;<input name="PassWord" type="password"></td>
    </tr>
    </table>

	<table align="center"  border="0" cellpadding="0" cellspacing="0">
	<tr>
	<td>
	 <input align="middle" type="submit" value="登录" name="submit">
	 <input type="reset" value="取消" name="reset">&nbsp; 
   </td>
   </tr>
	</table>
   </form>
   </body>
</html>
