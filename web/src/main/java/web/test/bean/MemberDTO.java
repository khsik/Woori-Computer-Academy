package web.test.bean;
/*
create table member(
    id varchar2(50) primary key,
    pw varchar2(50) not null,
    name varchar2(50) not null,
    birth date not null,
    phone1 varchar2(100) not null,
    phone2 varchar2(100) not null,
    gender varchar2(50) not null, 
    reg date default sysdate
);
*/
import java.sql.Timestamp;

public class MemberDTO { // Data Transfer Object
	private String id;		// 아이디
	private String pw;		// 비밀번호
	private String name;	// 이름
	private String birth;	// 생일
	private String phone1;	// 통신사
	private String phone2;	// 번호
	private String gender;	// 성별
	private Timestamp reg;	// 가입날짜
	
	private String auto;	// 자동 로그인 

	// id
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}

	// pw
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getPw() {
		return pw;
	}

	// name
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

	// birth
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getBirth() {
		return birth;
	}

	// phone1
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone1() {
		return phone1;
	}

	// phone2
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getPhone2() {
		return phone2;
	}

	// gender
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getGender() {
		return gender;
	}

	// reg
	public void setReg(Timestamp reg) {
		this.reg = reg;
	}
	public Timestamp getReg() {
		return reg;
	}

	// auto
	public void setAuto(String auto) {
		this.auto = auto;
	}
	public String getAuto() {
		return auto;
	}
}
