package cn.edu.jsu.lkm.ifc;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.jsu.lkm.dao.impl.OperationFile;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * �޸��������
 * @author mycom
 *
 */
public class Update extends JFrame {

	private JPanel contentPane;//�������
	private JTextField txt1;//�����
	private JTextField txt2;//�����
	private JTextField txt3;//�����
	private JLabel lbl1;//��ǩ
	private JLabel lbl2;//��ǩ
	private JLabel lbl3;//��ǩ
	private JButton btnNewButton_1;//��ť

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update frame = new Update();
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
	public Update() {
		setTitle("\u4FEE\u6539\u5BC6\u7801");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JpaneMag();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u8D26\u53F7");
		lblNewLabel.setBounds(44, 61, 85, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BF7\u8F93\u5165\u539F\u5BC6\u7801");
		lblNewLabel_1.setBounds(44, 101, 85, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u8BF7\u8F93\u5165\u65B0\u5BC6\u7801");
		lblNewLabel_2.setBounds(44, 141, 85, 23);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("\u4FEE\u6539");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkAccount()) {
					if(checkPassword()) {
						if(checkNewPassword()) {
							if(JOptionPane.showConfirmDialog(null, "ȷ��Ҫ�޸�������","",JOptionPane.YES_NO_OPTION)==0) {
							if(new OperationFile().doUpdate(txt1.getText(), txt3.getText())) {
							JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
				          }	
							}

						}
					}
				}

			}
		});
		btnNewButton.setBounds(137, 193, 73, 33);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("\u5BC6\u7801\u4FEE\u6539\u7CFB\u7EDF");
		lblNewLabel_3.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(128, 10, 171, 33);
		contentPane.add(lblNewLabel_3);
		
		txt1 = new JTextField();
		txt1.setBounds(138, 62, 161, 23);
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		txt2 = new JTextField();
		txt2.setBounds(138, 102, 161, 23);
		contentPane.add(txt2);
		txt2.setColumns(10);
		
		txt3 = new JTextField();
		txt3.setBounds(138, 142, 161, 23);
		contentPane.add(txt3);
		txt3.setColumns(10);
		
		lbl1 = new JLabel("");
		lbl1.setForeground(Color.RED);
		lbl1.setBounds(309, 65, 117, 23);
		contentPane.add(lbl1);
		
		lbl2 = new JLabel("");
		lbl2.setForeground(Color.RED);
		lbl2.setBounds(309, 105, 117, 23);
		contentPane.add(lbl2);
		
		lbl3 = new JLabel("");
		lbl3.setForeground(Color.RED);
		lbl3.setBounds(309, 145, 117, 23);
		contentPane.add(lbl3);
		
		btnNewButton_1 = new JButton("\u8FD4\u56DE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(220, 193, 73, 33);
		contentPane.add(btnNewButton_1);
		this.setLocationRelativeTo(null);
	}
	
	/**
	 * �����˺�
	 * @return false
	 */
	public boolean checkAccount() {
		  if(txt1.getText().length()==0) {
		    lbl1.setText("�˺Ų���Ϊ��");
		    txt1.requestFocus();
		    return false;
		  }else if(!txt1.getText().matches("\\d+")) {//����ƥ������
			    lbl1.setText("�˺ű���������");
			    txt1.requestFocus();
			    txt1.selectAll();//ȫѡ���е�����
			    return false;
		  }
		  lbl1.setText("");
		  return true;
	}
	
	/**
	 * ���������
	 * @return false
	 */
	public boolean checkPassword() {
		  if(txt2.getText().length()==0) {
		    lbl2.setText("���벻��Ϊ��");
		    txt2.requestFocus();
		    return false;
		  }
		  lbl2.setText("");
		  return true;
	}
	
	/**
	 * ����������
	 * @return false
	 */
	public boolean checkNewPassword() {
		  if(txt3.getText().length()==0) {
		    lbl3.setText("���벻��Ϊ��");
		    txt3.requestFocus();
		    return false;
		  }
		  lbl3.setText("");
		  return true;
	}
	
}
