package console;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Frontend {

	private JFrame frame;
	private JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frontend window = new Frontend();
					window.frame.setVisible(true);
					window.frame.setResizable(false);
					window.frame.setLocationRelativeTo(null);
					window.frame.setTitle("Typing S/W PRO");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Frontend() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 502, 425);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Welcome to Typing-Tuts");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(87, 56, 310, 66);
		lblNewLabel.setFont(new Font("Gill Sans MT", Font.BOLD | Font.ITALIC, 23));
		frame.getContentPane().add(lblNewLabel);
		

		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Gill Sans MT", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(101, 146, 99, 30);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Gill Sans MT", Font.ITALIC, 15));
		textField.setBounds(222, 148, 181, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
	
		
		JButton btnNewButton = new JButton("Play");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String uname = textField.getText();
				boolean n = uname.contains("@gmail.com");
				if(uname.contains("yahoo.com") == true || n==true )
				{
					//send username to console class 
					Entered e = new Entered();
					e.getuname(uname);	
					e.setVisible(true);
					e.setResizable(false);
					e.setLocationRelativeTo(null);
					e.setTitle("Typing S/W PRO");
					 
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid Username");
				}
				
			}
		});
		btnNewButton.setBounds(314, 189, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("(Enter your email)");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(77, 171, 150, 14);
		frame.getContentPane().add(lblNewLabel_2);
		

		
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setMaximumSize(new Dimension(50, 50));
		lblNewLabel_3.setSize(new Dimension(900, 950));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(0, 21, 486, 365);
		lblNewLabel_3.setIcon(new ImageIcon(Frontend.class.getResource("/k.png")));
		frame.getContentPane().add(lblNewLabel_3);
		
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 486, 23);
		frame.getContentPane().add(menuBar);
		
		JMenu Admintab = new JMenu("Admin");
		Admintab.setFont(new Font("Gill Sans MT", Font.ITALIC, 13));
		menuBar.add(Admintab);
		
		JMenuItem AdminLogin = new JMenuItem("Admin Login");
		AdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminInfo a =  new AdminInfo();
				a.setVisible(true);
				a.setLocationRelativeTo(null);
				a.setResizable(false);
				a.setVisible(true);
				a.setTitle("Typing S/W PRO");
			}
		});
		AdminLogin.setFont(new Font("Gill Sans MT", Font.ITALIC, 13));
		Admintab.add(AdminLogin);
		
		
		
		JMenuItem Exit = new JMenuItem("Exit");
		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		Exit.setFont(new Font("Gill Sans MT", Font.ITALIC, 13));
		Admintab.add(Exit);
		
		
		
		JMenu HelpTab = new JMenu("Help");
		HelpTab.setFont(new Font("Gill Sans MT", Font.ITALIC, 13));
		menuBar.add(HelpTab);
		
		JMenuItem aboutUs = new JMenuItem("About Us");
		aboutUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"TypingSw for imporving typing speeds along with TypingSpeed Analyser to keep track of the progress from the beginning of your journey");
			}
		});
		aboutUs.setFont(new Font("Gill Sans MT", Font.ITALIC, 13));
		HelpTab.add(aboutUs);
		

		
	}
}
