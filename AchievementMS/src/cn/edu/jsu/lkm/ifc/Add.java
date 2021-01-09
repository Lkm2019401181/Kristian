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
 * 增加数据界面
 * @author mycom
 *
 */
public class Add extends JFrame {

	private static Connection conn=null;//连接数据库
	private static PreparedStatement pstmt=null; //SQL对象
	private static String watername;//水域名
	private static double watercapacity;//储水量
	private static String waterposition;//水域位置
	private static String pollutionsituation;//污染情况
	private static String governance;//治理情况
	private JPanel contentPane;//内容面板
	private JTextField txt1;//输入框
	private JTextField txt2;//输入框
	private JTextField txt3;//输入框
	private JTextField txt4;//输入框
	private JTextField txt5;//输入框
	private JLabel lbl1;//标签
	private JLabel lbl2;//标签
	private JLabel lbl3;//标签
	private JLabel lbl4;//标签
	private JLabel lbl5;//标签

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
					                JOptionPane.showMessageDialog(null, "添加成功");
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
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.setBounds(176, 314, 129, 44);
		contentPane.add(btnNewButton);
		this.setLocationRelativeTo(null);
	}
	
	/**
	 * 检查水域名
	 * @return false
	 */
	public boolean check1() {
		  if(txt1.getText().length()==0) {
		    lbl1.setText("水域名不能为空");
		    txt1.requestFocus();
		    return false;
		  }
		  lbl1.setText("");
		  return true;
	}
	
	/**
	 * 检查储水量
	 * @return false
	 */
	public boolean check2() {
		  if(txt2.getText().length()==0) {
		    lbl2.setText("储水量不能为空");
		    txt2.requestFocus();
		    return false;
		  }else if(!txt2.getText().matches("\\d+")) {//正则匹配数字
			    lbl2.setText("储水量必须是数字");
			    txt2.requestFocus();
			    txt2.selectAll();//全选当中的内容
			    return false;
		  }
		  lbl2.setText("");
		  return true;
	}
	
	/**
	 * 检查水域位置
	 * @return false
	 */
	public boolean check3() {
		  if(txt3.getText().length()==0) {
		    lbl3.setText("水域位置不能为空");
		    txt3.requestFocus();
		    return false;
		  }
		  lbl3.setText("");
		  return true;
	}
	
	/**
	 * 检查污染情况
	 * @return false
	 */
	public boolean check4() {
		  if(txt4.getText().length()==0) {
		    lbl4.setText("污染情况不能为空");
		    txt4.requestFocus();
		    return false;
		  }
		  lbl4.setText("");
		  return true;
	}
	
	/**
	 * 检查治理情况
	 * @return false
	 */
	public boolean check5() {
		  if(txt5.getText().length()==0) {
		    lbl5.setText("治理情况不能为空");
		    txt5.requestFocus();
		    return false;
		  }
		  lbl5.setText("");
		  return true;
	}
}
