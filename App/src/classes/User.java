package classes;

public class User extends Account {

	private float balance;

	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	public User(String name, String password, String id, float balance) {
		super(name,password,id);
		this.balance = balance;
	}
	
	
}
