package com.topia.practice.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoSkill {
	private Integer skillIdx;
	private Integer userIdx;
	private String skillProjectName;
	private Date skillStartdate;
	private Date skillEnddate;
	private String skillCustomerComp;
	private String skillWorkComp;
	private String skillApplied;
	private String skillIndustry;
	private String skillRole;
	private String skillModel;
	private String skillOs;
	private String skillLang;
	private String skillDbms;
	private String skillComm;
	private String skillTool;
	private String skillEtc;
	public Integer getSkillIdx() {
		return skillIdx;
	}
	public void setSkillIdx(Integer skillIdx) {
		this.skillIdx = skillIdx;
	}
	public Integer getUserIdx() {
		return userIdx;
	}
	public void setUserIdx(Integer userIdx) {
		this.userIdx = userIdx;
	}
	public String getSkillProjectName() {
		return skillProjectName;
	}
	public void setSkillProjectName(String skillProjectName) {
		this.skillProjectName = skillProjectName;
	}
	public Date getSkillStartdate() {
		return skillStartdate;
	}
	public void setSkillStartdate(Date skillStartdate) {
		this.skillStartdate = skillStartdate;
	}
	public Date getSkillEnddate() {
		return skillEnddate;
	}
	public void setSkillEnddate(Date skillEnddate) {
		this.skillEnddate = skillEnddate;
	}
	public String getSkillCustomerComp() {
		return skillCustomerComp;
	}
	public void setSkillCustomerComp(String skillCustomerComp) {
		this.skillCustomerComp = skillCustomerComp;
	}
	public String getSkillWorkComp() {
		return skillWorkComp;
	}
	public void setSkillWorkComp(String skillWorkComp) {
		this.skillWorkComp = skillWorkComp;
	}
	public String getSkillApplied() {
		return skillApplied;
	}
	public void setSkillApplied(String skillApplied) {
		this.skillApplied = skillApplied;
	}
	public String getSkillIndustry() {
		return skillIndustry;
	}
	public void setSkillIndustry(String skillIndustry) {
		this.skillIndustry = skillIndustry;
	}
	public String getSkillRole() {
		return skillRole;
	}
	public void setSkillRole(String skillRole) {
		this.skillRole = skillRole;
	}
	public String getSkillModel() {
		return skillModel;
	}
	public void setSkillModel(String skillModel) {
		this.skillModel = skillModel;
	}
	public String getSkillOs() {
		return skillOs;
	}
	public void setSkillOs(String skillOs) {
		this.skillOs = skillOs;
	}
	public String getSkillLang() {
		return skillLang;
	}
	public void setSkillLang(String skillLang) {
		this.skillLang = skillLang;
	}
	public String getSkillDbms() {
		return skillDbms;
	}
	public void setSkillDbms(String skillDbms) {
		this.skillDbms = skillDbms;
	}
	public String getSkillComm() {
		return skillComm;
	}
	public void setSkillComm(String skillComm) {
		this.skillComm = skillComm;
	}
	public String getSkillTool() {
		return skillTool;
	}
	public void setSkillTool(String skillTool) {
		this.skillTool = skillTool;
	}
	public String getSkillEtc() {
		return skillEtc;
	}
	public void setSkillEtc(String skillEtc) {
		this.skillEtc = skillEtc;
	}
	
	
}
