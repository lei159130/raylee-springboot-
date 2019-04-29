package com.lee1314.raylee.modules.audio.model;

import java.util.Date;

/**
 * 人民日报entity
 * 
 * @author 雷力
 * @date 2019年1月17日 下午4:04:00
 */
public class PeopleDaily {
	/**
	 * 主键
	 */
	private Long id;

	/**
	 * 标题
	 */
	private String title;

	/**
	 * 音频时长
	 */
	private String audioPlayTime;

	/**
	 * 音频链接
	 */
	private String audioUrl;

	/**
	 * 回复数
	 */
	private Integer commentCount;

	/**
	 * 上传时间
	 */
	private Date dateTime;

	/**
	 * 分享页
	 */
	private String shareUrl;

	/**
	 * 内容
	 */
	private String content;

	/**
	 * 类型
	 */
	private Integer seminarId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public String getAudioPlayTime() {
		return audioPlayTime;
	}

	public void setAudioPlayTime(String audioPlayTime) {
		this.audioPlayTime = audioPlayTime == null ? null : audioPlayTime.trim();
	}

	public String getAudioUrl() {
		return audioUrl;
	}

	public void setAudioUrl(String audioUrl) {
		this.audioUrl = audioUrl == null ? null : audioUrl.trim();
	}

	public Integer getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public String getShareUrl() {
		return shareUrl;
	}

	public void setShareUrl(String shareUrl) {
		this.shareUrl = shareUrl == null ? null : shareUrl.trim();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}

	public Integer getSeminarId() {
		return seminarId;
	}

	public void setSeminarId(Integer seminarId) {
		this.seminarId = seminarId;
	}

}