package cn.edu.jsu.lkm.dao;

import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * 定义water表的数据层的操作标准	
 * @author mycom
 *
 */
public interface WaterDAO {

	/**
	 *  实现数据库数据的增加操作
	 * @param a 水域名
	 * @param b 储水量
	 * @param c 水域位置
	 * @param d 污染情况
	 * @param e 治理情况
	 * @throws SQLException SQL执行异常
	 */
	public void doCreat(String a,double b,String c,String d,String e) throws SQLException;
	
	/**
	 * 实现数据库数据的删除操作  
	 * @param table 数据表格
	 * @param model 数据模型
	 * @throws SQLException SQL执行异常
	 */
	public void doDelete(JTable table,DefaultTableModel model) throws SQLException;
	
	/**
	 * 实现数据库数据的修改操作
	 * @param table 数据表格
	 * @param model 数据模型
	 * @throws SQLException SQL执行异常
	 */
	public  void doUpdate(JTable table,DefaultTableModel model) throws SQLException;
	
	/**
	 *  数据库数据操作
	 * @param table 数据表格
	 * @param model 数据模型
	 * @throws SQLException SQL执行异常
	 */
	public  void doManage(JTable table,DefaultTableModel model) throws SQLException ;
}
