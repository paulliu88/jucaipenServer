package com.accumulate.manager;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.accumulate.service.UserServer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 *
 *  ��ѯ�û���¼״̬
 */
@SuppressWarnings("serial")
public class QuerryIsLogin extends HttpServlet {
	private String result;
	private String serverToken;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
           doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userId=request.getParameter("userId");
		String clientToken=request.getParameter("clientToken");
		if(StringUtil.isInteger(userId)){
			if(StringUtil.isNotNull(clientToken)){
				int uId=Integer.parseInt(userId);
				querryUserToken(uId);
				if(clientToken.equals(serverToken)){
					//token��֤ͨ��
					result=JsonUtil.getRetMsg(0, "�û���¼");
				}else {
					//token��֤ʧ��
					result=JsonUtil.getRetMsg(1,"�û�token��Ϣ��֤ʧ��");
				}
			}else {
				  result=JsonUtil.getRetMsg(2,"token��ϢΪ��");
			}
		}else {
			result=JsonUtil.getRetMsg(1,"�û�id���ָ�ʽ���쳣");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	/**
	 * @param token   �����û�id��ѯ�û���¼token��Ϣ
	 */
	private void querryUserToken(int uId) {
		serverToken=UserServer.findUserTokenById(uId);
	}

}
