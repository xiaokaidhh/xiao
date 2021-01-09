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
		String lookAndFeel = UIManager.getSystemLookAndFeelClassName();//ϵͳ�������
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

		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("source/b2.png"));//����Ա���������Ͻ�ͼƬ
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
		
		JMenu mnNewMenu = new JMenu("\u5BA0\u7269\u7BA1\u7406");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u589E\u52A0\u5BA0\u7269");
		mntmNewMenuItem_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	
				try {
					AddchildFrm cdframe = new AddchildFrm();	//�������ӳ�����Ӵ���
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
	     toolBar.setBounds(0,0,(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),50);//��ȡ��Ļ�ߴ�
	   
	     desktopPane.add(toolBar);
	     
	     JButton btnNewButton = new JButton("");
	     btnNewButton.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		
	     	try {
	     		TableFrm tf=new TableFrm();  //���ù���Ա��������--è��
	     		tf.setKind("Cat");//ʹ�����������è���������
	     		tf.setVisible(true);
	     				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	     		
	     	}
	     });
	     btnNewButton.setIcon(new ImageIcon("source/b2.png"));
	     toolBar.add(btnNewButton);
	     
	     toolBar.addSeparator(new Dimension(20,45));//�ָ���ť
	     
	     
	     JButton btnNewButton_1 = new JButton("");
	     btnNewButton_1.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		
	     	
				try {
					TableFrm tf = new TableFrm();
					tf.setKind("Dog");//ʹ����������ù����������
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
					AddchildFrm cdframe = new AddchildFrm(); //���������Ӵ���
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
					new SplitLookFrm().setVisible(true);  //��ҳ�鿴����
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
					new PrinttFrm().setVisible(true);     //��ӡ����
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
