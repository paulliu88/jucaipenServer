package com.accumulate.service;

import com.accumulate.dao.SiteConfigDao;
import com.accumulate.daoImp.SiteConfigImp;
import com.accumulate.entity.SiteConfig;

/**
 * @author YLF
 * 
 *
 */
public class SiteConfigSer{

	/**
	 * @return   ��ȡ������Ϣ
	 */
	public static SiteConfig findSiteConfig() {
		SiteConfigDao dao=new SiteConfigImp();
		return dao.findSiteConfig();
	}
}
