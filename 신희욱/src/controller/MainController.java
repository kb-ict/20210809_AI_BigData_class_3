package controller;

import java.util.ArrayList;
import java.util.Scanner;

import dto.MartMemberVO;
import dto.MartVO;
import service.MartMemberService;
import service.MartService;

public class MainController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<MartMemberVO> dtos;
		ArrayList<MartVO> dtos2;
		MartMemberService service = new MartMemberService();
		MartService service2 = new MartService();		
		boolean check;
		int choice1;
		int choice2;
		int choice3;
		int choice4;
		int choice5;
		int choice6;
		int choice7;
		int choice8;
		int money;
		String id;
		String pw;
		String loginID;
				
		Menu.first();
		choice1 = sc.nextInt();
		switch(choice1) {
			case 1://로그인 및 회원가입
				Menu.second();
				choice2 = sc.nextInt();
				switch(choice2) {
					case 1://로그인
						check = false;
						dtos = service.getAllMembers();
						System.out.print("아이디 입력 >>");
						id = sc.next();
						System.out.print("비밀번호 입력 >>");
						pw = sc.next();
						for (int i = 0; i < dtos.size(); i++) {
							if (dtos.get(i).getID().equals(id)) {
								if (dtos.get(i).getPW().equals(pw)) {
									check = true;
								}
							}
						}
						if (check == false) {
							System.out.println("로그인 실패");
							System.out.println("아이디 혹은 비밀번호를 다시 확인해주세요.");
							break; // 로그인실패 전메뉴로 돌아감
						} else {
							System.out.println("로그인 성공!");
							loginID = id; // 로그인성공한 id를 loginID에 저장
							
							Menu.third();
							choice3 = sc.nextInt();
							switch(choice3) {
								case 1://장보러가기
									Menu.fourth();
									choice4 = sc.nextInt();
									switch(choice4) {
										case 1 ://농산물
											String part1 = "nong";
											dtos2 = service2.getSelectMenu(part1);
											for (int i = 0; i < dtos2.size(); i++) {
												System.out.print("제품명: "+dtos2.get(i).getName()+"    ");
												System.out.println("가격: "+dtos2.get(i).getPrice());
											}
											System.out.println("");
											System.out.println("제품을 구매하시려면 '1번'을 누르세요. ");
											choice5=sc.nextInt();
											switch(choice5) {
											case 1 :
												System.out.println("어떤 제품을 구매하시겠습니까? ");
												for (int i = 0; i < dtos2.size(); i++) {
													System.out.print(i+1+"번-'"+dtos2.get(i).getName()+"'  ");
												}
												choice6=sc.nextInt();
												for(int i =0; i < dtos2.size(); i++) {
													if(choice6==i+1) {
														System.out.println(i+1+"번을 선택하였습니다. ");
														System.out.println("몇개를 고르시겠습니까? ");
														choice7 = sc.nextInt();
														System.out.println(choice7+"개를 고르셨습니다. ");
														System.out.println("총 구매요금은 5% 할인된 "
																+dtos2.get(i).getPrice()*choice7*0.95+"원 입니다.");
													}
												}
												
												break;
											default :
												break;
											}loginID="0";
											break;
										case 2 ://수산물
											String part2 = "soo";
											dtos2 = service2.getSelectMenu(part2);
											for (int i = 0; i < dtos2.size(); i++) {
												System.out.print("제품명: "+dtos2.get(i).getName()+"    ");
												System.out.println("가격: "+dtos2.get(i).getPrice());
											}
											System.out.println("");
											System.out.println("제품을 구매하시려면 '1번'을 누르세요. ");
											choice5=sc.nextInt();
											switch(choice5) {
											case 1 :
												System.out.println("어떤 제품을 구매하시겠습니까? ");
												for (int i = 0; i < dtos2.size(); i++) {
													System.out.print(i+1+"번-'"+dtos2.get(i).getName()+"'  ");
												}
												choice6=sc.nextInt();
												for(int i =0; i < dtos2.size(); i++) {
													if(choice6==i+1) {
														System.out.println(i+1+"번을 선택하였습니다. ");
														System.out.println("몇개를 고르시겠습니까? ");
														choice7 = sc.nextInt();
														System.out.println(choice7+"개를 고르셨습니다. ");
														System.out.println("총 구매요금은 5%할인된 "
																+dtos2.get(i).getPrice()*choice7*0.95+"원 입니다.");
													}
												}
												break;
											default :
												break;
											}loginID="0";
											break;
										case 3://간식 
											String part3 = "snack";
											dtos2 = service2.getSelectMenu(part3);
											for (int i = 0; i < dtos2.size(); i++) {
												System.out.print("제품명: "+dtos2.get(i).getName()+"    ");
												System.out.println("가격: "+dtos2.get(i).getPrice());
											}
											System.out.println("");
											System.out.println("제품을 구매하시려면 '1번'을 누르세요. ");
											choice5=sc.nextInt();
											switch(choice5) {
											case 1 :
												System.out.println("어떤 제품을 구매하시겠습니까? ");
												for (int i = 0; i < dtos2.size(); i++) {
													System.out.print(i+1+"번-'"+dtos2.get(i).getName()+"'  ");
												}
												choice6=sc.nextInt();
												for(int i =0; i < dtos2.size(); i++) {
													if(choice6==i+1) {
														System.out.println(i+1+"번을 선택하였습니다. ");
														System.out.println("몇개를 고르시겠습니까? ");
														choice7 = sc.nextInt();
														System.out.println(choice7+"개를 고르셨습니다. ");
														System.out.println("총 구매요금은 5%할인된 "
																+dtos2.get(i).getPrice()*choice7*0.95+"원 입니다.");
													}
												}
												break;
											default :
												break;
											}loginID="0";
											break;
										case 4://음료
											String part4 = "drink";
											dtos2 = service2.getSelectMenu(part4);
											for (int i = 0; i < dtos2.size(); i++) {
												System.out.print("제품명: "+dtos2.get(i).getName()+"    ");
												System.out.println("가격: "+dtos2.get(i).getPrice());
											}
											System.out.println("");
											System.out.println("제품을 구매하시려면 '1번'을 누르세요. ");
											choice5=sc.nextInt();
											switch(choice5) {
											case 1 :
												System.out.println("어떤 제품을 구매하시겠습니까? ");
												for (int i = 0; i < dtos2.size(); i++) {
													System.out.print(i+1+"번-'"+dtos2.get(i).getName()+"'  ");
												}
												choice6=sc.nextInt();
												for(int i =0; i < dtos2.size(); i++) {
													if(choice6==i+1) {
														System.out.println(i+1+"번을 선택하였습니다. ");
														System.out.println("몇개를 고르시겠습니까? ");
														choice7 = sc.nextInt();
														System.out.println(choice7+"개를 고르셨습니다. ");
														System.out.println("총 구매요금은 5%할인된 "
																+dtos2.get(i).getPrice()*choice7*0.95+"원 입니다.");
													}
												}
												break;
											default :
												break;
											}loginID="0";
											break;
										case 5://모든메뉴
											dtos2 = service2.getAllMenu();
											for (int i = 0; i < dtos2.size(); i++) {
												System.out.print("제품명: "+dtos2.get(i).getName()+"    ");
												System.out.println("가격: "+dtos2.get(i).getPrice());
											}
											System.out.println("");
											System.out.println("제품을 구매하시려면 '1번'을 누르세요. ");
											choice5=sc.nextInt();
											switch(choice5) {
											case 1 :
												System.out.println("어떤 제품을 구매하시겠습니까? ");
												for (int i = 0; i < dtos2.size(); i++) {
													System.out.print(i+1+"번-'"+dtos2.get(i).getName()+"'  ");
												}
												choice6=sc.nextInt();
												for(int i =0; i < dtos2.size(); i++) {
													if(choice6==i+1) {
														System.out.println(i+1+"번을 선택하였습니다. ");
														System.out.println("몇개를 고르시겠습니까? ");
														choice7 = sc.nextInt();
														System.out.println(choice7+"개를 고르셨습니다. ");
														System.out.println("총 구매요금은 5%할인된 "
																+dtos2.get(i).getPrice()*choice7*0.95+"원 입니다.");
														
													}
												}
												break;
											default :
												break;
											}
											loginID="0";
											break;
										case 0:
											System.out.println("종료합니다.");
											loginID="0";
											break;
										default:
											System.out.println("잘못 입력하였습니다.");
											System.out.println("종료합니다.");
											loginID="0";
											break;
									}
									break;
								case 2://포인트 조회
									check = false;
									
									System.out.print("비밀번호 입력 >>");
									pw = sc.next();
									dtos = service.getAllMembers();
									for (int i = 0; i < dtos.size(); i++) {
										if (dtos.get(i).getID().equals(id)) {
											if (dtos.get(i).getPW().equals(pw)) {
												System.out.println(dtos.get(i).getPoint()+"포인트 보유중입니다.");
												check = true;
											}
										}
									}
									if (check == false) {
										System.out.println("비밀번호를 다시 확인해주세요.");
									}else {
										
									}
									break;
								case 3://회원정보변경
									check = false;
									
									System.out.print("비밀번호 입력 >>");
									pw = sc.next();
									dtos = service.getAllMembers();
									for (int i = 0; i < dtos.size(); i++) {
										if (dtos.get(i).getID().equals(id)) {
											if (dtos.get(i).getPW().equals(pw)) {
												check = true;
											}
										}
									}
									if (check == false) {
										System.out.println("비밀번호를 다시 확인해주세요.");
									} else {
																										 
										System.out.print("새로운 비밀번호를 입력하세요. >>");
										pw = sc.next();
											
										dtos = service.updateMartMembers(loginID, pw);
										System.out.println("회원정보가 변경되었습니다. ");
										System.out.println("");
										
										loginID="0";
									}
									break;
								case 4://탈퇴
									check = false;
									
									System.out.print("비밀번호 입력 >>");
									pw = sc.next();
									dtos = service.getAllMembers();
									for (int i = 0; i < dtos.size(); i++) {
										if (dtos.get(i).getID().equals(id)) {
											if (dtos.get(i).getPW().equals(pw)) { // id와 pw가 일치하면 삭제
												dtos = service.deleteMartMembers(id);
												check = true;
											}
										}
									}
									if (check == false) {
										System.out.println("비밀번호를 다시 확인해주세요.");
									} else
										System.out.println("탈퇴 완료.");
									break;
								
								case 0://종료
									System.out.println("종료합니다.");
									break;
								default:
									System.out.println("잘못 입력하였습니다.");
									System.out.println("종료합니다.");
									break;
							}
						}loginID="0";
						break;
					case 2://회원가입
						check = false; // 아이디 중복 체크를 위한 bool타입
						dtos = service.getAllMembers();
						System.out.print("아이디 입력 >>");
						id = sc.next();
						for (int i = 0; i < dtos.size(); i++) {
							if (dtos.get(i).getID().equals(id)) { // getid와 id가 일치하면
								System.out.println("현재 사용중인 아이디입니다.");
								check = true; // check가 true가 되고 break;
								break;
							}
						}
						if (check == false) { // check가 false라면 가입진행
							System.out.print("비밀번호 입력 >>");
							pw = sc.next();
														
							dtos = service.insertMartMembers(id, pw);
						}
						break;
					case 0:
						System.out.println("종료합니다.");
						break;
					default:
						System.out.println("잘못 입력하였습니다.");
						System.out.println("종료합니다.");
						break;
				}
				break;
			case 2://그냥이용
				
				Menu.fourth();
				choice4 = sc.nextInt();
				switch(choice4) {
					case 1 ://농산물
						String part1 = "nong";
						dtos2 = service2.getSelectMenu(part1);
						for (int i = 0; i < dtos2.size(); i++) {
							System.out.print("제품명: "+dtos2.get(i).getName()+"    ");
							System.out.println("가격: "+dtos2.get(i).getPrice());
						}
						System.out.println("");
						System.out.println("제품을 구매하시려면 '1번'을 누르세요. ");
						choice5=sc.nextInt();
						switch(choice5) {
						case 1 :
							System.out.println("어떤 제품을 구매하시겠습니까? ");
							for (int i = 0; i < dtos2.size(); i++) {
								System.out.print(i+1+"번-'"+dtos2.get(i).getName()+"'  ");
							}
							choice6=sc.nextInt();
							for(int i =0; i < dtos2.size(); i++) {
								if(choice6==i+1) {
									System.out.println(i+1+"번을 선택하였습니다. ");
									System.out.println("몇개를 고르시겠습니까? ");
									choice7 = sc.nextInt();
									System.out.println(choice7+"개를 고르셨습니다. ");
									System.out.println("총 구매요금은 "+dtos2.get(i).getPrice()*choice7+"원 입니다.");
								}
							}
							break;
						default :
							break;
						}
						break;
					case 2 ://수산물
						String part2 = "soo";
						dtos2 = service2.getSelectMenu(part2);
						for (int i = 0; i < dtos2.size(); i++) {
							System.out.print("제품명: "+dtos2.get(i).getName()+"    ");
							System.out.println("가격: "+dtos2.get(i).getPrice());
						}
						System.out.println("");
						System.out.println("제품을 구매하시려면 '1번'을 누르세요. ");
						choice5=sc.nextInt();
						switch(choice5) {
						case 1 :
							System.out.println("어떤 제품을 구매하시겠습니까? ");
							for (int i = 0; i < dtos2.size(); i++) {
								System.out.print(i+1+"번-'"+dtos2.get(i).getName()+"'  ");
							}
							choice6=sc.nextInt();
							for(int i =0; i < dtos2.size(); i++) {
								if(choice6==i+1) {
									System.out.println(i+1+"번을 선택하였습니다. ");
									System.out.println("몇개를 고르시겠습니까? ");
									choice7 = sc.nextInt();
									System.out.println(choice7+"개를 고르셨습니다. ");
									System.out.println("총 구매요금은 "+dtos2.get(i).getPrice()*choice7+"원 입니다.");
								}
							}
							break;
						default :
							break;
						}
						break;
					case 3://간식 
						String part3 = "snack";
						dtos2 = service2.getSelectMenu(part3);
						for (int i = 0; i < dtos2.size(); i++) {
							System.out.print("제품명: "+dtos2.get(i).getName()+"    ");
							System.out.println("가격: "+dtos2.get(i).getPrice());
						}
						System.out.println("");
						System.out.println("제품을 구매하시려면 '1번'을 누르세요. ");
						choice5=sc.nextInt();
						switch(choice5) {
						case 1 :
							System.out.println("어떤 제품을 구매하시겠습니까? ");
							for (int i = 0; i < dtos2.size(); i++) {
								System.out.print(i+1+"번-'"+dtos2.get(i).getName()+"'  ");
							}
							choice6=sc.nextInt();
							for(int i =0; i < dtos2.size(); i++) {
								if(choice6==i+1) {
									System.out.println(i+1+"번을 선택하였습니다. ");
									System.out.println("몇개를 고르시겠습니까? ");
									choice7 = sc.nextInt();
									System.out.println(choice7+"개를 고르셨습니다. ");
									System.out.println("총 구매요금은 "+dtos2.get(i).getPrice()*choice7+"원 입니다.");
								}
							}
							break;
						default :
							break;
						}
						break;
					case 4://음료
						String part4 = "drink";
						dtos2 = service2.getSelectMenu(part4);
						for (int i = 0; i < dtos2.size(); i++) {
							System.out.print("제품명: "+dtos2.get(i).getName()+"    ");
							System.out.println("가격: "+dtos2.get(i).getPrice());
						}
						System.out.println("");
						System.out.println("제품을 구매하시려면 '1번'을 누르세요. ");
						choice5=sc.nextInt();
						switch(choice5) {
						case 1 :
							System.out.println("어떤 제품을 구매하시겠습니까? ");
							for (int i = 0; i < dtos2.size(); i++) {
								System.out.print(i+1+"번-'"+dtos2.get(i).getName()+"'  ");
							}
							choice6=sc.nextInt();
							for(int i =0; i < dtos2.size(); i++) {
								if(choice6==i+1) {
									System.out.println(i+1+"번을 선택하였습니다. ");
									System.out.println("몇개를 고르시겠습니까? ");
									choice7 = sc.nextInt();
									System.out.println(choice7+"개를 고르셨습니다. ");
									System.out.println("총 구매요금은 "+dtos2.get(i).getPrice()*choice7+"원 입니다.");
								}
							}
							break;
						default :
							break;
						}
						break;
					case 5://모든메뉴
						dtos2 = service2.getAllMenu();
						for (int i = 0; i < dtos2.size(); i++) {
							System.out.print("제품명: "+dtos2.get(i).getName()+"    ");
							System.out.println("가격: "+dtos2.get(i).getPrice());
						}
						System.out.println("");
						System.out.println("제품을 구매하시려면 '1번'을 누르세요. ");
						choice5=sc.nextInt();
						switch(choice5) {
						case 1 :
							System.out.println("어떤 제품을 구매하시겠습니까? ");
							for (int i = 0; i < dtos2.size(); i++) {
								System.out.print(i+1+"번-'"+dtos2.get(i).getName()+"'  ");
							}
							choice6=sc.nextInt();
							for(int i =0; i < dtos2.size(); i++) {
								if(choice6==i+1) {
									System.out.println(i+1+"번을 선택하였습니다. ");
									System.out.println("몇개를 고르시겠습니까? ");
									choice7 = sc.nextInt();
									System.out.println(choice7+"개를 고르셨습니다. ");
									System.out.println("총 구매요금은 "+dtos2.get(i).getPrice()*choice7+"원 입니다.");
								}
							}
							break;
						default :
							break;
						}
						
						break;
					case 0:
						System.out.println("종료합니다.");
						break;
					default:
						System.out.println("잘못 입력하였습니다.");
						System.out.println("종료합니다.");
						break;
				}
				break;
			case 0:
				System.out.println("종료합니다.");
				break;
			default:
				System.out.println("잘못 입력하였습니다.");
				System.out.println("종료합니다.");
				break;
		}
	}
}
