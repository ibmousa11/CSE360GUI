import java.util.ArrayList;

public class Owner extends User {
	
	private String ownerName;
	
	public Owner() {
		
	}
	
	public String getName() {
		return ownerName;
	}
	
	public void setName(String name) {
		this.ownerName = name;
	}
	
	public void initializeMenu() {
		
	}
	
	public void deliverFood(int customerID) {
		
	}
	
	public void changePrice(int itemIndex) {
		
	}
	
	public FoodItem createFoodItem(String name, double price) {
		return new FoodItem(name, price);
	}
	
	public void giveCoupon(int customerID){
		
	}
	


}
