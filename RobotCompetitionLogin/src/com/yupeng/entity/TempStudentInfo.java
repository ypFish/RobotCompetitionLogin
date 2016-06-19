package com.yupeng.entity;

import java.util.List;

public class TempStudentInfo {

	private StudentInfo tsStudent;
	private int tsCount;
	private List<String> tsListSubjectName;
	private List<String> tsListTeamName;
	
	public TempStudentInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TempStudentInfo(StudentInfo tsStudent, int tsCount,
			List<String> tsListSubjectName, List<String> tsListTeamName) {
		super();
		this.tsStudent = tsStudent;
		this.tsCount = tsCount;
		this.tsListSubjectName = tsListSubjectName;
		this.tsListTeamName = tsListTeamName;
	}
	/**
	 * @return the tsStudent
	 */
	public StudentInfo getTsStudent() {
		return tsStudent;
	}
	/**
	 * @param tsStudent the tsStudent to set
	 */
	public void setTsStudent(StudentInfo tsStudent) {
		this.tsStudent = tsStudent;
	}
	/**
	 * @return the tsCount
	 */
	public int getTsCount() {
		return tsCount;
	}
	/**
	 * @param tsCount the tsCount to set
	 */
	public void setTsCount(int tsCount) {
		this.tsCount = tsCount;
	}
	/**
	 * @return the tsListSubjectName
	 */
	public List<String> getTsListSubjectName() {
		return tsListSubjectName;
	}
	/**
	 * @param tsListSubjectName the tsListSubjectName to set
	 */
	public void setTsListSubjectName(List<String> tsListSubjectName) {
		this.tsListSubjectName = tsListSubjectName;
	}
	/**
	 * @return the tsListTeamName
	 */
	public List<String> getTsListTeamName() {
		return tsListTeamName;
	}
	/**
	 * @param tsListTeamName the tsListTeamName to set
	 */
	public void setTsListTeamName(List<String> tsListTeamName) {
		this.tsListTeamName = tsListTeamName;
	}
	
}
