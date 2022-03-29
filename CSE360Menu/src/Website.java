import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Website extends JFrame{
	
	

	
	public static void main(String[] args) {

		Website website = new Website();

	}
	
	public Website() {
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
		
		menuPanel.setSize(400,500);
		menuPanel.setLocation(50, 300);
		//menuPanel.setLayout(new GridLayout(2,2,0,0));
		menuPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		//menuPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);		//adds objects in from left to right
		add(menuPanel);
		
		
		//adding menu items into the menu
		ArrayList<FoodItem> menuItems = new ArrayList<FoodItem>();
		menuItems.add("Beef and Cheese");
		JLabel firstItem = new JLabel(menuItems.get(0));
		firstItem.setSize(150,30);
		firstItem.setLocation(10,10);
		menuPanel.add(firstItem);
		
		menuItems.add("Buffalo Chicken");
		JLabel secondItem = new JLabel(menuItems.get(1));
		secondItem.setSize(100,100);
		secondItem.setLocation(10,100);
		menuPanel.add(secondItem);
		
		try{
			ImageIcon img = new ImageIcon(getClass().getResource("beefAndCheesePic.jpg"));
			JLabel display = new JLabel(img);
			//display.setSize(300, 100);
			menuPanel.add(display);
		}
		catch(Exception e){
			System.out.println("Image cannot be found");
		}
		


	

	
	
	}
}
