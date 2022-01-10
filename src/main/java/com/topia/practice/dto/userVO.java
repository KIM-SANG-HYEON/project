package com.topia.practice.dto;

public class userVO {
	int rnum;
	String userIdx;
	String userName;
	String userComp;
	String userDept;
	String userregisterdate;
	String userSex;
	String careerDate;
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public String getUserIdx() {
		return userIdx;
	}
	public void setUserIdx(String userIdx) {
		this.userIdx = userIdx;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserComp() {
		return userComp;
	}
	public void setUserComp(String userComp) {
		this.userComp = userComp;
	}
	public String getUserDept() {
		return userDept;
	}
	public void setUserDept(String userDept) {
		this.userDept = userDept;
	}
	public String getUserregisterdate() {
		return userregisterdate;
	}
	public void setUserregisterdate(String userregisterdate) {
		this.userregisterdate = userregisterdate;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public String getCareerDate() {
		return careerDate;
	}
	public void setCareerDate(String careerDate) {
		this.careerDate = careerDate;
	}
	
	@Override
	public String toString() {
		return "userVO [rnum=" + rnum + ", userIdx=" + userIdx + ", userName=" + userName + ", userComp=" + userComp
				+ ", userDept=" + userDept + ", userregisterdate=" + userregisterdate + ", userSex=" + userSex
				+ ", careerDate=" + careerDate + "]";
	}
	
	
	
}
