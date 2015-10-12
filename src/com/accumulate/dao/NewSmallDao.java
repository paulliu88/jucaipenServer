package com.accumulate.dao;

import java.util.List;

import com.accumulate.entity.NewsSmallClass;

public interface NewSmallDao {
	/**
	 * @return   ��ȡ���ж���������Ϣ
	 */
	public List<NewsSmallClass>  findAllSmallClass();
	/**
	 * @param bigId
	 * @return    ����һ�������ȡ����������Ϣ
	 */
	public List<NewsSmallClass>  findSmallClassByBigId(int bigId);
	/**
	 * @param id
	 * @return   ����id��ȡ����������Ϣ
	 */
	public NewsSmallClass findSmallClassById(int id);

}
