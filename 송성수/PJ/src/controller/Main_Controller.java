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
			if (choice == 0) { // ����
				System.out.print("***���α׷��� �����մϴ�!***\n");
				break;
			}
			
			switch(choice) {
			
			case 1:
				
				dtos = service.getAllMembers();
				System.out.print("������ ID: ");
				in = sc.next();
				stop=0;
				for (int i = 0; i < dtos.size(); i++) {
					if (dtos.get(i).getID().equals(in)) { 
						System.out.print("�̹� ������� ID�Դϴ�.\n");
						stop=1;
						break;
					}
				}
				if(stop==1)
					break;
				System.out.print("������ PW: ");
				pw = sc.next();
				dtos = service.insertMembers(in, pw);
				break;
			
			case 2: 		//�α���
				
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
					System.out.print("ID�� ��й�ȣ�� �ٽ� Ȯ�����ּ���.\n");
				}
				break;
				
				
			default:
				System.out.print("�߸��� �Է°� �Դϴ�.\n");
				break;
			
			
			
			
			}
			
			
			
			
		}
		sc.close();
		

		
	}

	public static void Menu() {
		System.out.println("-----------------------");
		System.out.println("");
		System.out.println("     �߰� �ŷ� �Խ��� ");
		System.out.println("(1)ȸ������ (2)�α��� (0)����");
		System.out.println("-----------------------");
		System.out.print("ȸ������ �Ǵ� �α����Ͽ� �Խ��ǿ� �����ϼ���.\n");

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
		
		System.out.printf("**%s�� �������!**\n\n",login);
		
		do {
			
			if(page==0) {
				System.out.printf("No.  -------�ֱ� �Խù�-------      ---�ۼ���---     �� ��\n");
				System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
			dtos2 = service2.getAllTitle();
			
			for(int i=0; i< 5 && i<dtos2.size();i++) {
				dtos = service.getMembers(dtos2.get(i+(page*5)).getWriterId());
				state="";
				if(dtos2.get(i+(page*5)).getSoldOut()==1)
					state="�ǸſϷ�";
				else if(dtos.get(0).getSellCnt()>=5)
					state="�ڿ��ȸ��";
				
				System.out.printf("%-5d%-20s\t%11s%9s \n",dtos2.get(i).getNo(),dtos2.get(i).getTitle(), dtos2.get(i).getWriterId(),state);
				System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
				}
			System.out.printf("                            {%dpage}               {%dpage}(9)>>>\n",page,page+1);
			}
			System.out.printf("**���� ID: %s**\n\n",login);
			System.out.println();
			System.out.printf("(1)�Խñ� ����\t        %s\n","(2)�ǸŰԽñ� �ۼ�");
			System.out.printf("(3)�ǸſϷ�\t        %s\n","(4)�Խñ� ����");
			System.out.printf("(5)�Խñ� ����\t        %s\n","(0)�α׾ƿ�");
			
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
			System.out.print("**�α׾ƿ��մϴ�.**\n\n");
			return -1;
			
			
		case 1:
			
			System.out.print("���� �� �Խñ� ��ȣ(No.)�� �Է��ϼ���: \n");
			choice=sc.nextInt();
			dtos2 = service2.getTitle(choice);
			System.out.printf("\n\n����: %s\n",dtos2.get(0).getTitle());
			System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
			System.out.printf("����: %s\n\n",dtos2.get(0).getContent());
			System.out.printf("                          (1){�ڷ�}               \n");
			choice=sc.nextInt();
			page=0;
			
			break;
			
			
		
		case 2:
			
			System.out.print("����: ");
			title=sc.nextLine();// ���� Ŭ����
			title=sc.nextLine();
			System.out.print("����: ");
			content=sc.nextLine();
			
			dtos2 = service2.UpdateForum(title,  content,  login);
			
			System.out.print("���ε� �Ϸ��߽��ϴ�!\n\n");
			page=0;
			break;
			
			
		case 3:
			
			System.out.print("�ǸſϷ� ǥ�� �� �Խñ��� �����ϼ���.\n");
			System.out.print("(�ڽ��� �ۼ��� �Խñ۸� ���� �����մϴ�.)\n");
			System.out.print("�Խñ� ��ȣ(No.): ");
			choice=sc.nextInt();
			dtos2 = service2.getTitle(choice);

			if(dtos2.get(0).getWriterId().equals(login)&&dtos2.get(0).getSoldOut()==0) {
				dtos2 = service2.UpdateSoldOut(choice);
				dtos = service.updateSellCnt(login);
				System.out.print("���� �Ϸ�\n");
			}else if(dtos2.get(0).getSoldOut()==1)
				System.out.print("**�̹� �Ǹ� �Ϸ�� ���ù� �Դϴ�.**\n");
			else
				System.out.print("**���� �α����� �������� �ۼ��� �Խñ��� �ƴմϴ�.**\n");
			page=0;
			break;
			
		case 4:
			
			System.out.print("���� �� �Խñ��� �����ϼ���.\n");
			System.out.print("(�ڽ��� �ۼ��� �Խñ۸� ���� �����մϴ�.)\n");
			System.out.print("�Խñ� ��ȣ(No.): ");
			choice=sc.nextInt();
			dtos2 = service2.getTitle(choice);

			if(dtos2.get(0).getWriterId().equals(login)) {
				dtos2 = service2.DeleteForum(choice);
				System.out.print("���� �Ϸ�\n");
			}
			else
				System.out.print("**���� �α����� �������� �ۼ��� �Խñ��� �ƴմϴ�.**\n");
			page=0;
			break;
		
		case 5:
			
			System.out.print("���� �� �Խñ��� �����ϼ���.\n");
			System.out.print("(�ڽ��� �ۼ��� �Խñ۸� ���� �����մϴ�.)\n");
			System.out.print("�Խñ� ��ȣ(No.): ");
			choice=sc.nextInt();
			dtos2 = service2.getTitle(choice);

			if(dtos2.get(0).getWriterId().equals(login)) {
				
				
				System.out.print("������ ����: ");
				title=sc.nextLine();// ���� Ŭ����
				title=sc.nextLine();
				System.out.print("������ ����: ");
				content=sc.nextLine();
				
				
				
				dtos2 = service2.EditForum(title,content,choice);
				System.out.print("���� �Ϸ�\n");
			}
			else
				System.out.print("**���� �α����� �������� �ۼ��� �Խñ��� �ƴմϴ�.**\n");
			page=0;
			break;
			
			
			
		case 8:
			page--;
			
			
			
			dtos2 = service2.getAllTitle();
			if(page<=0){
				page=0;
				System.out.printf("\n** ù �������Դϴ�. **\n\n");
			}else {
				
				System.out.printf("No.  ---------�� ��---------      ---�ۼ���---     �� ��\n",page);
				System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
				for(int i=0; i< 5;i++) {
					dtos = service.getMembers(dtos2.get(i+(page*5)).getWriterId());
					state="";
					if(dtos2.get(i+(page*5)).getSoldOut()==1)
							state="�ǸſϷ�";
					else if(dtos.get(0).getSellCnt()>=5)
						state="�ڿ��ȸ��";
					if(i+(page*5)<dtos2.size()) {
					System.out.printf("%-5d%-20s\t%11s%9s \n",dtos2.get(i+(page*5)).getNo(),dtos2.get(i+(page*5)).getTitle(), dtos2.get(i+(page*5)).getWriterId(),state);
					}else {
						System.out.println();
					}
					System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");	
				
				}
			
					System.out.printf("<<<(8){%dpage}              {%dpage}               {%dpage}(9)>>>\n",page-1,page,page+1);

			}
			
			break;
			
			
			
			
			
		case 9:
			page++;
			
			
			
			dtos2 = service2.getAllTitle();
			if(page*5>=dtos2.size()){
				page--;
				System.out.printf("\n** �̹� ������ �������Դϴ�. **\n\n");
			}
				
			System.out.printf("No.  ---------�� ��---------      ---�ۼ���---     �� ��\n",page);
			System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
			for(int i=0; i< 5;i++) {
				
				state="";

				if(i+(page*5)<dtos2.size()) {
					dtos = service.getMembers(dtos2.get(i+(page*5)).getWriterId());
					if(dtos2.get(i+(page*5)).getSoldOut()==1)
						state="�ǸſϷ�";
					else if(dtos.get(0).getSellCnt()>=5)
						state="�ڿ��ȸ��";
				System.out.printf("%-5d%-20s\t%11s%9s \n",dtos2.get(i+(page*5)).getNo(),dtos2.get(i+(page*5)).getTitle(), dtos2.get(i+(page*5)).getWriterId(),state);
				}else {
					System.out.println("");
				}
				System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
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