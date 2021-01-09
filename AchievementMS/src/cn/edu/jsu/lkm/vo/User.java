package cn.edu.jsu.lkm.vo;

import java.io.Serializable;
/**
 * �Զ���ʵ����User����˺�����
 * @author lkm
 *
 */
public class User implements Serializable{
	private String account;//�˺�
	private String password;//����
	
	/**
	 * �չ��췽��
	 */
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * ���췽��ʵ�����˺ź�����
	 * @param account �˺�
	 * @param password ����
	 */
	public User(String account, String password) {
		super();
		this.account = account;
		this.password = password;
	}
	
	/**
	 * get���������˺�
	 * @return String
	 */
	public String getAccount() {
		return account;
	}
	
	/**
	 * set���������˺�
	 * @param account �˺�
	 */
	public void setAccount(String account) {
		this.account = account;
	}
	
	/**
	 * get������������
	 * @return String 
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * set������������
	 * @param password ����
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
	  return "�˺�:"+this.account+",����:"+this.password;
	}
	}
	

