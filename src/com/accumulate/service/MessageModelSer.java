package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.MessageModelDao;
import com.accumulate.daoImp.MessageModelImp;
import com.accumulate.entity.MessageModel;

public class MessageModelSer{

	/**
	 * @return  ��ȡ���ж�������
	 */
	public static List<MessageModel> querryAllModel() {
		MessageModelDao dao=new MessageModelImp();
		return dao.querryAllModel();
	}

	/**
	 * @param id
	 * @return  ����id��ȡ��������
	 */
	public static MessageModel findModelById(int id) {
		MessageModelDao dao=new MessageModelImp();
		return dao.findModelById(id);
	}
	

}
