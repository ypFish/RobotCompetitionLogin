package com.yupeng.biz.impl;

import java.util.List;

import com.yupeng.biz.TeamInfoBiz;
import com.yupeng.dao.TeamInfoDao;
import com.yupeng.dao.impl.TeamInfoDaoImpl;
import com.yupeng.entity.Histogram;
import com.yupeng.entity.StudentInfo;
import com.yupeng.entity.TeamInfo;

public class TeamInfoBizImpl implements TeamInfoBiz {

	TeamInfoDao tid=new TeamInfoDaoImpl();
	public int add(TeamInfo ti){
		return tid.add(ti);
	}
	
	public String login(String teamName){
		
		return tid.login(teamName);
	}
	
	public int getId(String teamName,String teamPassword){
		
		return tid.getId(teamName, teamPassword);
	}
	
	public List<Integer> getSubjcetId(String studentId){
		
		return tid.getSubjcetId(studentId);
	}
	
	public List<String> getTeamInfo(int teamId){
		
		return tid.getTeamInfo(teamId);
	}
	
	public int updateTeam(TeamInfo ti){
		
		return tid.updateTeam(ti);
	}
	
	public int getPeopleNumber(int teamId){
		
		return tid.getPeopleNumber(teamId);
	}
	
	public List<StudentInfo> getStudent(int teamId){
		
		return tid.getStudent(teamId);
	}
	
	public int getTeamSubjectId(int teamId){
		
		return tid.getTeamSubjectId(teamId);
	}
	
	public int updateStudentId(int teamId,String studentId,String oldStudentId){
		
		return tid.updateStudentId(teamId, studentId, oldStudentId);
	}
	
	
	public List<TeamInfo> getTeamBySubjectId(int subjectId){
		
		return tid.getTeamBySubjectId(subjectId);
	}
	
	public TeamInfo getTeamById(int teamId){
		
		return tid.getTeamById(teamId);
	}
	
	public List<Histogram> getHistogram(){
		
		return tid.getHistogram(); 
	}
}
