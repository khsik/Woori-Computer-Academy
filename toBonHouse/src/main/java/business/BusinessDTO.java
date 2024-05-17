package business;

import java.sql.Timestamp;
/*
	create table house_products(
		pnum	number			primary key,
		mem_num	number			not null,
		reg		date			default sysdate,
		pname	varchar2(100)	not null,
		cook	varchar2(60)	not null,
		thum1	varchar2(300)	not null,
		thum2	varchar2(300)	not null,
		price	number			not null,
		stock	number			not null,
		detail	varchar2(300)	not null,
		company	varchar2(150)	not null,
		country	varchar2(100)	not null,
		sales	number			default 0
	);
	alter table house_products add constraints FK_products FOREIGN KEY (mem_num) references house_member(mem_num);
	create sequence house_products_seq nocache;
	
	-- pnum에 house_products_seq.nextval() 사용
*/
public class BusinessDTO {
	private int pnum;		// 글번호
	private int mem_num;	// 판매자 (회원번호)
	private Timestamp reg;	// 등록 일자
	private String pName;	// 상품 이름
	private String cook;	// 조리 방법
	private String thum1;	// 썸네일 1
	private String thum2;	// 썸네일 2
	private int price;		// 가격
	private int stock;		// 재고
	private String detail;	// 상세설명 (세로로 긴 이미지 1장)
	private String company;	// 제조사
	private String country;	// 생산국(원산지)
	private int sales;		// 판매량

	// reg
	public Timestamp getReg() {
		return reg;
	}
	public void setReg(Timestamp reg) {
		this.reg = reg;
	}
	
	// seller
	public int getMem_num() {
		return mem_num;
	}
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	
	// pnum
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	
	// pName
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	
	// cook
	public String getCook() {
		return cook;
	}
	public void setCook(String cook) {
		this.cook = cook;
	}
	
	// thum1
	public String getThum1() {
		return thum1;
	}
	public void setThum1(String thum1) {
		this.thum1 = thum1;
	}
	
	// thum2
	public String getThum2() {
		return thum2;
	}
	public void setThum2(String thum2) {
		this.thum2 = thum2;
	}
	
	// price
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	// stock
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	// detail
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	// conpany
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	// country
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	// sales
	public int getSales() {
		return sales;
	}
	public void setSales(int sales) {
		this.sales = sales;
	}
	
}
