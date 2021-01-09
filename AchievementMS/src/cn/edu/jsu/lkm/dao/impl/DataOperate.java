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
 * 数据层实现类
 * @author mycom
 *
 */
public class DataOperate {

	//定义水源的第一个名字
	private static String firstName="邹喻柏水窦章云苏潘葛奚范彭郎鲁韦昌马苗凤花方俞任袁柳酆鲍史唐费廉岑薛雷贺倪汤滕殷罗毕郝邬安常乐于时傅皮卞齐康伍余元卜顾孟平黄和穆萧尹姚邵湛汪祁毛禹狄米贝明臧计伏成戴谈宋茅庞熊纪舒屈项祝董梁杜阮蓝闵席季麻强贾路娄危江童颜郭梅盛林刁钟徐邱骆高夏蔡田樊胡凌霍虞万支柯咎管卢莫经房裘缪干解应宗宣丁贲邓郁单杭洪包诸左石崔吉钮龚程嵇邢滑裴陆荣翁荀羊於惠甄魏加封芮羿储靳汲邴糜松井段富巫乌焦巴弓牧隗山谷车侯宓蓬全郗班仰秋仲伊宫宁仇栾暴甘钭厉戎祖武符刘姜詹束龙叶幸司韶郜黎蓟薄印宿白怀蒲台从鄂索咸籍赖卓蔺屠蒙池乔阴郁胥能苍双闻莘党翟谭贡劳逄姬申扶堵冉宰郦雍却璩桑桂濮牛寿通边扈燕冀郏浦尚农温别庄晏柴瞿阎充慕连茹习宦艾鱼容向古易慎戈廖庚终暨居衡步都耿满弘匡国文寇广禄阙东殴殳沃利蔚越夔隆师巩厍聂晁勾敖融冷訾辛阚那简饶空曾毋沙乜养鞠须丰巢关蒯相查后江红游竺权逯盖益桓公万俟司马上官欧阳夏侯诸葛闻人东方赫连皇甫尉迟公羊澹台公冶宗政濮阳淳于仲孙太叔申屠公孙乐正轩辕令狐钟离闾丘长孙慕容鲜于宇文司徒司空亓官司寇仉督子车颛孙端木巫马公西漆雕乐正壤驷公良拓拔夹谷宰父谷粱晋楚阎法汝鄢涂钦段干百里东郭南门呼延归海羊舌微生岳帅缑亢况后有琴梁丘左丘东门西门商牟佘佴伯赏南宫墨伟刚勇毅俊峰强军平保东文辉力明永健世广志义兴良海山仁波宁贵福生龙元全国胜学祥才发武新利清飞彬富顺信子杰涛昌成康星光天达安岩中茂进林有坚和彪博诚先敬震振壮会思群豪心邦承乐绍功松善厚庆磊民友裕河哲江超浩亮政谦亨奇固之轮翰朗伯宏言若鸣朋斌梁栋维启克伦翔旭鹏泽晨辰士以建家致树炎德行时泰盛雄琛钧冠策腾楠榕风航弘";
	//定义水源的第二个名字
	private static String secondName="寒少字桥板斐独千诗嘉扬善揭祈析赤紫青柔刚奇拜佛陀弥阿素长僧隐仙隽宇祭酒淡塔琦闪始星南天接波碧速伟刚勇毅俊峰强军平保东文辉力明永健世广志义兴良海山仁波宁贵福生龙元全国胜学祥才发武新利清飞彬富顺信子杰涛昌成康星光天达安岩中茂进林有坚和彪博诚先敬震振壮会思群豪心邦承乐绍功松善厚庆磊民友裕河哲江超浩亮政谦亨奇固之轮翰朗伯宏言若鸣朋斌梁栋维启克伦翔旭鹏泽晨辰士以建家致树炎德行时泰盛雄琛钧冠策腾楠榕风航弘";
	//定义水源位置第一个字
	private static String firstPosition="王台罗玉扼喉凤凰鸟汾河湾雄风千众安霸难应榆林包赤通奇拜佛陀弥阿素长僧隐仙隽宇祭酒淡塔琦闪始星南天接波碧速伟刚勇毅俊峰强军平保东文辉力明永健世广志义兴良海山仁波宁贵福生龙元全国胜学祥才发武新利清飞彬富顺信子杰涛昌成康星光天达安岩中茂进林有坚和彪博诚先敬震振壮会思群豪心邦承乐绍功松善厚庆磊民友裕河哲江超浩亮政谦亨奇固之轮翰朗伯宏言若鸣朋斌梁栋维启克伦翔旭鹏泽晨辰士以建家致树炎德行时泰盛雄琛钧冠策腾楠榕甄魏加封芮羿储靳汲邴糜松井段富巫乌焦巴弓牧隗山谷车";
	//定义水源位置第二个字
	private static String secondPosition="甄魏加封芮羿储靳汲邴糜松井段富巫乌焦巴弓牧隗山谷车花方俞任袁柳酆鲍史唐费廉岑薛雷贺倪汤滕殷罗毕郝邬安常乐于时傅皮卞齐康伍余元卜顾孟平黄和穆萧尹姚邵湛汪祁毛禹狄米贝明臧计伏成戴谈宋茅庞熊纪舒屈项祝董梁杜阮蓝闵席季麻强贾路娄危江童颜郭梅盛林刁钟徐邱骆高夏蔡田樊胡凌霍虞万支柯咎管卢莫经房裘缪干解应宗";
	
