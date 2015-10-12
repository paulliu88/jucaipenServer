package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.LogDao;
import com.accumulate.daoImp.LogImp;
import com.accumulate.entity.LoginLog;

public class LogServer {
	/**
	 * @param userId
	 * @return �����û�id��ѯ��¼��־
	 */
	public static List<LoginLog> findLogByUser(int userId, int pager) {
		LogDao dao = new LogImp();
		return dao.findLogByUser(userId, pager);
	}

	/**
	 * @param id
	 * @return ������־id����ѯ��¼��־��Ϣ
	 */
	public static LoginLog findLogById(int id) {
		LogDao dao = new LogImp();
		return dao.findLog(id);
	}

	/**
	 * @param log
	 * @return  ���ӵ�¼��־
	 */
	public static int insertLog(LoginLog log) {
		LogDao dao = new LogImp();
		return dao.insertLog(log);
	}

}