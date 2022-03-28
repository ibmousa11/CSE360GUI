
public class Owner {
	
	public String[] menu;
	
	public double[] prices; //indexes of menu array and prices array match up
	
	private String ownerName;
	
	public Owner() {
		
	}
	
	public String getName() {
		return ownerName;
	}
	
	public void setName(String name) {
		ownerName = name;
	}
	
	public void initializeMenu() {
		menu[0] = "Beef and Cheese";
		menu[1] = "BLT";
		menu[2] = "Buffalo Chicken";
		
		prices[0] = 7.99;
		prices[1] = 8.99;
		prices[2] = 9.99;
	}
	public void deliverFood(int customerID) {
		
	}
	
	public void changePrice(int itemIndex) {
		
	}
	
	public String getMenuItem(int index) {
		return menu[index];
	}
	
	public void createFoodItem(String name, double price) {
		
	}
	
	public void giveCoupon(int customerID){
		
	}
	


}
