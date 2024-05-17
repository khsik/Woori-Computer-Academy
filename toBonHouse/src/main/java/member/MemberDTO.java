package member;

import java.sql.Timestamp;


public class MemberDTO {	
	
	private int mem_num;	// 멤버 넘버
	private String id;		// 아이디
	private String pw;		// 비밀번호
	private String name;	// 이름
	private String tel_com;	// 통신사
	private String tel;		// 전화번호
	private String email;	// 이메일
	private String address;	// 주소
	private int grade;		// 회원 등급
	private Timestamp reg;	// 가입 날짜
	private int balance;	// 잔고
	private int point; 		// 적립금
	    
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
	
	
}