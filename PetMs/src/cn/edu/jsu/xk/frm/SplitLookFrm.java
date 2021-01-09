package cn.edu.jsu.xk.frm;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import cn.edu.jsu.xk.dao.BrowsingDao;
import cn.edu.jsu.xk.vo.Cat;
import cn.edu.jsu.xk.vo.PageController;
import cn.edu.jsu.xk.vo.TableCatModel;
import cn.edu.jsu.xk.vo.TableDogModel;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.awt.event.ItemEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

public class SplitLookFrm extends JFrame {
	private JPanel contentPane;// 定义窗体内容面板，放置各组件
	private JTable table;// 定义表格
	private JTextField txtKey;//定义查找关键字文本框
	private DefaultTableModel model;// 定义表格数据模型
	private TableRowSorter sorter;//定义排序器
	private ArrayList<RowSorter.SortKey> sortKeys;//设置排序规则
	
	private Vector<String> titles;

	public static void main(String[] args) throws SQLException {
		SplitLookFrm frame = new SplitLookFrm();// 实例化窗体
		frame.setLocationRelativeTo(null);// 窗体居中
		frame.setVisible(true);// 窗体可见
	}

	/**
	 * 定义构造方法创建窗体及组件.
	 * @throws SQLException 
	 */
	public SplitLookFrm() throws SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// 设置窗体关闭按钮
		setBounds(100, 100, 908, 629);// 设置窗体位置与大小
		contentPane = new JPanel();// 实例化内容面板
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));// 设置面板边框
		contentPane.setLayout(null);// 设置面板布局为绝对布局
		setContentPane(contentPane);// 将窗体默认面板

		// 设置滚动面板
		JScrollPane scrollPane = new JScrollPane();// 创建滚动面板
		scrollPane.setBounds(44, 82, 801, 215);// 设置大小与位置
		contentPane.add(scrollPane);// 将滚动面板加入到内容面板中

		// 使用动态数组数据（列标题与行数据）
		titles = new Vector<String>();// 定义动态数组表示表格标题
		Collections.addAll(titles, "编号","姓名","性别","颜色","热度","添加日期");
		Vector<Vector> stuInfo = new PageController().getPaegData();//获取第一页的数据

//		使用静态数据创建DefaultTableModel数据模型
		model = new TableCatModel().gettableCatdata() ;
	
		table = new JTable(model);// 使用DefaultTableModel数据模型实例化表格
		table.setAutoCreateRowSorter(true);;//设置表格自动排序

		scrollPane.setViewportView(table);// 设置使用滚动面板显示表格，如果不使用滚动面板显示，则表格的列标题无法显示
		
		JLabel lblKey = new JLabel("\u8F93\u5165\u59D3\u540D\uFF1A");
		lblKey.setBounds(511, 424, 79, 15);
		contentPane.add(lblKey);
		
		txtKey = new JTextField();
		txtKey.setBounds(600, 421, 119, 21);
		contentPane.add(txtKey);
		txtKey.setColumns(10);
		
		
		JLabel lblquery = new JLabel("");
		lblquery.setFont(new Font("宋体", Font.PLAIN, 16));
		lblquery.setForeground(Color.RED);
		lblquery.setBounds(707, 420, 151, 32);
		contentPane.add(lblquery);
		
		//定义查找按钮
		JButton btnFind = new JButton("查找");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key=(String)txtKey.getText();//获取输入关键字文本框的值
				if(key.length()!=0) {
			
					try {
						List<Cat> list=new BrowsingDao().getCatdata(txtKey.getText());
					
						if(!list.toString().equals("[]")) {
							 lblquery.setText("");
						DefaultTableModel model1=new TableCatModel().gettableCatdata(txtKey.getText());
						
						table.setModel(model1);}
						
						else lblquery.setText("查无此项");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}}
					else {
						lblquery.setText("请输入要查找的内容");
					}
					
				}
		});
		btnFind.setBounds(598, 463, 95, 25);
		contentPane.add(btnFind);
		
		JButton btnPre = new JButton("");
		btnPre.setIcon(new ImageIcon("source/53.png"));
		btnPre.addActionListener(new ActionListener() {//上一页单击事件
			@Override
			public void actionPerformed(ActionEvent e) {
				model=new DefaultTableModel(new PageController().prePage(),titles);//设置数据模型中的数据为上一页内容
				table.setModel(model);//设置表格的数据模型
				
			}
		});
		btnPre.setBounds(454, 320, 95, 41);
		contentPane.add(btnPre);
		
		JButton btnNext = new JButton("");
		btnNext.setIcon(new ImageIcon("source/64.png"));
		btnNext.addActionListener(new ActionListener() {//下一页单击事件
			@Override
			public void actionPerformed(ActionEvent e) {
				model=new DefaultTableModel(new PageController().nextPage(),titles);//设置数据模型中的数据为下一页内容
				table.setModel(model);//设置表格的数据模型
			}
		});
		btnNext.setBounds(572, 320, 95, 41);
		contentPane.add(btnNext);
		
		JLabel lblMsg = new JLabel("每页显示：");
		lblMsg.setBounds(707, 330, 68, 36);
		contentPane.add(lblMsg);
		

		
		JComboBox comboBox = new JComboBox(new Integer[] {3,5,10,15,20});
		comboBox.addItemListener(new ItemListener() {//页数下拉框选择改变事件
			public void itemStateChanged(ItemEvent e) {
				int pageSize=Integer.valueOf(comboBox.getSelectedItem().toString());//获取下拉框所选的值
				PageController pcl=new PageController();
				pcl.setCountPerpage(pageSize);//设置每页显示记录条数
			try {
				model=new TableCatModel().getpageTable(pcl.getPaegData());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				table.setModel(model);//设置表格数据模型
			}
		});
		comboBox.setSelectedIndex(1);//设置下拉框默认值
		comboBox.setBounds(790, 337, 55, 23);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("source/q5.jpg"));
		lblNewLabel.setBounds(44, 307, 379, 225);
		contentPane.add(lblNewLabel);
		
		
	}	
}
