package cn.edu.jsu.xk.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.jsu.xk.dbc.DatabaseConnectionSql;
import cn.edu.jsu.xk.vo.Check;
import cn.edu.jsu.xk.vo.CustomReg;
import cn.edu.jsu.xk.vo.Regbiao;


import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class RegisterFrm extends JFrame {

	private JPanel contentPane;
	private JTextField rgtxtzh;
	private JTextField rgtxtmm;
	private JTextField rgtxtmm1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterFrm frame = new RegisterFrm();
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

	public RegisterFrm() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 601, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		rgtxtzh = new JTextField();
		rgtxtzh.setColumns(10);
		rgtxtzh.setBounds(167, 64, 221, 39);
		contentPane.add(rgtxtzh);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u8D26\u53F7\uFF1A");
		lblNewLabel.setBounds(73, 70, 115, 26);
		contentPane.add(lblNewLabel);
		
		rgtxtmm = new JTextField();
		rgtxtmm.setColumns(10);
		rgtxtmm.setBounds(167, 127, 221, 39);
		contentPane.add(rgtxtmm);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BF7\u8F93\u5165\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setBounds(73, 133, 115, 26);
		contentPane.add(lblNewLabel_1);
		
		rgtxtmm1 = new JTextField();
		rgtxtmm1.setColumns(10);
		rgtxtmm1.setBounds(167, 198, 221, 39);
		contentPane.add(rgtxtmm1);
		
		JLabel lblNewLabel_2 = new JLabel("\u518D\u6B21\u786E\u8BA4\u5BC6\u7801\uFF1A");
		lblNewLabel_2.setBounds(73, 204, 115, 26);
		contentPane.add(lblNewLabel_2);
		
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(rgtxtzh.getText().length()==0) {
				
			JOptionPane.showMessageDialog(null, "请输入账号");}
				else if(rgtxtmm.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "请输入密码");}
				else {
				 
				try {
//					boolean checkb1=new Check().getcheckbiao(rgtxtzh.getText(),rgtxtmm.getText(),rgtxtmm1.getText());
				     boolean checkb2=new Check().checkCustomname(rgtxtzh.getText(),rgtxtmm.getText(),rgtxtmm1.getText());
				
					if(checkb2) {
//					new Regbiao(rgtxtzh.getText(),rgtxtmm.getText());管理员注册
						new CustomReg().reg(rgtxtzh.getText(),rgtxtmm.getText());//顾客注册
						File file =new File("d:/mypet/"+rgtxtzh.getText()+".txt");//注册后生产相应用户文件保存购买的宠物
						file.createNewFile();
					       dispose();
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				}}
		});
		btnNewButton.setBounds(219, 303, 135, 39);
		contentPane.add(btnNewButton);
	}

}
