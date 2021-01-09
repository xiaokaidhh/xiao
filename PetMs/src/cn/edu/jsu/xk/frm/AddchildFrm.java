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
import cn.edu.jsu.xk.vo.TableDogModel;
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
import javax.swing.table.DefaultTableModel;

public class AddchildFrm extends JInternalFrame {
	private JTextField txtname;
	private JTextField txtcolor;
	private JTextField txtage;
	private String selected = null;
	private JTable table;
	private JTextField txtid;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 * @throws PropertyVetoException 
	 * @throws SQLException 
	 */
	public AddchildFrm() throws PropertyVetoException, SQLException {
		setFrameIcon(null);
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 611, 652);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(82, 43, 425, 209);
		getContentPane().add(scrollPane);
		
	
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5BA0\u7269\u4FE1\u606F\u5F55\u5165"
			}
		));
		scrollPane.setViewportView(table);
		
		txtname = new JTextField();
		txtname.setBounds(106, 377, 158, 40);
		getContentPane().add(txtname);
		txtname.setColumns(10);
		
		JLabel name = new JLabel("\u6635\u79F0\uFF1A");
		name.setBounds(38, 389, 58, 15);
		getContentPane().add(name);
		
		txtcolor = new JTextField();
		txtcolor.setColumns(10);
		txtcolor.setBounds(106, 458, 158, 40);
		getContentPane().add(txtcolor);
		
		JLabel lblNewLabel_1 = new JLabel("\u989C\u8272\uFF1A");
		lblNewLabel_1.setBounds(38, 470, 58, 15);
		getContentPane().add(lblNewLabel_1);
		
		txtage = new JTextField();
		txtage.setColumns(10);
		txtage.setBounds(368, 458, 128, 40);
		getContentPane().add(txtage);
		
		JLabel lblNewLabel_3 = new JLabel("\u70ED\u5EA6\uFF1A");
		lblNewLabel_3.setBounds(327, 470, 58, 15);
		getContentPane().add(lblNewLabel_3);
		
		
		JRadioButton man = new JRadioButton("\u96C4");
		man.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (man.isSelected()) {
				selected = "ÐÛ";
				} else{
				selected = "´Æ";
				}
				
				}
			
		});
		man.setFont(new Font("ËÎÌå", Font.PLAIN, 16));
		man.setBounds(310, 379, 67, 32);
		getContentPane().add(man);
		
		JRadioButton woman = new JRadioButton("\u96CC");
		woman.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		 selected = null;
				if (woman.isSelected()) {
				selected = "´Æ";
				} else{
				selected = "ÐÛ";
				}
				}
			
		});
		woman.setFont(new Font("ËÎÌå", Font.PLAIN, 16));
		woman.setBounds(384, 364, 48, 62);
		getContentPane().add(woman);
		

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u72D7", "\u732B"}));
		comboBox.setBounds(458, 380, 58, 32);
		getContentPane().add(comboBox);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(man);
		bg.add(woman);
		
		JButton btnNewButton = new JButton("È·¶¨");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			try {
					String item = (String)comboBox.getSelectedItem();
					if(item.equals("Ã¨")) {
				
				new OpreationDao().AddCat(Integer.parseInt(txtid.getText()),txtname.getText(),selected,txtcolor.getText(),(Integer.parseInt(txtage.getText())),new Time().getTime());
				        
				table.setModel(new TableCatModel().gettableCatdata());
					}
				else {
						
						new OpreationDao().AddDog(Integer.parseInt(txtid.getText()),txtname.getText(),selected,txtcolor.getText(),(Integer.parseInt(txtage.getText())),new Time().getTime());
						table.setModel(new TableDogModel().gettableDogdata());
					
					}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
			}
		});
		btnNewButton.setBounds(376, 541, 97, 23);
		getContentPane().add(btnNewButton);
		
		txtid = new JTextField();
		txtid.setBounds(106, 533, 165, 40);
		getContentPane().add(txtid);
		txtid.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u7F16\u53F7\uFF1A");
		lblNewLabel.setBounds(38, 554, 58, 15);
		getContentPane().add(lblNewLabel);
		
		
		
		
	
		

	}
}
