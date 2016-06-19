package com.yupeng.dao.impl;

import java.sql.SQLException;

import com.yupeng.dao.ResultInfoDao;
import com.yupeng.entity.ResultInfo;

public class ResultInfoDaoImpl extends BaseDaoImpl implements ResultInfoDao {

	public int add(ResultInfo ri) {
		// TODO Auto-generated method stub
		this.openCon();
		String sql="insert into resultInfo values(?,?,'')";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1,ri.getTeamId());
			ps.setString(2, ri.getResultName().trim());
			num=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		
		
		return num;
	}

	public String getResultName(int teamId) {
		// TODO Auto-generated method stub
		this.openCon();
		String sql="select rewardName from resultInfo where resultInfo.teamId=?";
		String resultName="";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, teamId);
			rs=ps.executeQuery();
			while(rs.next()){
				resultName=rs.getNString("rewardName").trim();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		
		return resultName;
	}

	public int update(ResultInfo ri) {
		// TODO Auto-generated method stub
		this.openCon();
		String sql="update resultInfo set rewardName=? where resultInfo.teamId=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1,ri.getResultName().trim());
			ps.setInt(2, ri.getTeamId());
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
