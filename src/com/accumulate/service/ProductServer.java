package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.ProductDao;
import com.accumulate.daoImp.ProductDaoImp;
import com.accumulate.entity.Product;

public class ProductServer {
	/**
	 * @return  ��ѯ���в�Ʒ
	 */
	public static List<Product> findALL(int pager){
		ProductDao dao=new ProductDaoImp();
		return dao.findAll(pager);
	}
	/**
	 * @param id
	 * @return  ����id��ѯ��Ʒ��Ϣ
	 */
	public static Product findProduct(int id){
		ProductDao dao=new ProductDaoImp();
		return dao.findProduct(id);
	}

}
