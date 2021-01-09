package cn.edu.jsu.lkm.vo;

import java.io.Serializable;

/**
 * �Զ���ʵ����Pollution�鿴��Ⱦ���
 * @author mycom
 *
 */
public class Pollution implements Serializable {
	private String waterquality;//ˮ����
	private double transparency;//͸����
	private double ph;//phֵ
	private double mineralization;//�󻯶�
	
	/**
	 * �չ��췽��
	 */
	public Pollution() {
	}

	/**
	 * ���췽��ʵ����ȫ����Ա����
	 * @param waterquality ˮ����
	 * @param transparency ͸����
	 * @param ph phֵ
	 * @param mineralization �󻯶�
	 */
	public Pollution(String waterquality, double transparency, double ph, double mineralization) {
		super();
		this.waterquality = waterquality;
		this.transparency = transparency;
		this.ph = ph;
		this.mineralization = mineralization;
	}
    /**
     * get��������ˮ����
     * @return String
     */
	public String getWaterquality() {
		return waterquality;
	}

	/**
	 * set��������ˮ����
	 * @param waterquality ˮ����
	 */
	public void setWaterquality(String waterquality) {
		this.waterquality = waterquality;
	}

	/**
	 * get��������͸����
	 * @return double
	 */
	public double getTransparency() {
		return transparency;
	}

	/**
	 * set��������͸����
	 * @param transparency ͸����
	 */
	public void setTransparency(double transparency) {
		this.transparency = transparency;
	}

	/**
	 * get��������phֵ
	 * @return double
	 */
	public double getPh() {
		return ph;
	}

	/**
	 * set��������phֵ
	 * @param ph phֵ
	 */
	public void setPh(double ph) {
		this.ph = ph;
	}

	/**
	 * get�������ؿ󻯶�
	 * @return double
	 */
	public double getMineralization() {
		return mineralization;
	}

	/**
	 * set�������ÿ󻯶�
	 * @param mineralization �󻯶�
	 */
	public void setMineralization(double mineralization) {
		this.mineralization = mineralization;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ˮ��״��:"+this.waterquality+",͸����:"+this.transparency+",ph:"+this.ph+",�󻯶�:"+this.mineralization;
	}
}
