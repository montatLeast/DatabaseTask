package bean;

public class User {
	private int id;
	private String username;								//用户名
	private String password;								//密码
	private String character;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setUserName(String username) {				//设置用户名
		this.username=username;
	}
	public void setPassWord(String password) {				//设置密码
		this.password=password;
	}
	public String getUserName() {							//获取用户名
		return username;
	}
	public String getPassWord() {							//获取密码
		return password;
	}
	public String getCharacter() {
		return character;
	}
	public void setCharacter(String character) {
		this.character = character;
	}
}