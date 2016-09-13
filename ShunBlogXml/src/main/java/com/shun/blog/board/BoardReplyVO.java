package com.shun.blog.board;

import java.sql.Date;

public class BoardReplyVO {
	private int reBoardNo;
	private int boardReplyNo;
	private String reAccount;
	private String replyContent;
	private Date replyRegDate;
	private int boardLikeNum;

	public int getReBoardNo() {
		return reBoardNo;
	}

	public void setReBoardNo(int reBoardNo) {
		this.reBoardNo = reBoardNo;
	}

	public int getBoardReplyNo() {
		return boardReplyNo;
	}

	public void setBoardReplyNo(int boardReplyNo) {
		this.boardReplyNo = boardReplyNo;
	}

	public String getReAccount() {
		return reAccount;
	}

	public void setReAccount(String reAccount) {
		this.reAccount = reAccount;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Date getReplyRegDate() {
		return replyRegDate;
	}

	public void setReplyRegDate(Date replyRegDate) {
		this.replyRegDate = replyRegDate;
	}

	public int getBoardLikeNum() {
		return boardLikeNum;
	}

	public void setBoardLikeNum(int boardLikeNum) {
		this.boardLikeNum = boardLikeNum;
	}
}
