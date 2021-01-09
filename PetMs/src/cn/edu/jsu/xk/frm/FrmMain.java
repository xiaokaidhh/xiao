package cn.edu.jsu.xk.frm;

import java.awt.*;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
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

public class FrmMain {

 JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		String lookAndFeel = UIManager.getSystemLookAndFeelClassName();//系统风格主题
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
					FrmMain window = new FrmMain();
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
	public FrmMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);

		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("source/b2.png"));//管理员主界面左上角图片
		frame.setTitle("\u5BA0\u7269\u7BA1\u7406\u7CFB\u7EDF");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);//窗体居中，最大化可不使用
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);//窗口最大化

		
		JDesktopPane desktopPane = new JDesktopPane() {
			@Override
			public void paintComponent(Graphics g) {//重绘面板背景
				//创建一个未初始化的图像图标，参考API
				ImageIcon icon=new ImageIcon("source/q1.jpg");
				//绘制指定图像中已缩放到适合指定矩形内部的图像
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(),this);
			}
		};

		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		frame.getContentPane().add(menuBar, BorderLayout.NORTH);
		
		JMenu mnNewMenu = new JMenu("\u5BA0\u7269\u7BA1\u7406");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u589E\u52A0\u5BA0\u7269");
		mntmNewMenuItem_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	
				try {
					AddchildFrm cdframe = new AddchildFrm();	//调用增加宠物的子窗口
					desktopPane.add(cdframe);
				   cdframe.setVisible(true);
				} catch (PropertyVetoException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JToolBar toolBar = new JToolBar();
	     toolBar.setBounds(0,0,(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),50);//获取屏幕尺寸
	   
	     desktopPane.add(toolBar);
	     
	     JButton btnNewButton = new JButton("");
	     btnNewButton.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		
	     	try {
	     		TableFrm tf=new TableFrm();  //调用管理员操作界面--猫类
	     		tf.setKind("Cat");//使操作界面调用猫类相关数据
	     		tf.setVisible(true);
	     				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	     		
	     	}
	     });
	     btnNewButton.setIcon(new ImageIcon("source/b2.png"));
	     toolBar.add(btnNewButton);
	     
	     toolBar.addSeparator(new Dimension(20,45));//分隔按钮
	     
	     
	     JButton btnNewButton_1 = new JButton("");
	     btnNewButton_1.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		
	     	
				try {
					TableFrm tf = new TableFrm();
					tf.setKind("Dog");//使操作界面调用狗类相关数据
	     		    tf.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	     		
	     		
	    
	     	}
	     	
	     	
	     });
	     btnNewButton_1.setIcon(new ImageIcon("source/b1.png"));
	     toolBar.add(btnNewButton_1);
	     
	     toolBar.addSeparator(new Dimension(20,45));
	     JButton btnNewButton_2 = new JButton("");
	     btnNewButton_2.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		
	     		try {
					AddchildFrm cdframe = new AddchildFrm(); //宠物增加子窗口
					desktopPane.add(cdframe);
					cdframe.setVisible(true);
					
				} catch (PropertyVetoException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
	     	
	     		
	     	}
	     	
	     });
	     
	     btnNewButton_2.setIcon(new ImageIcon("source/35.png"));
	     toolBar.add(btnNewButton_2);
	     
	     toolBar.addSeparator(new Dimension(20,45));
	     
	     
	     JButton btnNewButton_3 = new JButton("");
	     btnNewButton_3.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		
	     		try {
					new SplitLookFrm().setVisible(true);  //分页查看窗口
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	     	
	     	}
	     });
	     btnNewButton_3.setIcon(new ImageIcon("source/d18.png"));
	     toolBar.add(btnNewButton_3);
	     
	     
	     toolBar.addSeparator(new Dimension(20,45));
	     
	     JButton btnNewButton_4 = new JButton("");
	     btnNewButton_4.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		
	     		try {
					new PrinttFrm().setVisible(true);     //打印窗口
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	     	}
	     });
	     btnNewButton_4.setIcon(new ImageIcon("source/d16.png"));
	     toolBar.add(btnNewButton_4);
	}
}
