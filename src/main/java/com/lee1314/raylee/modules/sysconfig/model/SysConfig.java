package com.lee1314.raylee.modules.sysconfig.model;

import java.util.Date;

/**
 * 系统配置
 * 
 * @title SysConfig
 * @author 雷力
 * @date 2019年4月29日上午10:56:22
 *
 */
public class SysConfig {
	/**
	 * 业务功能代码
	 */
	private String code;
	/**
	 * 业务功能对应值
	 */
	private String content;

	/**
	 * 业务功能代码描述
	 */
	private String description;

	/**
	 * 创建日期
	 */
	private Date createDate;

	/**
	 * 修改日期
	 */
	private Date modifyData;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code == null ? null : code.trim();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyData() {
		return modifyData;
	}

	public void setModifyData(Date modifyData) {
		this.modifyData = modifyData;
	}
}