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
 * ���ݲ�ʵ����
 * @author mycom
 *
 */
public class OperationFile implements UserDAO{
    final static File file=new File("D:/java�γ����/Zh.txt");
    
        /**
         * ʵ���ı������ݵ�����
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
		 * ��ѯ�˺��Ƿ����
		 */
		public Boolean find(String account) {
			String line;//�ַ�����ȡ
			try (FileReader fr = new FileReader(file);){
				BufferedReader br=new BufferedReader(fr);//ʹ�û�����
				while((line=br.readLine())!=null) {
					String[] col=line.split("\t");//���Ϊ����,��һ���ֶ�Ϊ�˺ţ��ڶ����ֶ�Ϊ����
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
         * ��ѯ�û������������ı��Ƿ�ƥ��
         */
		public boolean checkLogin(String account,String password) {
			String line;//�ַ�����ȡ
			try (FileReader fr = new FileReader(file);){
				BufferedReader br=new BufferedReader(fr);//ʹ�û�����
				while((line=br.readLine())!=null) {
					String[] col=line.split("\t");//���Ϊ����,��һ���ֶ�Ϊ�˺ţ��ڶ����ֶ�Ϊ����
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
         * �û��޸�����
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
		 * �õ��û�����������
		 */
		public Vector<User> get(){
			String line;//�ַ�����ȡ
			Vector<User> user = new Vector<User>();
			try (FileReader fr = new FileReader(file);){
				BufferedReader br=new BufferedReader(fr);//ʹ�û�����
				while((line=br.readLine())!=null) {
					String[] col=line.split("\t");//���Ϊ����
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

