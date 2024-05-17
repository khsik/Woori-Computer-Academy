package announce;

import java.sql.Timestamp;

public class AnnounceDTO {
	private int num;
	private String title;
	private String ann_Content;
	private String ann_Img;
	private String ann_Pw;
	private String category;
	private Timestamp ann_Reg;
	private int mem_num;
	private String id;
	private int rownum; // 추가 해야함
	
	// set - > 값을 입력
	// get - > 값을 출력
	public void setNum(int num) {
		this.num = num;
	}
	public int getNum() {
		return num;
	}
	
	public void setTitle(String title) {
		this.title = title;
	} 
	public String getTitle() {
		return title;
	}
	
	public void setAnn_Content(String ann_Content) {
		this.ann_Content = ann_Content;
	}
	public String getAnn_Content() {
		return ann_Content;
	}
	
	public String getAnn_Img() {
		return ann_Img;
	}
	public void setAnn_Img(String ann_Img) {
		this.ann_Img = ann_Img;
	}
	
	public void setAnn_Pw(String ann_Pw) {
		this.ann_Pw = ann_Pw;
	}
	public String getAnn_Pw() {
		return ann_Pw;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCategory() {
		return category;
	}
	
	public void setAnn_Reg(Timestamp ann_Reg) {
		this.ann_Reg = ann_Reg;
	}
	public Timestamp getAnn_Reg() {
		return ann_Reg;
	}
	
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	
	public int getMem_num() {
		return mem_num;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}

	
}
