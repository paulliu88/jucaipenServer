package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.AskClassDao;
import com.accumulate.daoImp.AskClassImp;
import com.accumulate.entity.AskClass;

public class AskClassSer{

	/**
	 * @return ��ȡ���е��������
	 */
	public static List<AskClass> findAllClass() {
		AskClassDao dao=new AskClassImp();
		return dao.findAllClass();
	}

	/**
	 * @param id
	 * @return ����id��ȡ�������
	 */
	public static AskClass findAskClassById(int id) {
		AskClassDao dao=new AskClassImp();
		return dao.findAskClassById(id);
	}

}
