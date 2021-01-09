package cn.edu.jsu.lkm.dao;

import java.util.Vector;

import cn.edu.jsu.lkm.vo.User;

/**
 * ����User������ݲ�Ĳ�����׼
 * @author mycom
 *
 */
public interface UserDAO {

	/**
	 * ʵ���ı������ݵ�����
	 * @param user �Զ���User��
	 * @return  false
	 */
	public boolean doCreate(User user);
	
	/**
	 * ��ѯ�˺��Ƿ����
	 * @param account �˺�
	 * @return false
	 */
	public Boolean find(String account);
	
	/**
	 * ����¼
	 * @param account �˺�
	 * @param password ����
	 * @return false
	 */
	
	/**
	 * �õ��û�����������
	 * @return Vector
	 */
	public Vector<User> get();
	
	/**
	 * ��ѯ�û������������ı��Ƿ�ƥ��
	 * @param account �˺�
	 * @param password ����
	 * @return false
	 */
	public boolean checkLogin(String account,String password);
	

	/**
	 * �û��޸�����
	 * @param account �˺�
	 * @param password ����
	 * @return false
	 */
	public boolean doUpdate(String account,String password);
}
