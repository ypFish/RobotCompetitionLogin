package com.yupeng.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.yupeng.dao.TeamInfoDao;
import com.yupeng.entity.Histogram;
import com.yupeng.entity.StudentInfo;
import com.yupeng.entity.TeamInfo;

public class TeamInfoDaoImpl extends BaseDaoImpl implements TeamInfoDao {

	public int add(TeamInfo ti){
		
		this.openCon();
		try {
			String sql="insert into teamInfo(teamName,teamPassword,subjectId,teacherName,student1,student2,student3,student4,student5,remark) values(?,?,?,?,?,?,?,?,?,'')";
			ps=con.prepareStatement(sql);
			ps.setString(1,ti.getTeamName());
			ps.setString(2, ti.getTeamPassword());
			ps.setInt(3, ti.getSubjectId());
			ps.setString(4, ti.getTeacherName());
			ps.setString(5,ti.getStudent1());
			ps.setString(6, ti.getStudent2());
			ps.setString(7, ti.getStudent3());
			ps.setString(8, ti.getStudent4());
			ps.setString(9, ti.getStudent5());
			num=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return num;
	}
	
	public String login(String teamName){
		
		this.openCon();
		String rightPassword="";
		String sql="select teamPassword from teamInfo where teamName=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, teamName);
			rs=ps.executeQuery();
			while(rs.next()){
				rightPassword=rs.getString("teamPassword");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		
		return rightPassword;
	}
	
	
	public int getId(String teamName,String teamPassword){
		
		this.openCon();
		int teamId=0;
		String sql="select teamId from teamInfo where teamName=? and teamPassword=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, teamName);
			ps.setString(2, teamPassword);
			rs=ps.executeQuery();
			while(rs.next()){
				
				teamId=rs.getInt("teamId");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		
		return teamId;
		
	}
	
	public List<Integer> getSubjcetId(String studentId){
		
		this.openCon();
		List<Integer> list=new ArrayList<Integer>();
		String sql="select subjectId from teamInfo where student1=? or student2=? or student3=? or student4=? or student5=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1,studentId);
			ps.setString(2,studentId);
			ps.setString(3,studentId);
			ps.setString(4,studentId);
			ps.setString(5,studentId);
			rs=ps.executeQuery();
			while(rs.next()){
				int subjectId=rs.getInt("subjectId");
				list.add(subjectId);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		
		return list;
	}
	
	public List<String> getTeamInfo(int teamId){
		
		String teamName="";
		String teamPassword="";
		String teacherName="";
		String subjectName="";
		List<String> listTeamInfo=new ArrayList<String>();
		this.openCon();
		String sql="select teamName,teamPassword,teacherName,subjectName from teamInfo inner join subjectInfo on subjectInfo.subjectId=teamInfo.subjectId where teamId=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1,teamId);
			rs=ps.executeQuery();
			while(rs.next()){
				teamName=rs.getString("teamName");
				teamPassword=rs.getString("teamPassword");
				teacherName=rs.getString("teacherName");
				subjectName=rs.getString("subjectName");
				listTeamInfo.add(teamName);
				listTeamInfo.add(teamPassword);
				listTeamInfo.add(teacherName);
				listTeamInfo.add(subjectName);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		
		return listTeamInfo;
	}
	
	public int updateTeam(TeamInfo ti){
		
		this.openCon();
		try {
			String sql="update teamInfo set teamName=?,teamPassword=?,teacherName=? where teamId=?";
			ps=con.prepareStatement(sql);
			ps.setString(1,ti.getTeamName());
			ps.setString(2,ti.getTeamPassword());
			ps.setString(3,ti.getTeacherName());
			ps.setInt(4,ti.getTeamId());
			num=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		
		return num;
	}
	
	public int getPeopleNumber(int teamId){
		
		this.openCon();
		int peopleNumber=0;
		String sql="select peopleNumber from subjectInfo where subjectId=(select subjectId from teamInfo where teamId=?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, teamId);
			rs=ps.executeQuery();
			while(rs.next()){
				peopleNumber=rs.getInt("peopleNumber");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return peopleNumber;
	}

	public List<StudentInfo> getStudent(int teamId){
		
		this.openCon();
		List<StudentInfo> list=new ArrayList<StudentInfo>();
		String sql="select studentId ,studentName,studentInstitute,studentPhone,studentEmail from studentInfo " +
				"where studentId =(select student1 from teamInfo where teamId=?) or studentId=(select student2 from teamInfo where teamId=?) or studentId=(select student3 from teamInfo where teamId=?) or studentId=(select student4 from teamInfo where teamId=?) or studentId=(select student5 from teamInfo where teamId=?)" +
				" order by studentId desc";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, teamId);
			ps.setInt(2, teamId);
			ps.setInt(3, teamId);
			ps.setInt(4, teamId);
			ps.setInt(5, teamId);
			rs=ps.executeQuery();
			while(rs.next()){
				StudentInfo si=new StudentInfo();
				si.setStudentId(rs.getString("studentId").trim());
				si.setStudentName(rs.getString("studentName").trim());
				si.setStudentInstitute(rs.getString("studentInstitute").trim());
				si.setStudentPhone(rs.getString("studentPhone").trim());
				si.setStudentEmail(rs.getString("studentEmail").trim());
				list.add(si);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			this.closeAll();
		}
		
		return list;
	}
	
	public int getTeamSubjectId(int teamId){
		
		this.openCon();
		int subjectId=0;
		String sql="select subjectId from teamInfo where teamId=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, teamId);
			rs=ps.executeQuery();
			while(rs.next()){
			subjectId=rs.getInt("subjectId");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return subjectId;
	}
	
	public int updateStudentId(int teamId,String studentId,String oldStudentId){
		
		this.openCon();
		try {
			String sql="";
			for(int i=1;i<=5;i++){
			sql="update teamInfo set student"+i+"=? where student"+i+"=? and teamId=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, studentId);
			ps.setString(2, oldStudentId);
			ps.setInt(3,teamId);
			num=ps.executeUpdate();
				if(num>0){
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return num;
	
	}
	
	public List<TeamInfo> getTeamBySubjectId(int subjectId){
		
		this.openCon();
		List<TeamInfo> list=new ArrayList<TeamInfo>();
		String sql="select teamId,teamName,teamPassword from teamInfo where subjectId=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, subjectId);
			rs = ps.executeQuery();
			while (rs.next()) {
				TeamInfo ti = new TeamInfo();
				ti.setTeamId(rs.getInt("teamId"));
				ti.setTeamName(rs.getString("teamName"));
				ti.setTeamPassword(rs.getString("teamPassword"));
				list.add(ti);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			this.closeAll();
		}
		return list;
	}
	
	public TeamInfo getTeamById(int teamId){
		this.openCon();
		TeamInfo ti=new TeamInfo();
		String sql="select teamName,teamPassword,teacherName,student1,student2,student3,student4,student5 from teamInfo where teamId=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1,teamId);
			rs=ps.executeQuery();
			while(rs.next()){
				ti.setTeamName(rs.getString("teamName").trim());
				ti.setTeamPassword(rs.getString("teamPassword").trim());
				ti.setTeacherName(rs.getString("teacherName").trim());
				ti.setStudent1(rs.getString("student1").trim());
				ti.setStudent2(rs.getString("student2").trim());
				ti.setStudent3(rs.getString("student3").trim());
				ti.setStudent4(rs.getString("student4").trim());
				ti.setStudent5(rs.getString("student5").trim());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		
		return ti;
	}

	public List<Histogram> getHistogram() {
		// TODO Auto-generated method stub
		this.openCon();
		List<Histogram> list=new ArrayList<Histogram>();
		String sql="select subjectName,count(teamId) as 'teamCount' from teamInfo right join subjectInfo on subjectInfo.subjectId=teamInfo.subjectId group by subjectName";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				
				Histogram his=new Histogram();
				his.setName(rs.getString("subjectName").trim()+":"+rs.getInt("teamCount"));
				his.setPer(rs.getInt("teamCount"));
				list.add(his);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		
		
		return list;
	}
}
