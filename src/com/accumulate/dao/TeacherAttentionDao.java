package com.accumulate.dao;

import java.util.List;

import com.accumulate.entity.TeacherAttention;

public interface TeacherAttentionDao {
	
	/**
	 * @return ��ӹ�ע
	 */
	public int insertAttention(TeacherAttention attention);
	/**
	 * @return ��ȡ���еĹ�ע��Ϣ
	 */
	public List<TeacherAttention> findAllAttention();
	/**
	 * @param userId
	 * @return �����û�id��ѯ��ע��Ϣ
	 */
	public List<TeacherAttention> findAttentionByUid(int userId);
	/**
	 * @param tId
	 * @return ���ݽ�ʦid��ѯ��ע��Ϣ
	 */
	public List<TeacherAttention> findAttentionBytid(int tId);
	/**
	 * @param uId
	 * @param tId
	 * @return �����û�id����ʦid��ȡ��ע����Ϣ
	 */
	public List<TeacherAttention> findAttentionByUidAndTid(int uId,int tId);
	

}
