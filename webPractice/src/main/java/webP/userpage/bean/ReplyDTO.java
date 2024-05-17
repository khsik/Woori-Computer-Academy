package webP.userpage.bean;

import java.sql.Timestamp;
/*
	table 생성 sql
create table userreply(
	  bnum number not null
	, rnum number primary key
	, rgroup number
	, rloc number not null
	, lev number not null
	, writer varchar2(30) not null
	, content varchar2(1000) not null
	, reg date default sysdate
);
create sequence userreply_seq nocache;
*/
public class ReplyDTO {
	private int bnum;	// 게시글 번호
	private int rnum;	// 댓글 번호
	private int rgroup;	// 댓글 그룹. 대댓글 달았을 때 상위 댓글 번호.
	private int rloc;	// 댓글 위치.
	private int lev;	// 댓글 들여쓰기 정도(댓글0, 대댓글1, 대대댓글2, ... 구분용) 최대치 5
	private String writer;	// 댓글 작성자
	private String content;	// 댓글 내용
	private Timestamp reg;	// 댓글 작성일자

	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public int getRgroup() {
		return rgroup;
	}
	public void setRgroup(int rgroup) {
		this.rgroup = rgroup;
	}
	public int getRloc() {
		return rloc;
	}
	public void setRloc(int rloc) {
		this.rloc = rloc;
	}
	public int getLev() {
		return lev;
	}
	public void setLev(int lev) {
		this.lev = lev;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
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
