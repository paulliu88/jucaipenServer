package com.accumulate.entity;

import java.io.Serializable;

/**
 * @author Administrator
 *
 *  ����Դ�
 *
 */
@SuppressWarnings("serial")
public class Question implements Serializable{
	/**
	 *  �����ʽ�ʦid
	 */
	private int teacherId;
	/**
	 * ��ʦ��Ƭ
	 */
	private String image;
	/**
	 * ��ʦ�ǳ�
	 */
	private String nickName;
	/**
	 * ��ʦͷ��
	 */
	private String level;
	/**
	 *  �Ƿ��V  0 ��   
	 */
	private int isV;
	/**
	 * �������ǳ�
	 */
	private String askName;
	/**
	 * ��������
	 */
	private String askBodys;
	/**
	 * ����״̬
	 */
	private int isReply;
	/**
	 * �ظ�����
	 */
	private String answerBody;
	
	public Question(int teacherId, String image, String nickName, String level,
			int isV, String askName, String askBodys, int isReply,
			String answerBody) {
		this.teacherId = teacherId;
		this.image = image;
		this.nickName = nickName;
		this.level = level;
		this.isV = isV;
		this.askName = askName;
		this.askBodys = askBodys;
		this.isReply = isReply;
		this.answerBody = answerBody;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public int getIsV() {
		return isV;
	}
	public void setIsV(int isV) {
		this.isV = isV;
	}
	public String getAskName() {
		return askName;
	}
	public void setAskName(String askName) {
		this.askName = askName;
	}
	public String getAskBodys() {
		return askBodys;
	}
	public void setAskBodys(String askBodys) {
		this.askBodys = askBodys;
	}
	
	public int getIsReply() {
		return isReply;
	}
	public void setIsReply(int isReply) {
		this.isReply = isReply;
	}
	public String getAnswerBody() {
		return answerBody;
	}
	public void setAnswerBody(String answerBody) {
		this.answerBody = answerBody;
	}
	

}
