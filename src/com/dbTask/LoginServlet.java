package com.dbTask;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.AdminService;
import bean.Company;
import bean.Demand;
import bean.Student;
import bean.StudentService;
import dao.JdbcLink;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String usr ;
	Connection conn;
	String ide;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	String method = request.getParameter("method");
    	
    	if("login".equals(method)){
		
		usr=new String(request.getParameter("account").getBytes("iso-8859-1"), "utf-8");
		String pwd =new String(request.getParameter("password").getBytes("iso-8859-1"), "utf-8");
		System.out.println(usr+" "+pwd);
		boolean isValid = false;
		try{
		conn = new JdbcLink().getConn();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from account where uname = "+"'"+usr+"'"+" and password = "+"'"+pwd+"'");
		if(rs.next())//查询语句
		{
			ide = rs.getString(3);
			isValid = true;
		}	
		System.out.println(isValid);
		if(isValid){
			request.getSession().setAttribute("account",usr); 
			System.out.println(usr);
			//根据用户身份选择跳转
			if(ide.equals("normal")){
			response.sendRedirect("index.jsp");	
			}
			else if(ide.equals("super")){
			response.sendRedirect("index_admin.jsp");	
			}
		}
		else{
			response.sendRedirect("page/login.jsp");	
		}
		}catch(SQLException e){e.printStackTrace();
		}
    	}
    	 if("alter".equals(method)){
    		StudentService sser = new StudentService();
    		String sname = request.getParameter("sname");
    		String birthday = new String(request.getParameter("birthday"));
    		String major = new String(request.getParameter("major").getBytes("iso-8859-1"),"utf-8");
    		String graduateyear = request.getParameter("graduateyear");
    		String degree  = new String(request.getParameter("degree").getBytes("iso-8859-1"),"utf-8");
    		String school = new String(request.getParameter("school").getBytes("iso-8859-1"),"utf-8");
    		
    		Student stu = new Student();
    		stu.setSno(usr);
    		stu.setBirthday(birthday);
    		stu.setMajor(major);
    		stu.setGraduateYear(graduateyear);
    		stu.setXueli(degree);
    		stu.setSchool(school);
    		if(sser.updateInfo(stu)&&sser.updateuserlist(usr, request.getParameter("password")))
    		{    	
    			response.sendRedirect("index.jsp");
    		}
    	}
    	 
    	if("alterDemand".equals(method)) {
    		AdminService adminService = new AdminService();
    		String dno = request.getParameter("dno");
    		String cno = request.getParameter("cno");
    		String cname = new String(request.getParameter("cname").getBytes("iso-8859-1"),"utf-8");
    		String post = new String(request.getParameter("post").getBytes("iso-8859-1"),"utf-8");
    		String time = request.getParameter("time");
    		int needperson = Integer.parseInt(request.getParameter("needperson"));
    		
    		Demand demand = new Demand();
    		demand.setDno(dno);
    		demand.setCno(cno);
    		demand.setCname(cname);
    		demand.setpost(post);
    		demand.setTime(time);
    		demand.setNeedperson(needperson);
    		
    		if(adminService.alterDemand(demand)) {
    			response.sendRedirect("index_admin.jsp");
    		}
    	}
    	
    	if("deleteDemand".equals(method)) {
    		AdminService adminService = new AdminService();
    		String dno = request.getParameter("dno");
    		if(adminService.deleteDemand(dno)) {
    			response.sendRedirect("index_admin.jsp");
    		}
    	}
    	
    	if("addDemand".equals(method)) {
    		AdminService adminService = new AdminService();
    		String cno = request.getParameter("cno");
    		String cname = new String(request.getParameter("cname").getBytes("iso-8859-1"),"utf-8");
    		String post = new String(request.getParameter("post").getBytes("iso-8859-1"),"utf-8");
    		String time = request.getParameter("time");
    		int needperson = Integer.parseInt(request.getParameter("needperson"));
    		
    		Demand demand = new Demand();
    		demand.setCno(cno);
    		demand.setCname(cname);
    		demand.setpost(post);
    		demand.setTime(time);
    		demand.setNeedperson(needperson);
    		
    		if(adminService.addDemand(demand)) {
    			response.sendRedirect("index_admin.jsp");
    		}
    	}
    	
    	if("alterCompany".equals(method)) {
    		AdminService adminService = new AdminService();
    		String cno = request.getParameter("cno");
    		String cname = new String(request.getParameter("cname").getBytes("iso-8859-1"),"utf-8");
    		String address = new String(request.getParameter("address").getBytes("iso-8859-1"),"utf-8");
    		
    		Company company = new Company();
    		company.setCno(cno);
    		company.setCname(cname);
    		company.setAddress(address);

    		if(adminService.alterCompany(company)) {
    			response.sendRedirect("index_admin.jsp");
    		}
    	}
    	
    	if("deleteCompany".equals(method)) {
    		AdminService adminService = new AdminService();
    		String cno = request.getParameter("cno");
    		if(adminService.deleteCompany(cno)) {
    			response.sendRedirect("index_admin.jsp");
    		}
    	}
    	
    	if("addCompany".equals(method)) {
    		AdminService adminService = new AdminService();
    		String cno = request.getParameter("cno");
    		String cname = new String(request.getParameter("cname").getBytes("iso-8859-1"),"utf-8");
    		String address = new String(request.getParameter("address").getBytes("iso-8859-1"),"utf-8");
    		
    		Company company = new Company();
    		company.setCno(cno);
    		company.setCname(cname);
    		company.setAddress(address);
    		
    		if(adminService.addCompany(company)) {
    			response.sendRedirect("index_admin.jsp");
    		}
    	}
    	
    	//接收用户注销登录的请求
    	if("logout".equals(method)){
    		request.getSession().setAttribute("account","");
    		response.sendRedirect("page/login.jsp");	
    	}

    	System.out.println(method);
	}

}
