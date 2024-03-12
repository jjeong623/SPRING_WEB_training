package com.spring.biz.board;

public class BoardDTO {
	private int bid;
	private String title;
	private String content;
	private String writer;
	
	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
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

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	@Override
	public String toString() {
		return "BoardDTO [bid=" + bid + ", title=" + title + ", content=" + content + ", writer=" + writer + "]";
	}	
}
