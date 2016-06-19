package com.yupeng.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yupeng.dao.TempTeamResultDao;
import com.yupeng.entity.StudentInfo;
import com.yupeng.entity.TempTeamResult;

public class TempTeamResultDaoImpl extends BaseDaoImpl implements
		TempTeamResultDao {

	public List<TempTeamResult> getAllTempTeamResult() {
		// TODO Auto-generated method stub
		this.openCon();
		List<TempTeamResult> list=new ArrayList<TempTeamResult>();
		String sql="select subjectName,teamInfo.subjectId,teamInfo.teamId,teamName,student1,student1Name=(select studentName from studentInfo where studentId=student1),"
+" student2, student2Name=(select studentName from studentInfo where studentId=student2),"
+" student3, student3Name=(select studentName from studentInfo where studentId=student3),"
+" student4, student4Name=(select studentName from studentInfo where studentId=student4),"
+" student5, student5Name=(select studentName from studentInfo where studentId=student5),"
+" rewardName from teamInfo "
+" left join subjectInfo on subjectInfo.subjectId=teamInfo.subjectId "
+" left join resultInfo on resultInfo.teamId=teamInfo.teamId "
+" order by subjectName";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				TempTeamResult ttr=new TempTeamResult();
				ttr.setTtSubjectName(rs.getString("subjectName").trim());
				ttr.setTtSubjectId(rs.getInt("subjectId"));
				ttr.setTtTeamId(rs.getInt("teamId"));
				ttr.setTtTeamName(rs.getString("teamName").trim());
				if(rs.getString("rewardName")==null||rs.getString("rewardName").trim().isEmpty()){
					ttr.setRewardName("нч");
				}else{
					ttr.setRewardName(rs.getString("rewardName").trim());
				}
				List<StudentInfo> listStudentInfo =new ArrayList<StudentInfo>();
				if(rs.getString("Student1")!=null&&!(rs.getString("Student1").trim()).isEmpty()){
					StudentInfo si=new StudentInfo();
					si.setStudentId(rs.getString("Student1").trim());
					si.setStudentName(rs.getString("student1Name").trim());
					listStudentInfo.add(si);
				}
				if(rs.getString("Student2")!=null&&!(rs.getString("Student2").trim()).isEmpty()){
					StudentInfo si=new StudentInfo();
					si.setStudentId(rs.getString("Student2").trim());
					si.setStudentName(rs.getString("student2Name").trim());
					listStudentInfo.add(si);
				}
				if(rs.getString("Student3")!=null&&!(rs.getString("Student3").trim()).isEmpty()){
					StudentInfo si=new StudentInfo();
					si.setStudentId(rs.getString("Student3").trim());
					si.setStudentName(rs.getString("student3Name").trim());
					listStudentInfo.add(si);
				}
				if(rs.getString("Student4")!=null&&!(rs.getString("Student4").trim()).isEmpty()){
					StudentInfo si=new StudentInfo();
					si.setStudentId(rs.getString("Student4").trim());
					si.setStudentName(rs.getString("student4Name").trim());
					listStudentInfo.add(si);
				}
				if(rs.getString("Student5")!=null&&!(rs.getString("Student5").trim()).isEmpty()){
					StudentInfo si=new StudentInfo();
					si.setStudentId(rs.getString("Student5").trim());
					si.setStudentName(rs.getString("student5Name").trim());
					listStudentInfo.add(si);
				}
				ttr.setTtListStudentInfo(listStudentInfo);
				list.add(ttr);
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
