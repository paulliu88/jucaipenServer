package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.FaceTypeDao;
import com.accumulate.daoImp.FaceTypeImp;
import com.accumulate.entity.ExpressionType;

/**
 * @author YLF
 * 
 *         �������
 * 
 */
public class FaceTypeServer {

	/**
	 * @return ��ȡ���б�����������Ϣ
	 */
	public static List<ExpressionType> findAllFace() {
		FaceTypeDao dao = new FaceTypeImp();
		return dao.findAllFace();
	}

	/**
	 * @param id
	 * @return ����id��ȡ���������Ϣ
	 */
	public static ExpressionType findFaceById(int id) {
		FaceTypeDao dao=new FaceTypeImp();
		return dao.findFaceById(id);
	}
	
}
