package cn.edu.jsu.lkm.dao;

import java.util.Vector;

import cn.edu.jsu.lkm.vo.User;

/**
 * 定义User表的数据层的操作标准
 * @author mycom
 *
 */
public interface UserDAO {

	/**
	 * 实现文本里数据的增加
	 * @param user 自定义User类
	 * @return  false
	 */
	public boolean doCreate(User user);
	
	/**
	 * 查询账号是否存在
	 * @param account 账号
	 * @return false
	 */
	public Boolean find(String account);
	
	/**
	 * 检查登录
	 * @param account 账号
	 * @param password 密码
	 * @return false
	 */
	
	/**
	 * 得到用户的所有数据
	 * @return Vector
	 */
	public Vector<User> get();
	
	/**
	 * 查询用户名和密码与文本是否匹配
	 * @param account 账号
	 * @param password 密码
	 * @return false
	 */
	public boolean checkLogin(String account,String password);
	

	/**
	 * 用户修改密码
	 * @param account 账号
	 * @param password 密码
	 * @return false
	 */
	public boolean doUpdate(String account,String password);
}
