package com.yupeng.entity;

public class TeamInfo {

private int teamId ;
public TeamInfo() {
	super();
	// TODO Auto-generated constructor stub
}
public TeamInfo(int teamId, String teamName, String teamPassword,
		int subjectId, String teacherName, String student1, String student2,
		String student3, String student4, String student5, String remark) {
	super();
	this.teamId = teamId;
	this.teamName = teamName;
	this.teamPassword = teamPassword;
	this.subjectId = subjectId;
	this.teacherName = teacherName;
	this.student1 = student1;
	this.student2 = student2;
	this.student3 = student3;
	this.student4 = student4;
	this.student5 = student5;
	this.remark = remark;
}
public TeamInfo(String teamName, String teamPassword, int subjectId,
		String teacherName, String student1, String student2, String student3,
		String student4, String student5, String remark) {
	super();
	this.teamName = teamName;
	this.teamPassword = teamPassword;
	this.subjectId = subjectId;
	this.teacherName = teacherName;
	this.student1 = student1;
	this.student2 = student2;
	this.student3 = student3;
	this.student4 = student4;
	this.student5 = student5;
	this.remark = remark;
}

/**
 * @return the teamId
 */
public int getTeamId() {
	return teamId;
}
/**
 * @param teamId the teamId to set
 */
public void setTeamId(int teamId) {
	this.teamId = teamId;
}
/**
 * @return the teamName
 */
public String getTeamName() {
	return teamName;
}
/**
 * @param teamName the teamName to set
 */
public void setTeamName(String teamName) {
	this.teamName = teamName;
}
/**
 * @return the teamPassword
 */
public String getTeamPassword() {
	return teamPassword;
}
/**
 * @param teamPassword the teamPassword to set
 */
public void setTeamPassword(String teamPassword) {
	this.teamPassword = teamPassword;
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
/**
 * @return the teacherName
 */
public String getTeacherName() {
	return teacherName;
}
/**
 * @param teacherName the teacherName to set
 */
public void setTeacherName(String teacherName) {
	this.teacherName = teacherName;
}
/**
 * @return the student1
 */
public String getStudent1() {
	return student1;
}
/**
 * @param student1 the student1 to set
 */
public void setStudent1(String student1) {
	this.student1 = student1;
}
/**
 * @return the student2
 */
public String getStudent2() {
	return student2;
}
/**
 * @param student2 the student2 to set
 */
public void setStudent2(String student2) {
	this.student2 = student2;
}
/**
 * @return the student3
 */
public String getStudent3() {
	return student3;
}
/**
 * @param student3 the student3 to set
 */
public void setStudent3(String student3) {
	this.student3 = student3;
}
/**
 * @return the student4
 */
public String getStudent4() {
	return student4;
}
/**
 * @param student4 the student4 to set
 */
public void setStudent4(String student4) {
	this.student4 = student4;
}
/**
 * @return the student5
 */
public String getStudent5() {
	return student5;
}
/**
 * @param student5 the student5 to set
 */
public void setStudent5(String student5) {
	this.student5 = student5;
}
/**
 * @return the remark
 */
public String getRemark() {
	return remark;
}
/**
 * @param remark the remark to set
 */
public void setRemark(String remark) {
	this.remark = remark;
}
private String teamName ;
private String teamPassword ;
private int	subjectId ;
private String teacherName ;
private String student1 ;
private String student2 ;
private String student3 ;
private String student4 ;
private String student5;
private String remark;

}
