package console;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Entered extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Entered frame = new Entered();
					frame.setVisible(true);  //for running individually
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	String uname= "";
	public void getuname(String uname)
	{
		this.uname = uname;
	}
  
	/**
	 * Create the frame.
	 */
	public Entered() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(0, 0, 520, 263);
		lblNewLabel_3.setIcon(new ImageIcon(Entered.class.getResource("/start.png")));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("INSTRUCTIONS");
		lblNewLabel_3.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel.setBounds(29, 28, 169, 46);
		
		JLabel lblNewLabel_2 = new JLabel("2. Result will be declared as you click the submit button to submit your response.");
		lblNewLabel_3.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(10, 142, 496, 40);
		
		JLabel lblNewLabel_1 = new JLabel("1.  Random text will pop up  at screen as you click the start button.");
		lblNewLabel_3.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 85, 444, 46);
		
		JButton btnNewButton = new JButton("Start The Game");
		lblNewLabel_3.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				Console c = new Console(uname);
				c.setVisible(true);
				c.setLocationRelativeTo(null);
				c.setTitle("Typing S/W PRO");
				c.setResizable(false);
				c.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,"Error occured while Loading the game "+e);
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(174, 196, 200, 40);
		
	
		
		
	}
}
