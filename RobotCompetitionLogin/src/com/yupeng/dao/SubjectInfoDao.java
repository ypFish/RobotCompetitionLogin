package com.yupeng.dao;

import java.util.List;

import com.yupeng.entity.SubjectInfo;
import com.yupeng.entity.TeamInfo;

public interface SubjectInfoDao extends BaseDao {

	public int addAll(SubjectInfo subjectInfo);
	
	public List<SubjectInfo> getAll();
	
	public int deleteById(int subjectId);
	
	public int updateById(SubjectInfo si);

}
