package cn.edu.jsu.lkm.vo;

import java.io.Serializable;

/**
 * 自定义实体类Pollution查看污染情况
 * @author mycom
 *
 */
public class Pollution implements Serializable {
	private String waterquality;//水质量
	private double transparency;//透明度
	private double ph;//ph值
	private double mineralization;//矿化度
	
	/**
	 * 空构造方法
	 */
	public Pollution() {
	}

	/**
	 * 构造方法实例化全部成员变量
	 * @param waterquality 水质量
	 * @param transparency 透明度
	 * @param ph ph值
	 * @param mineralization 矿化度
	 */
	public Pollution(String waterquality, double transparency, double ph, double mineralization) {
		super();
		this.waterquality = waterquality;
		this.transparency = transparency;
		this.ph = ph;
		this.mineralization = mineralization;
	}
    /**
     * get方法返回水质量
     * @return String
     */
	public String getWaterquality() {
		return waterquality;
	}

	/**
	 * set方法设置水质量
	 * @param waterquality 水质量
	 */
	public void setWaterquality(String waterquality) {
		this.waterquality = waterquality;
	}

	/**
	 * get方法返回透明度
	 * @return double
	 */
	public double getTransparency() {
		return transparency;
	}

	/**
	 * set方法设置透明度
	 * @param transparency 透明度
	 */
	public void setTransparency(double transparency) {
		this.transparency = transparency;
	}

	/**
	 * get方法返回ph值
	 * @return double
	 */
	public double getPh() {
		return ph;
	}

	/**
	 * set方法设置ph值
	 * @param ph ph值
	 */
	public void setPh(double ph) {
		this.ph = ph;
	}

	/**
	 * get方法返回矿化度
	 * @return double
	 */
	public double getMineralization() {
		return mineralization;
	}

	/**
	 * set方法设置矿化度
	 * @param mineralization 矿化度
	 */
	public void setMineralization(double mineralization) {
		this.mineralization = mineralization;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "水质状况:"+this.waterquality+",透明度:"+this.transparency+",ph:"+this.ph+",矿化度:"+this.mineralization;
	}
}
