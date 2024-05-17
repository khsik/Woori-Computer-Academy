package webP.userpage.bean;

import java.sql.Timestamp;

/*
	userinfo sql문

create table userinfo(
    id varchar2(30) primary key
    , pw varchar2(40) not null
    , name varchar2(30) not null
    , email varchar2(100)
    , phoneC varchar2(50) not null
    , phoneNum varchar2(25) not null unique
    , reg date default sysdate
);
 */
public class UserInfoDTO {
	private String id;
	private String pw;
	private String name;
	private String email;
	private String phoneC;	// 통신사
	private String phoneNum;
	private Timestamp reg;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneC() {
		return phoneC;
	}
	public void setPhoneC(String phoneC) {
		this.phoneC = phoneC;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public Timestamp getReg() {
		return reg;
	}
	public void setReg(Timestamp reg) {
		this.reg = reg;
	}
	
}

