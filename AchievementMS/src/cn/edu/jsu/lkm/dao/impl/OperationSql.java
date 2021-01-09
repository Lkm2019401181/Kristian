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
 * ���ݲ�ʵ����
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
     * ��δ�������ˮԴ����������
     */
	public  void doManage(JTable table,DefaultTableModel model) throws SQLException {
		if (table.getSelectedRow() != -1) {// �Ƿ�ѡ����Ҫɾ������
			  if (JOptionPane.showConfirmDialog(null, "�Ƿ�Ϊ��ˮԴ�����������","",JOptionPane.YES_NO_OPTION) == 0) {// ȷ���Ի���
				  conn=new DatabaseConnectionSql().getConnection();
				  String s=(String) model.getValueAt(table.getSelectedRow(), 0);
				  String sql="update watertable set governance='��������' where watername='"+s+"' ";
		            pstmt=conn.prepareStatement(sql);
		            pstmt.executeUpdate();
		            JOptionPane.showMessageDialog(null, "��Ϊ��ˮԴ����������");
		            model.removeRow(table.convertRowIndexToModel(table.getSelectedRow()));
			  } else {
			    JOptionPane.showMessageDialog(null, "��ѡ��Ҫ�����ˮԴ����");
			  }
			}
	}
	
	/**
	 * �������ݵ����ݿ�
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
	 * ɾ������
	 */
	public  void doDelete(JTable table,DefaultTableModel model) throws SQLException {
		if (table.getSelectedRow() != -1) {// �Ƿ�ѡ����Ҫɾ������
			  if (JOptionPane.showConfirmDialog(null, "ȷ��Ҫɾ��������","",JOptionPane.YES_NO_OPTION) == 0) {// ȷ���Ի���
	            conn=new DatabaseConnectionSql().getConnection();
	            String s=(String) model.getValueAt(table.getSelectedRow(), 0);
	            String sql="delete from watertable where watername='"+s+"' ";
	            pstmt=conn.prepareStatement(sql);
	            pstmt.executeUpdate();
	            JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
	            pstmt.close();
	            model.removeRow(table.convertRowIndexToModel(table.getSelectedRow()));
			    //�ӱ��������ɾ����,model1ΪDefaultTableModel���ͣ��������ֱ��ʹ�ñ���getSelectedRow������ȡ��ѡ�е���
			  } else {
			    JOptionPane.showMessageDialog(null, "��ѡ��Ҫɾ������");
			  }
			}	
}
        
    /**
     * �޸�����
     */
    public  void doUpdate(JTable table,DefaultTableModel model) throws SQLException {

        try {         
            conn=new DatabaseConnectionSql().getConnection();
            String sql1="delete from watertable";
            String sql2="insert into watertable(watername,watercapacity,waterposition,pollutionsituation,governance) values(?,?,?,?,?)";
            pstmt=conn.prepareStatement(sql1);
            pstmt.executeUpdate();
            pstmt2=conn.prepareStatement(sql2);
        	for (int i = 0; i < model.getRowCount(); i++) {// �����������
        		watername=model.getValueAt(i, 0).toString();
        		watercapacity=(double) model.getValueAt(i, 1);
        		waterposition=model.getValueAt(i, 2).toString();
        		pollutionsituation=model.getValueAt(i, 3).toString();
        		governance=model.getValueAt(i, 4).toString();
    			pstmt2.setString(1, watername);//�����1��ռλ��������
          		pstmt2.setDouble(2, watercapacity);//�����2��ռλ��������
        		pstmt2.setString(3, waterposition);//�����3��ռλ��������
        		pstmt2.setString(4, pollutionsituation);//�����4��ռλ��������
        		pstmt2.setString(5, governance);//�����5��ռλ��������
        		pstmt2.addBatch();//����������ȴ�ִ��
        	}
        	pstmt2.executeBatch();//����ִ�в������
        	JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
        } finally {
        	pstmt.close();
            pstmt2.close();
            conn.close();
        }
    }
	
}

