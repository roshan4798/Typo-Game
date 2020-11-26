package console;

import java.awt.Color;
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class AdminInfo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminInfo frame = new AdminInfo();
					frame.setVisible(true);  //for running individually
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public AdminInfo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 473, 306);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Details");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Stencil", Font.PLAIN, 23));
		lblNewLabel.setBounds(135, 28, 203, 39);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Gill Sans MT", Font.ITALIC, 17));
		textField.setBounds(251, 88, 180, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Gill Sans MT", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(152, 86, 89, 28);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Gill Sans MT", Font.ITALIC, 16));
		textField_1.setBounds(251, 137, 180, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Gill Sans MT", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(152, 137, 89, 25);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Log in");
		btnNewButton.setFont(new Font("Gill Sans MT", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().equals("Nitin") &&textField_1.getText().equals("N"))
				{
					Admin a =  new Admin();
					a.setVisible(true);
					a.setVisible(true);
					a.setResizable(false);
					a.setLocationRelativeTo(null);
					a.setTitle("Typing S/W PRO");
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Invalid Username or Password");
				}
			}
		});
		btnNewButton.setBounds(342, 197, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalTextPosition(SwingConstants.LEFT);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3.setIcon(new ImageIcon(AdminInfo.class.getResource("/admin.png")));
		lblNewLabel_3.setBounds(0, 0, 457, 267);
		contentPane.add(lblNewLabel_3);
	}
}
