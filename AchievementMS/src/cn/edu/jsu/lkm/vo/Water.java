package cn.edu.jsu.lkm.vo;

import java.io.Serializable;

/**
 * 自定义实体类water查看水资源情况
 * @author mycom
 *
 */
public class Water implements Serializable{

	private String watername;//水域名
	private double watercapacity;//储水量
	private String waterposition;//水域位置
	private String pollutionsituation;//污染情况
	private String governance;//治理情况
	
	/**
	 * 空构造方法
	 */
	public Water() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 构造方法实例化所有有成员变量
	 * @param watername 水域名
	 * @param watercapacity 储水量
	 * @param waterposition 水域位置
	 * @param pollutionsituation 污染情况
	 * @param governance 治理情况
	 */
	public Water(String watername, double watercapacity, String waterposition, String pollutionsituation,
			String governance) {
		super();
		this.watername = watername;
		this.watercapacity = watercapacity;
		this.waterposition = waterposition;
		this.pollutionsituation = pollutionsituation;
		this.governance = governance;
	}

	/**
	 * get方法返回水域名
	 * @return String
	 */
	public String getWatername() {
		return watername;
	}

	/**
	 * set方法设置水域名
	 * @param watername 水域名
	 */
	public void setWatername(String watername) {
		this.watername = watername;
	}

	/**
	 * get方法返回储水量
	 * @return double
	 */
	public double getWatercapacity() {
		return watercapacity;
	}

	/**
	 * set方法设置储水量
	 * @param watercapacity 储水量
	 */
	public void setWatercapacity(double watercapacity) {
		this.watercapacity = watercapacity;
	}

	/**
	 * get方法返回水域位置
	 * @return String
	 */
	public String getWaterposition() {
		return waterposition;
	}

	/**
	 * set方法设置水域位置
	 * @param waterposition 水域位置
	 */
	public void setWaterposition(String waterposition) {
		this.waterposition = waterposition;
	}

	/**
	 * get方法返回污染情况
	 * @return String
	 */
	public String getPollutionsituation() {
		return pollutionsituation;
	}

	/**
	 * set方法设置污染情况
	 * @param pollutionsituation 污染情况
	 */
	public void setPollutionsituation(String pollutionsituation) {
		this.pollutionsituation = pollutionsituation;
	}

	/**
	 * get方法返回治理情况
	 * @return String
	 */
	public String getGovernance() {
		return governance;
	}

	/**
	 * set方法设置治理情况
	 * @param governance 治理情况
	 */
	public void setGovernance(String governance) {
		this.governance = governance;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "水域名:"+this.watername+",储水量:"+this.watercapacity+",水域位置:"+this.waterposition+",污染情况:"+this.pollutionsituation+",治理情况:"+this.governance;
	}
}
