package DandB;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Page1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Page1 window = new Page1();
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
	public Page1() {
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
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JLabel lblNewLabel = new JLabel("Would you like to \r\ngo");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
		lblNewLabel.setBounds(37, 36, 347, 54);
		frame.getContentPane().add(lblNewLabel);
		
		JButton yes = new JButton("Yes");
		yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent yes) {
				Page2 window = new Page2();
				frame.setVisible(false);
			}
		});
		yes.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		yes.setBounds(163, 151, 89, 23);
		frame.getContentPane().add(yes);
		
		JButton no = new JButton("No");
		no.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Page2 window = new Page2();
				frame.setVisible(false);
			}
		});
		no.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		no.setBounds(163, 185, 89, 23);
		frame.getContentPane().add(no);
		
		JLabel lblNewLabel_1 = new JLabel("First?");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
		lblNewLabel_1.setBounds(141, 101, 122, 39);
		frame.getContentPane().add(lblNewLabel_1);
	}

	
}
