package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.NewsFavoritesDao;
import com.accumulate.daoImp.NewsFavoritesImp;
import com.accumulate.entity.NewsFavorites;

public class NewsFavoritesSer {
	/**
	 * @param uId
	 * @param nId
	 * @return �ղ���Ϣ
	 */
	public static int insertNews(int uId, NewsFavorites newsFavorites) {
		NewsFavoritesDao dao = new NewsFavoritesImp();
		return dao.insertNewsFavorites(uId, newsFavorites);
	}

	/**
	 * @param uId
	 * @param nId
	 * @return ȡ���ղ�����
	 */
	public static int cancelNews(int uId, int nId) {
		NewsFavoritesDao dao = new NewsFavoritesImp();
		return dao.cancelNewsFavorites(uId, nId);
	}

	/**
	 * @param uId
	 * @return ��ѯ���û��������ղص�������Ϣ
	 */
	public static List<NewsFavorites> findNewsFavoByUser(int uId, int pager) {
		NewsFavoritesDao dao = new NewsFavoritesImp();
		return dao.findNewsFavorites(uId, pager);
	}
	/**
	 * @param uId
	 * @param nId
	 * @return  ��ѯ�����Ƿ��ղ�
	 */
	public static NewsFavorites findNewsIsCollect(int uId,int nId){
		NewsFavoritesDao dao=new NewsFavoritesImp();
		return dao.findNewsFavouritesByUidAndNid(uId, nId);
	}

}
