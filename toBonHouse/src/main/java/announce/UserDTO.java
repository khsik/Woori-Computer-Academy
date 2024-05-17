package announce;

import java.sql.Timestamp;

/*
create table house_member(       
        mem_num number primary key,
        id varchar2(50) not null,        
        pw varchar2(100) not null,        
        name varchar2(50) not null,        
        tel_com varchar2(10) not null,        
        tel varchar2(20) not null,        
        email varchar2(80),        
        address varchar2(300) not null,        
        grade number not null,        
        reg date default sysdate,
        balance number default 0 not null,
        point number default 0 not null
);
create SEQUENCE house_member_seq start with 2 nocache;

*/
public class UserDTO {
	private int mem_num;
	private String id;
	private String pw;
	private String name;
	private String tel_com;
	private String tel;
	private String email;
	private String address;
	private int grade;
	private Timestamp reg;
	private int balance;
	private int point;
	private Timestamp resign_day;
	
	
	// 메서드
	public int getMem_num() {
		return mem_num;
	}
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	
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
	
	public String getTel_com() {
		return tel_com;
	}
	public void setTel_com(String tel_com) {
		this.tel_com = tel_com;
	}
	
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public Timestamp getReg() {
		return reg;
	}
	public void setReg(Timestamp reg) {
		this.reg = reg;
	}
	
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public Timestamp getResign_day() {
		return resign_day;
	}
	public void setResign_day(Timestamp resign_day) {
		this.resign_day = resign_day;
	}

	
	
	
}
