package com.accumulate.dao;

import java.util.List;

import com.accumulate.entity.ChatRoom;

/**
 * @author YLF
 * 
 *   ֱ����
 *
 */
public interface LiveRoomDao {
	
	/**
	 * @return   ��ȡ���з�������
	 */
	public List<ChatRoom> getRoomList();
	/**
	 * @param id
	 * @return  ����id ��ȡ������ϸ��Ϣ
	 */
	public ChatRoom getRoomInfo(int id);
	
	/**
	 * @param id
	 * @return  ����id ��ȡ��Ƶ����URL
	 */
	public ChatRoom  getLiveUrl(int id);
	
	/**
	 * @return   ��ȡ���з�����Ϣ
	 */
	public List<ChatRoom> getAllRoom();

}
