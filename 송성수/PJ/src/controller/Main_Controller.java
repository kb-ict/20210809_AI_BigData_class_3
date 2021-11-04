package controller;

import java.util.ArrayList;
import java.util.Scanner;

import dto.MemberVO;
import dto.ForumVO;
import service.MemberService;
import service.ForumService;

public class Main_Controller {

	public static void main(String[] args) {
		
		int choice;
		
		String in;
		String pw;
		String login;
		int stop=0;
		ArrayList<MemberVO> dtos; 
		ArrayList<ForumVO> dtos2; 
		MemberService service = new MemberService();
		ForumService service2 = new ForumService();
		
		Scanner sc = new Scanner(System.in);
		

		while (true) {
			Menu();
			choice = sc.nextInt();
			if (choice == 0) { // 종료
				System.out.print("***프로그램을 종료합니다!***\n");
				break;
			}
			
			switch(choice) {
			
			case 1:
				
				dtos = service.getAllMembers();
				System.out.print("가입할 ID: ");
				in = sc.next();
				stop=0;
				for (int i = 0; i < dtos.size(); i++) {
					if (dtos.get(i).getID().equals(in)) { 
						System.out.print("이미 사용중인 ID입니다.\n");
						stop=1;
						break;
					}
				}
				if(stop==1)
					break;
				System.out.print("가입할 PW: ");
				pw = sc.next();
				dtos = service.insertMembers(in, pw);
				break;
			
			case 2: 		//로그인
				
				dtos = service.getAllMembers();
				System.out.print("ID: ");
				in = sc.next();
				System.out.print("PW: ");
				pw = sc.next();

				stop=0;
				for (int i = 0; i < dtos.size(); i++) {
					if (dtos.get(i).getID().equals(in)&&dtos.get(i).getPW().equals(pw)) { 
						
						login=in;
						
						SubMenu(login);
						
						
						break;
					}
					else if(i==dtos.size()-1){
						stop=1;
					}
					
					
				}
				if(stop==1) {
					System.out.print("ID와 비밀번호를 다시 확인해주세요.\n");
				}
				break;
				
				
			default:
				System.out.print("잘못된 입력값 입니다.\n");
				break;
			
			
			
			
			}
			
			
			
			
		}
		sc.close();
		

		
	}

	public static void Menu() {
		System.out.println("-----------------------");
		System.out.println("");
		System.out.println("     중고 거래 게시판 ");
		System.out.println("(1)회원가입 (2)로그인 (0)종료");
		System.out.println("-----------------------");
		System.out.print("회원가입 또는 로그인하여 게시판에 접속하세요.\n");

	}

	public static void SubMenu(String login) {
		ArrayList<ForumVO> dtos2; 
		ForumService service2 = new ForumService();
		ArrayList<MemberVO> dtos; 
		MemberService service = new MemberService();
		String state;
		int page=0;
		Boolean logout=false;
		dtos2 = service2.getAllTitle();
		
		System.out.printf("**%s님 어서오세요!**\n\n",login);
		
		do {
			
			if(page==0) {
				System.out.printf("No.  -------최근 게시물-------      ---작성자---     상 태\n");
				System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			dtos2 = service2.getAllTitle();
			
			for(int i=0; i< 5 && i<dtos2.size();i++) {
				dtos = service.getMembers(dtos2.get(i+(page*5)).getWriterId());
				state="";
				if(dtos2.get(i+(page*5)).getSoldOut()==1)
					state="판매완료";
				else if(dtos.get(0).getSellCnt()>=5)
					state="★우수회원";
				
				System.out.printf("%-5d%-20s\t%11s%9s \n",dtos2.get(i).getNo(),dtos2.get(i).getTitle(), dtos2.get(i).getWriterId(),state);
				System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
				}
			System.out.printf("                            {%dpage}               {%dpage}(9)>>>\n",page,page+1);
			}
			System.out.printf("**접속 ID: %s**\n\n",login);
			System.out.println();
			System.out.printf("(1)게시글 보기\t        %s\n","(2)판매게시글 작성");
			System.out.printf("(3)판매완료\t        %s\n","(4)게시글 삭제");
			System.out.printf("(5)게시글 수정\t        %s\n","(0)로그아웃");
			
			page=Forum(login, page);
			logout=page<0;
		}while(!logout);
		
		
		
		
	}
	
