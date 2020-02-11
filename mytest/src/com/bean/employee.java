package com.bean;

import java.util.Date;

public class employee {

	
private String name,address,birthdate2;
private Byte gender,skill_id;
private Date birthdate;
private Double salary;	
private int employeeId;

private int skillId;
private String skillname;
private boolean selected;

private String languages;
private int skilllanguage;


private int EmployeeSkillid;
private int Skillemployeeid;

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public Byte getGender() {
	return gender;
}
public void setGender(Byte gender) {
	this.gender = gender;
}
public Byte getSkill_id() {
	return skill_id;
}
public void setSkill_id(Byte skill_id) {
	this.skill_id = skill_id;
}
public Date getBirthdate() {
	return birthdate;
}
public void setBirthdate(Date birthdate) {
	this.birthdate = birthdate;
}
public Double getSalary() {
	return salary;
}
public void setSalary(Double salary) {
	this.salary = salary;
}
public void setBirthdate2(String birthdate2) {
	// TODO Auto-generated method stub
	this.birthdate2=birthdate2;
}
public String getBirthdate2() {
	return birthdate2;
}
public int getEmployeeId() {
	return employeeId;
}
public void setEmployeeId(int employeeId) {
	this.employeeId = employeeId;
}
public String getSkillname() {
	return skillname;
}
public void setSkillname(String skillname) {
	this.skillname = skillname;
}
public boolean isSelected() {
	return selected;
}
public void setSelected(boolean selected) {
	this.selected = selected;
}
public int getSkillId() {
	return skillId;
}
public void setSkillId(int skillId) {
	this.skillId = skillId;
}
public int getSkilllanguage() {
	return skilllanguage;
}
public void setSkilllanguage(int skilllanguage) {
	this.skilllanguage = skilllanguage;
}


public int getEmployeeSkillid() {
	return EmployeeSkillid;
}
public void setEmployeeSkillid(int employeeSkillid) {
	EmployeeSkillid = employeeSkillid;
}
public int getSkillemployeeid() {
	return Skillemployeeid;
}
public void setSkillemployeeid(int skillemployeeid) {
	Skillemployeeid = skillemployeeid;
}

}
