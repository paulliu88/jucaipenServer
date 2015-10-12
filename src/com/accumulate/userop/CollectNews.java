package com.accumulate.userop;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.NewsFavorites;
import com.accumulate.service.NewsFavoritesSer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         �ղء�ȡ���ղ�����
 * 
 *         type ----0 �ղ� -----1 ȡ���ղ�
 * 
 */
@SuppressWarnings("serial")
public class CollectNews extends HttpServlet {
	private NewsFavorites newsFavorites;
	private NewsFavorites nf;
	private String result;
	private int isSuccess;
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
		String newsId = request.getParameter("newsId");
		if (StringUtil.isInteger(typeId)) {
			int type = Integer.parseInt(typeId);
			if (StringUtil.isInteger(userId)) {
				int uId = Integer.parseInt(userId);
				if (uId>0) {
					if (StringUtil.isInteger(newsId)) {
						int nId = Integer.parseInt(newsId);
						if (type == 0) {
							// �ղ�
							nf = newsIsCollect(uId, nId);
							if (nf != null) {
								result = JsonUtil.getRetMsg(1, "�������ѱ��ղ�");
							} else {
								insertNewsCollect(uId, nId);
								if (isSuccess == 1) {
									result = JsonUtil.getRetMsg(0, "�����ղسɹ�");
								} else {
									result = JsonUtil.getRetMsg(2, "�����ղ�ʧ��");
								}
							}
						} else if (type == 1) {
							// ȡ�� �ղ�
							nf = newsIsCollect(uId, nId);
							if (nf != null) {
								cancellNewsCollect(uId, nId);
								if (isSuccess == 1) {
									result = JsonUtil.getRetMsg(0, "�����ղ�ȡ���ɹ�");
								} else {
									result = JsonUtil.getRetMsg(2, "�����ղ�ȡ��ʧ��");
								}
							} else {
								result = JsonUtil.getRetMsg(1, "�����Ż�δ�ղ�");
							}
						}

					} else {
						result = JsonUtil.getRetMsg(5, "�û�id������ʽ���쳣");
					}
				} else {
					result = JsonUtil.getRetMsg(6, "��ǰ�û���û��¼");
				}

			} else {
				result = JsonUtil.getRetMsg(4, "�û�id�������ָ�ʽ���쳣");
			}
		} else {
			result = JsonUtil.getRetMsg(3, "���Ͳ������ָ�ʽ���쳣");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void cancellNewsCollect(int uId, int nId) {
		// ȡ�������ղ�
		isSuccess = NewsFavoritesSer.cancelNews(uId, nId);
	}

	private NewsFavorites newsIsCollect(int uId, int nId) {
		// �ж������Ƿ��ղ�
		return NewsFavoritesSer.findNewsIsCollect(uId, nId);

	}

	private void insertNewsCollect(int uId, int nId) {
		// �����ղ�
		newsFavorites = new NewsFavorites();
		newsFavorites.setnId(nId);
		newsFavorites.setuId(uId);
		newsFavorites.setDate(sdf.format(new Date()));
		isSuccess = NewsFavoritesSer.insertNews(uId, newsFavorites);

	}

}