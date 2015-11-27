package com.accumulate.userop;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.LoginLog;
import com.accumulate.entity.User;
import com.accumulate.service.LogServer;
import com.accumulate.service.UserServer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.MD5Util;
import com.accumulate.utils.StringUtil;

/**
 * @author YLF
 * 
 *         ��¼
 */
@SuppressWarnings("serial")
public class Login extends HttpServlet {
	private String result;
	private User user;
	private String md5Pwd;
	private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private String userName;
//	private int isSuccess;
	private String uuid;
	private String clientAddress;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		userName = request.getParameter("userName");
		String password = request.getParameter("password");
		clientAddress = request.getRemoteAddr();
		if (!StringUtil.isNotNull(userName)) {
			result = JsonUtil.getRetMsg(1, "�û�������Ϊ��");
		} else if (!StringUtil.isNotNull(password)) {
			result = JsonUtil.getRetMsg(2, "���벻��Ϊ��");
		} else {
			md5Pwd = MD5Util.MD5(password);
			user = UserServer.loginUser(userName);
			if (user != null) {
				// �û�������
				String pwd = user.getPassword();
				if (pwd.equals(md5Pwd)) {
					// ������ȷ
					int uId=user.getId();
					uuid=UUID.randomUUID().toString();
					Cookie cookie = new Cookie("account",uuid);
					response.addCookie(cookie);
					result = JsonUtil.getLoginResult(user);
					upDateLoginState(uId,uuid);
					handleLoginResult(1,password,uId);
				} else {
					// �������
					result = JsonUtil.getRetMsg(4, "������������");
					handleLoginResult(0,password,0);
				}
			} else {
				// �û���������
				result = JsonUtil.getRetMsg(3, "�˺Ų�����");
			}
		}
		out.print(result);
		out.flush();
		out.close();
	}
    /*
     * �޸ĵ�¼״̬
     */
	private void upDateLoginState(int uId,String token) {
		UserServer.updateLoginToken(uId, token);
		
	}

	private void handleLoginResult(int res,String pwd,int uId) {
		//�����¼���
		LoginLog log=new LoginLog();
		log.setLoginDate(sdf.format(new Date()));
		log.setLoginResult(res);
		log.setUserId(uId);
		log.setUserName(userName);
		log.setPassword(pwd);
		if(res==0){
			log.setRemark("��¼ʧ�ܣ��������");
		}else {
			log.setRemark("��¼�ɹ�");
		}
		log.setLoginIp(clientAddress);
		LogServer.insertLog(log);
		
		
	}

}
