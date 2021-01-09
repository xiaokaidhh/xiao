package cn.edu.jsu.xk.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;

public class LookFrm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LookFrm frame = new LookFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LookFrm() {
		
	}
//	String name,String sex,String color,String age,String date
	public LookFrm(String name,String sex,String color,String age,String date) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(497, 10, 550, 662);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u6635\u79F0\uFF1A");
		lblNewLabel.setBounds(43, 302, 55, 28);
		contentPane.add(lblNewLabel);
		
		JLabel looklblname = new JLabel(name);
		looklblname.setForeground(Color.BLACK);
		looklblname.setBounds(99, 294, 79, 36);
		contentPane.add(looklblname);
		
		JLabel lblNewLabel_2 = new JLabel("\u989C\u8272\uFF1A");
		lblNewLabel_2.setBounds(43, 364, 45, 28);
		contentPane.add(lblNewLabel_2);
		
		JLabel looklblcolor = new JLabel(color);
		looklblcolor.setBounds(99, 360, 79, 36);
		contentPane.add(looklblcolor);
		
		JLabel lblNewLabel_3 = new JLabel("\u6027\u522B:");
		lblNewLabel_3.setBounds(224, 302, 55, 28);
		contentPane.add(lblNewLabel_3);
		
		JLabel looklblsex = new JLabel(sex);
		looklblsex.setBounds(290, 294, 79, 36);
		contentPane.add(looklblsex);
		
		JLabel lblNewLabel_4 = new JLabel("»»∂»:");
		lblNewLabel_4.setBounds(234, 364, 45, 28);
		contentPane.add(lblNewLabel_4);
		
		JLabel looklblage = new JLabel(age);
		looklblage.setBounds(290, 356, 79, 36);
		contentPane.add(looklblage);
		
		JLabel lblNewLabel_5 = new JLabel("\u6DFB\u52A0\u65E5\u671F\uFF1A");
		lblNewLabel_5.setBounds(43, 418, 66, 32);
		contentPane.add(lblNewLabel_5);
		
		JLabel looklbldate = new JLabel(date);
		looklbldate.setBounds(167, 414, 143, 36);
		contentPane.add(looklbldate);
	}
}
