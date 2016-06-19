package com.yupeng.entity;

public class MiniSubjectInfo {

	private String subjectName;
	private int subjectId;
	public MiniSubjectInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MiniSubjectInfo(String subjectName, int subjectId) {
		super();
		this.subjectName = subjectName;
		this.subjectId = subjectId;
	}
	/**
	 * @return the subjectName
	 */
	public String getSubjectName() {
		return subjectName;
	}
	/**
	 * @param subjectName the subjectName to set
	 */
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	/**
	 * @return the subjectId
	 */
	public int getSubjectId() {
		return subjectId;
	}
	/**
	 * @param subjectId the subjectId to set
	 */
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
}
