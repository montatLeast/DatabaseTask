<%@page import="bean.Company"%>
<%@page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>主界面</title>
  <link rel="stylesheet" href="../../layui/css/layui.css">
</head>
<body class="layui-layout-body">
<jsp:useBean id="stulist" class="bean.StudentService"></jsp:useBean>
<jsp:useBean id="stu" class="bean.Student"></jsp:useBean>
<%
stu = stulist.queryInfo((String)session.getAttribute("account"));
List stus = stulist.queryCompany();
Iterator iter = stus.iterator();
%>
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">中南大学就业咨询系统</div>

    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
         <img src="../../img/face.jpg" class="layui-circle" width="35" height="35">
		 <cite><%out.println(stu.getName()); %></cite>
        </a>
        <dl class="layui-nav-child">
          <dd><a href="page/normal/userInfo.jsp">基本资料</a></dd>
          <dd><a href="">安全设置</a></dd>
        </dl>
      </li>
      <li class="layui-nav-item"><a href="../login.jsp">注销登录</a></li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
        <li class="layui-nav-item layui-nav-itemed">
          <a class="" href="javascript:;">用户管理</a>
          <dl class="layui-nav-child">
            <dd><a href="userInfo.jsp">用户信息</a></dd>
            <dd><a href="alterInfo.jsp">修改信息</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item">
          <a href="javascript:;">需求管理</a>
          <dl class="layui-nav-child">
            <dd><a href="queryDemand.jsp">查询需求</a></dd>
            <dd><a href="searchDemand.jsp">按需搜索</a></dd>
            <dd><a href="statistics.jsp">统计分析</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item">
          <a href="javascript:;">单位信息</a>
        </li>
      </ul>
    </div>
  </div>
  
  <div class="layui-body" >
    <!-- 内容主体区域 -->
       <div class="menu">
    <table class="layui-table" lay-size="sm">
  <colgroup>
    <col width="150">
    <col width="200">
    <col>
  </colgroup>
  <thead>
    <tr>
      <th>公司ID</th>
      <th>公司名称</th>
      <th>公司地址</th>
    </tr> 
  </thead>
  <tbody>
  	<%
		int i = 0;
		while (iter.hasNext()) {
			Company c = (Company) iter.next();
	%><tr>
    <tr>
      <td><%=c.getCno()%></td>
      <td><%=c.getCname()%></td>
      <td><%=c.getAddress()%></td>
    </tr>
    <%
		}
	%>
  </tbody>
</table>
	    </div>
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->
    计科1502班罗晓彤制作
  </div>
</div>
<script src="../../layui/layui.js"></script>
<script>
//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;
  
});
</script>
</body>
</html>