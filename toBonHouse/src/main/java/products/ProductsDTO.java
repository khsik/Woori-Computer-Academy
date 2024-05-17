package products;
import java.sql.Timestamp;
public class ProductsDTO {
	  private static ProductsDTO  instance = new ProductsDTO ();

	    // 생성자를 private으로 선언하여 외부에서 인스턴스를 생성할 수 없도록 함
	  
	        // 클래스 내부에서만 호출되어야 하므로 private으로 선언
	  private int bnum;					// 주문 번호
	  private int pnum;					// 상품 번호
	  private int totalPrice;			// 총 결제금액
	  private int amount;				// 주문 수량
	  private int mem_num;			    // 구매자 회원번호
	  private String status;			// 주문 처리 상황(준비중, 배송중, ...)
	  private String payment;			// 결제 방법
	  private String msg;				// 배송 요청사항
	  private String thum2;				// 썸네일2
	  private String rec_addr;			// 배송지 (상세 주소)
	  private String rec_name;			// 받는사람
	  private String rec_tel;			// 받는사람 연락처
	  private Timestamp orderReg;		// 주문 날짜
	  // 인스턴스 객체 생성 
	public static ProductsDTO getInstance() {
		return instance;
	}
	public static void setInstance(ProductsDTO instance) {
		ProductsDTO.instance = instance;
	}
	 // 변수 set get 메서드 
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
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
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getMem_num() {
		return mem_num;
	}
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public Timestamp getOrderReg() {
		return orderReg;
	}
	public void setOrderReg(Timestamp orderReg) {
		this.orderReg = orderReg;
	}
	  
}
