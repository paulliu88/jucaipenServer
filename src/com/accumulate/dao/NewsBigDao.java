package com.accumulate.dao;

import java.util.List;

import com.accumulate.entity.NewsBigClass;

public interface NewsBigDao {
	/**
	 * @return   ��ȡ���е�һ��������Ϣ
	 */
	public List<NewsBigClass>  findAllBigClass();
	/**
	 * @param id
	 * @return   ͨ��id ��ѯһ��������ϸ��Ϣ
	 */
	public List<NewsBigClass> findBigClassById(int id);

}
