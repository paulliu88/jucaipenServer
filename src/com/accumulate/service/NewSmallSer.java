package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.NewSmallDao;
import com.accumulate.daoImp.NewSmallImp;
import com.accumulate.entity.NewsSmallClass;

public class NewSmallSer {
	/**
	 * @return ��ȡ���е����Ŷ���������Ϣ
	 */
	public static List<NewsSmallClass> findAll() {
		NewSmallDao dao = new NewSmallImp();
		return dao.findAllSmallClass();
	}

	/**
	 * @param id
	 * @return ����id ��ȡ����������ϸ��Ϣ
	 */
	public static NewsSmallClass findNewSmallById(int id) {
		NewSmallDao dao = new NewSmallImp();
		return dao.findSmallClassById(id);
	}

	/**
	 * @param bigId
	 * @return   ����һ�������ѯ�±ߵĶ���������Ϣ
	 */
	public static List<NewsSmallClass> findNewSmallByByBigId(int bigId) {
		NewSmallDao dao = new NewSmallImp();
		return dao.findSmallClassByBigId(bigId);
	}

}