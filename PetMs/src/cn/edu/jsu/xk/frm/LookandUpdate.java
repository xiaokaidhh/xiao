package cn.edu.jsu.xk.frm;
import java.awt.EventQueue;
import java.beans.PropertyVetoException;
import java.sql.SQLException;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.border.SoftBevelBorder;

import cn.edu.jsu.xk.dao.OpreationDao;
import cn.edu.jsu.xk.vo.TableCatModel;
import cn.edu.jsu.xk.vo.Time;

import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class LookandUpdate extends JInternalFrame {
	private JTextField txtname;
	private JTextField txtcolor;
	private JTextField txtage;
	private String selected = null;
	private JTextField txtid;
	private JTextField txtsex;
	private JTextField txtdate;
	private String kind;
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	/**
	 * Launch the application.
	 */

	public LookandUpdate() {
		
	}
	/**
	 * Create the frame.
	 * @throws PropertyVetoException 
	 * @throws SQLException 
	 */
//	String id,String sname,String sex,String color,String age,String date
	public LookandUpdate(String id,String sname,String sex,String color,String age,String date) throws PropertyVetoException, SQLException {
		setFrameIcon(null);
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 611, 652);
		getContentPane().setLayout(null);
		
		txtname = new JTextField(sname);
		txtname.setBounds(118, 269, 158, 40);
		getContentPane().add(txtname);
		txtname.setColumns(10);
		
		JLabel name = new JLabel("\u6635\u79F0\uFF1A");
		name.setBounds(50, 281, 58, 15);
		getContentPane().add(name);
		
		txtcolor = new JTextField(color);
		txtcolor.setColumns(10);
		txtcolor.setBounds(118, 350, 158, 40);
		getContentPane().add(txtcolor);
		
		JLabel lblNewLabel_1 = new JLabel("\u989C\u8272\uFF1A");
		lblNewLabel_1.setBounds(50, 362, 58, 15);
		getContentPane().add(lblNewLabel_1);
		
		txtage = new JTextField(age);
		txtage.setColumns(10);
		txtage.setBounds(380, 350, 142, 40);
		getContentPane().add(txtage);
		
		JLabel lblNewLabel_3 = new JLabel("\u5E74\u9F84\uFF1A");
		lblNewLabel_3.setBounds(327, 362, 43, 40);
		getContentPane().add(lblNewLabel_3);
		
		
		
		JButton btnNewButton = new JButton("±£´æÐÞ¸Ä");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(kind.equals("Cat")) { 
				try {
					new OpreationDao().UpdateCat(Integer.parseInt(txtid.getText()),txtname.getText(),txtsex.getText(),txtcolor.getText(),Integer.parseInt(txtage.getText()),txtdate.getText());
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}} else
					try {
						new OpreationDao().UpdateDog(Integer.parseInt(txtid.getText()),txtname.getText(),txtsex.getText(),txtcolor.getText(),Integer.parseInt(txtage.getText()),txtdate.getText());
					} catch (NumberFormatException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				
			}
		});
		btnNewButton.setBounds(412, 546, 97, 23);
		getContentPane().add(btnNewButton);
		
		txtid = new JTextField(id);
		txtid.setBounds(118, 425, 165, 40);
		getContentPane().add(txtid);
		txtid.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u7F16\u53F7\uFF1A");
		lblNewLabel.setBounds(50, 446, 58, 15);
		getContentPane().add(lblNewLabel);
		
		txtsex = new JTextField(sex);
		txtsex.setColumns(10);
		txtsex.setBounds(376, 269, 146, 40);
		getContentPane().add(txtsex);
		
		JLabel name_1 = new JLabel("\u6027\u522B\uFF1A");
		name_1.setBounds(327, 274, 50, 28);
		getContentPane().add(name_1);
		
		txtdate = new JTextField(date);
		txtdate.setColumns(10);
		txtdate.setBounds(380, 425, 142, 40);
		getContentPane().add(txtdate);
		
		JLabel lblNewLabel_1_2 = new JLabel("\u6DFB\u52A0\u65E5\u671F\uFF1A");
		lblNewLabel_1_2.setBounds(311, 430, 66, 28);
		getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("source/q4.jpg"));
		lblNewLabel_2.setBounds(10, 10, 541, 229);
		getContentPane().add(lblNewLabel_2);
		
		
	
	}
}
