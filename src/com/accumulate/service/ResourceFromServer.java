package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.ResourceFromDao;
import com.accumulate.daoImp.ResourceFromImp;
import com.accumulate.entity.ResourceSources;

public class ResourceFromServer {
	/**
	 * @return   ��ȡ������Ѷ��Դ��Ϣ
	 */
	public static List<ResourceSources> getResourceSources(int pager) {
		ResourceFromDao dao = new ResourceFromImp();
		return dao.findAll(pager);
	}

	/**
	 * @param id
	 * @return   ����id��ȡ��Ѷ��Դ��Ϣ
	 */
	public static ResourceSources getRSources(int id) {
		ResourceFromDao dao = new ResourceFromImp();
		return dao.findResourceSources(id);
	}
}
