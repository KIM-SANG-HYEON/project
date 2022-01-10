package com.topia.practice.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoQualifi {
	private Integer qualifiIdx;
	private Integer userIdx;
	private String qualifiName;
	private Date qualifiGetdate;
	public Integer getQualifiIdx() {
		return qualifiIdx;
	}
	public void setQualifiIdx(Integer qualifiIdx) {
		this.qualifiIdx = qualifiIdx;
	}
	public Integer getUserIdx() {
		return userIdx;
	}
	public void setUserIdx(Integer userIdx) {
		this.userIdx = userIdx;
	}
	public String getQualifiName() {
		return qualifiName;
	}
	public void setQualifiName(String qualifiName) {
		this.qualifiName = qualifiName;
	}
	public Date getQualifiGetdate() {
		return qualifiGetdate;
	}
	public void setQualifiGetdate(Date qualifiGetdate) {
		this.qualifiGetdate = qualifiGetdate;
	}
	
	
}
