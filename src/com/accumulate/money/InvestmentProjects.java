package com.accumulate.money;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.Equity;
import com.accumulate.service.EquityServer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author ylf
 * 
 *         -------SmallId=5 BigId=2
 * 
 *         (���) ˽ļͶ����Ŀ------type=1 ��ҳ��ʾ type=2 ȫ����ʾ
 * 
 */
@SuppressWarnings("serial")
public class InvestmentProjects extends HttpServlet {
	private List<Equity> equities;
	private String result;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String type = request.getParameter("type");
		if (StringUtil.isInteger(type)) {
			int tp = Integer.parseInt(type);
			if (tp == 1) {
				equities = EquityServer.findIndex();
				result = JsonUtil.getIndexFinalList(equities);
			} else if (tp == 2) {
				String pager = request.getParameter("pager");
				if (StringUtil.isInteger(pager)) {
					equities = EquityServer.findAll(Integer.parseInt(pager));
					if (equities != null && equities.size() > 0) {
						result = JsonUtil.getIndexFinalList(equities);
					} else {
						result = JsonUtil.getRetMsg(3, "����˽ļͶ����Ŀ");
					}
				} else {
					result = JsonUtil.getRetMsg(2, "ҳ����ʽ���쳣");
				}
			}
		} else {
			result = JsonUtil.getRetMsg(1, "������ʽ���쳣");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
