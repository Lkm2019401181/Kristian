package cn.edu.jsu.lkm.vo;

import java.io.Serializable;

/**
 * �Զ���ʵ����water�鿴ˮ��Դ���
 * @author mycom
 *
 */
public class Water implements Serializable{

	private String watername;//ˮ����
	private double watercapacity;//��ˮ��
	private String waterposition;//ˮ��λ��
	private String pollutionsituation;//��Ⱦ���
	private String governance;//�������
	
	/**
	 * �չ��췽��
	 */
	public Water() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * ���췽��ʵ���������г�Ա����
	 * @param watername ˮ����
	 * @param watercapacity ��ˮ��
	 * @param waterposition ˮ��λ��
	 * @param pollutionsituation ��Ⱦ���
	 * @param governance �������
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
	 * get��������ˮ����
	 * @return String
	 */
	public String getWatername() {
		return watername;
	}

	/**
	 * set��������ˮ����
	 * @param watername ˮ����
	 */
	public void setWatername(String watername) {
		this.watername = watername;
	}

	/**
	 * get�������ش�ˮ��
	 * @return double
	 */
	public double getWatercapacity() {
		return watercapacity;
	}

	/**
	 * set�������ô�ˮ��
	 * @param watercapacity ��ˮ��
	 */
	public void setWatercapacity(double watercapacity) {
		this.watercapacity = watercapacity;
	}

	/**
	 * get��������ˮ��λ��
	 * @return String
	 */
	public String getWaterposition() {
		return waterposition;
	}

	/**
	 * set��������ˮ��λ��
	 * @param waterposition ˮ��λ��
	 */
	public void setWaterposition(String waterposition) {
		this.waterposition = waterposition;
	}

	/**
	 * get����������Ⱦ���
	 * @return String
	 */
	public String getPollutionsituation() {
		return pollutionsituation;
	}

	/**
	 * set����������Ⱦ���
	 * @param pollutionsituation ��Ⱦ���
	 */
	public void setPollutionsituation(String pollutionsituation) {
		this.pollutionsituation = pollutionsituation;
	}

	/**
	 * get���������������
	 * @return String
	 */
	public String getGovernance() {
		return governance;
	}

	/**
	 * set���������������
	 * @param governance �������
	 */
	public void setGovernance(String governance) {
		this.governance = governance;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ˮ����:"+this.watername+",��ˮ��:"+this.watercapacity+",ˮ��λ��:"+this.waterposition+",��Ⱦ���:"+this.pollutionsituation+",�������:"+this.governance;
	}
}
