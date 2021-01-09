package cn.edu.jsu.xk.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.jsu.xk.dao.MypetTxt;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuyRecordFrm extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private String username;
	private JButton btnNewButton;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuyRecordFrm frame = new BuyRecordFrm();
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
	public BuyRecordFrm() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 881, 708);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(77, 52, 689, 161);
		contentPane.add(scrollPane);
		
		table = new JTable(new MypetTxt().getMypet(username));   //
		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("\u8BE6\u7EC6\u4FE1\u606F");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int row=table.getSelectedRow();
				if(row!=-1) {
			try{
		LookFrm lf=	new LookFrm((String)table.getValueAt(row, 1),(String)table.getValueAt(row, 2),(String)table.getValueAt(row, 3),String.valueOf(table.getValueAt(row, 4)),(String)table.getValueAt(row, 5));
                 lf.setVisible(true);
                 
			}catch (Exception e1) {
				e1.printStackTrace();
			}
			}
			
			}
		});
		btnNewButton.setBounds(77, 287, 97, 23);
		contentPane.add(btnNewButton);
	}
}
