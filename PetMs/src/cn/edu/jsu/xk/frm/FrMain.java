package cn.edu.jsu.xk.frm;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import cn.edu.jsu.xk.vo.TableCatModel;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.sql.SQLException;

import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;

public class FrMain {

 JFrame frame;
 String username;
 

	public void setUsername(String username) {
	this.username = username;
}

	public String getUsername() {
		return username;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
		try {
			UIManager.setLookAndFeel(lookAndFeel);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrMain window = new FrMain();
					window.frame.setResizable(false);
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
	public FrMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);

		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Desktop\\7933\\b2.png"));
		frame.setTitle("\u5BA0\u7269\u7BA1\u7406\u7CFB\u7EDF");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);//������У���󻯿ɲ�ʹ��
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);//�������

		
		JDesktopPane desktopPane = new JDesktopPane() {
			@Override
			public void paintComponent(Graphics g) {//�ػ���屳��
				//����һ��δ��ʼ����ͼ��ͼ�꣬�ο�API
				ImageIcon icon=new ImageIcon("source/q1.jpg");
				//����ָ��ͼ���������ŵ��ʺ�ָ�������ڲ���ͼ��
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(),this);
			}
		};

		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		frame.getContentPane().add(menuBar, BorderLayout.NORTH);
		
		JMenu mnNewMenu = new JMenu("\u5BA0\u7269\u8D2D\u4E70");
		menuBar.add(mnNewMenu);
		
		JToolBar toolBar = new JToolBar();
	     toolBar.setBounds(0,0,(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),50);
	  
	     desktopPane.add(toolBar);
	     
	     JButton btnNewButton = new JButton("");
	     btnNewButton.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		
	     	try {
	     		CustomCatFrm cf=new CustomCatFrm(); //����è���û���������
	     		cf.setUsername(getUsername());     
	     		cf.setVisible(true);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	     		
	     	}
	     });
	     btnNewButton.setIcon(new ImageIcon("D:\\Desktop\\7933\\b2.png"));
	     toolBar.add(btnNewButton);
	     
	     toolBar.addSeparator(new Dimension(20,45));
	     
	     
	     
	     JButton btnNewButton_1 = new JButton("");
	     btnNewButton_1.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	   
				try {
					CustomDogFrm cf = new CustomDogFrm();	//�����û������������
					cf.setUsername(getUsername());      //�����û�ר������
	     		   cf.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	     		
	     		
	     	}
	     	
	     	
	     });
	     btnNewButton_1.setIcon(new ImageIcon("D:\\Desktop\\7933\\b1.png"));
	     toolBar.add(btnNewButton_1);
	     
	     toolBar.addSeparator(new Dimension(20,45));
	     
	     JButton btnNewButton_2 = new JButton("");
	     btnNewButton_2.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		
	     		BuyRecordFrm bs=	new BuyRecordFrm();  //�����¼����
	     		bs.setUsername(getUsername());
	     		bs.setVisible(true);
	     		
	     	}
	     });
	     btnNewButton_2.setIcon(new ImageIcon("source/66.png"));
	     toolBar.add(btnNewButton_2);
	     
	     toolBar.addSeparator(new Dimension(20,45));
	     
	     JButton btnNewButton_3 = new JButton("");
	     btnNewButton_3.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		
	     		
	     		
	     		try {
					new SplitLookFrm().setVisible(true);   //��ҳ�鿴
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	     	}
	     });
	     btnNewButton_3.setIcon(new ImageIcon("source/d18.png"));
	     toolBar.add(btnNewButton_3);
	}
}
