package com.lee1314.raylee.modules.audio.model;

/**
 * 人民日报Type entity
 * 
 * @Title: PeopleType
 * @Description:
 * @author: 雷力
 * @date: 2019年1月24日 下午4:28:04
 *
 */
public class PeopleType {
	/**
	 * 主键
	 */
	private Integer id;

	/**
	 * 编码
	 */
	private String code;

	/**
	 * 名称
	 */
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code == null ? null : code.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}
}