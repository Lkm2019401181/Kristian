package cn.edu.jsu.lkm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import cn.edu.jsu.lkm.dao.WaterDAO;
import cn.edu.jsu.lkm.dbc.*;

/**
 * 数据层实现类
 * @author mycom
 *
 */
public class OperationSql implements WaterDAO{

	private static Connection conn=null;
	private static PreparedStatement pstmt=null;
	private static PreparedStatement pstmt2=null;
	private static String watername;
	private static double watercapacity;
	private static String waterposition;
	private static String pollutionsituation;
	private static String governance;
	
    /**
     * 对未被治理的水源生成治理方案
     */
	public  void doManage(JTable table,DefaultTableModel model) throws SQLException {
		if (table.getSelectedRow() != -1) {// 是否选择了要删除的行
			  if (JOptionPane.showConfirmDialog(null, "是否为该水源添加治理方案？","",JOptionPane.YES_NO_OPTION) == 0) {// 确定对话框
				  conn=new DatabaseConnectionSql().getConnection();
				  String s=(String) model.getValueAt(table.getSelectedRow(), 0);
				  String sql="update watertable set governance='正在治理' where watername='"+s+"' ";
		            pstmt=conn.prepareStatement(sql);
		            pstmt.executeUpdate();
		            JOptionPane.showMessageDialog(null, "已为该水源生成治理方案");
		            model.removeRow(table.convertRowIndexToModel(table.getSelectedRow()));
			  } else {
			    JOptionPane.showMessageDialog(null, "请选择要治理的水源的行");
			  }
			}
	}
	
	/**
	 * 增加数据到数据库
	 */
	public void doCreat(String a,double b,String c,String d,String e) throws SQLException {
		conn=new DatabaseConnectionSql().getConnection();
		String sql="insert into watertable(watername,watercapacity,waterposition,pollutionsituation,governance)"+"values('"+a+"',  "+b+",  '"+c+"',   '"+d+"',   '"+e+"')";
		pstmt=conn.prepareStatement(sql);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}
	
	/**
	 * 删除数据
	 */
	public  void doDelete(JTable table,DefaultTableModel model) throws SQLException {
		if (table.getSelectedRow() != -1) {// 是否选择了要删除的行
			  if (JOptionPane.showConfirmDialog(null, "确定要删除数据吗？","",JOptionPane.YES_NO_OPTION) == 0) {// 确定对话框
	            conn=new DatabaseConnectionSql().getConnection();
	            String s=(String) model.getValueAt(table.getSelectedRow(), 0);
	            String sql="delete from watertable where watername='"+s+"' ";
	            pstmt=conn.prepareStatement(sql);
	            pstmt.executeUpdate();
	            JOptionPane.showMessageDialog(null, "删除成功");
	            pstmt.close();
	            model.removeRow(table.convertRowIndexToModel(table.getSelectedRow()));
			    //从表格数据中删除行,model1为DefaultTableModel类型，排序后不能直接使用表格的getSelectedRow方法获取被选中的行
			  } else {
			    JOptionPane.showMessageDialog(null, "请选择要删除的行");
			  }
			}	
}
        
    /**
     * 修改数据
     */
    public  void doUpdate(JTable table,DefaultTableModel model) throws SQLException {

        try {         
            conn=new DatabaseConnectionSql().getConnection();
            String sql1="delete from watertable";
            String sql2="insert into watertable(watername,watercapacity,waterposition,pollutionsituation,governance) values(?,?,?,?,?)";
            pstmt=conn.prepareStatement(sql1);
            pstmt.executeUpdate();
            pstmt2=conn.prepareStatement(sql2);
        	for (int i = 0; i < model.getRowCount(); i++) {// 遍历表格数据
        		watername=model.getValueAt(i, 0).toString();
        		watercapacity=(double) model.getValueAt(i, 1);
        		waterposition=model.getValueAt(i, 2).toString();
        		pollutionsituation=model.getValueAt(i, 3).toString();
        		governance=model.getValueAt(i, 4).toString();
    			pstmt2.setString(1, watername);//定义第1个占位符的内容
          		pstmt2.setDouble(2, watercapacity);//定义第2个占位符的内容
        		pstmt2.setString(3, waterposition);//定义第3个占位符的内容
        		pstmt2.setString(4, pollutionsituation);//定义第4个占位符的内容
        		pstmt2.setString(5, governance);//定义第5个占位符的内容
        		pstmt2.addBatch();//加入批处理等待执行
        	}
        	pstmt2.executeBatch();//批量执行插入操作
        	JOptionPane.showMessageDialog(null, "修改成功");
        } finally {
        	pstmt.close();
            pstmt2.close();
            conn.close();
        }
    }
	
}

