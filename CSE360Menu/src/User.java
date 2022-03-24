
public class User {
	
	private String username;
	private String password;
	public String name;
	public String phone;
	
	public User() {

		User user = new User();  //creating constructor
	
	}
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
