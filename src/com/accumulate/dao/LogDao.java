package com.accumulate.dao;

import java.util.List;

import com.accumulate.entity.LoginLog;

/**
 * @author YLF
 * 
 *   ��¼��־������
 *
 */
public interface LogDao {
	/**
	 * @param log
	 * @return  ��ӵ�¼��־
	 */
	public int insertLog(LoginLog log);
	/**
	 * @param id
	 * @return  ɾ����¼��־
	 */
	public int deleteLog(int id);
	/**
	 * @param id
	 * @return  ����id���ҵ�¼��־
	 */
	public LoginLog findLog(int id);
	/**
	 * @param userId
	 * @return  ���ҵ�ǰ�û������еĵ�¼��־��Ϣ
	 */
	public List<LoginLog> findLogByUser(int userId,int pager);

}
