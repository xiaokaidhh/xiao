package cn.edu.jsu.xk.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.jsu.xk.dao.BrowsingDao;
import cn.edu.jsu.xk.vo.PutExcel;
import cn.edu.jsu.xk.vo.PutTxt;
import cn.edu.jsu.xk.vo.TableCatModel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PrinttFrm extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrinttFrm frame = new PrinttFrm();
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
	public PrinttFrm() throws SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 849, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u5BFC\u51FA\u5230Excel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					new PutExcel().exportExcel(new BrowsingDao().getCatdata());
					JOptionPane.showMessageDialog(null, "导出文件成功!");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setBounds(548, 326, 125, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u5BFC\u51FA\u5230Txt");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					new PutTxt().exportTxt(new BrowsingDao().getCatdata());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "导出文件成功!");
			}
		});
		btnNewButton_1.setBounds(391, 328, 119, 37);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(73, 23, 727, 234);
		contentPane.add(scrollPane);
		
		table = new JTable(new TableCatModel().gettableCatdata());
		scrollPane.setViewportView(table);
	}
}
