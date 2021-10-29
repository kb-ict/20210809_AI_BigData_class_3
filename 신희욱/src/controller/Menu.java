package controller;

public class Menu {

	public static void first() {
		System.out.println("신씨네 마트에 오신걸 환영합니다. ");
		System.out.println("회원으로 이용시 할인가가 적용됩니다. ");
		System.out.println("1.회원가입 및 로그인 2.그냥 이용 0.종료 ");		
	}

	public static void second(){
		System.out.println("1.로그인 2.회원가입 0.종료");
	}
	
	public static void third() {
		System.out.println("1.장보러가기 2.포인트조회 3.회원정보변경 4.회원탈퇴 0.종료");
	}
	
	public static void fourth(){
		System.out.println("1.농산물 2.수산물 3.간식 4.음료 5.모든메뉴보기 0.종료");
	}
}
