package com.yupeng.biz;

import java.util.List;

import com.yupeng.entity.SubjectInfo;

public interface SubjectInfoBiz{

	public int addAll(SubjectInfo subjectInfo);
		
	public List<SubjectInfo> getAll();
	
	public int deleteById(int subjectId);

	public int updateById(SubjectInfo si);
}
