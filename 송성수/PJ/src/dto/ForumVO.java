package dto;

public class ForumVO {
	private int no;
	private String writer_id;
	private String title;
	private String content;
	private int sold_out;

	
	public ForumVO(int no, String title, String content, String writer_id, int sold_out) {
		this.no=no;
		this.writer_id=writer_id;
		this.title=title;
		this.content=content;
		this.sold_out=sold_out;
	}
	
	
	public int getNo() {
		return no;
	}
	

	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	
	public String getWriterId() {
		return writer_id;
	}
	
	public int getSoldOut() {
		return sold_out;
	}

	
}
