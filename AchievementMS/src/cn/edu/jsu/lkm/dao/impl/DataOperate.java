package cn.edu.jsu.lkm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import cn.edu.jsu.lkm.dbc.*;
/**
 * ���ݲ�ʵ����
 * @author mycom
 *
 */
public class DataOperate {

	//����ˮԴ�ĵ�һ������
	private static String firstName="������ˮ��������˸��ɷ�����³Τ������ﻨ������Ԭ��ۺ��ʷ�Ʒ����Ѧ�׺����������ޱϺ�����������ʱ��Ƥ���뿵����Ԫ������ƽ�ƺ�������Ҧ��տ����ë����ױ���갼Ʒ��ɴ�̸��é���ܼ�������ף������������ϯ����ǿ��·¦Σ��ͯ�չ�÷ʢ�ֵ�����������Ĳ��﷮���������֧�¾̹�¬Ī�������Ѹɽ�Ӧ�������ڵ��������������ʯ�޼�ť�������ϻ���½��������춻���κ�ӷ����ഢ���������ɾ��θ����ڽ��͹�����ɽ�ȳ������ȫۭ�����������������ﱩ�����������������ղ����Ҷ��˾��۬�輻��ӡ�ް׻���̨�Ӷ����̼���׿�����ɳ����������ܲ�˫��ݷ����̷�����̼������Ƚ��۪Ӻȴ�ɣ���ţ��ͨ�����༽ۣ����ũ�±�ׯ�̲����ֳ�Ľ����ϰ�°���������������θ����߾Ӻⲽ�����������Ŀܹ�»�ڶ�Ź�����εԽ��¡ʦ�������˹��������������Ǽ��Ŀ�����ɳؿ������ᳲ�������󽭺�����Ȩ�ָ��滸����ٹ˾���Ϲ�ŷ���ĺ�������˶��������ʸ�ξ�ٹ����̨��ұ���������������̫����������������ԯ�������������Ľ����������˾ͽ˾������˾���붽�ӳ�����ľ����������������ṫ���ذμй��׸����������ַ���۳Ϳ�նθɰ��ﶫ�����ź��ӹ麣����΢����˧�ÿ�������������������������Ĳ��٦�����Ϲ�īΰ�����㿡��ǿ��ƽ�����Ļ�������������־��������ɽ�ʲ���������Ԫȫ��ʤѧ��ŷ���������ɱ�˳���ӽ��β��ɿ��ǹ���ﰲ����ï�����м�ͱ벩���Ⱦ�����׳��˼Ⱥ���İ�����ܹ����ƺ���������ԣ���ܽ���������ǫ�����֮�ֺ��ʲ����������������ά�������������󳿳�ʿ�Խ��������׵���ʱ̩ʢ��衾��ڲ�����ŷ纽��";
	//����ˮԴ�ĵڶ�������
	private static String secondName="�������Ű�쳶�ǧʫ�����ƽ����������������ݷ����ְ��س�ɮ����������Ƶ�������ʼ������Ӳ�����ΰ�����㿡��ǿ��ƽ�����Ļ�������������־��������ɽ�ʲ���������Ԫȫ��ʤѧ��ŷ���������ɱ�˳���ӽ��β��ɿ��ǹ���ﰲ����ï�����м�ͱ벩���Ⱦ�����׳��˼Ⱥ���İ�����ܹ����ƺ���������ԣ���ܽ���������ǫ�����֮�ֺ��ʲ����������������ά�������������󳿳�ʿ�Խ��������׵���ʱ̩ʢ��衾��ڲ�����ŷ纽��";
	//����ˮԴλ�õ�һ����
	private static String firstPosition="��̨����������ں����۷�ǧ�ڰ�����Ӧ���ְ���ͨ��ݷ����ְ��س�ɮ����������Ƶ�������ʼ������Ӳ�����ΰ�����㿡��ǿ��ƽ�����Ļ�������������־��������ɽ�ʲ���������Ԫȫ��ʤѧ��ŷ���������ɱ�˳���ӽ��β��ɿ��ǹ���ﰲ����ï�����м�ͱ벩���Ⱦ�����׳��˼Ⱥ���İ�����ܹ����ƺ���������ԣ���ܽ���������ǫ�����֮�ֺ��ʲ����������������ά�������������󳿳�ʿ�Խ��������׵���ʱ̩ʢ��衾��ڲ��������κ�ӷ����ഢ���������ɾ��θ����ڽ��͹�����ɽ�ȳ�";
	//����ˮԴλ�õڶ�����
	private static String secondPosition="��κ�ӷ����ഢ���������ɾ��θ����ڽ��͹�����ɽ�ȳ���������Ԭ��ۺ��ʷ�Ʒ����Ѧ�׺����������ޱϺ�����������ʱ��Ƥ���뿵����Ԫ������ƽ�ƺ�������Ҧ��տ����ë����ױ���갼Ʒ��ɴ�̸��é���ܼ�������ף������������ϯ����ǿ��·¦Σ��ͯ�չ�÷ʢ�ֵ�����������Ĳ��﷮���������֧�¾̹�¬Ī�������Ѹɽ�Ӧ��";
	
	/**
	 * �������ָ����Χ�������
	 * @param start ��ʼ����
	 * @param end ��������
	 * @return dint
	 */
	 public static int getNum(int start,int end) {
	    	//Math.random()�������0.0��1.0֮�����
	        return (int)(Math.random()*(end-start+1)+start);
	    }
	 
