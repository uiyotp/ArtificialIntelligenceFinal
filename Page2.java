package DandB;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Page2 {
	boolean practiceMode =true;

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Page2 window = new Page2();
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
	public Page2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(100, 100, 450, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel("Would you like to use");
		lblNewLabel.setBounds(32, 22, 360, 72);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
		frame.getContentPane().add(lblNewLabel);
		
		JButton yes1 = new JButton("Yes");
		yes1.setBounds(170, 145, 89, 23);
		yes1.addActionListener(new ActionListener() {
//***************************************************************************
// Practice Yes Button
//***************************************************************************
			public void actionPerformed(ActionEvent yes) {
			PlayGame.Pmode("yes");
			MainGame window = new MainGame();
			frame.setVisible(false);
			}
		});
		yes1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		frame.getContentPane().add(yes1);
		
		JLabel lblNewLabel_1 = new JLabel("Practice Mode?");
		lblNewLabel_1.setBounds(85, 79, 326, 72);
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton no1 = new JButton("No");
		no1.setBounds(170, 179, 89, 23);
		no1.addActionListener(new ActionListener() {
//***************************************************************************
// Practice Yes Button
//***************************************************************************
			public void actionPerformed(ActionEvent no) {
			PlayGame.Pmode("no");
			MainGame window = new MainGame();
			frame.setVisible(false);
			}
		});
		no1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		frame.getContentPane().add(no1);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
