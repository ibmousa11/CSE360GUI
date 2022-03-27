import java.util.ArrayList;

public class Order {
	public int orderId;
	public String orderStatus;
	public ArrayList<FoodItem> cart;
	public double totalPrice;
	
	public Order() {
		orderStatus = "Order Received by Restaurant";
		cart = new ArrayList<FoodItem>();
		totalPrice = 0.00;
	}
	
	public int getOrderId() {
		return orderId;
	}
	
	public void setOrderId(int orderId) {
		
	}
	
	public String getOrderStatus() {
		return orderStatus;
	}
	
	public void setOrderStatus(String newOrderStatus) {
		
	}
	
	public double getTotalPrice() {
		return totalPrice;
	}
	
	public void updatePrice() {
		// for each item in the cart, get the price
		for(int i = 0; i < cart.size(); i++) {
			totalPrice += cart.get(i).getPrice();
		}
	}
	
	
	public String printOrder() {
		
	}
	
	
}
