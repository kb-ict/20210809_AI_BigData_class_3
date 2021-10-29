package dto;

public class MartMemberVO {
	private String id;
	private String pw;
	private int point;
	
	public MartMemberVO(String id,String pw, int point) {
		this.id=id;
		this.pw=pw;
		this.point=point;

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
	public void setPoint(int point) {
		this.point=point;
	}
	public int getPoint() {
		return point;
	}
}
