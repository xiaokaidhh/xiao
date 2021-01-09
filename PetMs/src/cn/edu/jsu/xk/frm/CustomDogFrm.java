package cn.edu.jsu.xk.frm;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import cn.edu.jsu.xk.dao.BuyPetTxt;
import cn.edu.jsu.xk.dao.MypetTxt;
import cn.edu.jsu.xk.dao.OpreationDao;
import cn.edu.jsu.xk.vo.TableCatModel;
import cn.edu.jsu.xk.vo.TableDogModel;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class CustomDogFrm extends JFrame {
	private DefaultTableModel model;
	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;
	         String username;


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
					CustomDogFrm frame = new CustomDogFrm();
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
	public CustomDogFrm() throws SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1071, 732);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 10, 971, 285);
		contentPane.add(scrollPane);
		
		model=new TableDogModel().gettableDogdata();
		table = new JTable(model);
		scrollPane.setViewportView(table);
		
		
		btnNewButton = new JButton("\u8D2D\u4E70");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int row=table.getSelectedRow();
				if(row!=-1) {
					
				int selected = (int)table.getValueAt(row,0); 
				
				try {
					new OpreationDao().DeleteDog(selected);
					table = new JTable(new TableDogModel().gettableDogdata());
					scrollPane.setViewportView(table);
					
					new BuyPetTxt().buy(row, model,username);//购买宠物写进文档保存
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				}
				
			}
		});
		btnNewButton.setBounds(518, 424, 99, 41);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u67E5\u770B");
		btnNewButton_1.addActionListener(new ActionListener() {
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
		btnNewButton_1.setBounds(356, 424, 114, 41);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setIcon(new ImageIcon("source/70.png"));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					table.setModel(new TableDogModel().gettableDogdata());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			
		});
		btnNewButton_4.setBounds(707, 424, 48, 41);
		contentPane.add(btnNewButton_4);
		
	
		
		
		
		
		
		
	}
}
