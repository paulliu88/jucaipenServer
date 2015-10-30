package com.accumulate.entity;

import java.io.Serializable;

/**
 * @author Administrator
 * 
 *   ��Ʒ
 *
 */
@SuppressWarnings("serial")
public class PayProduct implements Serializable{
	/**
	 * id 
	 */
	private int id;
	/**
	 * ��Ʒ����
	 */
	private String productTitle;
	/**
	 * ԭ��
	 */
	private String price;
	/**
	 * �ּ�
	 */
	private String nowPrice;
	/**
	 * ��ʦId(����0ʱ���ò�ƷΪϵͳ��Ʒ��������ĳ����ʦ�Ĳ�Ʒ)
	 */
	private int teacherId;
	/**
	 * ��Ʒ���ͣ�1��һ�������ۣ�2����Լ�����ۣ�
	 */
	private int type;
	private int pxId;
	/**
	 * ��Լ����
	 */
	private int contractYear;
	/**
	 * ��Լ����
	 */
	private int contractMoth;
	/**
	 * ��Լ����
	 */
	private int contraceDay;
	/**
	 * ����״̬��1���������ۣ�2����ͣ���ۣ�
	 */
	private int state;
	/**
	 * ��Ʒ״̬��1��������4��ɾ����
	 */
	private int isDelete;
	public PayProduct(int id, String productTitle, String price,
			String nowPrice, int teacherId, int type, int pxId,
			int contractYear, int contractMoth, int contraceDay, int state,
			int isDelete) {
		this.id = id;
		this.productTitle = productTitle;
		this.price = price;
		this.nowPrice = nowPrice;
		this.teacherId = teacherId;
		this.type = type;
		this.pxId = pxId;
		this.contractYear = contractYear;
		this.contractMoth = contractMoth;
		this.contraceDay = contraceDay;
		this.state = state;
		this.isDelete = isDelete;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductTitle() {
		return productTitle;
	}
	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getNowPrice() {
		return nowPrice;
	}
	public void setNowPrice(String nowPrice) {
		this.nowPrice = nowPrice;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getPxId() {
		return pxId;
	}
	public void setPxId(int pxId) {
		this.pxId = pxId;
	}
	public int getContractYear() {
		return contractYear;
	}
	public void setContractYear(int contractYear) {
		this.contractYear = contractYear;
	}
	public int getContractMoth() {
		return contractMoth;
	}
	public void setContractMoth(int contractMoth) {
		this.contractMoth = contractMoth;
	}
	public int getContraceDay() {
		return contraceDay;
	}
	public void setContraceDay(int contraceDay) {
		this.contraceDay = contraceDay;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	
	
	

}
