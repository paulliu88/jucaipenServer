package com.accumulate.userop;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.accumulate.service.OrderEquityServer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author YLF
 * 
 *         ԤԼ��ȡ����Ȩ
 * 
 *         type-----��Ȩ�������� ��1 Ԥ�� 2 ȡ��Ԥ����
 *         
 *         orderType=1  ԤԼ��Ȩ��Ŀ
 *         orderType=2  ԤԼ˽ļ��Ŀ
 * 
 * 
 *         ----������ userId(�û�id) trueName(�û���ʵ����) MobileNum(�ֻ���) Remark(��ע)
 *         TouziMoney(Ͷ�ʽ��) ItemId(�ɷ�id)
 * 
 */
@SuppressWarnings("serial")
public class OrderEquity extends HttpServlet {
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private String result;
	private String orderDate;
	private int uId;
	private int eId;
	private int isSuccess;
	private com.accumulate.entity.OrderEquity oe;
	private int oType;
	private String ip;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String type = request.getParameter("type");
		String userId = request.getParameter("userId");
		String equityId = request.getParameter("equityId");
		String orderType=request.getParameter("orderType");
		ip = request.getRemoteAddr();
		if(StringUtil.isInteger(orderType)){
			oType=Integer.parseInt(orderType);
			if(oType==1||oType==2){
				if (StringUtil.isInteger(type)) {
					int tp = Integer.parseInt(type);
					if (StringUtil.isInteger(equityId)) {
						eId = Integer.parseInt(equityId);
						if (StringUtil.isInteger(userId)) {
							uId = Integer.parseInt(userId);
							if(uId>0){
								if (tp == 1) {
									// ԤԼ��Ȩ
									com.accumulate.entity.OrderEquity oe = checkData(request,out);
									if(oe!=null){
										isSuccess = orderEquity(oe, uId);
										if (isSuccess == 1) {
											result = JsonUtil.getRetMsg(0, "ԤԼ��Ȩ�ɹ�");
										} else {
											result = JsonUtil.getRetMsg(8, "ԤԼ��Ȩʧ��");
										}
									}
								} else if (tp == 2) {
									// ȡ����ȨԤԼ��Ϣ
									cancelEquity(eId, uId,oType);
								}
							}else {
								result=JsonUtil.getRetMsg(4,"��ǰ�û���û��¼");
							}
							
						} else {
							result = JsonUtil.getRetMsg(3, "�û�id���ֲ�����ʽ���쳣");
						}
					} else {
						result = JsonUtil.getRetMsg(2, "��Ȩid���ָ�ʽ���쳣");
					}
				} else {
					result = JsonUtil.getRetMsg(1, "���Ͳ������ָ�ʽ���쳣");
				}
			}else {
				result=JsonUtil.getRetMsg(5, "ԤԼ���Ͳ���ֻ����1����2");
			}
		}else {
			result=JsonUtil.getRetMsg(6, "ԤԼ���Ͳ������ָ�ʽ���쳣");
		}
		
		
		
		
		out.print(result);

		out.flush();
		out.close();
	}

	private com.accumulate.entity.OrderEquity checkData(
			HttpServletRequest request,PrintWriter out) {
		orderDate = sdf.format(new Date());
		String trueName = request.getParameter("trueName");
		String mobileNum = request.getParameter("telPhone");
		String remark = request.getParameter("remark");
		String touziMoney = request.getParameter("touziMoney");
		if (StringUtil.isNotNull(mobileNum)
				&& StringUtil.isMobileNumber(mobileNum)) {
			oe = new com.accumulate.entity.OrderEquity();
			oe.seteId(eId);
			oe.setuIp(ip);
			oe.setInsertDate(orderDate);
			oe.setMobileNum(mobileNum);
			oe.setuId(uId);
			oe.setTrueName(trueName);
			oe.setTouziMoney(touziMoney);
			oe.setOrderType(oType);
			oe.setRemark(remark);
			return oe;
		}else {
			result=JsonUtil.getRetMsg(5,"�Ƿ��ֻ���");
			return null;
		}
	}

	private int cancelEquity(int eId, int uId,int oType) {
		// ȡ��ԤԼ��Ȩ��Ϣ
		return OrderEquityServer.cancenOrder(eId, uId,oType);
	}

	private int orderEquity(com.accumulate.entity.OrderEquity oe, int uId) {
		// ԤԼ��Ȩ��Ϣ
		return OrderEquityServer.insertOrder(uId, oe);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
