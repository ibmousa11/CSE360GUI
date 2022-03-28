
public class PaymentInfo {

	private String cardNumber;
	private String cash;
	private boolean paymentMethod;
	
	public PaymentInfo() {
		paymentMethod = false;
		cardNumber = "1234-1234-1234-1234";
		cash = "paying by cash";
	}
	
	public String getPaymentInfo() {
		if(paymentMethod == false) {
			return cash;
		} else {
			return cardNumber;
		}
	}
	
	public void setPaymentInfo(String paymentSetting) {
		if(paymentSetting == "cash") {
			paymentMethod = false;
		} else {
			paymentMethod = true;
		}
	}
	
}
