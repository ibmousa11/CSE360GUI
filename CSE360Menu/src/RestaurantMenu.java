import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.imageio.ImageIO;
import javax.swing.*;

public class RestaurantMenu {
	
	private String currentUsername;
	private String currentUserpassword;
	private ArrayList<Customer> customerAccounts;
	
	private JLabel title;
	private JLabel couponTitle;
	private JLabel couponInfo;
	
	private JPanel picturePanel;
	
	private JFrame loginFrame;
	private JPanel loginPanel;
	private JButton loginButton;

	private JFrame frame;
	private JPanel homePanel;
	private JPanel couponPanel;
	private JPanel menuPanel;
	private ArrayList<FoodItem> menuItems;
	
	private JPanel cartPanel;
	private JPanel innerCartPanel;
	private JLabel subtotal;
	
	private JPanel orderPanel;
	private JButton placeOrder;
	
	private JFrame PaymentFrame;
	private JPanel PaymentPanel;
	private JButton PaymentButton;
	
	private int placeInLine = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		// example for adding a customer, adding fooditems to menu, then adding
		// fooditems to a users order and printing the order, price updates accordingly
		
		/*Customer newCustomer = new Customer("yaneric", "password");
		FoodItem sandwich = new FoodItem("Sandwich",8.99);
		FoodItem sandwich2 = new FoodItem("Italian Sub",7.99);
		newCustomer.setPhone("5034736866");
		newCustomer.addItem(sandwich);
		newCustomer.addItem(sandwich2);
		newCustomer.orders[0].printOrder();
		System.out.println("Current total: " + newCustomer.orders[0].getTotalPrice());*/
		
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
		menuItems = new ArrayList<FoodItem>();
		customerAccounts = new ArrayList<Customer>();
		
		//Initialize GUI elements in the constructor so we don't duplicate anything
		frame = new JFrame("SubZilla");	
        homePanel = new JPanel();
        title = new JLabel("SubZilla");
        couponTitle = new JLabel("Rewards Program");
        couponInfo = new JLabel("BUY TEN SUBS, GET ONE FREE");
        
        picturePanel = new JPanel();
        
		loginPanel = new JPanel();
		loginButton = new JButton("Login");
		loginFrame = new JFrame("LOGIN");
		
        orderPanel = new JPanel();
		innerCartPanel = new JPanel();
		cartPanel = new JPanel();
		
		placeOrder = new JButton("Place Order");
		subtotal = new JLabel("0.00");
		
		PaymentPanel = new JPanel();
		PaymentButton = new JButton("Customer Information");
		
		couponPanel = new JPanel();
		
		menuPanel = new JPanel();

		Owner owner = new Owner();
		owner.setName("I am the owner");
		owner.initializeMenu();
		owner.createFoodItem(menuItems,"Beef and Cheese", 8.99, "Tender ribeye steak with melted provolone and caramelized onions on a hoagie roll");
		owner.createFoodItem(menuItems,"Buffalo Chicken", 7.99, "Shredded chicken with blue cheese crumbles, ranch dressing, and signature buffalo sauce");
		owner.createFoodItem(menuItems, "Classic Ham", 5.99, "Classic ham and cheese sub with honey mustard, french bread, cheddar cheese , and sliced ham ");
		
