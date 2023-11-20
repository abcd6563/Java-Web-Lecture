package com.example.demo.blog;

import java.time.LocalDateTime;

public class Blog {
	private int bid;
	private String penName;
	private String title;
	private String content;
	private LocalDateTime modeTime;
	private int viewCount;
	

	private int isDeleted;
	
	
	@Override
	public String toString() {
		return "Blog [bid=" + bid + ", penName=" + penName + ", title=" + title + ", content=" + content + ", modeTime="
				+ modeTime.toString().substring(2, 16).replace("T"," ") + ", viewCount=" + viewCount + ", isDeleted=" + isDeleted + "]";
	}

	public Blog() {}
	// Insert하는 경우 사용되는 생성자 
	public Blog(String penName, String title, String content) {
		this.penName = penName;
		this.title = title;
		this.content = content;
	}
	// Update하는 경우 사용되는 생성자
	public Blog(int bid, String penName, String title, String content) {
		this.bid = bid;
		this.penName = penName;
		this.title = title;
		this.content = content;
	}
	
	public Blog(int bid, String penName, String title, String content, LocalDateTime modeTime, int viewCount,
			int isDeleted) {
		this.bid = bid;
		this.penName = penName;
		this.title = title;
		this.content = content;
		this.modeTime = modeTime;
		this.viewCount = viewCount;
		this.isDeleted = isDeleted;
		
	}
	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}


	public String getPenName() {
		return penName;
	}

	public void setPenName(String penName) {
		this.penName = penName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getModeTime() {
		return modeTime;
	}

	public void setModeTime(LocalDateTime modeTime) {
		this.modeTime = modeTime;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	


	}

	
	

