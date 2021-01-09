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

/**
 * ���ݹ������
 * @author mycom
 *
 */
public class FrmTable extends JFrame {
	private JPanel contentPane;// ���崰��������壬���ø����
	private JTable table;// ������
	private DefaultTableModel model;// ����������ģ��
	private JTextField txtKey;// �����

	public static void main(String[] args) {
		FrmTable frame = new FrmTable();// ʵ��������
		frame.setLocationRelativeTo(null);// �������
		frame.setVisible(true);// ����ɼ�
	}

	/**
	 * ���幹�췽���������弰���.
	 */
	public FrmTable() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// ���ô���رհ�ť
		setBounds(100, 100, 748, 529);// ���ô���λ�����С
		contentPane = new JpaneFrm();// ʵ�����������
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));// �������߿�
		contentPane.setLayout(null);// ������岼��Ϊ���Բ���
		setContentPane(contentPane);// ������Ĭ�����

		// ���ù������
		JScrollPane scrollPane = new JScrollPane();// �����������
		scrollPane.setBounds(44, 82, 643, 380);// ���ô�С��λ��
		contentPane.add(scrollPane);// �����������뵽���������

		// ʹ�ö�̬�������ݣ��б����������ݣ�
		Vector<String> titles = new Vector<String>();// ���嶯̬�����ʾ������
		Collections.addAll(titles, "ˮ����", "��ˮ��", "ˮ��λ��","��Ⱦ���","�������");
		String sql="select * from watertable";//�����ѯ���
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
		
		scrollPane.setViewportView(table);// ����ʹ�ù��������ʾ��������ʹ�ù��������ʾ��������б����޷���ʾ
		
		JLabel lblKey = new JLabel("����ؼ��֣�");
		lblKey.setForeground(Color.WHITE);
		lblKey.setBounds(44, 40, 79, 15);
		contentPane.add(lblKey);
		
		txtKey = new JTextField();
		txtKey.setBounds(117, 37, 119, 21);
		contentPane.add(txtKey);
		txtKey.setColumns(10);
		
		//��������
		JButton btnFind = new JButton("����");
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
		btnFind.setBounds(246, 35, 95, 25);
		contentPane.add(btnFind);
		
		//ɾ������
		JButton btnNewButton = new JButton("\u5220\u9664");
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new OperationSql().doDelete(table, model);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(351, 35, 95, 25);
		contentPane.add(btnNewButton);
		
		//�޸�����
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.setBackground(Color.CYAN);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "ȷ��Ҫ�޸�������","",JOptionPane.YES_NO_OPTION) == 0)
				try {
					new OperationSql().doUpdate(table, model);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(456, 35, 95, 25);
		contentPane.add(btnNewButton_1);
		
		//��������
		JButton btnNewButton_2 = new JButton("\u589E\u52A0");
		btnNewButton_2.setBackground(Color.CYAN);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add frame = new Add();
				frame.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(561, 35, 95, 25);
		contentPane.add(btnNewButton_2);
	}
}