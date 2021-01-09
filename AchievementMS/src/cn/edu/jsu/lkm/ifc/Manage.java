package cn.edu.jsu.lkm.ifc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import cn.edu.jsu.lkm.dao.*;
import cn.edu.jsu.lkm.dao.impl.DataOperate;
import cn.edu.jsu.lkm.dao.impl.OperationSql;
import cn.edu.jsu.lkm.ifc.*;
import cn.edu.jsu.lkm.vo.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

/**
 * ����������
 * @author mycom
 *
 */
public class Manage extends JFrame {
	private JPanel contentPane;// ���崰��������壬���ø����
	private JTable table;// ������
	private DefaultTableModel model;// ����������ģ��
	private JTextField txtKey;//�����

	public static void main(String[] args) {
		Manage frame = new Manage();// ʵ��������
		frame.setVisible(true);// ����ɼ�
		frame.setLocationRelativeTo(null);// �������
	}

	/**
	 * ���幹�췽���������弰���.
	 */
	public Manage() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// ���ô���رհ�ť
		setBounds(100, 100, 702, 529);// ���ô���λ�����С
		contentPane = new JpaneFrm();// ʵ�����������
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));// �������߿�
		contentPane.setLayout(null);// ������岼��Ϊ���Բ���
		setContentPane(contentPane);// ������Ĭ�����

		// ���ù������
		JScrollPane scrollPane = new JScrollPane();// �����������
		scrollPane.setBounds(45, 46, 600, 380);// ���ô�С��λ��
		contentPane.add(scrollPane);// �����������뵽���������

		// ʹ�ö�̬�������ݣ��б����������ݣ�
		Vector<String> titles = new Vector<String>();// ���嶯̬�����ʾ������
		Collections.addAll(titles, "ˮ����", "��ˮ��", "ˮ��λ��","��Ⱦ���","�������");
		String sql="select * from watertable where governance='δ������'";//�����ѯ���
		Vector<Vector> stuInfo = DataOperate.getSelectAll(sql);// �����ݿ��ж�ȡ����������

//		ʹ�þ�̬���ݴ���DefaultTableModel����ģ��
		model = new DefaultTableModel(stuInfo, titles) {// ʹ��Vectorװ�ر������ģ�ͣ���дgetColumnClass������ʵ�ְ����е�������������
			public Class getColumnClass(int column) {//��ȡ�е�����
				Class returnValue;
				if ((column >= 0) && (column < getColumnCount())) {
					returnValue = getValueAt(0, column).getClass();
				} else {
					returnValue = Object.class;
				}
				return returnValue;
			}
		};
		table = new JTable(model);// ʹ��DefaultTableModel����ģ��ʵ�������
		TableRowSorter sorter = new TableRowSorter<DefaultTableModel>(model);//����������
		table.setRowSorter(sorter);//���ñ���������
		
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("\u672A\u6CBB\u7406\u6C34\u6E90\u8868");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel.setBounds(262, 10, 193, 26);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\u6CBB\u7406");
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setFont(new Font("����", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new OperationSql().doManage(table,model);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(400, 440, 103, 26);
		contentPane.add(btnNewButton);
		
		txtKey = new JTextField();
		txtKey.setBounds(168, 445, 117, 21);
		contentPane.add(txtKey);
		txtKey.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BF7\u8F93\u5165\u5173\u952E\u5B57");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(71, 445, 87, 21);
		contentPane.add(lblNewLabel_1);
		
		//��������
		JButton btnFind = new JButton("����");
		btnFind.setFont(new Font("����", Font.PLAIN, 20));
		btnFind.setForeground(Color.BLACK);
		btnFind.setBackground(Color.CYAN);
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key=txtKey.getText().trim();//��ȡ����ؼ����ı����ֵ
				if(key.length()!=0) {
					sorter.setRowFilter(RowFilter.regexFilter(key));//�Ƿ����������ֵ
				}else {
					sorter.setRowFilter(null);//�����ˣ���ʾ��������
				}
				
			}
		});
		btnFind.setBounds(295, 440, 103, 26);
		contentPane.add(btnFind);
	}
}