package com.accumulate.dao;

import java.util.List;

import com.accumulate.entity.Teacher;

public interface TeacherDao {
	/**
	 * @return  ��ѯ���н�ʦ
	 */
	public List<Teacher> findAll(int page);
	/**
	 * @param id
	 * @return ��ѯָ���Ľ�ʦ
	 */
	public Teacher findTeacher(int id);

}
