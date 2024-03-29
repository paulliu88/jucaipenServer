package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.MobileMessageDao;
import com.accumulate.daoImp.MobileMessageImp;
import com.accumulate.entity.MobileMessage;

public class MobileMessageSer{

	/**
	 * @param message
	 * @return  添加短信
	 */
	public static int insertMessage(MobileMessage message) {
		MobileMessageDao dao=new MobileMessageImp();
		return dao.insertMessage(message);
	}

	/**
	 * @param id
	 * @param message
	 * @return  修改短信验证状态
	 */
	public static int upDateMessageType(String msgId, MobileMessage message) {
		MobileMessageDao dao=new MobileMessageImp();
		return dao.upDateMessageType(msgId, message);
	}

	/**
	 * @param telPhone
	 * @return  根据手机号获取所有接受短信
	 */
	public static List<MobileMessage> findMobileMessgageByMobileNum(String telPhone) {
		MobileMessageDao dao=new MobileMessageImp();
		return dao.findMobileMessgageByMobileNum(telPhone);
	}

	/**
	 * @param count
	 * @param mobile
	 * @return 根据手机号获取最近接受到的几条短信
	 */
	public static List<MobileMessage> findMobileMessageByMobileNumLast(int count,
			String mobile) {
		MobileMessageDao dao=new MobileMessageImp();
		return dao.findMobileMessageByMobileNumLast(count, mobile);
	}}
