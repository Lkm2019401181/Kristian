package cn.edu.jsu.lkm.dbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * ���ݿ�����
 * @author mycom
 *
 */
public class DatabaseConnectionSql {
	//����SQLServer���ݿ���������
	private static final String DBRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	//����SQLServer���ݿ����ӵ�ַ
	private static final String DBURL="jdbc:sqlserver://localhost:1433;DatabaseName=water";
	private static final String DBUSER="sa"; //SQLServer���ݿ������û���
	private static final String PASSWORD="549262"; //SQLServer���ݿ���������
	private Connection conn=null; //�������Ӷ���
	
	/**
	 * ���췽���������ݿ�
	 */
	public DatabaseConnectionSql() {//���췽���������ݿ�
		try {
			Class.forName(DBRIVER);
			this.conn=DriverManager.getConnection(DBURL,DBUSER,PASSWORD);
		} catch (Exception e) {e.printStackTrace();}
	}
	
	/**
	 * �������ݿ����Ӷ���
	 * @return Connection
	 */
	public  Connection getConnection() {//�������ݿ����Ӷ���
		return this.conn;
	}
	
	/**
	 * �ر����ݿ�����
	 */
	public void close() {//�ر���������
		if(this.conn!=null) {
			try {
				this.conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}