package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.AdverticeDao;
import com.accumulate.daoImp.AdverticeImp;
import com.accumulate.entity.Advertive;

public class AdverSer {
	public static List<Advertive> findAll() {
		return null;

	}

	/**
	 * @param pId
	 * @return   ���ݻõ�id ��ȡ��Ӧ���
	 */
	public static List<Advertive> findAdverByPid(int pId) {
		AdverticeDao dao = new AdverticeImp();
		return dao.findAdByPid(pId);
	}

}
