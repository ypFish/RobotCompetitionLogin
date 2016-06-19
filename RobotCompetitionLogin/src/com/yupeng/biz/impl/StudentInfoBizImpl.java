package com.yupeng.biz.impl;

import java.util.List;

import com.yupeng.biz.StudentInfoBiz;
import com.yupeng.dao.StudentInfoDao;
import com.yupeng.dao.impl.StudentInfoDaoImpl;
import com.yupeng.entity.StudentInfo;

public class StudentInfoBizImpl implements StudentInfoBiz {

	StudentInfoDao stuDao=new StudentInfoDaoImpl();
	public List<String> getStudentId() {
		// TODO Auto-generated method stub
		
		return stuDao.getStudentId();
	}
	
	public int havaStudentId(String studentId){
		
		return stuDao.havaStudentId(studentId);
	}
	
	public int add(StudentInfo studentInfo){
		
		return stuDao.add(studentInfo);
	}
	
	public int update(StudentInfo studentInfo){
		
		return stuDao.update(studentInfo);
	}
	
	public int delete(String studentId){
		
		return stuDao.delete(studentId);
	}

}
