package com.lee1314.raylee.modules.lovetree.model;

import java.util.Date;

/**
 * 爱情书entity
 * 
 * @author 雷力
 * @date 2019年1月17日 下午4:03:54
 */
public class LoveTree {
	/**
	 * 主键
	 */
	private Long id;

	/**
	 * 链接
	 */
	private String url;

	/**
	 * 第一个名字
	 */
	private String firstname;

	/**
	 * 第二个名字
	 */
	private String secondname;

	/**
	 * 相遇时间
	 */
	private Date meettime;

	/**
	 * 文件名
	 */
	private String fileName;

	/**
	 * 状态
	 */
	private Integer status;

	/**
	 * 内容
	 */
	private String content;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname == null ? null : firstname.trim();
	}

	public String getSecondname() {
		return secondname;
	}

	public void setSecondname(String secondname) {
		this.secondname = secondname == null ? null : secondname.trim();
	}

	public Date getMeettime() {
		return meettime;
	}

	public void setMeettime(Date meettime) {
		this.meettime = meettime;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName == null ? null : fileName.trim();
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}
}