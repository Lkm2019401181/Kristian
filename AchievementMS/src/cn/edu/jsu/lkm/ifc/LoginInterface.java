package cn.edu.jsu.lkm.ifc;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.jsu.lkm.dao.impl.OperationFile;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;

/**
 * 登录界面
 * @author mycom
 *
 */
public class LoginInterface extends JFrame {

	private JPanel contentPane;//内容面板
	private JLabel lblTheme;//标签
	private JLabel lblZh;//标签
	private JLabel lblMm;//标签
	private JLabel lblMsgZh;//标签
	private JLabel lblMsgMm;//标签
	private JTextField txtZh;//输入框
	private JTextField txtMm;//输入框
	private JButton btnDl;//按钮
	private JButton btnZc;//按钮

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginInterface frame = new LoginInterface();
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
	public LoginInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTheme = new JLabel("\u6C34\u8D44\u6E90");
		lblTheme.setFont(new Font("华光胖头鱼_CNKI", Font.PLAIN, 55));
		lblTheme.setBounds(126, 60, 171, 80);
		contentPane.add(lblTheme);
		
		lblZh = new JLabel("\u8D26\u53F7\uFF1A");
		lblZh.setFont(new Font("黑体", Font.PLAIN, 20));
		lblZh.setBounds(141, 215, 81, 40);
		contentPane.add(lblZh);
		
		lblMm = new JLabel("\u5BC6\u7801\uFF1A");
		lblMm.setFont(new Font("黑体", Font.PLAIN, 20));
		lblMm.setBounds(141, 270, 81, 40);
		contentPane.add(lblMm);
		
		lblMsgZh = new JLabel("");
		lblMsgZh.setFont(new Font("新宋体", Font.PLAIN, 15));
		lblMsgZh.setForeground(Color.WHITE);
		lblMsgZh.setBounds(470, 225, 146, 25);
		contentPane.add(lblMsgZh);
		
		lblMsgMm = new JLabel("");
		lblMsgMm.setFont(new Font("新宋体", Font.PLAIN, 15));
		lblMsgMm.setForeground(Color.WHITE);
		lblMsgMm.setBounds(470, 275, 146, 25);
		contentPane.add(lblMsgMm);
		
		txtZh = new JTextField();
		txtZh.setBounds(223, 216, 221, 40);
		contentPane.add(txtZh);
		txtZh.setColumns(10);
		
		txtMm = new JTextField();
		txtMm.setBounds(223, 266, 221, 40);
		contentPane.add(txtMm);
		txtMm.setColumns(10);
		
		btnDl = new JButton("\u767B\u5F55");
		btnDl.setBackground(Color.PINK);
		btnDl.setForeground(Color.BLACK);
		btnDl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(checkInputZh()) {
					if(checkInputMm()) {
                        if(new OperationFile().checkLogin(txtZh.getText(),txtMm.getText())) {
							JOptionPane.showMessageDialog(null, "登录成功");
							new MainInterface().init();//调主界面
							dispose();
						}else {
							JOptionPane.showMessageDialog(null, "账号或密码错误");
						}
					}
				}
			}
		});
		this.setVisible(false);
		btnDl.setFont(new Font("黑体", Font.PLAIN, 20));
		btnDl.setBounds(215, 316, 93, 34);
		contentPane.add(btnDl);
		
		btnZc = new JButton("\u6CE8\u518C");
		btnZc.setBackground(Color.PINK);
		btnZc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register frame = new Register();
				frame.setVisible(true);
			}
		});
		btnZc.setFont(new Font("黑体", Font.PLAIN, 20));
		btnZc.setBounds(345, 316, 93, 34);
//		btnZc.setContentAreaFilled(false);
//		btnZc.setBorderPainted(false);
		contentPane.add(btnZc);
		
		JLabel lblNewLabel = new JLabel("\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setFont(new Font("华光中圆_CNKI", Font.PLAIN, 30));
		lblNewLabel.setBounds(296, 96, 185, 34);
		contentPane.add(lblNewLabel);
		
		ImageIcon image=new ImageIcon("C:\\Users\\mycom\\Pictures\\Saved Pictures\\Login.png");
		JLabel label=new JLabel(image);
		contentPane.add(label);
		label.setBounds(0,0,630,203);
		
		this.setSize(640,430);
		this.setLocationRelativeTo(null);//窗体居中
		
	}
	
	/**
	 * 检验账号
	 * @return false
	 */
	public boolean checkInputZh() {//检验账号
		  if(txtZh.getText().length()==0) {//获取账号输入框的内容长度
		    lblMsgZh.setText("账号不能为空");//设置警告信息
		    txtZh.requestFocus();//账号输入框获取焦点
		    return false;
		  }else if(!txtZh.getText().matches("\\d+")) {//正则匹配整数
		    lblMsgZh.setText("账号必须是数字");
		    txtZh.requestFocus();//账号输入框获取焦点
		    txtZh.selectAll();//全选当中的内容
		    return false;
		  } 
		  lblMsgZh.setText("");//当检验通过时设置提示文本不可见
		  return true;
	}
	
	/**
	 * 检验密码
	 * @return false
	 */
	public boolean checkInputMm() {//检验密码
		  if(txtMm.getText().length()==0) {//获取密码输入框的内容长度
		    lblMsgMm.setText("密码不能为空");//设置警告信息
		    txtMm.requestFocus();//密码输入框获取焦点
		    return false;
		  }
		  lblMsgMm.setText("");//当检验通过时设置提示文本不可见
		  return true;
	}
}
