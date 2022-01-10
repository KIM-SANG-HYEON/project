package com.topia.practice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoHealth {

	private Integer healthIdx;
	private Integer userIdx;
	private String userBloodtype;
	private String userHeight;
	private String userEyesightLeft;
	private String userEyesightRight;
	private String userWeight;
	private String userHobby;
	private String userSpeciality;
	public Integer getHealthIdx() {
		return healthIdx;
	}
	public void setHealthIdx(Integer healthIdx) {
		this.healthIdx = healthIdx;
	}
	public Integer getUserIdx() {
		return userIdx;
	}
	public void setUserIdx(Integer userIdx) {
		this.userIdx = userIdx;
	}
	public String getUserBloodtype() {
		return userBloodtype;
	}
	public void setUserBloodtype(String userBloodtype) {
		this.userBloodtype = userBloodtype;
	}
	public String getUserHeight() {
		return userHeight;
	}
	public void setUserHeight(String userHeight) {
		this.userHeight = userHeight;
	}
	public String getUserEyesightLeft() {
		return userEyesightLeft;
	}
	public void setUserEyesightLeft(String userEyesightLeft) {
		this.userEyesightLeft = userEyesightLeft;
	}
	public String getUserEyesightRight() {
		return userEyesightRight;
	}
	public void setUserEyesightRight(String userEyesightRight) {
		this.userEyesightRight = userEyesightRight;
	}
	public String getUserWeight() {
		return userWeight;
	}
	public void setUserWeight(String userWeight) {
		this.userWeight = userWeight;
	}
	public String getUserHobby() {
		return userHobby;
	}
	public void setUserHobby(String userHobby) {
		this.userHobby = userHobby;
	}
	public String getUserSpeciality() {
		return userSpeciality;
	}
	public void setUserSpeciality(String userSpeciality) {
		this.userSpeciality = userSpeciality;
	}
	
	
	
}
