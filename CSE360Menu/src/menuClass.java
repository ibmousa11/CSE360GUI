import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class menuClass extends JFrame{
	
	

	
	public static void main(String[] args) {
		
		Owner owner = new Owner();
		
		menuClass menu = new menuClass();

	}
	
	public menuClass() {
		setSize(1920, 1080);
		setTitle("SubZilla");
		setVisible(true);
		setLayout(null);
		
		//creating the title
		JLabel title = new JLabel("SubZilla");
		title.setSize(290, 70);
		title.setFont(new Font("Impact", Font.PLAIN, 80));
		add(title);
		title.setLocation(815, 30);
		
		
		//creating the view cart button
		JButton viewCartButton = new JButton("View Cart");
		viewCartButton.setSize(100,50);
		viewCartButton.setLocation(1700, 800);
		add(viewCartButton);
		
		//creating the coupon info panel
		JPanel couponPanel = new JPanel();
		couponPanel.setSize(400, 300);
		couponPanel.setLocation(1400,300);
		couponPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		add(couponPanel);
		
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
		
		
		//creating the menu section
		JPanel menuPanel = new JPanel();			//creates a panel with two columns and infinite rows
		menuPanel.setLayout(new GridLayout(1,1));
		menuPanel.setSize(400,500);
		menuPanel.setLocation(50, 300);
		menuPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		menuPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);		//adds objects in from left to right
		add(menuPanel);
		
		//adding menu items into the menu
		Vector<String> menuItems = new Vector<String>(1);
		menuItems.add("Beef and Cheese");
		JLabel firstItem = new JLabel(menuItems.get(0));
		firstItem.setSize(150,30);
		menuPanel.add(firstItem);
		
		menuItems.add("Buffalo Chicken");
		JLabel secondItem = new JLabel(menuItems.get(1));
		secondItem.setSize(150,30);
		menuPanel.add(secondItem);
		
//		JButton hello = new JButton("hello");
//		hello.setSize(30,30);
//		menuPanel.add(hello);
		
		
		 
		
	}
}
