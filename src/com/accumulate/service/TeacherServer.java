package com.accumulate.service;

import java.util.List;

import com.accumulate.dao.TeacherDao;
import com.accumulate.daoImp.TeacherImp;
import com.accumulate.entity.Teacher;

public class TeacherServer {
	/**
	 * @return �������н�ʦ��Ϣ
	 */
	public static List<Teacher> getTeachers(int page) {
		TeacherDao dao = new TeacherImp();
		return dao.findAll(page);
	}

	/**
	 * @param id
	 * @return  ����ĳ����ʦ��Ϣ
	 */
	public static Teacher getTeacher(int id) {
		TeacherDao dao = new TeacherImp();
		return dao.findTeacher(id);
	}

}
