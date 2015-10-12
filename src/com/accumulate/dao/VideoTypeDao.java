package com.accumulate.dao;

import java.util.List;

import com.accumulate.entity.VideoType;

public interface VideoTypeDao {
	/**
	 * @return  ��ȡȫ����Ƶ������Ϣ
	 */
	public List<VideoType> findAll();
	/**
	 * @param id
	 * @return   ����id ��ȡ��Ƶ������Ϣ
	 */
	public VideoType findTypeById(int id);
	/**
	 * @param isDelete
	 * @return   ��ѯ��Ƶ�����Ƿ�ɾ��
	 */
	public List<VideoType> findTypeByIsDelete(int isDelete);
	
	/**
	 * @param parentId
	 * @return  ����һ������id��ѯ��������
	 */
	public List<VideoType> findTypeByTypeId(int parentId);

}