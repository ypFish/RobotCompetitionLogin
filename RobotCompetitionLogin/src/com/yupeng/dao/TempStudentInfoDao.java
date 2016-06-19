package com.yupeng.dao;

import java.util.List;

import com.yupeng.entity.TempStudentInfo;

public interface TempStudentInfoDao extends BaseDao {

	//以学生角度(姓名)
	public List<TempStudentInfo> getAllByStudentName();
	//以学生角度(学号)
	public List<TempStudentInfo> getAllByStudentId();
	//以学生角度(学院)
	public List<TempStudentInfo> getAllByStudentInstitute();

	//以组队角度
	public List<TempStudentInfo> getAllByTeamName();
	

}
