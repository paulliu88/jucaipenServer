package com.accumulate.money;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accumulate.entity.News;
import com.accumulate.service.NewServer;
import com.accumulate.utils.JsonUtil;
import com.accumulate.utils.StringUtil;

/**
 * @author YLF
 * 
 *         股权报告 -----bigId=2 smallId=4
 * 
 */
@SuppressWarnings("serial")
public class EquityReport extends HttpServlet {
	private List<News> news;
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
				news = NewServer.findIndexNewsById(2, 4);
				result = JsonUtil.getIndxKnownList(news);
			} else if (tp == 2) {
				String pager = request.getParameter("pager");
				if (StringUtil.isInteger(pager)) {
					news = NewServer.queryNewsById(2, 4,
							Integer.parseInt(pager));
					if (news != null && news.size() > 0) {
						result = JsonUtil.getObject(news);
					} else {
						result = JsonUtil.getRetMsg(2, "暂无股权报告信息");
					}
				} else {
					result = JsonUtil.getRetMsg(1, "页数参数格式化异常");
				}
			}

		} else {
			result = JsonUtil.getRetMsg(3, "类型参数数字格式化异常");

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
