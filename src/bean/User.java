package bean;

public class User {
	private int id;
	private String username;								//�û���
	private String password;								//����
	private String character;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setUserName(String username) {				//�����û���
		this.username=username;
	}
	public void setPassWord(String password) {				//��������
		this.password=password;
	}
	public String getUserName() {							//��ȡ�û���
		return username;
	}
	public String getPassWord() {							//��ȡ����
		return password;
	}
	public String getCharacter() {
		return character;
	}
	public void setCharacter(String character) {
		this.character = character;
	}
}