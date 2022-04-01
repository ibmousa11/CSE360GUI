import java.util.ArrayList;

public class Owner extends User {
	
	private String ownerName;
	private ArrayList<Order> ordersProcessing;
	
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
	
	public void changePrice(ArrayList<FoodItem> menu, String foodItem, double price) {
		for(FoodItem item : menu) {
			if(item.getName().equals(foodItem)) {
				item.setPrice(price);
			}
		}
	}
	
	public FoodItem createFoodItem(ArrayList<FoodItem> menu, String name, double price, String description) {
		FoodItem newItem = new FoodItem(name, price, description);
		menu.add(newItem);
		return newItem;
	}
	
	public void giveCoupon(int customerID){
		
	}
	


}
