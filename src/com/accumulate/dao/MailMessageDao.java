package com.accumulate.dao;

import com.accumulate.entity.MailMessage;

/**
 * @author YLF
 * 
 *    �ʼ���Ϣ
 *
 */
public interface MailMessageDao {
	
	/**
	 * @param mailMessage
	 * @return  �����ʼ���Ϣ
	 */
	public int insertMessage(MailMessage mailMessage);
	
	
	/**
	 * @param type
	 * @return   �ı��ʼ���Ϣ״̬
	 */
	public int upDateMessageType(int type);

}
