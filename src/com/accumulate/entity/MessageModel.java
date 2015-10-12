package com.accumulate.entity;

import java.io.Serializable;

/**
 * @author YLF
 * 
 *    ���䡢����ģ��
 *
 */
@SuppressWarnings("serial")
public class MessageModel implements Serializable{
	/**
	 *  ģ��id
	 */
	private int id;
	/**
	 * ģ������
	 */
	private int modelType;
	/**
	 *  ��ע
	 */
	private String title;
	/**
	 *  ģ������
	 */
	private String modelContent;
	
	public MessageModel() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getModelType() {
		return modelType;
	}
	public void setModelType(int modelType) {
		this.modelType = modelType;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getModelContent() {
		return modelContent;
	}
	public void setModelContent(String modelContent) {
		this.modelContent = modelContent;
	}
	

}