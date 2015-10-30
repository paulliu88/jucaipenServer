package com.accumulate.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.MobileMessage;
import com.accumulate.entity.User;
import com.accumulate.service.MobileMessageSer;
import com.accumulate.service.UserServer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 *
 *
 *  ��֤�ֻ�������
 */
@SuppressWarnings("serial")
public class CheckMobileCode extends HttpServlet {
	private String result;
	private boolean isPassed;
	private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private String checkDate;
	private int id;

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
		checkDate = sdf.format(new Date());
		//�û���ʵ����
		String trueName=request.getParameter("trueName");
		//�û�id
		String userId=request.getParameter("userId");
		//�û��ֻ���
		String mobileNum=request.getParameter("telPhone");
		//��֤��
		String actionCode=request.getParameter("actionCode");
		//ȯ������
		String qsName=request.getParameter("qsName");
		if(StringUtil.isInteger(userId)){
			//�û�id���ָ�ʽ������
			int uId=Integer.parseInt(userId);
			if(StringUtil.isMobileNumber(mobileNum)){
				//�ֻ��ŷ���Ҫ��
				checkMobileCode(mobileNum,actionCode);
				if(isPassed){
					result=JsonUtil.getRetMsg(0, "��֤����Ϣ��ȷ");
					insertUserInfo(uId,trueName,mobileNum);
				}else {
					result=JsonUtil.getRetMsg(3,"��Ч����֤��");
				}
				insertCheckInfo(mobileNum,checkDate);
			}else {
				result=JsonUtil.getRetMsg(2,"�ֻ��Ų�����Ҫ��");
			}
		}else {
			result=JsonUtil.getRetMsg(1,"�����û�id���ָ�ʽ���쳣");
		}
		out.print(result);
		out.flush();
		out.close();
	}
	private void insertUserInfo(int uId, String trueName, String mobileNum) {
		// �޸ĵ�ǰ�û���Ϣ
		User u=new User();
		u.setTrueName(trueName);
		u.setMobileNum(mobileNum);
		UserServer.updateUserTrueNameAndTelById(id, u);
		
	}
	private void insertCheckInfo(String mobileNum, String checkDate2) {
		//�޸Ķ��ż���״̬
		MobileMessage mobileMessage=new MobileMessage();
		if(isPassed){
			mobileMessage.setMsgType(2);
			mobileMessage.setCheckDate(checkDate2);
		}else {
			mobileMessage.setMsgType(3);
		}
		MobileMessageSer.upDateMessageType(id, mobileMessage);
		
	}
	private void checkMobileCode(String mobile, String actionCode) {
		// ��֤�ֻ���֤���Ƿ�Ϸ�
		List<MobileMessage> mobileList = MobileMessageSer.findMobileMessageByMobileNumLast(1, mobile);
		if(mobileList.size()>0){
			String checkCode=mobileList.get(0).getActionCode();
			String sendDate=mobileList.get(0).getSendDate();
			id = mobileList.get(0).getId();
			long sendTime=new Date(sendDate).getTime();
			long currrentTime=new Date(checkCode).getTime();
			if((actionCode.equals(checkCode))&&((currrentTime-sendTime)<=(3*60*1000))){
				isPassed=true;
			}else {
				isPassed=false;
			}
		}
	   
	}

}
