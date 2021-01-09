package cn.edu.jsu.lkm.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Vector;

import javax.swing.JOptionPane;

import cn.edu.jsu.lkm.dao.UserDAO;
import cn.edu.jsu.lkm.vo.User;

/**
 * 数据层实现类
 * @author mycom
 *
 */
public class OperationFile implements UserDAO{
    final static File file=new File("D:/java课程设计/Zh.txt");
    
        /**
         * 实现文本里数据的增加
         */
		public boolean doCreate(User user) {
			try (FileWriter fw=new FileWriter(file,true)){
	   		    Vector<User> user2=get();
				for(int i=0;i<user2.size();i++) {
					if(find(user.getAccount()))
						{
                         return false;
						}else {
							fw.write(user.getAccount()+'\t'+user.getPassword()+'\n');
							return true;
						}
				}
				} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		/**
		 * 查询账号是否存在
		 */
		public Boolean find(String account) {
			String line;//字符串读取
			try (FileReader fr = new FileReader(file);){
				BufferedReader br=new BufferedReader(fr);//使用缓冲流
				while((line=br.readLine())!=null) {
					String[] col=line.split("\t");//拆分为数组,第一个字段为账号，第二个字段为密码
					if(col[0].equals(account)) 
					return true;
					}
			  } catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
				return false;
			}
			return false;
		}
		
        /**
         * 查询用户名和密码与文本是否匹配
         */
		public boolean checkLogin(String account,String password) {
			String line;//字符串读取
			try (FileReader fr = new FileReader(file);){
				BufferedReader br=new BufferedReader(fr);//使用缓冲流
				while((line=br.readLine())!=null) {
					String[] col=line.split("\t");//拆分为数组,第一个字段为账号，第二个字段为密码
					if(col[0].equals(account)) {
						if(col[1].equals(password))
							return true;
						else
							return false;
						}
					}
			  } catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			return false;
		}
	  
        /**
         * 用户修改密码
         */
		public boolean doUpdate(String account,String password) {
			Boolean b=false;
   		    Vector<User> user=get();
			for(int i=0;i<user.size();i++) {
				if(user.get(i).getAccount().equals(account))
					{
					 user.get(i).setPassword(password);
					 b=true;
					}
			}
			try (FileWriter fw=new FileWriter(file,false)){
				for(int i=0;i<user.size();i++)
				fw.write(user.get(i).getAccount()+'\t'+user.get(i).getPassword()+'\n');
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			return b;
		}

		/**
		 * 得到用户的所有数据
		 */
		public Vector<User> get(){
			String line;//字符串读取
			Vector<User> user = new Vector<User>();
			try (FileReader fr = new FileReader(file);){
				BufferedReader br=new BufferedReader(fr);//使用缓冲流
				while((line=br.readLine())!=null) {
					String[] col=line.split("\t");//拆分为数组
					user.add(new User(col[0],col[1]));
					}
			  } catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
				return null;
			}
			return user;
			
		}
  }

