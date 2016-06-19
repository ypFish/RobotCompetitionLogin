package com.yupeng.biz;

import java.util.List;

import com.yupeng.entity.Histogram;
import com.yupeng.entity.StudentInfo;
import com.yupeng.entity.TeamInfo;

public interface TeamInfoBiz {

	public int add(TeamInfo ti);
	
	public String login(String teamName);
	
	public int getId(String teamName,String teamPassword);
	
	public List<Integer> getSubjcetId(String studentId);
	
	public List<String> getTeamInfo(int teamId);
	
	public int updateTeam(TeamInfo ti);
	
	public int getPeopleNumber(int teamId);
	
	public List<StudentInfo> getStudent(int teamId);
	
	public int getTeamSubjectId(int teamId);
	
	public int updateStudentId(int teamId,String studentId,String oldStudentId);
	
	public List<TeamInfo> getTeamBySubjectId(int subjectId);
	
	public TeamInfo getTeamById(int teamId);
	
	public List<Histogram> getHistogram();
}
