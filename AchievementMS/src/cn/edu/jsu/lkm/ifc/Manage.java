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
 * 治理方案界面
 * @author mycom
 *
 */
public class Manage extends JFrame {
	private JPanel contentPane;// 定义窗体内容面板，放置各组件
	private JTable table;// 定义表格
	private DefaultTableModel model;// 定义表格数据模型
	private JTextField txtKey;//输入框

	public static void main(String[] args) {
		Manage frame = new Manage();// 实例化窗体
		frame.setVisible(true);// 窗体可见
		frame.setLocationRelativeTo(null);// 窗体居中
	}

	/**
	 * 定义构造方法创建窗体及组件.
	 */
	public Manage() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// 设置窗体关闭按钮
		setBounds(100, 100, 702, 529);// 设置窗体位置与大小
		contentPane = new JpaneFrm();// 实例化内容面板
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));// 设置面板边框
		contentPane.setLayout(null);// 设置面板布局为绝对布局
		setContentPane(contentPane);// 将窗体默认面板

		// 设置滚动面板
		JScrollPane scrollPane = new JScrollPane();// 创建滚动面板
		scrollPane.setBounds(45, 46, 600, 380);// 设置大小与位置
		contentPane.add(scrollPane);// 将滚动面板加入到内容面板中

		// 使用动态数组数据（列标题与行数据）
		Vector<String> titles = new Vector<String>();// 定义动态数组表示表格标题
		Collections.addAll(titles, "水域名", "储水量", "水域位置","污染情况","治理情况");
		String sql="select * from watertable where governance='未被治理'";//定义查询语句
		Vector<Vector> stuInfo = DataOperate.getSelectAll(sql);// 从数据库中读取所有行数据

//		使用静态数据创建DefaultTableModel数据模型
		model = new DefaultTableModel(stuInfo, titles) {// 使用Vector装载表格数据模型，覆写getColumnClass方法，实现按各列的数据类型排序
			public Class getColumnClass(int column) {//获取列的类型
				Class returnValue;
				if ((column >= 0) && (column < getColumnCount())) {
					returnValue = getValueAt(0, column).getClass();
				} else {
					returnValue = Object.class;
				}
				return returnValue;
			}
		};
		table = new JTable(model);// 使用DefaultTableModel数据模型实例化表格
		TableRowSorter sorter = new TableRowSorter<DefaultTableModel>(model);//设置排序器
		table.setRowSorter(sorter);//设置表格的排序器
		
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("\u672A\u6CBB\u7406\u6C34\u6E90\u8868");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 20));
		lblNewLabel.setBounds(262, 10, 193, 26);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\u6CBB\u7406");
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
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
		
		//查找数据
		JButton btnFind = new JButton("查找");
		btnFind.setFont(new Font("宋体", Font.PLAIN, 20));
		btnFind.setForeground(Color.BLACK);
		btnFind.setBackground(Color.CYAN);
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key=txtKey.getText().trim();//获取输入关键字文本框的值
				if(key.length()!=0) {
					sorter.setRowFilter(RowFilter.regexFilter(key));//是否包含输入框的值
				}else {
					sorter.setRowFilter(null);//不过滤，显示所有数据
				}
				
			}
		});
		btnFind.setBounds(295, 440, 103, 26);
		contentPane.add(btnFind);
	}
}