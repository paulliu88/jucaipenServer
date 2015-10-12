package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.ChatFaceDao;
import com.accumulate.daoImp.ChatFaceImp;
import com.accumulate.entity.ChatFace;

/**
 * @author Administrator
 * 
 * 
 *         �������
 */
public class ChatFaceServer {

	/**
	 * @return ��ȡ�����������
	 */
	public static List<ChatFace> findAllFace() {
		ChatFaceDao dao = new ChatFaceImp();
		return dao.findAll();
	}

	/**
	 * @param id
	 * @return  ����id��ѯ������Ϣ
	 */
	public static ChatFace findFaceById(int id) {
		ChatFaceDao dao = new ChatFaceImp();
		return dao.findFaceById(id);
	}

}
