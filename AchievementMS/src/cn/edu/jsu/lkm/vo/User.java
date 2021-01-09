package cn.edu.jsu.lkm.vo;

import java.io.Serializable;
/**
 * 自定义实体类User存放账号密码
 * @author lkm
 *
 */
public class User implements Serializable{
	private String account;//账号
	private String password;//密码
	
	/**
	 * 空构造方法
	 */
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 构造方法实例化账号和密码
	 * @param account 账号
	 * @param password 密码
	 */
	public User(String account, String password) {
		super();
		this.account = account;
		this.password = password;
	}
	
	/**
	 * get方法返回账号
	 * @return String
	 */
	public String getAccount() {
		return account;
	}
	
	/**
	 * set方法设置账号
	 * @param account 账号
	 */
	public void setAccount(String account) {
		this.account = account;
	}
	
	/**
	 * get方法返回密码
	 * @return String 
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * set方法设置密码
	 * @param password 密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
	  return "账号:"+this.account+",密码:"+this.password;
	}
	}
	

