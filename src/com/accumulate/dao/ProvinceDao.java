package com.accumulate.dao;

import java.util.List;

import com.accumulate.entity.Province;

public interface ProvinceDao {
	/**
	 * @return  ��ѯ����ʡ����Ϣ
	 */
	public List<Province> findAll();
	/**
	 * @param id
	 * @return  ����id��ѯʡ����Ϣ
	 */
	public Province findProvince(int id);

}
