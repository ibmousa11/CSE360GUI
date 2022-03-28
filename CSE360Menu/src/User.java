// yo 

public class User {
	
	private String username;
	private String password;
	public String phone;
	public boolean hasCoupon = false;
	
	public User() {
		
	}
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.phone = "";
	}
	
	public String getName() {
		return username;
	}
	
	public void setName(String name) {
		this.username = name;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
