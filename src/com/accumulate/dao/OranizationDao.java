package com.accumulate.dao;

import java.util.List;

import com.accumulate.entity.Organization;

public interface OranizationDao {
	/**
	 * @return ��ѯ���л���
	 */
	public List<Organization> findAll(int pager);
	/**
	 * @param id
	 * @return  ��ѯָ���Ļ���
	 */
	public Organization findOrganization(int id);

}
