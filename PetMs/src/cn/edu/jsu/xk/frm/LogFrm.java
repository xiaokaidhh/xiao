package cn.edu.jsu.xk.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.jsu.xk.vo.Check;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

public class LogFrm extends JFrame {

	private JPanel contentPane;
	private JTextField txtzh;
	private JLabel lblzhh;
	private JLabel lblmmm;
	private JButton btnNewButton_1;
	private JPasswordField txtmm;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogFrm frame = new LogFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
  public boolean checkzh(){
		if(txtzh.getText().length()==0) {
		lblzhh.setText("请输入账号后再登录!");
		return false;	
		}
		lblzhh.setText(" ");
		return true;
	}
  public boolean checkmm(){
		if(txtmm.getText().length()==0) {
		lblmmm.setText("请输入密码后再登录!");
		return false;	
		}
		lblmmm.setText(" ");
		return true;
	}

	/**
	 * Create the frame.
	 */
	public LogFrm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 534, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblzh = new JLabel();
		lblzh.setText("\u8D26\u53F7\uFF1A");
		lblzh.setBounds(117, 112, 48, 48);
		contentPane.add(lblzh);
		
		txtzh = new JTextField();
		txtzh.setBounds(176, 119, 192, 36);
		contentPane.add(txtzh);
		
		
		txtmm = new JPasswordField();
		txtmm.setBounds(178, 187, 192, 36);
		contentPane.add(txtmm);
		
		
		JLabel lblmm = new JLabel();
		lblmm.setText("\u5BC6\u7801\uFF1A");
		lblmm.setBounds(117, 183, 48, 48);
		contentPane.add(lblmm);
		
		JCheckBox checkb = new JCheckBox("\u7BA1\u7406\u5458");
		checkb.setBounds(158, 244, 107, 23);
		contentPane.add(checkb);
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag1=checkzh();
				if(flag1) {
				boolean flag2=checkmm();
				if(flag2) {
					
					try {
						if(new Check().getchecklog(txtzh.getText(),txtmm.getText())&&checkb.isSelected()){//得到账号和密码调用Check类进行验证     同时验证是否勾选管理员登录
							JOptionPane.showMessageDialog(null, "登录成功");
							dispose();
							FrmMain window = new FrmMain();    //管理员窗口
							window.frame.setVisible(true);
							
						}
						else if(new Check().checkCustomlog(txtzh.getText(),txtmm.getText())&&!checkb.isSelected()){//没有勾选挂管理员 验证后调用用户窗口
							
							FrMain fr=new FrMain();	//用户主窗口
							fr.setUsername(txtzh.getText());//得到用户名
							fr.frame.setVisible(true);
							
							
//							 CustomFrm  cf=	new CustomFrm();//调出顾客操作界面
//							 cf.setUsername(txtzh.getText());
//							 cf.setVisible(true);
									 
						}
						else JOptionPane.showMessageDialog(null, "账户名或密码错误");
					} catch (HeadlessException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				}
			}
		});
		btnNewButton.setBounds(281, 267, 113, 26);
		contentPane.add(btnNewButton);
		
		lblzhh = new JLabel("");
		lblzhh.setForeground(Color.RED);
		lblzhh.setBounds(388, 125, 122, 23);
		contentPane.add(lblzhh);
		
		lblmmm = new JLabel("");
		lblmmm.setForeground(Color.RED);
		lblmmm.setBounds(388, 200, 122, 26);
		contentPane.add(lblmmm);
		
		btnNewButton_1 = new JButton("注册");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				new RegisterFrm().setVisible(true);//调用户注册界面;
				
				
			}
		});
		btnNewButton_1.setBounds(158, 267, 113, 26);
		contentPane.add(btnNewButton_1);
		
		
	}
}
