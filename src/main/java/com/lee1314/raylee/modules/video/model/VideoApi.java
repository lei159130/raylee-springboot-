package com.lee1314.raylee.modules.video.model;

/**
 * 视频entity
 * 
 * @author 雷力
 * @date 2019年1月17日 下午4:03:24
 */
public class VideoApi {
	/**
	 * 主键
	 */
	private Long id;

	/**
	 * 接口
	 */
	private String url;

	/**
	 * 热度
	 */
	private Long heats;

	/**
	 * 连通率
	 */
	private Long connects;

	/**
	 * 状态
	 */
	private Integer status;

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

	public Long getHeats() {
		return heats;
	}

	public void setHeats(Long heats) {
		this.heats = heats;
	}

	public Long getConnects() {
		return connects;
	}

	public void setConnects(Long connects) {
		this.connects = connects;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}