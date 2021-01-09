package cn.edu.jsu.lkm.ifc;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.jsu.lkm.dao.*;
import cn.edu.jsu.lkm.dao.impl.OperationSql;
import cn.edu.jsu.lkm.dbc.DatabaseConnectionSql;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * �������ݽ���
 * @author mycom
 *
 */
public class Add extends JFrame {

	private static Connection conn=null;//�������ݿ�
	private static PreparedStatement pstmt=null; //SQL����
	private static String watername;//ˮ����
	private static double watercapacity;//��ˮ��
	private static String waterposition;//ˮ��λ��
	private static String pollutionsituation;//��Ⱦ���
	private static String governance;//�������
	private JPanel contentPane;//�������
	private JTextField txt1;//�����
	private JTextField txt2;//�����
	private JTextField txt3;//�����
	private JTextField txt4;//�����
	private JTextField txt5;//�����
	private JLabel lbl1;//��ǩ
	private JLabel lbl2;//��ǩ
	private JLabel lbl3;//��ǩ
	private JLabel lbl4;//��ǩ
	private JLabel lbl5;//��ǩ

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add frame = new Add();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Add() {
		Add frame = new Add();
		frame.setVisible(true);
		setTitle("\u589E\u52A0\u6570\u636E");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 520, 405);
		contentPane = new JpaneMag();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u6C34\u57DF\u540D");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(33, 30, 91, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u50A8\u6C34\u91CF");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(33, 90, 91, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u6C34\u57DF\u4F4D\u7F6E");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(33, 150, 91, 28);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u6C61\u67D3\u60C5\u51B5");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(33, 210, 91, 28);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u6CBB\u7406\u60C5\u51B5");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(33, 270, 91, 28);
		contentPane.add(lblNewLabel_4);	
		
		txt1 = new JTextField();
		txt1.setBounds(134, 33, 233, 28);
		contentPane.add(txt1);
		txt1.setColumns(10);		
		
		txt2 = new JTextField();
		txt2.setBounds(134, 93, 233, 28);
		contentPane.add(txt2);
		txt2.setColumns(10);
		
		txt3 = new JTextField();
		txt3.setBounds(134, 153, 233, 28);
		contentPane.add(txt3);
		txt3.setColumns(10);
		
		txt4 = new JTextField();
		txt4.setBounds(134, 213, 233, 28);
		contentPane.add(txt4);
		txt4.setColumns(10);
		
		txt5 = new JTextField();
		txt5.setBounds(134, 273, 233, 28);
		contentPane.add(txt5);
		txt5.setColumns(10);
		
		lbl1 = new JLabel("");
		lbl1.setForeground(Color.RED);
		lbl1.setBounds(381, 37, 115, 20);
		contentPane.add(lbl1);
		
		lbl2 = new JLabel("");
		lbl2.setForeground(Color.RED);
		lbl2.setBounds(381, 97, 115, 20);
		contentPane.add(lbl2);
		
		lbl3 = new JLabel("");
		lbl3.setForeground(Color.RED);
		lbl3.setBounds(395, 157, 115, 20);
		contentPane.add(lbl3);
		
		lbl4 = new JLabel("");
		lbl4.setForeground(Color.RED);
		lbl4.setBounds(395, 217, 115, 20);
		contentPane.add(lbl4);
		
		lbl5 = new JLabel("");
		lbl5.setForeground(Color.RED);
		lbl5.setBounds(395, 277, 115, 20);
		contentPane.add(lbl5);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(check1()) {
						if(check2()) {
							if(check3()) {
								if(check4()) {
									if(check5()) {
									new OperationSql().doCreat(txt1.getText(),Double.parseDouble(txt2.getText()),txt3.getText(),txt4.getText(),txt5.getText());
					                JOptionPane.showMessageDialog(null, "��ӳɹ�");
					                txt1.setText("");
					                txt2.setText("");
					                txt3.setText("");
					                txt4.setText("");
					                txt5.setText("");
									}
								}
							}
						}
					}
					
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("����", Font.PLAIN, 20));
		btnNewButton.setBounds(176, 314, 129, 44);
		contentPane.add(btnNewButton);
		this.setLocationRelativeTo(null);
	}
	
	/**
	 * ���ˮ����
	 * @return false
	 */
	public boolean check1() {
		  if(txt1.getText().length()==0) {
		    lbl1.setText("ˮ��������Ϊ��");
		    txt1.requestFocus();
		    return false;
		  }
		  lbl1.setText("");
		  return true;
	}
	
	/**
	 * ��鴢ˮ��
	 * @return false
	 */
	public boolean check2() {
		  if(txt2.getText().length()==0) {
		    lbl2.setText("��ˮ������Ϊ��");
		    txt2.requestFocus();
		    return false;
		  }else if(!txt2.getText().matches("\\d+")) {//����ƥ������
			    lbl2.setText("��ˮ������������");
			    txt2.requestFocus();
			    txt2.selectAll();//ȫѡ���е�����
			    return false;
		  }
		  lbl2.setText("");
		  return true;
	}
	
	/**
	 * ���ˮ��λ��
	 * @return false
	 */
	public boolean check3() {
		  if(txt3.getText().length()==0) {
		    lbl3.setText("ˮ��λ�ò���Ϊ��");
		    txt3.requestFocus();
		    return false;
		  }
		  lbl3.setText("");
		  return true;
	}
	
	/**
	 * �����Ⱦ���
	 * @return false
	 */
	public boolean check4() {
		  if(txt4.getText().length()==0) {
		    lbl4.setText("��Ⱦ�������Ϊ��");
		    txt4.requestFocus();
		    return false;
		  }
		  lbl4.setText("");
		  return true;
	}
	
	/**
	 * ����������
	 * @return false
	 */
	public boolean check5() {
		  if(txt5.getText().length()==0) {
		    lbl5.setText("�����������Ϊ��");
		    txt5.requestFocus();
		    return false;
		  }
		  lbl5.setText("");
		  return true;
	}
}
