package cn.edu.jsu.xk.frm;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.DesktopPaneUI;
import javax.swing.table.DefaultTableModel;

import cn.edu.jsu.xk.dao.BrowsingDao;
import cn.edu.jsu.xk.dao.OpreationDao;
import cn.edu.jsu.xk.vo.Cat;
import cn.edu.jsu.xk.vo.TableCatModel;
import cn.edu.jsu.xk.vo.TableDogModel;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;

public class TableFrm extends JFrame {
	private DefaultTableModel model;
	private JPanel contentPane;
	private JTable table;
	private JButton btndelete;
	private JTextField txtxchaxun;
	private String kind=" ";

	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableFrm frame = new TableFrm();
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
	public TableFrm() throws SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1071, 732);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 10, 453, 366);
		contentPane.add(scrollPane);
		
		txtxchaxun = new JTextField();
		txtxchaxun.setBounds(24, 512, 248, 28);
		contentPane.add(txtxchaxun);
		txtxchaxun.setColumns(10);
		
		 
	    model=new TableDogModel().gettableDogdata();
		table = new JTable(model);
		table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);
		
		
		JDesktopPane desktopPane = new JDesktopPane() {
			@Override
			public void paintComponent(Graphics g) {//重绘面板背景
				//创建一个未初始化的图像图标，参考API
				ImageIcon icon=new ImageIcon("source/q2.jpeg");
				//绘制指定图像中已缩放到适合指定矩形内部的图像，参考API
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(),this);
			}
		};
		desktopPane.setBounds(497, 10, 550, 675);
		contentPane.add(desktopPane);
		desktopPane.setLayout(null);
		
		
		
		btndelete = new JButton("\u5220\u9664");
		btndelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				int row=table.getSelectedRow();
				if(row!=-1) {
				int selected = (int)table.getValueAt(row,0); 
			if(kind.equals("Cat")) {
				try {
					new OpreationDao().DeleteCat(selected);
					
					table = new JTable(new TableCatModel().gettableCatdata());
					
					scrollPane.setViewportView(table);
					
				} catch (SQLException e1) {
					// TODO Autelseo-generated catch block
					e1.printStackTrace();
				}}
			else  {
				try {
				new OpreationDao().DeleteDog(selected);
				
				table = new JTable(new TableDogModel().gettableDogdata());
				
				scrollPane.setViewportView(table);
				
			} catch (SQLException e1) {
				// TODO Autelseo-generated catch block
				e1.printStackTrace();
			}}
			
				}
			}
		});
		btndelete.setBounds(253, 460, 97, 23);
		contentPane.add(btndelete);
		
		JButton btnlook = new JButton("\u67E5\u770B");
		btnlook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row=table.getSelectedRow();
				if(row!=-1) {
			try{
//				AddchildFrm  cf=new AddchildFrm();
//				cf.setBounds(0, 0, 550, 675);
//					desktopPane.add(cf);
//					cf.setVisible(true);
				if(kind.equals("Cat")) {//种类为猫就导入
				int selected = (int)table.getValueAt(row,0); 
			JTable	table1=new JTable(new TableCatModel().gettableCatdata(selected));
		LookandUpdate lf=new LookandUpdate(String.valueOf(table1.getValueAt(0,0)),(String)table1.getValueAt(0, 1),(String)table1.getValueAt(0, 2),(String)table1.getValueAt(0, 3),String.valueOf(table1.getValueAt(0, 4)),(String)table.getValueAt(0, 5));
		 lf.setKind(kind);
		lf.setBounds(0,0,550,675);
		     desktopPane.add(lf);
                 lf.setVisible(true);
                 }
				else {
					int selected = (int)table.getValueAt(row,0); 
			JTable	table1=new JTable(new TableDogModel().gettableDogdata(selected));
			 LookandUpdate lf=new LookandUpdate(String.valueOf(table1.getValueAt(0,0)),(String)table1.getValueAt(0, 1),(String)table1.getValueAt(0, 2),(String)table1.getValueAt(0, 3),String.valueOf(table1.getValueAt(0, 4)),(String)table.getValueAt(0, 5));
			    lf.setKind(kind); 
			       lf.setBounds(0,0,550,675);
				     desktopPane.add(lf);
		                 lf.setVisible(true);
				}
			
				
			}catch (Exception e1) {
				e1.printStackTrace();
			}
			}
					
				
			}
		});
		btnlook.setBounds(141, 460, 97, 23);
		contentPane.add(btnlook);
		
		JButton updatebton = new JButton("\u4FDD\u5B58\u4FEE\u6539");
		updatebton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
		  for (int i = 0; i < table.getRowCount(); i++) {//z 遍历表格数据，加入集合中
			  if(kind.equals("Cat")) {
		 try {
			new OpreationDao().UpdateCat((int)table.getValueAt(i, 0),(String)table.getValueAt(i, 1), (String)table.getValueAt(i, 2),(String)table.getValueAt(i, 3),(int)table.getValueAt(i, 0),(String)table.getValueAt(i, 5));
		} 
	catch (NumberFormatException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}     }// 获取表格中每一行的每一个单元格
         else
			try {
					new OpreationDao().UpdateDog((int)table.getValueAt(i, 0),(String)table.getValueAt(i, 1), (String)table.getValueAt(i, 2),(String)table.getValueAt(i, 3),(int)table.getValueAt(i, 0),(String)table.getValueAt(i, 5));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
	               }
				
			}
		});
		updatebton.setBounds(34, 460, 97, 23);
		contentPane.add(updatebton);
		
		JButton btnNewButton_3 = new JButton("\u67E5\u8BE2");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(kind.equals("Cat")) {
				
					try {
						List<Cat> list = new BrowsingDao().getCatdata(txtxchaxun.getText());
						if(!list.toString().equals("[]")) {
							DefaultTableModel model1=new TableCatModel().gettableCatdata(txtxchaxun.getText());
							table.setModel(model1);}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			else
					try {List<Cat> list = new BrowsingDao().getCatdata(txtxchaxun.getText());
					if(!list.toString().equals("[]")) {
					
						table.setModel(new TableDogModel().gettableDogdata(txtxchaxun.getText()));
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			
			}
		});
		btnNewButton_3.setBounds(288, 514, 97, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnrefsh = new JButton("\u5237\u65B0");
		btnrefsh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(kind.equals("Cat")) {
					try {
						
						table.setModel(new TableCatModel().gettableCatdata(txtxchaxun.getText()));
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}} else
							try {
								table.setModel(new TableDogModel().gettableDogdata(txtxchaxun.getText()));
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
					
			}
			
			
		});
		btnrefsh.setBounds(364, 460, 97, 23);
		contentPane.add(btnrefsh);
		
		
		
		
		
		
		
		
		
	}
}
