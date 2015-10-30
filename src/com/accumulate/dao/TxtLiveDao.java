package com.accumulate.dao;

import java.util.List;

import com.accumulate.entity.TextLive;

public interface TxtLiveDao {
	
	/**
	 * @param textLive
	 * @return   �������ֱ����Ϣ
	 */
	public int insertTxtLive(TextLive textLive);
	
	/**
	 * @param condition
	 * @return  ��ȡ����ֱ����ҳ��
	 */
	public int findTotlePage(String condition);

	/**
	 * @param id
	 * @return  ����id��ȡֱ����Ϣ
	 */
	public TextLive findTextLiveById(int id);
	/**
	 * @return  ��ȡȫ��ֱ����Ϣ
	 */
	public List<TextLive>findAllTextLive(int page);
	/**
	 * @param teacherId
	 * @return  ���ݽ�ʦid��ȡֱ����Ϣ
	 */
	public List<TextLive> findTextLiveByTeacherId(int teacherId);
	/**
	 * @param isEnd
	 * @return   �����Ƿ������ȡֱ����Ϣ
	 */
	public List<TextLive> findTextLiveByIsEnd(int isEnd);
	
	/**
	 * @param teacherId
	 * @param count
	 * @return   ��ȡ��ʦ����ļ���ֱ��
	 */
	public List<TextLive> findTxtLiveByTeacherIdAndLast(int teacherId,int count);
}
