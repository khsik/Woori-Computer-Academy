package products;

public class OrderJangDTO {
	private static OrderJangDTO  instance = new OrderJangDTO ();
	public static OrderJangDTO getInstance() {
		return instance;
	}
	public static void setInstance(OrderJangDTO instance) {
		OrderJangDTO.instance = instance;
	}
	
	private int mem_num;			// house_member 회원번호 포링키 지정
	private int pnum;				// house_product 상품번호 
	private int amount;				// 장바구니 수량
	
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
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}
