package com.mycompany.sort.test;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 
 * 项目版本及项目  的关联VO
 * @author 
 *
 */
public class RelationProjVersVO implements Serializable {
	
	private static final long serialVersionUID = 8992980588576019686L;

	//项目版本id
	private Integer projectVersionId;
	
	 //版本字符串(如V1.0, V2.0等)
    private String  projectVersion;

    //立项单号
    private String  projectVersionNo;
    
    //项目id
    private Integer projectId;
    
    //项目名称
    private String projectName;
    
    //项目code
    private String projectCode;
    
    //产品线id
    private Integer productId;

	public Integer getProjectVersionId() {
		return projectVersionId;
	}

	public void setProjectVersionId(Integer projectVersionId) {
		this.projectVersionId = projectVersionId;
	}

	public String getProjectVersion() {
		return projectVersion;
	}

	public void setProjectVersion(String projectVersion) {
		this.projectVersion = projectVersion;
	}

	public String getProjectVersionNo() {
		return projectVersionNo;
	}

	public void setProjectVersionNo(String projectVersionNo) {
		this.projectVersionNo = projectVersionNo;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
    
    public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String toString(){
    	return ToStringBuilder.reflectionToString(this);
    }
    
}
