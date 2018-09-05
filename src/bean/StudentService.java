package bean;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.JdbcLink;

public class StudentService {
	private Connection conn;
	private PreparedStatement pstmt;
	public StudentService() {
		conn = new JdbcLink().getConn();
	}
	//学生查询个人信息
	public Student queryInfo(String sno){
		try{
			Student student = new Student();
			pstmt = conn.prepareStatement("select * from student where sno="+sno);
			ResultSet rst = pstmt.executeQuery();
			if(rst.next()){
				student.setSno(rst.getString(1));
				student.setName(rst.getString(2));
				student.setSex(rst.getString(3));
				student.setBirthday(rst.getString(4));
				student.setMajor(rst.getString(5));
				student.setGraduateYear(rst.getString(6));
				student.setXueli(rst.getString(7));
				student.setSchool(rst.getString(8));
			}
			return student;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	//学生更新个人信息
	
	public boolean updateInfo(Student student){
		try {
			pstmt=conn.prepareStatement("update student set birthday=?,major=?,graduateyear=?,degree=?,school=? where sno=?");
			pstmt.setString(1, student.getBirthday());
			pstmt.setString(2, student.getMajor());
			pstmt.setString(3, student.getGraduateYear());
			pstmt.setString(4, student.getXueli());
			pstmt.setString(5, student.getSchool());
			pstmt.setString(6, student.getSno());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	//学生更改密码
	public boolean updateuserlist(String uname,String password){
		try {
			pstmt=conn.prepareStatement("update account set password=? where uname=?");
			pstmt.setString(1, password);
			pstmt.setString(2, uname);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	//根据帐号查询用户密码
	public String querypassword(String uname){
		try{
			String password = new String();
			pstmt=conn.prepareStatement("select * from account where uname=?");
			pstmt.setString(1, uname);
			ResultSet rst = pstmt.executeQuery();
			if(rst.next()){
				password = rst.getString(2);
			}
			return password;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	//查看需求
	public List queryDemand(){
		List dList = new ArrayList();
		try {
			pstmt = conn.prepareStatement("select * from demand");
			ResultSet rst = pstmt.executeQuery();
			while (rst.next()) {
				Demand demand = new Demand();
				demand.setDno(rst.getString(1));
				demand.setCno(rst.getString(2));
				demand.setCname(rst.getString(3));
				demand.setpost(rst.getString(4));
				demand.setTime(rst.getString(5));
				demand.setNeedperson(rst.getInt(6));
				dList.add(demand);
			}
			return dList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
			}
		}
	//搜索需求
	public List searchDemand(String type,String info){
		List dList = new ArrayList();
		String extra = new String();
		try {
			if(type.equals("按公司ID搜索")) {
				extra = "cno="+info;
				pstmt = conn.prepareStatement("select * from demand where " + extra);
			}
			else if(type.equals("按岗位搜索")) {
				extra = "post="+info;
				pstmt = conn.prepareStatement("select * from demand where " + extra);
			}
			else if(type.equals("按年份搜索")) {
				extra = "substr(time,0,4)="+info;
				pstmt = conn.prepareStatement("select * from demand where " + extra);
			}
			ResultSet rst = pstmt.executeQuery();
			while (rst.next()) {
				Demand demand = new Demand();
				demand.setDno(rst.getString(1));
				demand.setCno(rst.getString(2));
				demand.setCname(rst.getString(3));
				demand.setpost(rst.getString(4));
				demand.setTime(rst.getString(5));
				demand.setNeedperson(rst.getInt(6));
				dList.add(demand);
			}
			return dList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
			}
		}
	//查看单位列表
	public List queryCompany(){
		List cList = new ArrayList();
		try {
			pstmt = conn.prepareStatement("select * from company");
			ResultSet rst = pstmt.executeQuery();
			while (rst.next()) {
				Company company = new Company();
				company.setCno(rst.getString(1));
				company.setCname(rst.getString(2));
				company.setAddress(rst.getString(3));
				cList.add(company);
			}
			return cList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
			}
		}
	//获取统计信息
	public List statistics() {
		List sList = new ArrayList();
		try {
			pstmt = conn.prepareStatement("select post,sum(needperson) from demand group by post");
			ResultSet rst = pstmt.executeQuery();
			while (rst.next()) {
				Demand demand = new Demand();
				demand.setpost(rst.getString(1));
				demand.setNeedperson(rst.getInt(2));
				sList.add(demand);
			}
			return sList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
			}
	}
	
}

