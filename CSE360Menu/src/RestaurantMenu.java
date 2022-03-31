import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import java.awt.*;
import javax.swing.*;

public class RestaurantMenu {

	private JFrame frame;
	private JFrame loginFrame;
	private JPanel homePanel;
	private JPanel couponPanel;
	private JPanel menuPanel;
	private ArrayList<FoodItem> menuItems;
	private Boolean enterBool;

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
		menuItems = new ArrayList<FoodItem>();
		
		//what we can do is before we use initialize() we present user with login
		//window that will take info and process it before we even open the menu
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		loginMenu();
		
		}
	// create menu should read the CSV file with food items and then add to menu
	private void renderMenu() {
		// while there are still lines to read food items
			// read the food item and add it to the array
		
		// for each food item in the array
			// create respective labels and add to the menu, dynamically adds menu items
		menuItems.forEach((FoodItem) -> {
			JPanel newItem = new JPanel();
			JLabel newLabel = new JLabel(FoodItem.getName());
			JLabel newPrice = new JLabel(String.valueOf(FoodItem.getPrice()));
			newItem.setSize(150,30);
			newItem.add(newLabel);
			newItem.add(newPrice);
			menuPanel.add(newItem);
		});
	}
	private void loginMenu() {
		
		loginFrame = new JFrame("Login");
		loginFrame.setBounds(100, 100, 450, 300);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.pack();
		loginFrame.setSize(500,600);
		loginFrame.setVisible(true);
		JPanel loginPanel = new JPanel();
		JLabel newLogin = new JLabel("LOGIN");
		JTextField username = new JTextField(25);
		JTextField password = new JTextField(25);
		JButton enter = new JButton("Enter");
		loginFrame.add(loginPanel);
		loginPanel.add(username);
		loginPanel.add(password);
		
		username.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = username.getText();
				newLogin.setText(input);	
			}
		});
		password.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = password.getText();
				newLogin.setText(input);	
			}
		});
		loginPanel.add(enter);
		enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = username.getText() + " " + password.getText();
				newLogin.setText(input);	
				enterBool = true;
				loginFrame.dispose();
				/* ---------------------------------- Window Frame -------------------------------------- */
				// create a frame, this is the window of the application
				frame = new JFrame("SubZilla");
				frame.setBounds(100, 100, 450, 300);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        frame.pack();
		        frame.setSize(1920,1080);
		        frame.setVisible(true);
		        /* --------------------------------------------------------------------------------------- */
		      
		        
		        
		        /* ---------------------------------- Home Panel ----------------------------------------- */
		        
		        // create a Panel that sits inside the frame
		        homePanel = new JPanel();
		        homePanel.setLayout(null);
		        homePanel.setSize(1920,1080);
		        frame.add(homePanel);
		        
		        //creating the title
				JLabel title = new JLabel("SubZilla");
				title.setSize(290, 70);
				title.setFont(new Font("Impact", Font.PLAIN, 80));
				homePanel.add(title);
				title.setLocation(815, 30);
				
				/* ----------------------------------------------------------------------------------------- */
				
				
				
				/* -------------------------------------- Cart Button -------------------------------------- */
				JButton viewCartButton = new JButton("View Cart");
				viewCartButton.setSize(100,50); 
				viewCartButton.setLocation(1700, 900);
				homePanel.add(viewCartButton);
				/* ----------------------------------------------------------------------------------------- */

				
				/* -------------------------------------- Coupon Panel ------------------------------------- */
				couponPanel = new JPanel();
				couponPanel.setSize(400, 600);
				couponPanel.setLocation(1400,200);
				couponPanel.setBorder(BorderFactory.createLineBorder(Color.black));
				homePanel.add(couponPanel);
				
				JLabel couponTitle = new JLabel("Rewards Program");
				couponTitle.setSize(150,30);
				couponTitle.setLocation(125, 10);
				couponTitle.setHorizontalAlignment(JLabel.CENTER);
				couponPanel.add(couponTitle);
				
				JLabel couponInfo = new JLabel("BUY TEN SUBS, GET ONE FREE");
				couponInfo.setSize(250,30);
				couponInfo.setLocation(75, 125);
				couponInfo.setHorizontalAlignment(JLabel.CENTER);	//centers label inside of the label container
				couponPanel.add(couponInfo);
				/* ---------------------------------------------------------------------------------------- */
				
				
				/* --------------------------------------- Menu Panel ------------------------------------- */
				/*
				AutoCompleteDecorator decorator;
				JComboBox combobox;
				for (int i = menuItems.size(); i--;)
				combobox = new JComboBox(new Object[]{FoodItem.getName()});
				AutoCompleteDecorator.decorate(combobox);
				menuPanel.add(combobox);
				*/
				menuPanel = new JPanel();			//creates a panel with two columns and infinite rows
				menuPanel.setSize(400,500);
				menuPanel.setLocation(50, 300);
				
				
				//menuPanel.setLayout(new GridLayout(2,2,0,0));
				menuPanel.setBorder(BorderFactory.createLineBorder(Color.black));
				//menuPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);		//adds objects in from left to right
				homePanel.add(menuPanel);
				/* --------------------------------------- Search Bar -------------------------------------- */
				
				/*
				JPanel search = new JPanel();
				search.setSize(400,400);
				search.setLocation(50,350);
				search.setLayout(new FlowLayout());
				search.add(combobox);
				search.setVisible(true);
				*/
				

				
				/* ----------------------------------------------------------------------------------------- */

		        // creating a user object with name Eric
				User user = new User();
				user.setName("Eric");
				
				//creating owner object
				Owner owner = new Owner();
				owner.setName("I am the owner");
				owner.initializeMenu();			//I get an error every time I add stuff to the menu and prices array
				/* --------------------------------------------------------------------------------------- */
				
				menuItems.add(owner.createFoodItem("Beef and Cheese", 8.99));
				menuItems.add(owner.createFoodItem("Buffalo Chicken", 7.99));
				
				// execute create menu
				renderMenu();
				
		        // button listener template
				/*
				
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
				});*/
			}
		});
		
		loginPanel.add(newLogin);
		

	}
}