		//take that login info and pass it to initialize to start the menu
		Customer guest = new Customer("guest", "guest");
		initialize(guest);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Customer currentUser) {
		System.out.println("currently logged in as: " + currentUser.getName());
		
		/* ---------------------------------- Window Frame -------------------------------------- */
		// create a frame, this is the window of the application
		frame.setBounds(100, 100, 100, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(1366,768);
        frame.setVisible(true);
        /* --------------------------------------------------------------------------------------- */
      
        
        /* ---------------------------------- Home Panel ----------------------------------------- */
        
        // create a Panel that sits inside the frame
        homePanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        homePanel.setSize(1920,1080);
        frame.add(homePanel);
        
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        constraints.weightx = 0.3;
        constraints.weighty = 0.3;
        
		title.setSize(200, 50);
		title.setFont(new Font("Impact", Font.PLAIN, 50));
		homePanel.add(title,constraints);
		
		/* ----------------------------------------------------------------------------------------- */
		
		/*-----------------------------Login Button-------------------------------------------*/
		constraints.gridx = 2;
		constraints.gridy = 0;
		constraints.ipadx = 50;
		constraints.ipady = 50;
		constraints.anchor = GridBagConstraints.FIRST_LINE_END;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weighty = 0.2;
		loginPanel.add(loginButton);
		homePanel.add(loginPanel,constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 0;
		
		
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		
		});
		
		/* ---------------------------------- Cart Panel -------------------------------------- */
		// create a frame, this is the window of the application
		constraints.gridx = 2;
		constraints.gridy = 1;
		constraints.ipadx = 10;
		constraints.ipady = 10;
		constraints.anchor = GridBagConstraints.LINE_END;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weightx = 0.4;
		constraints.weighty = 0.6;
		
        innerCartPanel.setLayout(new BoxLayout(innerCartPanel, BoxLayout.Y_AXIS));
        
        cartPanel.setLayout(new BoxLayout(cartPanel, BoxLayout.Y_AXIS));
        cartPanel.setBorder(BorderFactory.createTitledBorder("Cart"));
        cartPanel.add(innerCartPanel);
        homePanel.add(cartPanel,constraints);
        
		subtotal.setText("Total: " + String.valueOf(currentUser.getOrdersArr()[currentUser.getNumOfOrders()].getTotalPrice()));
        /* --------------------------------------------------------------------------------------- */
		
		
		/* -------------------------------------- Place Order Button -------------------------------------- */
        constraints.gridx = 2;
        constraints.gridy = 3;
        constraints.ipadx = 50;
        constraints.ipady = 50;
        constraints.anchor = GridBagConstraints.PAGE_END;
        constraints.fill = GridBagConstraints.NONE;
        constraints.weighty = 0.3;
        
		//placeOrder.setSize(100,50);
		//placeOrder.setLocation(1700, 900);
		orderPanel.add(placeOrder);
		homePanel.add(orderPanel,constraints);
		
		placeOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				homePanel.setVisible(false);
				placeInLine++;
				
				JPanel checkoutPanel = new JPanel();
				checkoutPanel.setLayout(new GridBagLayout());
				GridBagConstraints checkoutConstraints = new GridBagConstraints();
				
				checkoutPanel.setSize(1920,1080);
		        
				checkoutConstraints.gridx = 0;
				checkoutConstraints.gridy = 0;
		        checkoutConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
		        checkoutConstraints.weighty = 2;
		        
				JLabel OrderPlacedTitle = new JLabel("Order Placed");
				OrderPlacedTitle.setFont(new Font("Impact", Font.PLAIN, 80));
				checkoutPanel.add(OrderPlacedTitle,checkoutConstraints);
				
				JLabel placeInLineLabel = new JLabel("Your place in line is: " + placeInLine);
				placeInLineLabel.setFont(new Font("Impact", Font.PLAIN, 20));
				checkoutConstraints.gridy = 1;
				checkoutPanel.add(placeInLineLabel,checkoutConstraints);
				
				
				JPanel orderSummaryPanel = new JPanel();
				checkoutConstraints.ipadx = 200;
				checkoutConstraints.ipady = 300;
				orderSummaryPanel.setBorder(BorderFactory.createTitledBorder("Summary"));
				checkoutConstraints.gridy = 2; 
				checkoutConstraints.fill = GridBagConstraints.HORIZONTAL;
			
				checkoutPanel.add(orderSummaryPanel,checkoutConstraints);
				
				frame.add(checkoutPanel);
				
				
			}
		});
		
        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.ipadx = 20;
        constraints.ipady = 20;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.weighty = 0.3;
        homePanel.add(subtotal,constraints);
        
        /* -------------------------------------Payment InformationPanel---------------------------------- */
        
        constraints.gridx = -1;
        constraints.gridy = 0;
        constraints.ipadx = 100;
        constraints.ipady = 100;
        constraints.anchor = GridBagConstraints.FIRST_LINE_END;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weighty = 0.2;
        PaymentPanel.add( PaymentButton);
        homePanel.add( PaymentPanel, constraints);
       
        PaymentButton.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		Payment();
        	}
        });
	

		
		/* -------------------------------------- Coupon Panel ------------------------------------- */
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.anchor = GridBagConstraints.LINE_START;
		constraints.ipadx = 10;
		constraints.weightx = 0.2;
		constraints.weighty = 0.2;
		
		couponPanel.setSize(250, 600);
		couponPanel.setLocation(50,200);
		couponPanel.setBorder(BorderFactory.createTitledBorder("Coupons"));
		homePanel.add(couponPanel,constraints);
		
		couponTitle.setSize(150,30);
		couponTitle.setLocation(125, 10);
		couponTitle.setHorizontalAlignment(JLabel.CENTER);
		couponPanel.add(couponTitle);
		
		couponInfo.setSize(250,30);
		couponInfo.setLocation(75, 125);
		couponInfo.setHorizontalAlignment(JLabel.CENTER);
		couponPanel.add(couponInfo);
		
		
		constraints.gridy = 2;
		picturePanel.setPreferredSize(new Dimension(200,200));
		homePanel.add(picturePanel,constraints);
		/* ---------------------------------------------------------------------------------------- */
		
		
		/* --------------------------------------- Menu Panel ------------------------------------- */
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.gridheight = 1;
		constraints.weighty = 0.5;
		constraints.ipadx = 300;
		constraints.ipady = 300;
		constraints.insets = new Insets(20,20,20,20);
		
		menuPanel.setSize(1170,500);
		menuPanel.setLocation(350, 300);
		menuPanel.setLayout(new FlowLayout());
		menuPanel.setBorder(BorderFactory.createTitledBorder("MENU"));
		menuPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);		//adds objects in from left to right
		homePanel.add(menuPanel,constraints);
		
		/* --------------------------------------------------------------------------------------- */
		
		// execute create menu
		renderMenu(currentUser);
	}
	
	
	// create menu should read the CSV file with food items and then add to menu
	private void renderMenu(Customer currentUser) {
		// while there are still lines to read food items
			// read the food item and add it to the array
		
		// for each food item in the array
			// create respective labels and add to the menu, dynamically adds menu items
		menuPanel.removeAll();
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridy = 2;
		c.weighty = 0.1;
		c.fill = GridBagConstraints.NONE;
		
		menuItems.forEach((FoodItem) -> {
			BufferedImage pic = null;
			try {
				pic = ImageIO.read(this.getClass().getResource(FoodItem.getName() + ".jpg"));
				System.out.println(FoodItem.getName() + ".jpg");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			ImageIcon imageIcon = new ImageIcon(pic);
			Image image = imageIcon.getImage();
			Image scaledImg = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
			imageIcon = new ImageIcon(scaledImg);
			JLabel picture = new JLabel(imageIcon);
			JFrame pictureFrame = new JFrame();
			pictureFrame.setSize(300,300);
			pictureFrame.setBounds(650,350,300,250);
			
			JButton newItem = new JButton();
			newItem.setLayout(new FlowLayout());

			JLabel newLabel = new JLabel(FoodItem.getName());
			JLabel newPrice = new JLabel(String.valueOf(FoodItem.getPrice()));
			newItem.setSize(100,100);
			newItem.add(newLabel);
			newItem.add(newPrice);
			
			// Hover item functionality to display food information
			newItem.addMouseListener(new MouseAdapter() {
				JPanel informationBox = new JPanel();
				JLabel information = new JLabel(FoodItem.getDescription() + " | Prep Time: " + FoodItem.getPrepTime() + " Minutes");
				public void mouseEntered(java.awt.event.MouseEvent evt) {
					c.gridx = 1;
					informationBox.add(information);
					homePanel.add(informationBox,c);
					pictureFrame.add(picture);
					pictureFrame.setVisible(true);
					homePanel.revalidate();
					homePanel.repaint();
				}
				public void mouseExited(java.awt.event.MouseEvent evt) {
					homePanel.remove(informationBox);
					pictureFrame.dispose();
					homePanel.revalidate();
					homePanel.repaint();
				}
			});

			// add to cart listener functionality
			newItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// add the food item to the current user's cart
					currentUser.addItem(FoodItem);
					
					// this is just printing it in the console so we can debug
					currentUser.getOrdersArr()[currentUser.getNumOfOrders()].printOrder();
					
					// update the cart GUI
					renderCart(currentUser);
				}
			});
			menuPanel.add(newItem);
		});
	}
	
	private void renderCart(Customer currentUser) {
		cartPanel.removeAll();
		cartPanel.repaint();
		currentUser.getOrdersArr()[currentUser.getNumOfOrders()].getCart().forEach((FoodItem) -> {
			JButton cartItem = new JButton("[x]  " + FoodItem.getName() + " " + FoodItem.getPrice());

			cartItem.setAlignmentX(Component.CENTER_ALIGNMENT);
			cartPanel.add(cartItem,BorderLayout.PAGE_END);
			cartPanel.revalidate();	
			
			subtotal.setText("Total: $" + String.valueOf(currentUser.getOrdersArr()[currentUser.getNumOfOrders()].getTotalPrice()));
			
			cartItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					currentUser.getOrdersArr()[currentUser.getNumOfOrders()].removeFromOrder(FoodItem);
					cartPanel.remove(cartItem);
					cartPanel.revalidate();
					cartPanel.repaint();
					subtotal.setText("Total: $" + String.valueOf(currentUser.getOrdersArr()[currentUser.getNumOfOrders()].getTotalPrice()));
				}
			});
			cartPanel.repaint();
		});
	}
	
	private void login()
	{
		loginFrame.setBounds(100, 100, 450, 300);
		loginFrame.pack();
		loginFrame.setSize(500,600);
		loginFrame.setVisible(true);
		JPanel loginFields = new JPanel();
		JLabel newLogin = new JLabel("LOGIN");
		
		JLabel userLabel = new JLabel("User:");
		userLabel.setBounds(10,20,80,25);
		loginFields.add(userLabel);
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(10, 50, 80, 25);
		loginFields.add(passwordLabel);
		
		JTextField usernameField = new JTextField(25);
		usernameField.setBounds(10,20,80,25);
		
		JTextField passwordField = new JTextField(25);
		passwordField.setBounds(10,50,80,25);
		
		JButton enter = new JButton("Enter");
		loginFrame.add(loginFields);
		loginFields.add(usernameField);
		loginFields.add(passwordField);
		loginFields.add(enter);
		
		// we need to make a new customer given the username and password options
		
		enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentUsername = usernameField.getText();
				currentUserpassword = passwordField.getText();
				Customer newCustomer = new Customer(currentUsername,currentUserpassword);
				
				frame.dispose();
				loginFrame.dispose();
				renderCart(newCustomer);
				initialize(newCustomer);
			}
		});
	}
	
	//payment information
	private void Payment()
	{
		PaymentFrame = new JFrame("Payment Information");
		PaymentFrame.setBounds(100, 100, 450, 300);
		PaymentFrame.pack();
		PaymentFrame.setSize(500,600);
		PaymentFrame.setVisible(true);
		JPanel PaymentPanel = new JPanel();
		JLabel newPayment = new JLabel("PAY");
		JTextField address = new JTextField(25);
		JTextField card = new JTextField(25);
		JTextField coupon = new JTextField(25);
		JButton enter = new JButton("Enter");
		PaymentFrame.add(PaymentPanel);
		PaymentPanel.add(address);
		PaymentPanel.add(card);
		PaymentPanel.add(coupon);
		PaymentPanel.add(enter);
	}
	
}
