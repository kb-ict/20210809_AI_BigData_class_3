package dto;

public class MemberVO {
	private String id;
	private String pw;
	private int sell_cnt;
	
	public MemberVO(String id,String pw,int sell_cnt) {
		this.id=id;
		this.pw=pw;
		this.sell_cnt=sell_cnt;
	}
	public void setID(String id) {
		this.id=id;
	}
	public String getID() {
		return id;
	}
	public void setPW(String pw) {
		this.pw=pw;
	}
	public String getPW() {
		return pw;
	}
	
	public void setSellCnt(int sell_cnt) {
		this.sell_cnt=sell_cnt;
	}
	
	public int getSellCnt() {
		return sell_cnt;
	}
	
	
	

}
