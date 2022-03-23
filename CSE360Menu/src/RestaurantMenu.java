import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class RestaurantMenu {

	private JFrame frame;
	private JButton button;

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
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(480,640);
        frame.setVisible(true);
        
        // create a Panel that sits inside the frame
        JPanel panel = new JPanel();
        panel.setSize(100,50);
        frame.add(panel);
        

        // creating a user object with name Eric
		User user = new User();
		user.setName("Eric");
		
		
        // create a button, this will sit inside the panel
		button = new JButton("I am a button");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,user.getName());
			}
		});
		
		button.setBounds(30, 30, 10, 10);
		
		panel.add(button);
	}

}
