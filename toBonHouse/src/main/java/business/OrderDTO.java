package business;

import java.sql.Timestamp;
/*
create table house_orderList(
	bnum		number			primary key,                   
	mem_num		number			not null,  
	pnum		number			not null,
	totalPrice	number			not null,
	status		varchar2(50)	not null,                  
	orderReg	date			default sysdate,            
	payment		varchar2(50)	not null,                         
	msg			varchar2(100),                              
	thum2		varchar2(300)	not null,
	amount		number			default 1 not null,
	rec_addr	varchar2(300)	not null,
	rec_name	varchar2(50)	not null,
	rec_tel		varchar2(20)	not null
);
alter table house_orderList add constraints FK_products FOREIGN KEY (mem_num) references house_member(mem_num); 
create sequence house_orderList_seq nocache;

-- 시퀀스 bnum에 사용
TODO id -> mem_num 수정
*/

public class OrderDTO {
	private int bnum;		// 주문번호
	private int mem_num;	// 구매자 (회원번호)
	private int pnum;		// 상품번호
	private int totalPrice;	// 총 결제금액
	private String status;	// 주문 처리 상황
	private Timestamp orderReg;	// 주문 날짜
	private String payment;		// 결제방법
	private String msg;		// 배송 요청사항
	private String thum2;	// 썸네일2
	private int amount;		// 주문 수량
	private String rec_addr;	// 배송지 주소
	private String rec_name;	// 받는사람
	private String rec_tel;		// 받는사람 연락처
	

	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public int getMem_num() {
		return mem_num;
	}
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Timestamp getOrderReg() {
		return orderReg;
	}
	public void setOrderReg(Timestamp orderReg) {
		this.orderReg = orderReg;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getThum2() {
		return thum2;
	}
	public void setThum2(String thum2) {
		this.thum2 = thum2;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getRec_addr() {
		return rec_addr;
	}
	public void setRec_addr(String rec_addr) {
		this.rec_addr = rec_addr;
	}
	public String getRec_name() {
		return rec_name;
	}
	public void setRec_name(String rec_name) {
		this.rec_name = rec_name;
	}
	public String getRec_tel() {
		return rec_tel;
	}
	public void setRec_tel(String rec_tel) {
		this.rec_tel = rec_tel;
	}
	
}
