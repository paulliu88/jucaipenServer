package com.accumulate.dao;

import java.util.List;

import com.accumulate.entity.ExpressionType;

public interface FaceTypeDao {
	
	/**
	 * @return   ��ȡ���б���
	 */
	public List<ExpressionType> findAllFace();
	
	/**
	 * @param id
	 * @return   ͨ������id��ȡ������Ϣ
	 */
	public ExpressionType findFaceById(int id);

}
