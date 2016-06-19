package com.yupeng.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yupeng.dao.SubjectInfoDao;
import com.yupeng.entity.SubjectInfo;

public class SubjectInfoDaoImpl extends BaseDaoImpl implements SubjectInfoDao {

	public int addAll(SubjectInfo subjectInfo) {
		// TODO Auto-generated method stub
		this.openCon();
		String sql="insert into subjectInfo values(?,?,?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1,subjectInfo.getSubjectName());
			ps.setInt(2,subjectInfo.getPeopleNumber());
			ps.setString(3,subjectInfo.getSubjectInformation());
			ps.setString(4,subjectInfo.getRemark());
			num=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		
		return num;
	}
	
	public List<SubjectInfo> getAll(){
		
		List<SubjectInfo> list=new ArrayList<SubjectInfo>();
		this.openCon();
		String sql="select subjectId,subjectName,peopleNumber,subjectInformation,remark from subjectInfo";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				SubjectInfo si=new SubjectInfo();
				si.setSubjectId(rs.getInt("subjectId"));
				si.setSubjectName(rs.getString("subjectName"));
				si.setPeopleNumber(rs.getInt("peopleNumber"));
				si.setSubjectInformation(rs.getString("subjectInformation"));
				si.setRemark(rs.getString("remark"));
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
	
	public int deleteById(int subjectId){
		
		this.openCon();
		try {
			String sql="delete from subjectInfo where subjectId=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, subjectId);
			num=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return num;
	}
	
	public int updateById(SubjectInfo si){
		
		this.openCon();
		String sql="update subjectInfo set subjectName=?,peopleNumber=?,subjectInformation=? where subjectId=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1,si.getSubjectName());
			ps.setInt(2, si.getPeopleNumber());
			ps.setString(3, si.getSubjectInformation());
			ps.setInt(4, si.getSubjectId());
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
