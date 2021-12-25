package software.project.backend.Model;

public class User implements Imodel{
	private int userId;
	private String userName;
	private String firstName;
	private String lastName;
	private String password;
	private String Address;
	private String phone;
	private boolean role;
	
	public User()
	{
		
	}
	
	
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int i) {
		this.userId = i;
	}


	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String user) {
		this.userName = user;
	}
	
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String pass) {
		this.password = pass;
	}
	
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String p) {
		this.phone = p;
	}
	
	public String getAddress() {
		return this.Address;
	}

	public void setAddress(String address) {
		this.Address = address;
	}

	public boolean getRole() {
		return role;
	}

	public void setRole(boolean role) {
		this.role = role;
	}
}
