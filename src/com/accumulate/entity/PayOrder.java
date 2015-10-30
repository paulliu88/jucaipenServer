package com.accumulate.entity;

import java.io.Serializable;

/**
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class PayOrder implements Serializable{
	/**
	 * 
	 */
	private int id;
	/**
	 * �û���
	 */
	private String userName;
	/**
	 * ��ʵ����
	 */
	private String trueName;
	/**
	 * �ֻ���
	 */
	private String mobileNum;
	/**
	 * ����ʡ��
	 */
	private int provinceId;
	/**
	 * ���ڳ���
	 */
	private int cityId;
	/**
	 * �����ء���
	 */
	private int areaId;
	/**
	 * ��ϸ��ַ
	 */
	private String address;
	/**
	 * ��������
	 */
	private String title;
	/**
	 * �������
	 */
	private String orderCode;
	/**
	 * �������
	 */
	private String allMoney;
	/**
	 * ֧�����
	 */
	private String payMoney;
	/**
	 * ��������ʱ��
	 */
	private String insertDate;
	/**
	 * 1��֧������2��΢��֧����3���ױ�֧��
	 */
	private int payModel;
	/**
	 * 1��δ���2���Ѹ���
	 */
	private int payState;
	/**
	 * ��������
	 */
	private String payDate;
	/**
	 * 1������������2���ѹر�
	 */
	private int orderState;
	/**
	 * ��Դ��ʦId(��IdΪ��ͳ�ƽ�ʦ�ļ�Ч)
	 */
	private int fromTeacherId;
	/**
	 * ��Ʒ״̬��1��������4��ɾ����
	 */
	private int isDelete;
	
	public PayOrder(int id, String userName, String trueName, String mobileNum,
			int provinceId, int cityId, int areaId, String address,
			String title, String orderCode, String allMoney, String payMoney,
			String insertDate, int payModel, int payState, String payDate,
			int orderState, int fromTeacherId, int isDelete) {
		this.id = id;
		this.userName = userName;
		this.trueName = trueName;
		this.mobileNum = mobileNum;
		this.provinceId = provinceId;
		this.cityId = cityId;
		this.areaId = areaId;
		this.address = address;
		this.title = title;
		this.orderCode = orderCode;
		this.allMoney = allMoney;
		this.payMoney = payMoney;
		this.insertDate = insertDate;
		this.payModel = payModel;
		this.payState = payState;
		this.payDate = payDate;
		this.orderState = orderState;
		this.fromTeacherId = fromTeacherId;
		this.isDelete = isDelete;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public String getMobileNum() {
		return mobileNum;
	}
	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}
	public int getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public int getAreaId() {
		return areaId;
	}
	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getAllMoney() {
		return allMoney;
	}
	public void setAllMoney(String allMoney) {
		this.allMoney = allMoney;
	}
	public String getPayMoney() {
		return payMoney;
	}
	public void setPayMoney(String payMoney) {
		this.payMoney = payMoney;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	public int getPayModel() {
		return payModel;
	}
	public void setPayModel(int payModel) {
		this.payModel = payModel;
	}
	public int getPayState() {
		return payState;
	}
	public void setPayState(int payState) {
		this.payState = payState;
	}
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	public int getOrderState() {
		return orderState;
	}
	public void setOrderState(int orderState) {
		this.orderState = orderState;
	}
	public int getFromTeacherId() {
		return fromTeacherId;
	}
	public void setFromTeacherId(int fromTeacherId) {
		this.fromTeacherId = fromTeacherId;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	
	
	
	
	
	

}
