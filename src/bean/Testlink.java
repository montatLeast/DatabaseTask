package bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import dao.JdbcLink;

public class Testlink {
	public static void main(String[] args) {
		try {
		Connection connection = new JdbcLink().getConn();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("select * from account where uname = 'admin' and password = '123456'");
		if(rs.next()) {
			System.out.println(rs.getString(1));
		}
		
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
