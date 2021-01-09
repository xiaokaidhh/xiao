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
		lblzhh.setText("�������˺ź��ٵ�¼!");
		return false;	
		}
		lblzhh.setText(" ");
		return true;
	}
  public boolean checkmm(){
		if(txtmm.getText().length()==0) {
		lblmmm.setText("������������ٵ�¼!");
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
		
		JButton btnNewButton = new JButton("ȷ��");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag1=checkzh();
				if(flag1) {
				boolean flag2=checkmm();
				if(flag2) {
					
					try {
						if(new Check().getchecklog(txtzh.getText(),txtmm.getText())&&checkb.isSelected()){//�õ��˺ź��������Check�������֤     ͬʱ��֤�Ƿ�ѡ����Ա��¼
							JOptionPane.showMessageDialog(null, "��¼�ɹ�");
							dispose();
							FrmMain window = new FrmMain();    //����Ա����
							window.frame.setVisible(true);
							
						}
						else if(new Check().checkCustomlog(txtzh.getText(),txtmm.getText())&&!checkb.isSelected()){//û�й�ѡ�ҹ���Ա ��֤������û�����
							
							FrMain fr=new FrMain();	//�û�������
							fr.setUsername(txtzh.getText());//�õ��û���
							fr.frame.setVisible(true);
							
							
//							 CustomFrm  cf=	new CustomFrm();//�����˿Ͳ�������
//							 cf.setUsername(txtzh.getText());
//							 cf.setVisible(true);
									 
						}
						else JOptionPane.showMessageDialog(null, "�˻������������");
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
		
		btnNewButton_1 = new JButton("ע��");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				new RegisterFrm().setVisible(true);//���û�ע�����;
				
				
			}
		});
		btnNewButton_1.setBounds(158, 267, 113, 26);
		contentPane.add(btnNewButton_1);
		
		
	}
}
