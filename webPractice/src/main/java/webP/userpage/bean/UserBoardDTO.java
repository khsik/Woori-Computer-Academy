package webP.userpage.bean;

import java.sql.Timestamp;

/*
	userboard sql문

create table userboard(
      bnum number primary key
    , writer varchar2(30) not null
    , title varchar2(150) not null
    , content varchar2(3000) not null
    , reg date default sysdate
);
create sequence userboard_seq nocache;
*/
public class UserBoardDTO {
	private int bnum;
	private String writer;
	private String title;
	private String content;
	private Timestamp reg;
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
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
	public Timestamp getReg() {
		return reg;
	}
	public void setReg(Timestamp reg) {
		this.reg = reg;
	}
}
