package com.accumulate.dao;

import com.accumulate.entity.MobileMessage;

/**
 * @author YLF
 * 
 *    �ֻ�����
 *
 */
public interface MobileMessageDao {
	
	/**
	 * @param message
	 * @return  ���Ͷ���
	 */
	public int insertMessage(MobileMessage message);
	
	/**
	 * @param type
	 * @return  �ı����״̬
	 */
	public int upDateMessageType(int type);

}
