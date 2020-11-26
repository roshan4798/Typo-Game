package console;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Console extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Console frame = new Console("as");
					frame.setVisible(true);  //for running individually
					frame.setTitle("Typing S/W PRO");
					frame.getContentPane().setLayout(new BorderLayout());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	

	
	
	
	
	/**
	 * Create the frame.
	 */
	String uname = "";
	
	JTextField gmax = new JTextField("0");
	Clip c;
	public Console(String uname) {
		this.uname= uname;
		
		
		//background music
		String f = "E:\\java\\eclipse\\TypingSw\\coffin.wav";
	
		try {
		File file= new File(f);
		AudioInputStream a = AudioSystem.getAudioInputStream(file);
		c = AudioSystem.getClip();
		c.open(a);
		c.start();
		c.loop(c.LOOP_CONTINUOUSLY);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		FloatControl gainControl = (FloatControl) c.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(-10.0f);
		


		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 875, 597);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
	
		JButton music = new JButton("");	
		music.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				c.stop();
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				
				c.start();
			}
		});
		music.setIcon(new ImageIcon(Console.class.getResource("/sound.png")));
		music.setBounds(400, 11, 33, 23);
		contentPane.add(music);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Write this Text");
		lblNewLabel_1.setBounds(22, 16, 258, 23);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(lblNewLabel_1);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 50, 839, 118);
		panel.setBackground(new Color(64, 224, 208));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel(" Type this to start.");
		lblNewLabel_2.setFont(new Font("Gill Sans MT", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel_2.setBounds(0, 11, 839, 96);
		panel.add(lblNewLabel_2);
		

		
		
		//Extracting text by calling TextExtracter
		TextExtracter t = null;
		try {
			t = new TextExtracter();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		JLabel lblNewLabel = new JLabel("Write Here \u2193");
		lblNewLabel.setBounds(20, 174, 157, 28);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(lblNewLabel);
		
		
		
		textField = new JTextField(" ");
		textField.setFont(new Font("Gill Sans MT", Font.BOLD | Font.ITALIC, 19));
		textField.setBounds(10, 207, 839, 140);
		textField.setForeground(new Color(25, 25, 112));
		textField.setBackground(new Color(0, 255, 204));
		contentPane.add(textField);
		textField.setColumns(10);
		

		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(177, 383, 478, 92);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		TypingSpeedLogic ob = new TypingSpeedLogic();
		JLabel lblNewLabel_3 = new JLabel(ob.returnresult()+" wpm is your typing speed");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Stencil", Font.PLAIN, 22));
		lblNewLabel_3.setBounds(10, 11, 458, 50);
		panel_1.add(lblNewLabel_3);
		
		
		
		JLabel MaxSpeed = new JLabel("");
		MaxSpeed.setHorizontalAlignment(SwingConstants.CENTER);
		MaxSpeed.setFont(new Font("Stencil", Font.PLAIN, 17));
		MaxSpeed.setBounds(0, 67, 478, 25);
		panel_1.add(MaxSpeed);
		

		
		int arr[] = new int[50];
	
		
		TypingSpeedLogic t1 = new TypingSpeedLogic();
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.setBounds(680, 402, 144, 33);
		btnNewButton.addActionListener(new ActionListener() {
			int totalwords = 0;
			long start;
			int max = 0;
			int i = -1;
			public void actionPerformed(ActionEvent e) {
				
				if(textField.getText().equals(" Type this to start."))
						{
							start = (System.currentTimeMillis()/1000);
							TextExtracter z = null;
							try {
								z = new TextExtracter();
							} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							String res = z.getText();
							lblNewLabel_2.setText(res);
							panel.add(lblNewLabel_2);
							textField.setText(" ");
							
						}
				else if(textField.getText().equals(lblNewLabel_2.getText()))
				{	
					totalwords = textField.getText().length();
					t1.getwords(totalwords);
					TextExtracter z = null;
					try {
						z = new TextExtracter();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					String res = z.getText();
					lblNewLabel_2.setText(res);
					panel.add(lblNewLabel_2);
					

					
					
					textField.setText(" ");
					long stop = (System.currentTimeMillis()/1000);
					long elapsed=(stop - start);
	
					t1.gettime(elapsed);
					int x =(int) t1.returnresult();
					//put this into database along with the id used to log in
					arr[++i] = x;
					
					max = arr[0];
					for(int i=0;i<arr.length;i++)
					{
						if(max<arr[i])
						{
							max = arr[i];
						}
					}
					lblNewLabel_3.setText("You are typing at "+x+" wpm");
					
					
				
					//to get this local variable into the dbms call
				
					gmax.setText(""+max);
					panel_1.add(lblNewLabel_3);;
					start = (System.currentTimeMillis()/1000);
					}
				else
				{
					JOptionPane.showMessageDialog(null, "Something is not RIGHT");
				}
			MaxSpeed.setText("Max speed = "+max+" wpm");
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.add(btnNewButton);
		
		

		
		JLabel lblNewLabel_4 = new JLabel("1.  Your maximum typing speed will be recorded and saved in our database.");
		lblNewLabel_4.setFont(new Font("Comic Sans MS", Font.ITALIC, 11));
		lblNewLabel_4.setBounds(296, 478, 412, 28);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("2.  To access that Go to Admin tab at Login page-> Enter Credentials->Click on Stats.");
		lblNewLabel_5.setFont(new Font("Comic Sans MS", Font.ITALIC, 11));
		lblNewLabel_5.setBounds(294, 517, 448, 25);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel();
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_6.setIcon(new ImageIcon(Console.class.getResource("/icon.png")));
		lblNewLabel_6.setBounds(20, 353, 147, 194);
		contentPane.add(lblNewLabel_6);
		
		boolean flag = false;
		JButton DBMS = new JButton("Save Data");
		DBMS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//database logic to record max speed
				if(flag == false) {
				DBMS db  = new DBMS();
				int z = Integer.parseInt(gmax.getText().trim());
				System.out.println("uname and z "+uname+" "+gmax.getText());
				try {
					
					db.insertdata(uname,z);
					c.stop();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				final boolean flag = true;
				}
			}
		});
		DBMS.setFont(new Font("Times New Roman", Font.BOLD, 20));
		DBMS.setBounds(717, 11, 132, 30);
		contentPane.add(DBMS);
		

	
		
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}

