package com.accumulate.userop;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.accumulate.entity.EquityFavorites;
import com.accumulate.service.EquityFavSer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         �ղء�ȡ���ղع�Ȩ
 * 
 *         type ----0 �ղع�Ȩ ----1 ȡ���ղع�Ȩ
 * 
 */
@SuppressWarnings("serial")
public class CollectEquity extends HttpServlet {
	private EquityFavorites equityFavorites;
	private EquityFavorites ef;
	private int isSuccess;
	private String result;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

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
		String typeId = request.getParameter("type");
		String userId = request.getParameter("userId");
		String equityId = request.getParameter("equityId");
		if (StringUtil.isInteger(typeId)) {
			int type = Integer.parseInt(typeId);
			if (StringUtil.isInteger(userId)) {
				int uId = Integer.parseInt(userId);
				if (uId >0) {
					if (StringUtil.isInteger(equityId)) {
						int eId = Integer.parseInt(equityId);
						if (type == 0) {
							// �ղع�Ȩ
							querryEquityIsCollect(uId, eId);
							if (ef != null) {
								result = JsonUtil.getRetMsg(2, "��Ȩ�ѱ��ղ�");
							} else {
								insertCollectEquity(uId, eId);
								if (isSuccess == 1) {
									result = JsonUtil.getRetMsg(0, "��Ȩ�ղسɹ�");
								} else {
									result = JsonUtil.getRetMsg(1, "��Ȩ�ղ�ʧ��");
								}
							}
						} else if (type == 1) {
							// ȡ���ղع�Ȩ
							querryEquityIsCollect(uId, eId);
							if (ef != null) {
								cancellCollectEquity(uId, eId);
								if (isSuccess == 1) {
									result = JsonUtil.getRetMsg(0, "��Ȩ�ղ�ȡ���ɹ�");
								} else {
									result = JsonUtil.getRetMsg(1, "��Ȩ�ղ�ȡ��ʧ��");
								}
							} else {
								result = JsonUtil.getRetMsg(2, "��Ȩ��δ�ղ�");
							}
						}
					} else {
						result = JsonUtil.getRetMsg(5, "��Ȩid�������ָ�ʽ���쳣");
					}
				} else {
					result = JsonUtil.getRetMsg(6, "��ǰ�û���û��¼");
				}

			} else {
				result = JsonUtil.getRetMsg(4, "�û��������ָ�ʽ���쳣");
			}
		} else {
			result = JsonUtil.getRetMsg(3, "���Ͳ������ָ�ʽ���쳣");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void cancellCollectEquity(int uId, int eId) {
		// ȡ����Ȩ�ղ�
		isSuccess = EquityFavSer.cancelEquity(uId, eId);

	}

	private void querryEquityIsCollect(int uId, int eId) {
		// ��ѯ��Ȩ�Ƿ��ղ�
		ef = EquityFavSer.findEquityIsCollect(uId, eId);

	}

	private void insertCollectEquity(int uId, int eId) {
		// �ղع�Ȩ
		equityFavorites = new EquityFavorites();
		equityFavorites.setuId(uId);
		equityFavorites.seteId(eId);
		equityFavorites.setDate(sdf.format(new Date()));
		isSuccess = EquityFavSer.insertEquity(uId, equityFavorites);

	}

}
