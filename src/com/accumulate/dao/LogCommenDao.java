package com.accumulate.dao;

import java.util.List;

import com.accumulate.entity.LogCommen;

public interface LogCommenDao {
	/**
	 * @param logCommen
	 * @return  �����־����
	 */
	public int insertLogComm(LogCommen logCommen);
	/**
	 * @param id
	 * @return ����id��ȡ��־������ϸ��Ϣ
	 */
	public LogCommen findLogCommBuId(int id);
	/**
	 * @return ��ȡ������־������Ϣ
	 */
	public List<LogCommen> findAllComm();
	/**
	 * @param uid
	 * @return  �����û�id��ȡ��־������Ϣ
	 */
	public List<LogCommen> findLogCommByUserId(int uid);
	/**
	 * @param logId
	 * @return ������־id��ȡ��־������Ϣ
	 */
	public List<LogCommen> findLogCommByLogId(int logId);
	/**
	 * @param uid
	 * @param logId
	 * @return  �����û�id����־id��ѯ��־����
	 */
	public List<LogCommen> findLogCommByUidAndLogId(int uid,int logId);
}
