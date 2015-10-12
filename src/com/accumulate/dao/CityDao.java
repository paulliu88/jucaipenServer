package com.accumulate.dao;

import java.util.List;

import com.accumulate.entity.City;

public interface CityDao {
	/**
	 * @param pId
	 * @return  ��ѯʡ�����������г�����Ϣ
	 */
	public List<City> findCitys(int pId);
	/**
	 * @param pId
	 * @param id
	 * @return  ��ѯʡ�µ�ĳ��������Ϣ
	 */
	public City findCity(int id);
	/**
	 * @param pager
	 * @return  ��ѯ���г�����Ϣ
	 */
	public List<City> findAll(int pager);

}