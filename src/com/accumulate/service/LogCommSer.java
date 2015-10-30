package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.LogCommenDao;
import com.accumulate.daoImp.LogCommImp;
import com.accumulate.entity.LogCommen;

public class LogCommSer{

	/**
	 * @param logCommen
	 * @return  �����־����
	 */
	public static int insertLogComm(LogCommen logCommen) {
		LogCommenDao dao=new LogCommImp();
		return dao.insertLogComm(logCommen);
	}

	/**
	 * @param id
	 * @return  ����id��ѯ��־��������
	 */
	public static LogCommen findLogCommBuId(int id) {
		LogCommenDao dao=new LogCommImp();
		return dao.findLogCommBuId(id);
	}

	/**
	 * @return  ��ѯ���е���־����
	 */
	public static List<LogCommen> findAllComm() {
		LogCommenDao dao=new LogCommImp();
		return dao.findAllComm();
	}

	/**
	 * @param uid
	 * @return  �����û�id��ѯ��־����
	 */
	public static List<LogCommen> findLogCommByUserId(int uid) {
		LogCommenDao dao=new LogCommImp();
		return dao.findLogCommByUserId(uid);
	}

	/**
	 * @param logId
	 * @return  ������־id��ѯ��־����
	 */
	public static List<LogCommen> findLogCommByLogId(int logId) {
		LogCommenDao dao=new LogCommImp();
		return dao.findLogCommByLogId(logId);
	}

	/**
	 * @param uid
	 * @param logId
	 * @return  �����û�id����־id��ѯ��־����
	 */
	public static List<LogCommen> findLogCommByUidAndLogId(int uid, int logId) {
		LogCommenDao dao=new LogCommImp();
		return dao.findLogCommByUidAndLogId(uid, logId);
	}

}
