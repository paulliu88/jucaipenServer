package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.ReadInfoDao;
import com.accumulate.daoImp.ReadInfoImp;
import com.accumulate.entity.ReadInfo;

public class ReadInfoServer {
	/**
	 * @return  ��ȡȫ����ȡ��Ϣ
	 */
	public List<ReadInfo> findAll(int page){
		ReadInfoDao dao=new ReadInfoImp();
		return dao.findAll(page);
	}
	/**
	 * @param id
	 * @return  ����id��ȡ��ȡ����Ϣ
	 */
	public ReadInfo findInfoById(int id){
		ReadInfoDao dao=new ReadInfoImp();
		return dao.findReadInfo(id);
	}
	/**
	 * @param userId
	 * @param page �����û���ѯ��ȡ��Ϣ
	 * @return   
	 */
	public List<ReadInfo> findInfoByUser(int userId,int page){
		ReadInfoDao dao=new ReadInfoImp();
		return dao.findReadInfoByUser(userId,page);
	}
	/**
	 * @param readDate
	 * @param page
	 * @return   ���ݶ�ȡʱ���ѯ��ȡʱ��
	 */
	public List<ReadInfo> findInfoByReadDate(String readDate,int page){
		ReadInfoDao dao=new ReadInfoImp();
		return dao.findReadInfoByReadDate(readDate,page);
	}

}