	 /**
	  * �������һ������
	  * @return String
	  */
	 public static String getName(){
		 int index=getNum(0, firstName.length()-1);//���ȡfirstName�ַ����е�����λ��
		 String first=firstName.substring(index, index+1);//��ȡ��λ�õ���
		 
		 //���ȡ��������
		 String third="";
		 int td=getNum(0,1);
		 if(td==0) {
			 third="��";
		 }
		 else 
			 third="Ϫ";
		 
		 int hassecond=getNum(0,1);//���ȡ�Ƿ��еڶ�����
		 String second="";//Ĭ��û�еڶ�����
		 if(hassecond==1) {//��������ȡΪ1�����еڶ�����
			 int length=secondName.length();//��ȡ�ڶ������ֵĳ���
			 index=getNum(0,length-1);
	         second=secondName.substring(index, index+1);
	         return first+second+third;
		 }
		 return first+third;
	 }
	 
	 /**
	  * �������һ��double�͵���ֵ��Ϊ��ˮ��
	  * @return dint
	  */
	 public static int getCapacity() {
		 int capacity=getNum(9999,99999);
		 return capacity;
	 }
	 
	 /**
	  * �������һ��λ��
	  * @return String
	  */
	 public static String getPosition(){
		 int index=getNum(0, firstPosition.length()-1);//���ȡfirstPosition�ַ����е�����λ��
		 String first=firstPosition.substring(index, index+1);//��ȡ��λ�õ���
		 
		 //���ȡ��������
		 String third="";
		 int td=getNum(0,1);
		 if(td==0) {
			 third="��";
		 }
		 else 
			 third="��";
		 
		 int hassecond=getNum(0,1);//���ȡ�Ƿ��еڶ�����
		 String second="";//Ĭ��û�еڶ�����
		 if(hassecond==1) {//��������ȡΪ1�����еڶ�����
			 int length=secondPosition.length();//��ȡ�ڶ������ֵĳ���
			 index=getNum(0,length-1);
	         second=secondPosition.substring(index, index+1);
	         return first+second+third;
		 }
		 return first+third;
	 }
	 
	 /**
	  * ���������Ⱦ�����
	  * @return String
	  */
	 public static String getPollution(){
		 String pl;
		 int pollution=getNum(0,2);
		 if(pollution==0) {
			 pl="�����Ⱦ";
		 }else if(pollution==1) {
			 pl="�ж���Ⱦ";
		 }else {
			 pl="�ض���Ⱦ";
		 }
		 return pl;
	 }
	 
	 /**
	  * ���������������
	  * @return String
	  */
	 public static String getgovernance() {
		 String gn;
		 int governance=getNum(0,1);
		 if(governance==0) {
			 gn="δ������";
		 }
		 else{
			 gn="��������";
		 }
		 return gn;
	 }
	 
	 /**
	  * ����10000���������
	  */
	 public static void addOprate() {
		 DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ���Զ�����������ݿ����
	    	String sql="insert into watertable(watername,watercapacity,waterposition,pollutionsituation,governance) values(?,?,?,?,?)";//ʹ��ռλ������������
	    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
	            ArrayList<String> list=new ArrayList<>();
	    		for(int i=1;i<=10000;) {
	    			    String watername=getName();//�����ȡˮԴ����
	    			    if(!list.contains(watername)) {	    			    	
	    			    list.add(watername);
	    				double watercapacity=getCapacity(); //�����ȡ��ˮ��
	    				String waterposition=getPosition();//�����ȡˮ��λ��
	    				String pollutionsituation=getPollution();//�����ȡ��Ⱦ���
	    				String governance=getgovernance();//�����ȡ�������
	    				pstmt.setString(1, watername);//�����1��ռλ��������
	    	      		pstmt.setDouble(2, watercapacity);//�����2��ռλ��������
	    	    		pstmt.setString(3, waterposition);//�����3��ռλ��������
	    	    		pstmt.setString(4, pollutionsituation);//�����4��ռλ��������
	    	    		pstmt.setString(5, governance);//�����5��ռλ��������
	    	    		pstmt.addBatch();//����������ȴ�ִ��
	    				i++;//ѧ��Ψһ��ѭ����������ִ��
	    			    }
	    			}
	    		pstmt.executeBatch();//����ִ�в������
	    		JOptionPane.showMessageDialog(null, "sucess");
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	 }
	 
	 public static void main(String[] args) {
         addOprate();
	}
	 
	 /**
	  * �����ɵ�������ӵ�������
	  * @param sql SQL���
	  * @return Vector
	  */
	 public static Vector<Vector> getSelectAll(String sql){
	    	Vector<Vector> rows=new Vector<Vector>();//����Ҫ���ص����м�¼����
	    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ���Զ�����������ݿ����
	    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
	    		ResultSet rs=pstmt.executeQuery();//ִ�в�ѯ��䣬����ŵ����ݼ���
	    		while(rs.next()) {//�������ݼ�
	    			Vector row=new Vector();//����������
	    			row.add(rs.getString(1));//��ȡ��һ���ֶ�ˮ����
	    			row.add(rs.getDouble(2));//��ȡ�ڶ����ֶδ�ˮ��
	    			row.add(rs.getString(3));//��ȡ�������ֶ�ˮ��λ��
	    			row.add(rs.getString(4));//��ȡ���ĸ��ֶ���Ⱦ���
	    			row.add(rs.getString(5));//��ȡ������ֶ��������
	    			rows.add(row);//����������ӵ���¼������
	    		}
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    	return rows;//��������������
	    }
	   
}
