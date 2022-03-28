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
		//owner.initializeMenu();			//I get an error every time I add stuff to the menu and prices array
		
		//Customizing the frame that holds the menu
		
		JLabel item = new JLabel("Buffalo Chicken");
//		JLabel item0 = new JLabel(owner.menu[0]);
//		JLabel item1 = new JLabel(owner.menu[1]);
//		JLabel item2 = new JLabel(owner.menu[2]);
//		JLabel price0 = new JLabel(Double.toString(owner.prices[0]));
//		JLabel price1 = new JLabel(Double.toString(owner.prices[1]));
//		JLabel price2 = new JLabel(Double.toString(owner.prices[2]));
		
		menuFrame.add(item);
		
		
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
