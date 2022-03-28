
public class FoodItem {
	private String name;
	private double price;
	private String description;
	
	
	public FoodItem(String name, double price) {
		this.price = price;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
}
