package dto;

public class MartVO {
	private String name;
	private int price;
	private int nong;
	private int soo;
	private int snack;
	private int drink;
		
	public MartVO(String name,int price,int nong,int soo,int snack,int drink){
		this.name=name;
		this.price=price;
		this.nong=nong;
		this.soo=soo;
		this.snack=snack;
		this.drink=drink;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setPrice(int price) {
		this.price=price;
	}
	public int getPrice() {
		return price;
	}
	
	public void setNong(int nong) {
		this.nong=nong;
	}
	public int getNong() {
		return nong;
	}
	public void setSoo(int soo) {
		this.soo=soo;
	}
	public int getSoo() {
		return soo;
	}
	public void setSnack(int snack) {
		this.snack=snack;
	}
	public int getSnack() {
		return snack;
	}
	public void setDrink(int drink) {
		this.drink=drink;
	}
	public int getDrink() {
		return drink;
	}
	
}
