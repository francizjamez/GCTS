package classes;

public class Account {
	private String user_name;
	private String password;
	private String ID;
	
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	
	public Account (String name, String password, String ID) {
		this.user_name = name;
		this.password = password;
		this.ID = ID;
	}
}
