package com.xxx.webservice.pojo;

import java.util.Date;

public class XBook {
	private Integer id;
	private String name;
	private String telOrEmail;
	private String ifine;
	private String bookTitle;
	private String bookDetail;
	private Date bookDatetime;
	private String replyTitle;
	private String replyDetail;
	private Date replyDatetime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelOrEmail() {
		return telOrEmail;
	}

	public void setTelOrEmail(String telOrEmail) {
		this.telOrEmail = telOrEmail;
	}

	public String getIfine() {
		return ifine;
	}

	public void setIfine(String ifine) {
		this.ifine = ifine;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookDetail() {
		return bookDetail;
	}

	public void setBookDetail(String bookDetail) {
		this.bookDetail = bookDetail;
	}

	public Date getBookDatetime() {
		return bookDatetime;
	}

	public void setBookDatetime(Date bookDatetime) {
		this.bookDatetime = bookDatetime;
	}

	public String getReplyTitle() {
		return replyTitle;
	}

	public void setReplyTitle(String replyTitle) {
		this.replyTitle = replyTitle;
	}

	public String getReplyDetail() {
		return replyDetail;
	}

	public void setReplyDetail(String replyDetail) {
		this.replyDetail = replyDetail;
	}

	public Date getReplyDatetime() {
		return replyDatetime;
	}

	public void setReplyDatetime(Date replyDatetime) {
		this.replyDatetime = replyDatetime;
	}
}
