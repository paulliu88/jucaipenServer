package com.accumulate.userop;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author YLF
 * 
 *         �ļ�����
 * 
 */
@SuppressWarnings("serial")
public class FileDownLoad extends HttpServlet {
	private static File fs[];

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.flush();
		out.close();
	}

	/**
	 * @param args
	 * 
	 *    ���������ļ�
	 */
	public static void main(String[] args) {
		File f = new File("D:/");
		if (f.exists()) {
			while (f.isDirectory()) {
				fs = f.listFiles();
				for (File fi : fs) {
					System.out.println("һ����");
					System.out.println("�ļ�����" + fi.getName());
					System.out.println("ʣ��ռ䣺" + fi.getFreeSpace() + "   �ܿռ䣺"
							+ fi.getTotalSpace());
					f=fi;
				}
			}

		}
	}

}
