package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.VideoTypeDao;
import com.accumulate.daoImp.VideoTypeImp;
import com.accumulate.entity.VideoType;

public class VideoTypeSer {
	/**
	 * @return ��ȡ������Ƶ������Ϣ
	 */
	public static List<VideoType> findAll() {
		VideoTypeDao dao = new VideoTypeImp();
		return dao.findAll();
	}

	/**
	 * @param id
	 * @return ����id ��ѯ������Ϣ
	 */
	public static VideoType findTypeById(int id) {
		VideoTypeDao dao = new VideoTypeImp();
		return dao.findTypeById(id);
	}

	/**
	 * @param parentId
	 * @return   ����һ������id��ѯ�±߶����������Ϣ
	 */
	public static List<VideoType> findVideoTypeByParentId(int parentId) {
		VideoTypeDao dao = new VideoTypeImp();
		return dao.findTypeByTypeId(parentId);
	}
}
