package com.yupeng.biz;

import java.util.List;

import com.yupeng.entity.StudentInfo;

public interface StudentInfoBiz {

	public List<String> getStudentId();
	
	public int havaStudentId(String studentId);
	
	public int add(StudentInfo studentInfo);
	
	public int update(StudentInfo studentInfo);
	
	public int delete(String studentId);
}
