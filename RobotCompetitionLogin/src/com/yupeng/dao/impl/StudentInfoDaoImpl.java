package com.yupeng.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yupeng.dao.StudentInfoDao;
import com.yupeng.entity.StudentInfo;


public class StudentInfoDaoImpl extends BaseDaoImpl implements StudentInfoDao {

	public List<String> getStudentId(){
		// TODO Auto-generated method stub
		List<String> list=new ArrayList<String>();
		this.openCon();
		String sql="select studentId from studentInfo";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				String studentId=rs.getString("studentId");
				list.add(studentId);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		
		return list;
	
	}
	
	public int havaStudentId(String studentId){
		
		this.openCon();
		int havaStudentId=0;
		String sql="select COUNT(studentId) as 'havaStudentId' from studentInfo where studentId=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, studentId);
			rs=ps.executeQuery();
			while(rs.next()){
				
				havaStudentId=rs.getInt("havaStudentId");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return havaStudentId;
	}
	
	public int add(StudentInfo studentInfo){
		this.openCon();
		String sql="insert into studentInfo(studentId,studentName,studentInstitute,studentPhone,studentEmail,remark) values(?,?,?,?,?,'')";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, studentInfo.getStudentId());
			ps.setString(2, studentInfo.getStudentName());
			ps.setString(3, studentInfo.getStudentInstitute());
			ps.setString(4, studentInfo.getStudentPhone());
			ps.setString(5, studentInfo.getStudentEmail());
			num=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		
		return num;
	}
	
	public int update(StudentInfo studentInfo){
		
		this.openCon();
		String sql="update studentInfo set studentName=? ,studentInstitute=?,studentPhone=?,studentEmail=? where studentId=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1,studentInfo.getStudentName());
			ps.setString(2, studentInfo.getStudentInstitute());
			ps.setString(3, studentInfo.getStudentPhone());
			ps.setString(4,studentInfo.getStudentEmail());
			ps.setString(5,studentInfo.getStudentId());
			num=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		
		return num;
	}
	
	public int delete(String studentId){
		
		this.openCon();
		try {
			String sql="delete from studentInfo where studentId=?";
			ps=con.prepareStatement(sql);
			ps.setString(1,studentId);
			num=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return num;
	}

}
