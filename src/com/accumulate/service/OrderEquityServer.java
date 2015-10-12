package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.OrderEquityDao;
import com.accumulate.daoImp.OrderEquityImp;
import com.accumulate.entity.OrderEquity;

public class OrderEquityServer {
	/**
	 * @param id
	 * @param userId
	 * @return  ԤԼ��Ȩ
	 */
	public static int insertOrder(int uId,OrderEquity oe){
		OrderEquityDao dao=new OrderEquityImp();
		return dao.insertEquity(uId, oe);
	}
	/**
	 * @param id
	 * @param userId
	 * @return  ȡ��ԤԼ��Ȩ
	 */
	public static int cancenOrder(int id,int userId,int oType){
		OrderEquityDao dao=new OrderEquityImp();
		return dao.cancelEquity(userId, id,oType);
	}
	/**
	 * @param userId
	 * @return  ��ѯ��ǰ�û������е�ԤԼ��Ȩ
	 */
	public static List<OrderEquity> findOrder(int userId,int pager){
		OrderEquityDao dao=new OrderEquityImp();
		return dao.findOrderEquity(userId,pager);
	}

}
