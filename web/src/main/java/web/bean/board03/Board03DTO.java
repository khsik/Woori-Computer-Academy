package web.bean.board03;

import java.sql.Timestamp;

/*
create table board03(
      num number primary key
    , title varchar2(100) not null
    , img varchar2(300)
    , reg date default sysdate
);
create sequence board03_seq nocache;
*/
public class Board03DTO {
	private int num;
	private String title;
	private String img;
	private Timestamp reg;
	
	// num
	public void setNum(int num) {
		this.num = num;
	}
	public int getNum() {
		return num;
	}
	
	// title
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	
	// img
	public void setImg(String img) {
		this.img = img;
	}
	public String getImg() {
		return img;
	}
	
	// reg
	public void setReg(Timestamp reg) {
		this.reg = reg;
	}
	public Timestamp getReg() {
		return reg;
	}
	
}
