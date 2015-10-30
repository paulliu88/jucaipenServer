package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.TeacherAttentionDao;
import com.accumulate.daoImp.TeacherAttentionImp;
import com.accumulate.entity.TeacherAttention;

/**
 * @author Administrator
 *
 *
 *  ��ע
 */
public class TeacherAttentionSer {

	/**
	 * @return ��ӹ�ע
	 */
	public static int insertAttention(TeacherAttention attention) {
		TeacherAttentionDao dao=new TeacherAttentionImp();
		return dao.insertAttention(attention);
	}

	/**
	 * @return ��ȡ���еĹ�ע
	 */
	public static List<TeacherAttention> findAllAttention() {
		TeacherAttentionDao dao=new TeacherAttentionImp();
		return dao.findAllAttention();
	}

	/**
	 * @param userId
	 * @return  ��ѯ��ǰ�û��µĹ�ע
	 */
	public static List<TeacherAttention> findAttentionByUid(int userId) {
		TeacherAttentionDao dao=new TeacherAttentionImp();
		return dao.findAttentionByUid(userId);
	}

	/**
	 * @param tId
	 * @return  ���ݽ�ʦid��ѯ��ע��Ϣ
	 */
	public static List<TeacherAttention> findAttentionBytid(int tId) {
		TeacherAttentionDao dao=new TeacherAttentionImp();
		return dao.findAttentionBytid(tId);
	}

	/**
	 * @param uId
	 * @param tId
	 * @return ��ѯ��ǰ
	 */
	public static List<TeacherAttention> findAttentionByUidAndTid(int uId, int tId) {
		TeacherAttentionDao dao=new TeacherAttentionImp();
		return dao.findAttentionByUidAndTid(uId, tId);
	}

}
