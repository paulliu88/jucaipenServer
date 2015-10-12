package com.accumulate.dao;

import java.util.List;

import com.accumulate.entity.Product;

public interface ProductDao {
	/**
	 * @return   ��ѯ���в�Ʒ��Ϣ
	 */
	public List<Product> findAll(int pager);

	/**
	 * @param id
	 * @return   ����id��ѯ��Ʒ��Ϣ
	 */
	public Product findProduct(int id);

}
