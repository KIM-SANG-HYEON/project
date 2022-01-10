package com.topia.practice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoLicen {
	private Integer licenIdx;
	private Integer UserIdx;
	private String licenName;
	private String licenSkillLevel;
	public Integer getLicenIdx() {
		return licenIdx;
	}
	public void setLicenIdx(Integer licenIdx) {
		this.licenIdx = licenIdx;
	}
	public Integer getUserIdx() {
		return UserIdx;
	}
	public void setUserIdx(Integer userIdx) {
		UserIdx = userIdx;
	}
	public String getLicenName() {
		return licenName;
	}
	public void setLicenName(String licenName) {
		this.licenName = licenName;
	}
	public String getLicenSkillLevel() {
		return licenSkillLevel;
	}
	public void setLicenSkillLevel(String licenSkillLevel) {
		this.licenSkillLevel = licenSkillLevel;
	}
	
	
}
