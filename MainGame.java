package DandB;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainGame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGame window = new MainGame();
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
	public MainGame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		JButton TopLeft = new JButton("");
		TopLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			TopLeft.setBackground(Color.RED);
			TopLeft.setEnabled(false);
			}
		});
		TopLeft.setBounds(61, 23, 150, 12);
		frame.getContentPane().add(TopLeft);
		
		JButton TopRight = new JButton("");
		TopRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TopRight.setBackground(Color.RED);
				TopRight.setEnabled(false);
			}
		});
		TopRight.setBounds(221, 23, 150, 12);
		frame.getContentPane().add(TopRight);
		
		JButton RightTop = new JButton("");
		RightTop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RightTop.setBackground(Color.RED);
				RightTop.setEnabled(false);
			}
		});
		RightTop.setBounds(369, 23, 14, 161);
		frame.getContentPane().add(RightTop);
		
		JButton MiddleTop = new JButton("");
		MiddleTop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MiddleTop.setBackground(Color.RED);
				MiddleTop.setEnabled(false);
				}
		});
		MiddleTop.setBounds(207, 23, 14, 161);
		frame.getContentPane().add(MiddleTop);
		
		JButton LeftTop = new JButton("");
		LeftTop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LeftTop.setBackground(Color.RED);
				LeftTop.setEnabled(false);
			}
		});
		LeftTop.setBounds(48, 23, 14, 161);
		frame.getContentPane().add(LeftTop);
		
		JButton MiddleLeft = new JButton("");
		MiddleLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MiddleLeft.setBackground(Color.RED);
				MiddleLeft.setEnabled(false);
			}
		});
		MiddleLeft.setBounds(61, 172, 150, 12);
		frame.getContentPane().add(MiddleLeft);
		
		JButton MiddleRight = new JButton("");
		MiddleRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MiddleRight.setBackground(Color.RED);
				MiddleRight.setEnabled(false);
			}
		});
		MiddleRight.setBounds(221, 172, 150, 12);
		frame.getContentPane().add(MiddleRight);
		
		JButton BottomLeft = new JButton("");
		BottomLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BottomLeft.setBackground(Color.RED);
				BottomLeft.setEnabled(false);
			}
		});
		BottomLeft.setBounds(61, 326, 150, 12);
		frame.getContentPane().add(BottomLeft);
		
		JButton LeftBottom = new JButton("");
		LeftBottom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LeftBottom.setBackground(Color.RED);
				LeftBottom.setEnabled(false);
			}
		});
		LeftBottom.setBounds(48, 177, 14, 161);
		frame.getContentPane().add(LeftBottom);
		
		JButton MiddleBottom = new JButton("");
		MiddleBottom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MiddleBottom.setBackground(Color.RED);
				MiddleBottom.setEnabled(false);
			}
		});
		MiddleBottom.setBounds(207, 177, 14, 161);
		frame.getContentPane().add(MiddleBottom);
		
		JButton RightBottom = new JButton("");
		RightBottom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RightBottom.setBackground(Color.RED);
				RightBottom.setEnabled(false);
			}
		});
		RightBottom.setBounds(369, 177, 14, 161);
		frame.getContentPane().add(RightBottom);
		
		JButton BottomRight = new JButton("");
		BottomRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BottomRight.setBackground(Color.RED);
				BottomRight.setEnabled(false);
			}
		});
		BottomRight.setBounds(221, 326, 150, 12);
		frame.getContentPane().add(BottomRight);
	}

}
