package web.test.bean;
/*
-- 글번호, 작성자, 제목, 내용, 작성날짜
create table board01(
      num       number          primary key
    , writer    varchar2(100)   not null
    , title     varchar2(100)   not null
    , content   varchar2(4000)  not null
    , reg       date            default sysdate
);

create sequence board01_seq nocache;
*/
import java.sql.Timestamp;

public class BoardDTO {
	private int num;
	private String writer;
	private String title;
	private String content;
	private Timestamp reg;
	
	// num
	public void setNum(int num) {
		this.num = num;
	}
	public int getNum() {
		return num;
	}
	
	// writer
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getWriter() {
		return writer;
	}
	
	// title
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}

	// content
	public void setContent(String content) {
		this.content = content;
	}
	public String getContent() {
		return content;
	}
	
	// reg
	public void setReg(Timestamp reg) {
		this.reg = reg;
	}
	public Timestamp getReg() {
		return reg;
	}
}
