
public class Customer extends User {

	private PaymentInfo paymentInfo;
	private Order[] orders;
	private int numOfOrders;
	private boolean hasCoupon;
	
	public Customer() {
		// set payment info to a new payment info object, we will create cash or card payment info in main
		// -----
		
		hasCoupon = false;
		
		// numOfOrders will be zero indexed, the real number of orders is numOfOrders + 1
		// a limitation is that we won't be able to access older orders once they are placed in this implementation
		numOfOrders = 0;
		
		// for simplicity, we can limit customers to ten orders, or we can switch to an ArrayList
		// no linked list because we don't really need efficient insertion / deletion
		orders = new Order[10];		
	}
	
	// addItem should add a food item and subsequently update the price, then return a boolean if successful
	public boolean addItem(FoodItem foodItem) {
		boolean result = orders[numOfOrders].cart.add(foodItem);
		orders[numOfOrders].updatePrice();
		return result;
	}
	
	// removeItem should return a boolean as to whether the removal of a food item was successful
	public boolean removeItem(FoodItem foodItem) {
		boolean result = orders[numOfOrders].cart.remove(foodItem);
		orders[numOfOrders].updatePrice();
		return result;
	}
	
	public boolean placeOrder() {
		numOfOrders++;
		// we need to send this current order to a restaurant class that will process it or something similar
	}
	
	public boolean setPaymentInfo(String paymentSetting) {
		
	}
}
