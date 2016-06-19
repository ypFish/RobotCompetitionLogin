package com.yupeng.biz.impl;

import java.util.List;

import com.yupeng.biz.SubjectInfoBiz;
import com.yupeng.dao.SubjectInfoDao;
import com.yupeng.dao.impl.SubjectInfoDaoImpl;
import com.yupeng.entity.SubjectInfo;

public class SubjectInfoBizImpl implements SubjectInfoBiz {

	SubjectInfoDao sid=new SubjectInfoDaoImpl();
	public int addAll(SubjectInfo subjectInfo) {
		// TODO Auto-generated method stub
		
		return sid.addAll(subjectInfo);
	}
	
	public List<SubjectInfo> getAll(){
				
		return sid.getAll();
	}
	
	public int deleteById(int subjectId){
		
		return sid.deleteById(subjectId);
	}

	public int updateById(SubjectInfo si){
		
		return sid.updateById(si);
	}
}

