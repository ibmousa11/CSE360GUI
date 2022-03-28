import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class RestaurantMenu {

	private JFrame frame;
	private JFrame menuFrame;
	private JButton userButton;
	private JButton ownerButton;
	private JButton menuButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		// example for adding a customer, adding fooditems to menu, then adding
		// fooditems to a users order and printing the order, price updates accordingly
		Customer newCustomer = new Customer("yaneric", "password");
		FoodItem sandwich = new FoodItem("Sandwich",8.99);
		FoodItem sandwich2 = new FoodItem("Italian Sub",7.99);
		newCustomer.setPhone("5034736866");
		newCustomer.addItem(sandwich);
		newCustomer.addItem(sandwich2);
		newCustomer.orders[0].printOrder();
		System.out.println("Current total: " + newCustomer.orders[0].getTotalPrice());
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RestaurantMenu window = new RestaurantMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RestaurantMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// create a frame, this is the window of the application
		frame = new JFrame("SubZilla");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(480,640);
        frame.setVisible(true);
        
        menuFrame = new JFrame();
        menuFrame.setSize(480,640);
        menuFrame.setVisible(false);
        menuFrame.setLayout(null);
        
        // create a Panel that sits inside the frame
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setSize(480,640);
        frame.add(panel);
        

        // creating a user object with name Eric
		User user = new User();
		user.setName("Eric");
		
		//creating owner object
		Owner owner = new Owner();
		owner.setName("I am the owner");
		owner.initializeMenu();			//I get an error every time I add stuff to the menu and prices array
		
		//Customizing the frame that holds the menu
		JLabel item0 = new JLabel(owner.menu[0]);
		JLabel item1 = new JLabel(owner.menu[1]);
		JLabel item2 = new JLabel(owner.menu[2]);
		JLabel price0 = new JLabel(Double.toString(owner.prices[0]));
		JLabel price1 = new JLabel(Double.toString(owner.prices[1]));
		JLabel price2 = new JLabel(Double.toString(owner.prices[2]));
		
		//setting properties for spacing of menu components
		item0.setBounds(10, 10, 100, 20);
		item1.setBounds(10, 40, 100, 20);
		item2.setBounds(10, 70, 100, 20);
		price0.setBounds(130, 10, 100, 20);
		price1.setBounds(130, 40, 100, 20);
		price2.setBounds(130, 70, 100, 20);
		
		menuFrame.add(item0);
		menuFrame.add(item1);
		menuFrame.add(item2);
		menuFrame.add(price0);
		menuFrame.add(price1);
		menuFrame.add(price2);
		
		
        // create a button, this will sit inside the panel
		userButton = new JButton("Click if you are a customer");
		ownerButton = new JButton("Click if you are the owner");
		menuButton = new JButton("Menu");
		
		userButton.setBounds(50, 30, 180, 30);
		ownerButton.setBounds(250, 30, 180, 30);
		menuButton.setBounds(200,80,80,30);
		
		panel.add(userButton);
		panel.add(ownerButton);
		panel.add(menuButton);
		
		userButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,user.getName());
			}
		});
		
		
		ownerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, owner.getName());
			}
		});
		
		menuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuFrame.setVisible(true);
			}
		});
		
		
		
		
	}

}
