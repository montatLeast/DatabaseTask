package bean;

import java.net.URI;
import java.net.URL;
import java.util.Date;


public class Demand {
	private String dno;
	private String cno;
	private String cname;
	private String post;
	private String time;
	private int needperson;
	
	public String getDno() {
		return dno;
	}
	public String getCno() {
		return cno;
	}
	public String getCname() {
		return cname;
	}
	public String getpost() {
		return post;
	}
	public String getTime() {
		return time;
	}
	public int getNeedperson() {
		return needperson;
	}
	
	public void setDno(String dno) {
		this.dno = dno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public void setpost(String post) {
		this.post = post;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public void setNeedperson(int needperson) {
		this.needperson = needperson;
	}

}