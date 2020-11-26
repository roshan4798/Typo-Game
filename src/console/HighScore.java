package console;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.TextArea;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.Color;

public class HighScore extends JFrame {

	private JPanel contentPane;
	private final JLabel bgimage = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HighScore frame = new HighScore();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public HighScore() throws SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(bgimage);
		
		
		bgimage.setBounds(0, 0, 434, 261);
		bgimage.setIcon(new ImageIcon(HighScore.class.getResource("/highscore.png")));
		
		
		TextArea textArea = new TextArea("");
		textArea.setBackground(Color.LIGHT_GRAY);
		bgimage.add(textArea);
		textArea.setEditable(false);
		textArea.setFont(new Font("Gill Sans MT", Font.ITALIC, 14));
		textArea.setBounds(156, 108, 268, 143);
		
		JLabel lblNewLabel = new JLabel("High-Scores");
		bgimage.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Snap ITC", Font.BOLD | Font.ITALIC, 26));
		lblNewLabel.setBounds(204, 22, 230, 46);
		
		DBMS d = new DBMS();
		ArrayList<String> a = new ArrayList<String>();
		a = d.fetchdata();
		for(int i=0;i<a.size();i++)
		{
			if(i%2!=0)
			{
				textArea.setText(textArea.getText()+a.get(i)+"\n");
			}
			else 
			{
				textArea.setText(textArea.getText()+a.get(i)+"      MaxSpeed = ");
			}
		}
		
	}

}
