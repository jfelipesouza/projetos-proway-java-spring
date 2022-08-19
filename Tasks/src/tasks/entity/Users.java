package tasks.entity;

public class Users {
	private String userName,email;
	private int id;

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "Users [userName=" + userName + ", email=" + email + ", id=" + id + "]";
	}
	
	public Users(String userName, String email) {
		this.userName = userName;
		this.email = email;
	}

	public Users() {

	}
	
	
}
