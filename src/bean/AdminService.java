package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.JdbcLink;

public class AdminService {
	private Connection conn;
	private PreparedStatement pstmt;
	public AdminService() {
		conn = new JdbcLink().getConn();
	}
	
	public List queryStudent(){
		List sList = new ArrayList();
		try {
			pstmt = conn.prepareStatement("select * from student");
			ResultSet rst = pstmt.executeQuery();
			while (rst.next()) {
				Student student = new Student();
				student.setSno(rst.getString(1));
				student.setName(rst.getString(2));
				student.setSex(rst.getString(3));
				student.setBirthday(rst.getString(4));
				student.setMajor(rst.getString(5));
				student.setGraduateYear(rst.getString(6));
				student.setXueli(rst.getString(7));
				student.setSchool(rst.getString(8));
				sList.add(student);
			}
			return sList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
			}
		}
	
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
	
	public Demand queryoneDemand(String info){
		List dList = new ArrayList();
		try {
			Demand demand = new Demand();
			pstmt = conn.prepareStatement("select * from demand where dno="+info);
			ResultSet rst = pstmt.executeQuery();
			if (rst.next()) {
				demand.setDno(rst.getString(1));
				demand.setCno(rst.getString(2));
				demand.setCname(rst.getString(3));
				demand.setpost(rst.getString(4));
				demand.setTime(rst.getString(5));
				demand.setNeedperson(rst.getInt(6));
			}
			return demand;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
			}
		}
	
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
			System.out.println(type);
			System.out.println(info);
			
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
	
	public boolean addDemand(Demand demand){
		try{
		pstmt=conn.prepareStatement("insert into demand values(seq_test.nextval,?,?,?,?,?)");
		pstmt.setString(1, demand.getCno());
		pstmt.setString(2, demand.getCname());
		pstmt.setString(3, demand.getpost());
		pstmt.setString(4, demand.getTime());
		pstmt.setInt(5, demand.getNeedperson());
		pstmt.executeUpdate();
		return true;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	public boolean alterDemand(Demand demand){
		try{
		pstmt=conn.prepareStatement("update demand set cno=?,cname=?,post=?,time=?,needperson=? where dno=?");
		pstmt.setString(1, demand.getCno());
		pstmt.setString(2, demand.getCname());
		pstmt.setString(3, demand.getpost());
		pstmt.setString(4, demand.getTime());
		pstmt.setInt(5, demand.getNeedperson());
		pstmt.setString(6, demand.getDno());
		pstmt.executeUpdate();
		return true;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteDemand(String dno){
		try{
		pstmt=conn.prepareStatement("delete from demand where dno=?");
		pstmt.setString(1, dno);
		pstmt.executeUpdate();
		
		return true;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
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
	
	public Company queryoneCompany(String info){
		List dList = new ArrayList();
		try {
			Company company = new Company();
			pstmt = conn.prepareStatement("select * from company where cno="+info);
			ResultSet rst = pstmt.executeQuery();
			if (rst.next()) {
				company.setCno(rst.getString(1));
				company.setCname(rst.getString(2));
				company.setAddress(rst.getString(3));
			}
			return company;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
			}
		}
	
	
	public boolean addCompany(Company company){
		try{
		pstmt=conn.prepareStatement("insert into company values(?,?,?)");
		pstmt.setString(1, company.getCno());
		pstmt.setString(2, company.getCname());
		pstmt.setString(3, company.getAddress());
		pstmt.executeUpdate();
		return true;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean alterCompany(Company company){
		try{
		pstmt=conn.prepareStatement("update company set cname=?,address=? where cno=?");
		pstmt.setString(1, company.getCname());
		pstmt.setString(2, company.getAddress());
		pstmt.setString(3, company.getCno());
		pstmt.executeUpdate();
		return true;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteCompany(String cno){
		try{
		pstmt=conn.prepareStatement("delete from company where cno=?");
		pstmt.setString(1, cno);
		pstmt.executeUpdate();
		return true;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
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
