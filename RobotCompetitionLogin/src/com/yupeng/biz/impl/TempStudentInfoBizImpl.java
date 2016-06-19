package com.yupeng.biz.impl;

import java.util.List;

import com.yupeng.biz.TempStudentInfoBiz;
import com.yupeng.dao.TempStudentInfoDao;
import com.yupeng.dao.impl.TempStudentInfoDaoImpl;
import com.yupeng.entity.TempStudentInfo;

public class TempStudentInfoBizImpl implements TempStudentInfoBiz {

	TempStudentInfoDao td=new TempStudentInfoDaoImpl();
	
	public List<TempStudentInfo> getAllByStudentId() {
		// TODO Auto-generated method stub
		return td.getAllByStudentId();
	}

	public List<TempStudentInfo> getAllByStudentInstitute() {
		// TODO Auto-generated method stub
		return td.getAllByStudentInstitute();
	}

	public List<TempStudentInfo> getAllByStudentName() {
		// TODO Auto-generated method stub
		return td.getAllByStudentName();
	}

	public List<TempStudentInfo> getAllByTeamName() {
		// TODO Auto-generated method stub
		return td.getAllByTeamName();
	}

}
