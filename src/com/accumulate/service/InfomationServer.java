package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.SysInfoDao;
import com.accumulate.daoImp.SysInfoImp;
import com.accumulate.entity.SystemInfo;

public class InfomationServer {
	/**
	 * @return ��ѯȫ����Ϣ
	 */
	public static List<SystemInfo> getInfos(int page) {
		SysInfoDao dao = new SysInfoImp();
		return dao.findAll(page);
	}

	/**
	 * @param id
	 * @return ��ѯ������Ϣ
	 */
	public static SystemInfo getInfo(int id) {
		SysInfoDao dao = new SysInfoImp();
		return dao.findSystemInfo(id);
	}

}
