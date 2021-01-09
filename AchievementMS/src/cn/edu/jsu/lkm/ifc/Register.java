package cn.edu.jsu.lkm.ifc;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import cn.edu.jsu.lkm.dao.impl.OperationFile;
import cn.edu.jsu.lkm.vo.*;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

/**
 * 注册界面
 * @author mycom
 *
 */
public class Register extends JFrame {

	private JPanel contentPane;//内容面板
	private JTextField txt1;//输入框
	private JTextField txt2;//输入框
	private JLabel lblNewLabel;//标签
	private JLabel lblNewLabel_1;//标签
	private JLabel lbl1;//标签
	private JLabel lbl2;//标签
	private JButton btnNewButton_1;//按钮

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JpaneMag();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txt1 = new JTextField();
		txt1.setBounds(117, 55, 179, 34);
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		txt2 = new JTextField();
		txt2.setBounds(117, 126, 179, 34);
		contentPane.add(txt2);
		txt2.setColumns(10);
		
		JButton btnNewButton = new JButton("\u6CE8\u518C");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkAccount()) {
					if(checkPassword()) {
					if(new OperationFile().doCreate(new User(txt1.getText(),txt2.getText()))) {
						JOptionPane.showMessageDialog(null, "注册成功");
						txt1.setText("");
						txt2.setText("");
				}else {
					JOptionPane.showMessageDialog(null,"账号已存在");
				}
					}
				}

			}
		});
		btnNewButton.setBounds(117, 193, 87, 34);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("\u8D26\u53F7\uFF1A");
		lblNewLabel.setBounds(43, 64, 49, 25);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setBounds(43, 130, 49, 25);
		contentPane.add(lblNewLabel_1);
		
		lbl1 = new JLabel("");
		lbl1.setForeground(Color.RED);
		lbl1.setBounds(306, 64, 120, 25);
		contentPane.add(lbl1);
		
		lbl2 = new JLabel("");
		lbl2.setForeground(Color.RED);
		lbl2.setBounds(306, 135, 120, 25);
		contentPane.add(lbl2);
		
		btnNewButton_1 = new JButton("\u8FD4\u56DE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_1.setBounds(214, 193, 87, 34);
		contentPane.add(btnNewButton_1);
		this.setLocationRelativeTo(null);
	}
	
	/**
	 * 检验账号
	 * @return false
	 */
	public boolean checkAccount() {
		  if(txt1.getText().length()==0) {
		    lbl1.setText("账号不能为空");
		    txt1.requestFocus();
		    return false;
		  }else if(!txt1.getText().matches("\\d+")) {//正则匹配数字
			    lbl1.setText("账号必须是数字");
			    txt1.requestFocus();
			    txt1.selectAll();//全选当中的内容
			    return false;
		  }
		  lbl1.setText("");
		  return true;
	}
	
	/**
	 * 检验密码
	 * @return false
	 */
	public boolean checkPassword() {
		  if(txt2.getText().length()==0) {
		    lbl2.setText("密码不能为空");
		    txt2.requestFocus();
		    return false;
		  }
		  lbl2.setText("");
		  return true;
	}
}
