package com.accumulate.dao;

import java.util.List;

import com.accumulate.entity.ChatFace;

/**
 * @author Administrator
 *
 *
 *   �������
 */
public interface ChatFaceDao {
	
	/**
	 * @return  ��ȡ�����������
	 */
	public List<ChatFace> findAll();
	
	/**
	 * @param id
	 * @return  ����id��ѯ�������
	 */
	public ChatFace findFaceById(int id);

}
