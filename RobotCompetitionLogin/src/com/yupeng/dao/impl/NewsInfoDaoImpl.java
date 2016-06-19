package com.yupeng.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yupeng.dao.NewsInfoDao;
import com.yupeng.entity.NewsInfo;

public class NewsInfoDaoImpl extends BaseDaoImpl implements NewsInfoDao {

	public int addAll(NewsInfo newsInfo) {
		// TODO Auto-generated method stub
		this.openCon();
		String sql="insert into newsInfo(newsName,newsContent,newsDate,remark) values(?,?,convert(varchar(10),getdate(),120),?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, newsInfo.getNewsName());
			ps.setString(2, newsInfo.getNewsContent());
			ps.setString(3, newsInfo.getRemark());
			num=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		
		
		return num;
	}
	
	public List<NewsInfo> getAll(){
		
		List<NewsInfo> list=new ArrayList<NewsInfo>();
		this.openCon();
		String sql="select newsId,newsName,newsContent,newsDate,remark from newsInfo";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				NewsInfo ni=new NewsInfo();
				ni.setNewsId(rs.getInt("newsId"));
				ni.setNewsName(rs.getString("newsName"));
				ni.setNewsContent(rs.getString("newsContent"));
				ni.setDatetime(rs.getString("newsDate"));
				ni.setRemark(rs.getString("remark"));
				list.add(ni);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		
		
		
		return list;
	}
	
	public int deleteById(int NewsId){
		
		this.openCon();
		try {
			String sql="delete from newsInfo where newsId=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, NewsId);
			num=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		
		
		
		return num;
	}
	
	public int updateById(NewsInfo ni){
		
		this.openCon();
		String sql="update newsInfo set newsName=?,newsContent=?,newsDate=convert(varchar(10),getdate(),120) where newsId=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, ni.getNewsName());
			ps.setString(2, ni.getNewsContent());
			ps.setInt(3, ni.getNewsId());
			num=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return num;
	}
	
	public List<NewsInfo> getAllNews(){
		
		List<NewsInfo> list=new ArrayList<NewsInfo>();
		this.openCon();
		String sql="select top 15 newsId,newsName,newsContent,convert(varchar(10),newsDate,120) as 'newsDate',remark from newsInfo order by newsDate";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				NewsInfo ni=new NewsInfo();
				ni.setNewsId(rs.getInt("newsId"));
				ni.setNewsName(rs.getString("newsName"));
				ni.setNewsContent(rs.getString("newsContent"));
				ni.setDatetime(rs.getString("newsDate"));
				ni.setRemark(rs.getString("remark"));
				list.add(ni);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return list;
		
	}
	
	public NewsInfo getNewsById(int newsId){
		
		this.openCon();
		NewsInfo ni=new NewsInfo();
		String sql="select  newsId,newsName,newsContent,convert(varchar(10),newsDate,120) as 'newsDate',remark from newsInfo where newsId=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1,newsId);
			rs=ps.executeQuery();
			while(rs.next()){
				
				ni.setNewsId(rs.getInt("newsId"));
				ni.setNewsName(rs.getString("newsName"));
				ni.setNewsContent(rs.getString("newsContent"));
				ni.setDatetime(rs.getString("newsDate"));
				ni.setRemark(rs.getString("remark"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return ni;
	}

}
