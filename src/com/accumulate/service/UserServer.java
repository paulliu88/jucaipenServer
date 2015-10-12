package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.UserDao;
import com.accumulate.daoImp.UserImp;
import com.accumulate.entity.User;

public class UserServer {
	/**
	 * @return ��ѯ���е��û���Ϣ
	 */
	public static List<User> findUser(int page) {
		UserDao dao = new UserImp();
		return dao.findUser(page);

	}

	/**
	 * @param id
	 * @return ����id��ѯ�û�
	 */
	public static User findUserById(int id) {
		UserDao dao = new UserImp();
		return dao.findUserById(id);
	}

	/**
	 * @param userName
	 * @return �����û�����ѯ�û�
	 */
	public static User findUserByAccount(String userName) {
		UserDao dao = new UserImp();
		return dao.findUserByAccount(userName);
	}

	/**
	 * @param userName
	 *            �ֻ��Ż��û���
	 * @return ��¼
	 */
	public static User loginUser(String userName) {
		UserDao dao = new UserImp();
		return dao.findUserByOther(userName);

	}

	/**
	 * @param user
	 * @return ע�����û�
	 */
	public static int insertUser(User user) {
		UserDao dao = new UserImp();
		return dao.reginUser(user);

	}

	/**
	 * @param uId
	 * @return �޸��û���Ϣ
	 */
	public static int updateUser(int uId, User user) {
		UserDao dao = new UserImp();
		return dao.updataUserById(uId, user);
	}

	/**
	 * @param uId
	 * @return �޸�����
	 */
	public static int updatePassword(int uId, String pwd) {
		UserDao dao = new UserImp();
		return dao.updataPasswordById(uId, pwd);
	}

	/**
	 * @param id
	 * @param faceImage
	 * @return  ����id�޸��û�ͷ��URL
	 */
	public static int updateUserLogo(int id, String faceImage) {
		UserDao dao = new UserImp();
		return dao.updateUserLogoById(id, faceImage);
	}

	/**
	 * @param id
	 * @return �����û�id��ѯ�û�����
	 */
	public static String findPasswordById(int id) {
		UserDao dao = new UserImp();
		return dao.findPasswordById(id).getPassword();
	}
	
	
	/**
	 * @param tel
	 * @return   ͨ���ֻ��Ų�ѯ�û���Ϣ  ---���Ƹ�������ʱ��֤�ֻ����Ƿ��Ѿ���
	 */
	public static User findUserByTelPhone(String tel){
		UserDao dao=new UserImp();
		return dao.findUserByTelPhone(tel);
	}
	
	
	/**
	 * @param qqId
	 * @return   ͨ��qqId ��ѯ�û���Ϣ  --�󶨵������˺�ʱ��֤qq�Ƿ��
	 */
	public static User findUserByQQId(String qqId){
		UserDao dao=new UserImp();
		return dao.findUserByQqopenId(qqId);
	}
	
	
	/**
	 * @param weixinId
	 * @return   ͨ��΢��id ��ѯ�û���Ϣ   --�󶨵������˺�ʱ��֤΢���˺��Ƿ��
	 */
	public static User findUserByWeixinId(String weixinId){
		UserDao dao=new UserImp();
		return dao.findUserByWeixinId(weixinId);
	}
	
	
	/**
	 * @param sinaId
	 * @return   ͨ������id��ѯ�û���Ϣ    --�󶨵������˺�ʱ��֤�����˺��Ƿ��Ѿ���
	 */
	public static User  findUserBySinaId(String sinaId){
		UserDao dao=new UserImp();
		return dao.findUserBySinaId(sinaId);
		
	}
	
	/**
	 * @param id
	 * @return  �����û�id��ȡ�û�ͷ��URL
	 */
	public static String findFaceImageById(int id){
		UserDao dao=new UserImp();
		return dao.querryFaceImage(id);
	}

	/**
	 * @param id
	 * @return �����û�id��ѯ�û��ǳ� --��������
	 */
	public static User findUserNikNameById(int id) {
		UserDao dao = new UserImp();
		return dao.findUserInfoById(id);
	}

	/**
	 * @param id
	 *            ��ǰ�û�id
	 * @param accountType
	 *            �޸��û��˺�����
	 * @param accountId
	 *            �������˺�id
	 * @return �޸��û��󶨵������˺�id
	 */
	public static int updateAccountId(int id, int accountType, String accountId) {
		UserDao dao = new UserImp();
		return dao.upDataAccountId(id, accountType, accountId);
	}

	/**
	 * @param accountType
	 *            �˺�����
	 * @param accountId
	 *            �˺�id
	 * @return �������˺ŵ�¼ ��ѯ�������˺��Ƿ����
	 */
	public static User otherAccountLogin(int accountType, String accountId) {
		UserDao dao = new UserImp();
		return dao.otherAccountLogin(accountType, accountId);
	}

	/**
	 * @param id
	 * @return ��ѯ��ǰ�û��µĵ������˺���Ϣ
	 */
	public static User querryOtherAccount(int id) {
		UserDao dao = new UserImp();
		return dao.querryOtherAccount(id);
	}

	/**
	 * @param isLive
	 * @param uId
	 * @return �޸��û��Ƿ���ֱ����
	 */
	public static int updateUserIsLiveRoom(int isLive, int uId) {
		UserDao dao = new UserImp();
		return dao.updateUserIsOnRoom(isLive, uId);
	}

	/**
	 * @param uId
	 * @return ��ѯ�û���¼token
	 */
	public static String findUserTokenById(int uId) {
		UserDao dao = new UserImp();
		return dao.querryUserIsLogin(uId);
	}

	/**
	 * @param uId
	 * @param token
	 * @return �����û�token��Ϣ
	 */
	public static int updateLoginToken(int uId, String token) {
		UserDao dao = new UserImp();
		return dao.updateUserLoginToken(uId, token);
	}

}