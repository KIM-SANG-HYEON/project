package com.topia.practice.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoTraining {
	private Integer trainingIdx;
	private Integer userIdx;
	private String trainingName;
	private Date trainingStartdate;
	private Date trainingEnddate;
	private String trainingAgency;
	public Integer getTrainingIdx() {
		return trainingIdx;
	}
	public void setTrainingIdx(Integer trainingIdx) {
		this.trainingIdx = trainingIdx;
	}
	public Integer getUserIdx() {
		return userIdx;
	}
	public void setUserIdx(Integer userIdx) {
		this.userIdx = userIdx;
	}
	public String getTrainingName() {
		return trainingName;
	}
	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}
	public Date getTrainingStartdate() {
		return trainingStartdate;
	}
	public void setTrainingStartdate(Date trainingStartdate) {
		this.trainingStartdate = trainingStartdate;
	}
	public Date getTrainingEnddate() {
		return trainingEnddate;
	}
	public void setTrainingEnddate(Date trainingEnddate) {
		this.trainingEnddate = trainingEnddate;
	}
	public String getTrainingAgency() {
		return trainingAgency;
	}
	public void setTrainingAgency(String trainingAgency) {
		this.trainingAgency = trainingAgency;
	}
	
	
}
