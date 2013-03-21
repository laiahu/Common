package com.mycompany.common.test;

public class TestVO {

	//立项编号
	private String projectVersionNo;  
	
	//css 小版本号
	private String  smallVersion;  
	
	//Hd_Sn 硬件序列号
	private String  hardwareSn;
	
	//CSS_ID 问题id
	private String  cssProblemId;
	
	//FAQ_Nm  问题名称
	private String  problemName;
	
	//FAQ_Desc  问题描述
	private String  problemDesc;
	
	//FAQ_Env 问题运行环境
	private String  problemEnv;
	
	//Cstm  客户名称
	private String  customer;
	
	//Cmt_Usr 反馈/提交人
	private String  commitUser;
	
	//FAQ_Lvl  问题级别   very:非常高 , high:高, model:中, low:低
	private String  problemLevel;

	//Add_Tm  反馈/添加时间
	private String  addTimeStr; 
	
	//Dmd_Rspd_Tm  要求响应时间
	private String  demandRespondTimeStr;
	
	//Expt_Rpr_Tm  期望修复时间
	private String  expectRepairTimeStr; 

	//Prjt_Mgr  项目经理 (英文)
	private String  projectMgr;
	
	//Tech_Mgr  技术经理(英文)
	private String  techniqueMgr;
	
	//Tst_Usr   测试负责人(英文)
	private String  testResponsiUser;
	
	//Upd_Fl   附件
	private String  uploadFileUrl;

	public String getProjectVersionNo() {
		return projectVersionNo;
	}

	public void setProjectVersionNo(String projectVersionNo) {
		this.projectVersionNo = projectVersionNo;
	}

	public String getSmallVersion() {
		return smallVersion;
	}

	public void setSmallVersion(String smallVersion) {
		this.smallVersion = smallVersion;
	}

	public String getHardwareSn() {
		return hardwareSn;
	}

	public void setHardwareSn(String hardwareSn) {
		this.hardwareSn = hardwareSn;
	}

	public String getCssProblemId() {
		return cssProblemId;
	}

	public void setCssProblemId(String cssProblemId) {
		this.cssProblemId = cssProblemId;
	}

	public String getProblemName() {
		return problemName;
	}

	public void setProblemName(String problemName) {
		this.problemName = problemName;
	}

	public String getProblemDesc() {
		return problemDesc;
	}

	public void setProblemDesc(String problemDesc) {
		this.problemDesc = problemDesc;
	}

	public String getProblemEnv() {
		return problemEnv;
	}

	public void setProblemEnv(String problemEnv) {
		this.problemEnv = problemEnv;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getCommitUser() {
		return commitUser;
	}

	public void setCommitUser(String commitUser) {
		this.commitUser = commitUser;
	}

	public String getProblemLevel() {
		return problemLevel;
	}

	public void setProblemLevel(String problemLevel) {
		this.problemLevel = problemLevel;
	}

	public String getAddTimeStr() {
		return addTimeStr;
	}

	public void setAddTimeStr(String addTimeStr) {
		this.addTimeStr = addTimeStr;
	}

	public String getDemandRespondTimeStr() {
		return demandRespondTimeStr;
	}

	public void setDemandRespondTimeStr(String demandRespondTimeStr) {
		this.demandRespondTimeStr = demandRespondTimeStr;
	}

	public String getExpectRepairTimeStr() {
		return expectRepairTimeStr;
	}

	public void setExpectRepairTimeStr(String expectRepairTimeStr) {
		this.expectRepairTimeStr = expectRepairTimeStr;
	}

	public String getProjectMgr() {
		return projectMgr;
	}

	public void setProjectMgr(String projectMgr) {
		this.projectMgr = projectMgr;
	}

	public String getTechniqueMgr() {
		return techniqueMgr;
	}

	public void setTechniqueMgr(String techniqueMgr) {
		this.techniqueMgr = techniqueMgr;
	}

	public String getTestResponsiUser() {
		return testResponsiUser;
	}

	public void setTestResponsiUser(String testResponsiUser) {
		this.testResponsiUser = testResponsiUser;
	}

	public String getUploadFileUrl() {
		return uploadFileUrl;
	}

	public void setUploadFileUrl(String uploadFileUrl) {
		this.uploadFileUrl = uploadFileUrl;
	}
	
	
	
}
