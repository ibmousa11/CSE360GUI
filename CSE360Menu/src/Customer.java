
public class Customer extends User {

	private PaymentInfo paymentInfo;
	public Order[] orders;
	private int numOfOrders;
	private boolean hasCoupon;
	
	public Customer() {
		//default constructor
	}
	
	public Customer(String username, String password) {
		super(username, password);
		paymentInfo = new PaymentInfo();		// by default, payment info will be cash
		hasCoupon = false;
		
		// numOfOrders will be zero indexed, the real number of orders is numOfOrders + 1
		// a limitation is that we won't be able to access older orders once they are placed in this implementation
		numOfOrders = 0;
		
		// for simplicity, we can limit customers to ten orders, or we can switch to an ArrayList
		// no linked list because we don't really need efficient insertion / deletion
		orders = new Order[10];
		for(int i = 0; i < 10; i++) {
			orders[i] = new Order();
		}
	}
	
	// addItem should add a food item and subsequently update the price, then return a boolean if successful
	public boolean addItem(FoodItem foodItem) {
		boolean result = orders[numOfOrders].addToOrder(foodItem);
		return result;
	}
	
	// removeItem should return a boolean as to whether the removal of a food item was successful
	public boolean removeItem(FoodItem foodItem) {
		boolean result = orders[numOfOrders].removeFromOrder(foodItem);
		return result;
	}
	
	public boolean placeOrder() {
		numOfOrders++;
		// we need to send this current order to a restaurant class that will process it or something similar
		return false;
	}
	
	public void changePaymentSetting(String paymentSetting) {
		paymentInfo.setPaymentInfo(paymentSetting);
	}
}