	public static int Forum(String login,int page) {
		
		
		ArrayList<MemberVO> dtos; 
		MemberService service = new MemberService();
		ArrayList<ForumVO> dtos2; 
		ForumService service2 = new ForumService();
		int choice;
		String state;
		String title;
		String content;
		Scanner sc = new Scanner(System.in);
		choice=sc.nextInt();
		switch (choice) {
		
		case 0:
			System.out.print("**로그아웃합니다.**\n\n");
			return -1;
			
			
		case 1:
			
			System.out.print("열람 할 게시글 번호(No.)를 입력하세요: \n");
			choice=sc.nextInt();
			dtos2 = service2.getTitle(choice);
			System.out.printf("\n\n제목: %s\n",dtos2.get(0).getTitle());
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.printf("내용: %s\n\n",dtos2.get(0).getContent());
			System.out.printf("                          (1){뒤로}               \n");
			choice=sc.nextInt();
			page=0;
			
			break;
			
			
		
		case 2:
			
			System.out.print("제목: ");
			title=sc.nextLine();// 버퍼 클리어
			title=sc.nextLine();
			System.out.print("내용: ");
			content=sc.nextLine();
			
			dtos2 = service2.UpdateForum(title,  content,  login);
			
			System.out.print("업로드 완료했습니다!\n\n");
			page=0;
			break;
			
			
		case 3:
			
			System.out.print("판매완료 표시 할 게시글을 선택하세요.\n");
			System.out.print("(자신이 작성한 게시글만 변경 가능합니다.)\n");
			System.out.print("게시글 번호(No.): ");
			choice=sc.nextInt();
			dtos2 = service2.getTitle(choice);

			if(dtos2.get(0).getWriterId().equals(login)&&dtos2.get(0).getSoldOut()==0) {
				dtos2 = service2.UpdateSoldOut(choice);
				dtos = service.updateSellCnt(login);
				System.out.print("변경 완료\n");
			}else if(dtos2.get(0).getSoldOut()==1)
				System.out.print("**이미 판매 완료된 개시물 입니다.**\n");
			else
				System.out.print("**현재 로그인한 계정으로 작성된 게시글이 아닙니다.**\n");
			page=0;
			break;
			
		case 4:
			
			System.out.print("삭제 할 게시글을 선택하세요.\n");
			System.out.print("(자신이 작성한 게시글만 삭제 가능합니다.)\n");
			System.out.print("게시글 번호(No.): ");
			choice=sc.nextInt();
			dtos2 = service2.getTitle(choice);

			if(dtos2.get(0).getWriterId().equals(login)) {
				dtos2 = service2.DeleteForum(choice);
				System.out.print("삭제 완료\n");
			}
			else
				System.out.print("**현재 로그인한 계정으로 작성된 게시글이 아닙니다.**\n");
			page=0;
			break;
		
		case 5:
			
			System.out.print("수정 할 게시글을 선택하세요.\n");
			System.out.print("(자신이 작성한 게시글만 수정 가능합니다.)\n");
			System.out.print("게시글 번호(No.): ");
			choice=sc.nextInt();
			dtos2 = service2.getTitle(choice);

			if(dtos2.get(0).getWriterId().equals(login)) {
				
				
				System.out.print("수정할 제목: ");
				title=sc.nextLine();// 버퍼 클리어
				title=sc.nextLine();
				System.out.print("수정할 내용: ");
				content=sc.nextLine();
				
				
				
				dtos2 = service2.EditForum(title,content,choice);
				System.out.print("수정 완료\n");
			}
			else
				System.out.print("**현재 로그인한 계정으로 작성된 게시글이 아닙니다.**\n");
			page=0;
			break;
			
			
			
		case 8:
			page--;
			
			
			
			dtos2 = service2.getAllTitle();
			if(page<=0){
				page=0;
				System.out.printf("\n** 첫 페이지입니다. **\n\n");
			}else {
				
				System.out.printf("No.  ---------제 목---------      ---작성자---     상 태\n",page);
				System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
				for(int i=0; i< 5;i++) {
					dtos = service.getMembers(dtos2.get(i+(page*5)).getWriterId());
					state="";
					if(dtos2.get(i+(page*5)).getSoldOut()==1)
							state="판매완료";
					else if(dtos.get(0).getSellCnt()>=5)
						state="★우수회원";
					if(i+(page*5)<dtos2.size()) {
					System.out.printf("%-5d%-20s\t%11s%9s \n",dtos2.get(i+(page*5)).getNo(),dtos2.get(i+(page*5)).getTitle(), dtos2.get(i+(page*5)).getWriterId(),state);
					}else {
						System.out.println();
					}
					System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");	
				
				}
			
					System.out.printf("<<<(8){%dpage}              {%dpage}               {%dpage}(9)>>>\n",page-1,page,page+1);

			}
			
			break;
			
			
			
			
			
		case 9:
			page++;
			
			
			
			dtos2 = service2.getAllTitle();
			if(page*5>=dtos2.size()){
				page--;
				System.out.printf("\n** 이미 마지막 페이지입니다. **\n\n");
			}
				
			System.out.printf("No.  ---------제 목---------      ---작성자---     상 태\n",page);
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			for(int i=0; i< 5;i++) {
				
				state="";

				if(i+(page*5)<dtos2.size()) {
					dtos = service.getMembers(dtos2.get(i+(page*5)).getWriterId());
					if(dtos2.get(i+(page*5)).getSoldOut()==1)
						state="판매완료";
					else if(dtos.get(0).getSellCnt()>=5)
						state="★우수회원";
				System.out.printf("%-5d%-20s\t%11s%9s \n",dtos2.get(i+(page*5)).getNo(),dtos2.get(i+(page*5)).getTitle(), dtos2.get(i+(page*5)).getWriterId(),state);
				}else {
					System.out.println("");
				}
				System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			}
			if((page+1)*5<dtos2.size()) {
				System.out.printf("<<<(8){%dpage}              {%dpage}               {%dpage}(9)>>>\n",page-1,page,page+1);
			}else {
				System.out.printf("<<<(8){%dpage}              {%dpage}                 \n",page-1,page);

			}
			
			break;
			
		
		
			

		}
		return page;
		
	
		
	}
	


	
	
	
}