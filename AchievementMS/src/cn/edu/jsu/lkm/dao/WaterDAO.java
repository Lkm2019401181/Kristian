package cn.edu.jsu.lkm.dao;

import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * ����water������ݲ�Ĳ�����׼	
 * @author mycom
 *
 */
public interface WaterDAO {

	/**
	 *  ʵ�����ݿ����ݵ����Ӳ���
	 * @param a ˮ����
	 * @param b ��ˮ��
	 * @param c ˮ��λ��
	 * @param d ��Ⱦ���
	 * @param e �������
	 * @throws SQLException SQLִ���쳣
	 */
	public void doCreat(String a,double b,String c,String d,String e) throws SQLException;
	
	/**
	 * ʵ�����ݿ����ݵ�ɾ������  
	 * @param table ���ݱ��
	 * @param model ����ģ��
	 * @throws SQLException SQLִ���쳣
	 */
	public void doDelete(JTable table,DefaultTableModel model) throws SQLException;
	
	/**
	 * ʵ�����ݿ����ݵ��޸Ĳ���
	 * @param table ���ݱ��
	 * @param model ����ģ��
	 * @throws SQLException SQLִ���쳣
	 */
	public  void doUpdate(JTable table,DefaultTableModel model) throws SQLException;
	
	/**
	 *  ���ݿ����ݲ���
	 * @param table ���ݱ��
	 * @param model ����ģ��
	 * @throws SQLException SQLִ���쳣
	 */
	public  void doManage(JTable table,DefaultTableModel model) throws SQLException ;
}
