package com.yupeng.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yupeng.dao.TempStudentInfoDao;
import com.yupeng.entity.StudentInfo;
import com.yupeng.entity.TempStudentInfo;
import com.yupeng.tool.ChangeInstitute;

public class TempStudentInfoDaoImpl extends BaseDaoImpl implements
		TempStudentInfoDao {

	public List<TempStudentInfo> getAllByStudentName() {
		// TODO Auto-generated method stub
		this.openCon();
		PreparedStatement ps2=null;
		ResultSet rs2=null;
		List<TempStudentInfo> listTemp=new ArrayList<TempStudentInfo>();
		String sql="select studentId,studentName,studentInstitute,studentPhone,(select COUNT(teamId) from teamInfo where student1=studentInfo.studentId or student2=studentInfo.studentId or student3=studentInfo.studentId or student4=studentInfo.studentId or student5=studentInfo.studentId) as 'count' from studentInfo order by count desc";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				if(rs.getString("studentId")==null||(rs.getString("studentId").trim()).isEmpty()){
					continue;
				}
				if(rs.getInt("count")==0){
					continue;
				}
				StudentInfo si=new StudentInfo();
				si.setStudentId(rs.getString("studentId").trim());
				si.setStudentName(rs.getString("studentName").trim());
				si.setStudentInstitute(ChangeInstitute.change(rs.getString("studentInstitute")));
				si.setStudentPhone(rs.getString("studentPhone").trim());
				
				TempStudentInfo ts=new TempStudentInfo();
				ts.setTsStudent(si);
				ts.setTsCount(rs.getInt("count"));
				
				String sql2="select subjectName,teamName from teamInfo inner join subjectInfo on teamInfo.subjectId=subjectInfo.subjectId where student1=? or student2=? or student3=? or student4=? or student5=?";
				ps2=con.prepareStatement(sql2);
				
				ps2.setString(1,si.getStudentId());
				ps2.setString(2,si.getStudentId());
				ps2.setString(3,si.getStudentId());
				ps2.setString(4,si.getStudentId());
				ps2.setString(5,si.getStudentId());
				rs2=ps2.executeQuery();
				List<String> listSubject=new ArrayList<String>();
				List<String> listTeam=new ArrayList<String>();
				while(rs2.next()){
					listSubject.add(rs2.getString("subjectName").trim());
					listTeam.add(rs2.getString("teamName").trim());
				}
				ts.setTsListSubjectName(listSubject);
				ts.setTsListTeamName(listTeam);
				listTemp.add(ts);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(rs2!=null){
					rs2.close();
				}
				if(ps2!=null){
					ps2.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.closeAll();
		}
		
		return listTemp;
	}

	public List<TempStudentInfo> getAllByTeamName() {
		// TODO Auto-generated method stub
		this.openCon();
		List<TempStudentInfo> listTemp=new ArrayList<TempStudentInfo>();
		String sql=" select subjectName,teamName,studentId,studentName,studentInstitute,studentPhone from teamInfo "+
"inner join subjectInfo on subjectInfo.subjectId=teamInfo.subjectId "+
"inner join studentInfo on student1=studentInfo.studentId "+
"union "+
"select subjectName,teamName,studentId,studentName,studentInstitute,studentPhone from teamInfo "+
"inner join subjectInfo on subjectInfo.subjectId=teamInfo.subjectId "+
"inner join studentInfo on student2=studentInfo.studentId "+
"union "+
"select subjectName,teamName,studentId,studentName,studentInstitute,studentPhone from teamInfo "+
" inner join subjectInfo on subjectInfo.subjectId=teamInfo.subjectId "+
"inner join studentInfo on student3=studentInfo.studentId "+
" union "+
"select subjectName,teamName,studentId,studentName,studentInstitute,studentPhone from teamInfo "+
" inner join subjectInfo on subjectInfo.subjectId=teamInfo.subjectId "+
" inner join studentInfo on student4=studentInfo.studentId "+
" union "+
"select subjectName,teamName,studentId,studentName,studentInstitute,studentPhone from teamInfo "+
" inner join subjectInfo on subjectInfo.subjectId=teamInfo.subjectId "+
" inner join studentInfo on student5=studentInfo.studentId "+
" order by subjectName ";
	try {
		ps=con.prepareStatement(sql);
		rs=ps.executeQuery();
		while(rs.next()){
			if(rs.getString("studentId")==null||(rs.getString("studentId").trim()).isEmpty()){
				continue;
			}
			StudentInfo si=new StudentInfo();
			si.setStudentId(rs.getString("studentId").trim());
			si.setStudentName(rs.getString("studentName").trim());
			si.setStudentInstitute(ChangeInstitute.change(rs.getString("studentInstitute")));
			si.setStudentPhone(rs.getString("studentPhone").trim());
			TempStudentInfo ts=new TempStudentInfo();
			ts.setTsStudent(si);
			ts.setTsCount(1);
			List<String> listSubject=new ArrayList<String>();
			List<String> listTeam=new ArrayList<String>();
			listSubject.add(rs.getString("subjectName").trim());
			listTeam.add(rs.getString("teamName").trim());
			ts.setTsListSubjectName(listSubject);
			ts.setTsListTeamName(listTeam);
			listTemp.add(ts);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		this.closeAll();
	}
		return listTemp;
	}

	public List<TempStudentInfo> getAllByStudentId() {
		// TODO Auto-generated method stub
		this.openCon();
		PreparedStatement ps2=null;
		ResultSet rs2=null;
		List<TempStudentInfo> listTemp=new ArrayList<TempStudentInfo>();
		String sql="select studentId,studentName,studentInstitute,studentPhone,(select COUNT(teamId) from teamInfo where student1=studentInfo.studentId or student2=studentInfo.studentId or student3=studentInfo.studentId or student4=studentInfo.studentId or student5=studentInfo.studentId) as 'count' from studentInfo order by studentId desc";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				if(rs.getString("studentId")==null||(rs.getString("studentId").trim()).isEmpty()){
					continue;
				}
				if(rs.getInt("count")==0){
					continue;
				}
				StudentInfo si=new StudentInfo();
				si.setStudentId(rs.getString("studentId").trim());
				si.setStudentName(rs.getString("studentName").trim());
				si.setStudentInstitute(ChangeInstitute.change(rs.getString("studentInstitute")));
				si.setStudentPhone(rs.getString("studentPhone").trim());
				
				TempStudentInfo ts=new TempStudentInfo();
				ts.setTsStudent(si);
				ts.setTsCount(rs.getInt("count"));
				
				String sql2="select subjectName,teamName from teamInfo inner join subjectInfo on teamInfo.subjectId=subjectInfo.subjectId where student1=? or student2=? or student3=? or student4=? or student5=?";
				ps2=con.prepareStatement(sql2);
				
				ps2.setString(1,si.getStudentId());
				ps2.setString(2,si.getStudentId());
				ps2.setString(3,si.getStudentId());
				ps2.setString(4,si.getStudentId());
				ps2.setString(5,si.getStudentId());
				rs2=ps2.executeQuery();
				List<String> listSubject=new ArrayList<String>();
				List<String> listTeam=new ArrayList<String>();
				while(rs2.next()){
					listSubject.add(rs2.getString("subjectName").trim());
					listTeam.add(rs2.getString("teamName").trim());
				}
				ts.setTsListSubjectName(listSubject);
				ts.setTsListTeamName(listTeam);
				listTemp.add(ts);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(rs2!=null){
					rs2.close();
				}
				if(ps2!=null){
					ps2.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.closeAll();
		}
		
		return listTemp;
	}

	public List<TempStudentInfo> getAllByStudentInstitute() {
		// TODO Auto-generated method stub
		this.openCon();
		PreparedStatement ps2=null;
		ResultSet rs2=null;
		List<TempStudentInfo> listTemp=new ArrayList<TempStudentInfo>();
		String sql="select studentId,studentName,studentInstitute,studentPhone,(select COUNT(teamId) from teamInfo where student1=studentInfo.studentId or student2=studentInfo.studentId or student3=studentInfo.studentId or student4=studentInfo.studentId or student5=studentInfo.studentId) as 'count' from studentInfo order by studentInstitute desc";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				if(rs.getString("studentId")==null||(rs.getString("studentId").trim()).isEmpty()){
					continue;
				}
				if(rs.getInt("count")==0){
					continue;
				}
				StudentInfo si=new StudentInfo();
				si.setStudentId(rs.getString("studentId").trim());
				si.setStudentName(rs.getString("studentName").trim());
				si.setStudentInstitute(ChangeInstitute.change(rs.getString("studentInstitute")));
				si.setStudentPhone(rs.getString("studentPhone").trim());
				
				TempStudentInfo ts=new TempStudentInfo();
				ts.setTsStudent(si);
				ts.setTsCount(rs.getInt("count"));
				
				String sql2="select subjectName,teamName from teamInfo inner join subjectInfo on teamInfo.subjectId=subjectInfo.subjectId where student1=? or student2=? or student3=? or student4=? or student5=?";
				ps2=con.prepareStatement(sql2);
				
				ps2.setString(1,si.getStudentId());
				ps2.setString(2,si.getStudentId());
				ps2.setString(3,si.getStudentId());
				ps2.setString(4,si.getStudentId());
				ps2.setString(5,si.getStudentId());
				rs2=ps2.executeQuery();
				List<String> listSubject=new ArrayList<String>();
				List<String> listTeam=new ArrayList<String>();
				while(rs2.next()){
					listSubject.add(rs2.getString("subjectName").trim());
					listTeam.add(rs2.getString("teamName").trim());
				}
				ts.setTsListSubjectName(listSubject);
				ts.setTsListTeamName(listTeam);
				listTemp.add(ts);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(rs2!=null){
					rs2.close();
				}
				if(ps2!=null){
					ps2.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.closeAll();
		}
		
		return listTemp;
	}

}
