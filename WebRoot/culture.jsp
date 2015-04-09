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
		<style type="text/css">
			div#container{width:1400px}
			div#header {background-color:#99bbbb;}
			div#menu {background-color:#ffff99;height:480px;width:400px;float:left;}
			div#content {background-color:#EEEEEE;height:480px;width:600px;float:left;}
			div#right{background-color:#ffff99;height:480px;width:400px;float:left;}
			div#footer {background-color:#99bbbb;clear:both;text-align:center;}
			h1 {margin-bottom:0;}
			h2 {margin-bottom:0;font-size:18px;}
			ul {margin:0;}
			li {list-style:none;}
		</style>
  </head>
  
  <body class=html id="homefirst">
   	<img src="./logo.jpg" alt="欢迎您进入天津河西疗养院" align="top" ><br>
   	<div id="container">
	<div id="header">
	<h1> files manage </h1>
	</div>
   
	 <div id="menu">
		<h2>医疗卫生</h2>
		<ul>
			<li><a href="./hospital.jsp" title="天津河西疗养院-医院">医院_1</a></li>
			<li><a href="./menzhen.jsp" title="天津河西疗养院-门诊">门诊_2</a></li>
			<li><a href="./nurseroom.jsp" title="天津河西疗养院-护理室">护理室_3</a></li>
			</ul>
		<h2>文化体育</h2>	
		<ul>
			<li class="currentLink"><a href="./culture.jsp" title="天津河西疗养院-文化活动中心">文化活动中心_4</a></li>
			<li><a href="./sport.jsp" title="天津河西疗养院-运动场">运动场_5</a></li>
			<li><a href="./fitness.jsp" title="天津河西疗养院-健身房">健身房_6</a></li>
		</ul>
		<h2>服务中心</h2>	
		<ul>
			<li><a href="./service.jsp" title="天津河西疗养院-综合服务处">综合服务处_7</a></li>
			<li><a href="./oldhome.jsp" title="天津河西疗养院-养老院">养老院_8</a></li>
			<li><a href="./health.jsp" title="天津河西疗养院-保健室">保健室_9</a></li>
		</ul>
	</div> 
	
	
	<div id="content">
	
   <form action="facility_select" method="post">
    <table width="40%" border="1" cellpadding="0" cellspacing="0" align="center" style="height:100px; width: 270px; ">
	<tr>
	<td><h3>文化活动中心设施查询</h3></td></tr>
	<tr>
	<td>设施名称<input type="text" name="facilityName" style="width: 159px; "></td>
	<td></td></tr>
	<tr>
	<td><input type="submit" value="查询">
	</td></tr></table> </form><br>
	
	
	<form action="facility_delete" method="post">
	<table width="40%" border="1" cellpadding="0" cellspacing="0" align="center" style="height:100px; width: 270px; ">
	<tr>
	<td><h3>文化活动中心设施删除</h3></td></tr>
	<tr>
	<td>设施名称<input type="text" name="facilityName" style="width: 159px; "></td>
	<td></td></tr>
	<tr>
	<td>
	<input type="submit" value="删除">
	
	</td></tr></table> </form><br>
	
	
	<form action="facility_add" method="post">
	<table width="40%" border="1" cellpadding="0" cellspacing="0" align="center" style="height:100px; width: 270px; ">
	<tr>
	<td><h3>文化活动中心设施增加</h3></td></tr>
	<tr>
	<td>设施名称<input type="text" name="facilityName" style="width: 159px; "></td>
	<td></td></tr>
	<tr>
	<td>设施用途与描述<input type="text" name="content" style="width: 185px; "></td></tr>
	<tr>
	<td>属于中心设备请填4<input type="text" name="num" style="width: 185px; "></td></tr>
	<tr>
	<td><input type="submit"  value="增加">
	</td></tr></table> </form>
	
	</div>
	
	<div id="right">
		<h2>人员管理</h2>
		<ul>
			<li><a href="person_select" title="天津河西疗养院">查询所有人员</a></li>
			<li><a href="./person_add.jsp" title="天津河西疗养院">增加人员</a></li>
			<li><a href="./person_delete.jsp" title="天津河西疗养院">删除人员</a></li>
			<li><a href="./person_update.jsp" title="天津河西疗养院">重新分配</a></li>
			</ul>
			
			 <br>
	 <br><br><br>
	 <ul>
	 <li><a href="logoutServlet" title="注销">注销登录</a></li>
	</ul>	
	</div>
	
    <div id="footer">天津河西疗养院</div>
    </div>
    
     <br>
  </body>
</html>