	/**
	 * 随机返回指定范围间的整数
	 * @param start 开始的数
	 * @param end 结束的数
	 * @return dint
	 */
	 public static int getNum(int start,int end) {
	    	//Math.random()随机返回0.0至1.0之间的数
	        return (int)(Math.random()*(end-start+1)+start);
	    }
	 
	 /**
	  * 随机返回一个名字
	  * @return String
	  */
	 public static String getName(){
		 int index=getNum(0, firstName.length()-1);//随机取firstName字符串中的任意位置
		 String first=firstName.substring(index, index+1);//获取该位置的名
		 
		 //随机取第三个字
		 String third="";
		 int td=getNum(0,1);
		 if(td==0) {
			 third="河";
		 }
		 else 
			 third="溪";
		 
		 int hassecond=getNum(0,1);//随机取是否有第二个字
		 String second="";//默认没有第二个字
		 if(hassecond==1) {//如果随机获取为1，则有第二个字
			 int length=secondName.length();//获取第二个名字的长度
			 index=getNum(0,length-1);
	         second=secondName.substring(index, index+1);
	         return first+second+third;
		 }
		 return first+third;
	 }
	 
	 /**
	  * 随机返回一个double型的数值作为储水量
	  * @return dint
	  */
	 public static int getCapacity() {
		 int capacity=getNum(9999,99999);
		 return capacity;
	 }
	 
	 /**
	  * 随机返回一个位置
	  * @return String
	  */
	 public static String getPosition(){
		 int index=getNum(0, firstPosition.length()-1);//随机取firstPosition字符串中的任意位置
		 String first=firstPosition.substring(index, index+1);//获取该位置的名
		 
		 //随机取第三个字
		 String third="";
		 int td=getNum(0,1);
		 if(td==0) {
			 third="区";
		 }
		 else 
			 third="县";
		 
		 int hassecond=getNum(0,1);//随机取是否有第二个字
		 String second="";//默认没有第二个字
		 if(hassecond==1) {//如果随机获取为1，则有第二个字
			 int length=secondPosition.length();//获取第二个名字的长度
			 index=getNum(0,length-1);
	         second=secondPosition.substring(index, index+1);
	         return first+second+third;
		 }
		 return first+third;
	 }
	 
	 /**
	  * 随机返回污染的情况
	  * @return String
	  */
	 public static String getPollution(){
		 String pl;
		 int pollution=getNum(0,2);
		 if(pollution==0) {
			 pl="轻度污染";
		 }else if(pollution==1) {
			 pl="中度污染";
		 }else {
			 pl="重度污染";
		 }
		 return pl;
	 }
	 
	 /**
	  * 随机返回治理的情况
	  * @return String
	  */
	 public static String getgovernance() {
		 String gn;
		 int governance=getNum(0,1);
		 if(governance==0) {
			 gn="未被治理";
		 }
		 else{
			 gn="正在治理";
		 }
		 return gn;
	 }
	 
	 /**
	  * 生成10000条随机数据
	  */
	 public static void addOprate() {
		 DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//使用自定义的连接数据库的类
	    	String sql="insert into watertable(watername,watercapacity,waterposition,pollutionsituation,governance) values(?,?,?,?,?)";//使用占位符定义插入语句
	    	try(Connection conn=dbcs.getConnection();//获取数据库接
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
	            ArrayList<String> list=new ArrayList<>();
	    		for(int i=1;i<=10000;) {
	    			    String watername=getName();//随机获取水源名字
	    			    if(!list.contains(watername)) {	    			    	
	    			    list.add(watername);
	    				double watercapacity=getCapacity(); //随机获取储水量
	    				String waterposition=getPosition();//随机获取水域位置
	    				String pollutionsituation=getPollution();//随机获取污染情况
	    				String governance=getgovernance();//随机获取治理情况
	    				pstmt.setString(1, watername);//定义第1个占位符的内容
	    	      		pstmt.setDouble(2, watercapacity);//定义第2个占位符的内容
	    	    		pstmt.setString(3, waterposition);//定义第3个占位符的内容
	    	    		pstmt.setString(4, pollutionsituation);//定义第4个占位符的内容
	    	    		pstmt.setString(5, governance);//定义第5个占位符的内容
	    	    		pstmt.addBatch();//加入批处理等待执行
	    				i++;//学号唯一，循环继续往下执行
	    			    }
	    			}
	    		pstmt.executeBatch();//批量执行插入操作
	    		JOptionPane.showMessageDialog(null, "sucess");
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	 }
	 
	 public static void main(String[] args) {
         addOprate();
	}
	 
	 /**
	  * 将生成的数据添加到集合里
	  * @param sql SQL语句
	  * @return Vector
	  */
	 public static Vector<Vector> getSelectAll(String sql){
	    	Vector<Vector> rows=new Vector<Vector>();//定义要返回的所有记录集合
	    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//使用自定义的连接数据库的类
	    	try(Connection conn=dbcs.getConnection();//获取数据库接
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
	    		ResultSet rs=pstmt.executeQuery();//执行查询语句，结果放到数据集中
	    		while(rs.next()) {//遍历数据集
	    			Vector row=new Vector();//定义行数据
	    			row.add(rs.getString(1));//获取第一个字段水域名
	    			row.add(rs.getDouble(2));//获取第二个字段储水量
	    			row.add(rs.getString(3));//获取第三个字段水域位置
	    			row.add(rs.getString(4));//获取第四个字段污染情况
	    			row.add(rs.getString(5));//获取第五个字段治理情况
	    			rows.add(row);//将行数据添加到记录集合中
	    		}
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    	return rows;//返回所有行数据
	    }
	   
}
