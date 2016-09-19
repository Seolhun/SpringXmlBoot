package com.shun.blog.model.board;

import java.sql.Date;
/*-- 게시판
CREATE TABLE boardVO(
boardno number CONSTRAINT board_boardno_PK PRIMARY KEY,
userno number,
subject VARCHAR2(150) CONSTRAINT board_subject_NN NOT NULL,
content CLOB CONSTRAINT board_boardcontent__NN NOT NULL,
regdate Date DEFAULT SYSDATE,
HIT NUMBER DEFAULT 0,
blike number DEFAULT 0,
depth number CONSTRAINT board_boardno__NN Not Null,
CONSTRAINT board_boardno_FK FOREIGN KEY(userno) REFERENCES userVO(userno)
);*/
public class BoardVO {
    private int boardno;
    private String account;
    private int userno;
    private String subject;
    private String content;
    private Date regdate;
    private int hit;
    private int blike;
    private int depth;
    
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public int getBoardno() {
		return boardno;
	}
	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}
	public int getUserno() {
		return userno;
	}
	public void setUserno(int userno) {
		this.userno = userno;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getBlike() {
		return blike;
	}
	public void setBlike(int blike) {
		this.blike = blike;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}

//    private int group_id;
//    private int group_step;
//    private int group_tab;
//    private int root;
//    private int depth;
//    private String dbday;
}