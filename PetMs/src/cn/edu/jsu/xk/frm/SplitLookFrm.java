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
	private JPanel contentPane;// ���崰��������壬���ø����
	private JTable table;// ������
	private JTextField txtKey;//������ҹؼ����ı���
	private DefaultTableModel model;// ����������ģ��
	private TableRowSorter sorter;//����������
	private ArrayList<RowSorter.SortKey> sortKeys;//�����������
	
	private Vector<String> titles;

	public static void main(String[] args) throws SQLException {
		SplitLookFrm frame = new SplitLookFrm();// ʵ��������
		frame.setLocationRelativeTo(null);// �������
		frame.setVisible(true);// ����ɼ�
	}

	/**
	 * ���幹�췽���������弰���.
	 * @throws SQLException 
	 */
	public SplitLookFrm() throws SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// ���ô���رհ�ť
		setBounds(100, 100, 908, 629);// ���ô���λ�����С
		contentPane = new JPanel();// ʵ�����������
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));// �������߿�
		contentPane.setLayout(null);// ������岼��Ϊ���Բ���
		setContentPane(contentPane);// ������Ĭ�����

		// ���ù������
		JScrollPane scrollPane = new JScrollPane();// �����������
		scrollPane.setBounds(44, 82, 801, 215);// ���ô�С��λ��
		contentPane.add(scrollPane);// �����������뵽���������

		// ʹ�ö�̬�������ݣ��б����������ݣ�
		titles = new Vector<String>();// ���嶯̬�����ʾ������
		Collections.addAll(titles, "���","����","�Ա�","��ɫ","�ȶ�","�������");
		Vector<Vector> stuInfo = new PageController().getPaegData();//��ȡ��һҳ������

//		ʹ�þ�̬���ݴ���DefaultTableModel����ģ��
		model = new TableCatModel().gettableCatdata() ;
	
		table = new JTable(model);// ʹ��DefaultTableModel����ģ��ʵ�������
		table.setAutoCreateRowSorter(true);;//���ñ���Զ�����

		scrollPane.setViewportView(table);// ����ʹ�ù��������ʾ��������ʹ�ù��������ʾ��������б����޷���ʾ
		
		JLabel lblKey = new JLabel("\u8F93\u5165\u59D3\u540D\uFF1A");
		lblKey.setBounds(511, 424, 79, 15);
		contentPane.add(lblKey);
		
		txtKey = new JTextField();
		txtKey.setBounds(600, 421, 119, 21);
		contentPane.add(txtKey);
		txtKey.setColumns(10);
		
		
		JLabel lblquery = new JLabel("");
		lblquery.setFont(new Font("����", Font.PLAIN, 16));
		lblquery.setForeground(Color.RED);
		lblquery.setBounds(707, 420, 151, 32);
		contentPane.add(lblquery);
		
		//������Ұ�ť
		JButton btnFind = new JButton("����");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key=(String)txtKey.getText();//��ȡ����ؼ����ı����ֵ
				if(key.length()!=0) {
			
					try {
						List<Cat> list=new BrowsingDao().getCatdata(txtKey.getText());
					
						if(!list.toString().equals("[]")) {
							 lblquery.setText("");
						DefaultTableModel model1=new TableCatModel().gettableCatdata(txtKey.getText());
						
						table.setModel(model1);}
						
						else lblquery.setText("���޴���");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}}
					else {
						lblquery.setText("������Ҫ���ҵ�����");
					}
					
				}
		});
		btnFind.setBounds(598, 463, 95, 25);
		contentPane.add(btnFind);
		
		JButton btnPre = new JButton("");
		btnPre.setIcon(new ImageIcon("source/53.png"));
		btnPre.addActionListener(new ActionListener() {//��һҳ�����¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				model=new DefaultTableModel(new PageController().prePage(),titles);//��������ģ���е�����Ϊ��һҳ����
				table.setModel(model);//���ñ�������ģ��
				
			}
		});
		btnPre.setBounds(454, 320, 95, 41);
		contentPane.add(btnPre);
		
		JButton btnNext = new JButton("");
		btnNext.setIcon(new ImageIcon("source/64.png"));
		btnNext.addActionListener(new ActionListener() {//��һҳ�����¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				model=new DefaultTableModel(new PageController().nextPage(),titles);//��������ģ���е�����Ϊ��һҳ����
				table.setModel(model);//���ñ�������ģ��
			}
		});
		btnNext.setBounds(572, 320, 95, 41);
		contentPane.add(btnNext);
		
		JLabel lblMsg = new JLabel("ÿҳ��ʾ��");
		lblMsg.setBounds(707, 330, 68, 36);
		contentPane.add(lblMsg);
		

		
		JComboBox comboBox = new JComboBox(new Integer[] {3,5,10,15,20});
		comboBox.addItemListener(new ItemListener() {//ҳ��������ѡ��ı��¼�
			public void itemStateChanged(ItemEvent e) {
				int pageSize=Integer.valueOf(comboBox.getSelectedItem().toString());//��ȡ��������ѡ��ֵ
				PageController pcl=new PageController();
				pcl.setCountPerpage(pageSize);//����ÿҳ��ʾ��¼����
			try {
				model=new TableCatModel().getpageTable(pcl.getPaegData());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				table.setModel(model);//���ñ������ģ��
			}
		});
		comboBox.setSelectedIndex(1);//����������Ĭ��ֵ
		comboBox.setBounds(790, 337, 55, 23);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("source/q5.jpg"));
		lblNewLabel.setBounds(44, 307, 379, 225);
		contentPane.add(lblNewLabel);
		
		
	}	
}
