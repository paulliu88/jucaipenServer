package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.CityDao;
import com.accumulate.daoImp.CityImp;
import com.accumulate.entity.City;

public class CityServer {
	/**
	 * @param pId
	 * @return ��ѯʡ���µ����г�����Ϣ
	 */
	public static List<City> getCitys(int pId) {
		CityDao dao = new CityImp();
		return dao.findCitys(pId);
	}

	/**
	 * @param id
	 * @return ��ѯָ��������Ϣ
	 */
	public static City getCity(int id) {
		CityDao dao = new CityImp();
		return dao.findCity(id);
	}

	/**
	 * @param pager
	 * @return  ��ѯ���г�����Ϣ
	 */
	public static List<City> findAll(int pager) {
		CityDao dao = new CityImp();
		return dao.findAll(pager);
	}

}
