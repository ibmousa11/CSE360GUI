
public class FoodItem {
	private String name;
	private double price;
	private String description;
	private int prepTime;
	
	
	public FoodItem(String name, double price, String description) {
		this.price = price;
		this.name = name;
		this.description = description;
		this.prepTime = 10;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getPrepTime() {
		return prepTime;
	}
}
