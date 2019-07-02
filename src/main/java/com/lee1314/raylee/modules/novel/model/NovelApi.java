package com.lee1314.raylee.modules.novel.model;

public class NovelApi {
	private Long id;

	private String url;

	private String host;

	private Long connects;

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

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host == null ? null : host.trim();
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