package com.accumulate.dao;

import java.util.List;

import com.accumulate.entity.Advertive;

public interface AdverticeDao {

	/**
	 * @return ��ѯ���й��
	 */
	public List<Advertive> findAll();

	/**
	 * @param pId
	 * @return ���������õ�id��ѯ���
	 */
	public List<Advertive> findAdByPid(int pId);
}
