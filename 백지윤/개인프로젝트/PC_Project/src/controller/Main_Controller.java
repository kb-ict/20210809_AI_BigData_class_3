package controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import dto.MemberVO;
import dto.PcVO;
import service.MemberService;
import service.PcService;

public class Main_Controller {

	public static void main(String[] args) {
		int choice = 0;
		int subChoice = 0;
		String id = "";
		String pw = "";
		String name = "";
		boolean check = false;
		String loginId = "";
		ArrayList<MemberVO> dtos;
		ArrayList<PcVO> dtos2;
		MemberService service = new MemberService();
		PcService service2 = new PcService();
		Scanner sc = new Scanner(System.in);

		System.out.println("��                               ��");
		System.out.println("           PC�� ���α׷� ");
		System.out.println("��                               ��");

		while (true) {
			Menu();
			choice = sc.nextInt();
			if (choice == 0) {
				break;
			}
			switch (choice) {
			case 1:
				// ȸ������
				dtos = service.getAllMember();
				check = false;
				System.out.print("����� ���̵� �Է� >>");
				id = sc.next();
				for (int i = 0; i < dtos.size(); i++) {
					if (dtos.get(i).getID().equals(id)) {
						check = true; // �ߺ��� id��� true�� �ٲ��
					}
				}
				if (check == true) {
					System.out.println("���� ������� ���̵��Դϴ�.\n�ٸ����̵� �Է����ּ���.");
					break;
				} else {
					System.out.print("����� pw �Է� >>");
					pw = sc.next();
					System.out.print("�̸� �Է� >>");
					name = sc.next();
					dtos = service.insertMember(id, pw, name);
				}
				break;
			case 2:
				// ���̵�, ��й�ȣã��
				int findInfo = 0;
				System.out.println("1.���̵�ã��");
				System.out.println("2.��й�ȣã��");
				findInfo = sc.nextInt();
				dtos = service.getAllMember();
				if (findInfo == 1) {
					System.out.print("ã������ ���̵��� �̸� �Է� >>");
					name = sc.next();
					for (int i = 0; i < dtos.size(); i++) {
						if (dtos.get(i).getName().equals(name)) {
							System.out.print("���̵�� [" + dtos.get(i).getID() + "] �Դϴ�.");
							System.out.println();
						}
					}
				} else if (findInfo == 2) {
					System.out.print("���̵� �Է� >>");
					id = sc.next();
					for (int i = 0; i < dtos.size(); i++) {
						if (dtos.get(i).getID().equals(id)) {
							System.out.print("��й�ȣ�� [" + dtos.get(i).getPW() + "] �Դϴ�.");
							System.out.println();
						}
					}
				}
				break;
			case 3:
				loginId = "";
				check = false;
				int useSeat = 0;
				dtos = service.getAllMember();
				System.out.print("���̵� �Է� >>");
				id = sc.next();
				for (int i = 0; i < dtos.size(); i++) {
					if (dtos.get(i).getID().equals(id)) {
						loginId = id; // loginId�� id����
						System.out.print("��й�ȣ �Է� >>");
						pw = sc.next();
						check = true; // ���̵� �ߺ����� üũ
						if (dtos.get(i).getPW().equals(pw)) {
							System.out.println("�α��οϷ�!");
						}
					}
				}
				if (check = false) {
					System.out.println("���̵� �ٽ� Ȯ�����ּ���.");
					break;
				}
				while (true) {
					subMenu();
					subChoice = sc.nextInt();
					if (subChoice == 0) {
						break; // �α׾ƿ�
					}
					switch (subChoice) {
					case 1:
						// ȸ�� ����
						System.out.println(" ----- ȸ�� ���� ���� ----- ");
						for (int i = 0; i < dtos.size(); i++) {
							if (dtos.get(i).getID().equals(loginId)) {
								System.out.println("���̵�: " + dtos.get(i).getID());
								System.out.println("��й�ȣ: " + dtos.get(i).getPW());
								System.out.println("�̸�: " + dtos.get(i).getName());
								if (dtos.get(i).getRemainTime() != null) {
									System.out.println("�����ð� " + dtos.get(i).getRemainTime().substring(11, 19));
								} else {
									System.out.println("�����ð��� 0���Դϴ�.");
								}
							}
						}
						break;
					case 2:
						// �¼� ��Ȳ
						int seat = 0;
						dtos2 = service2.getAllPcInfo();
						for (int i = 0; i < dtos2.size(); i++) {
							seat = dtos2.get(i).getSeat();
							if (i % 5 == 0) { // �ܼ�â �ٹٲ�
								System.out.println();
								System.out.println(" ---  ---  ---  ---  ---  ");
							}
							if (dtos2.get(i).getID() != null) { // pc �¼��� ������̶�� *���
								System.out.print(" |* |");
							} else {
								if (i < 9) {
									System.out.print(" |" + seat + " |");
								} else {
									System.out.print(" |" + seat + "|");
								}
							}

						}
						System.out.println();
						break;
					case 3:
						check = false;
						// �¼����� �� ���
						dtos2 = service2.getAllPcInfo();
						seat = 0;
						int input_Time = 0;
						System.out.println(" ������������������������������������������������");
						System.out.println("      1 �ð� 1OOO��      ");
						System.out.println("      6 �ð� 5OOO��      ");
						System.out.println("      1O�ð� 8OOO��      ");
						System.out.println(" ������������������������������������������������");
						System.out.print("�¼� ��ȣ �Է� >>");
						seat = sc.nextInt();
						for (int i = 0; i < dtos2.size(); i++) {
							if (dtos2.get(i).getSeat() == seat) {
								if (dtos2.get(i).getID() != null) {
									System.out.println("���� ������� �ڸ��Դϴ�.");
									System.out.println("�ٸ� �¼��� �������ּ���.");
									check = true;
									break;
								}
							}
						}
						if (check == true) {
							break;
						}

						useSeat = seat;
						System.out.print("���� �ð� �Է� >>");
						input_Time = sc.nextInt();
						System.out.println();
						int remainHour = 0;
						int remainMinute = 0;
						int remainSecond = 0;
						LocalDateTime now = LocalDateTime.now(); // ���� ��¥,�ð�
						String fmNow = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

						int nowHour = now.getHour(); // ���� ��(Hour)�� ����
						int nowMinute = now.getMinute();
						int nowSecond = now.getSecond();
						int nowDay = now.getDayOfMonth();

						for (int i = 0; i < dtos.size(); i++) {
							if (dtos.get(i).getID().equals(loginId)) {
								if (dtos.get(i).getRemainTime() != null) { // �α��� id�� �ܿ��ð��� �ִٸ�
									String rmHour = dtos.get(i).getRemainTime().substring(11, 13);
									String rmMinute = dtos.get(i).getRemainTime().substring(14, 16);
									String rmSecond = dtos.get(i).getRemainTime().substring(17, 19);

									System.out
											.println("�ܿ��ð��� " + rmHour + "�ð� " + rmMinute + "�� " + rmSecond + "�� �Դϴ�.");

									remainHour = Integer.parseInt(rmHour);
									remainMinute = Integer.parseInt(rmMinute);
									remainSecond = Integer.parseInt(rmSecond);

									nowHour = nowHour + remainHour; // nowHour�� ����
									nowMinute = nowMinute + remainMinute;
									nowSecond = nowSecond + remainSecond;

									if (59 < nowMinute) {
										nowHour += 1;
										nowMinute -= 60;
									}
									if (59 < nowSecond) {
										nowMinute += 1;
										nowSecond -= 60;
									}

									break;
								}
							}
						}

						int buyHour = input_Time + nowHour;

						if (buyHour > 23) { // ����ð��� ���Žð��� �������� 24�̻��̸� ��¥�� �Ϸ�ö󰣴�.
							nowDay += 1;
							buyHour -= 24;
						}

						String endTime = buyHour + ":" + nowMinute + ":" + nowSecond;

						dtos2 = service2.UpdatePcInfo(seat, fmNow, endTime, input_Time, loginId);
						int price = 0;
						int calc_Num = input_Time;
						for (int i = 1; i <= calc_Num;) { // ��� ���
							if (calc_Num >= 10) {
								price += 8000;
								calc_Num -= 10;
							} else if (calc_Num >= 6) {
								price += 5000;
								calc_Num -= 6;
							} else {
								price += 1000;
								calc_Num -= 1;
							}
						}
						System.out.printf("���Žð��� %d�ð� �̸�, ", input_Time);
						System.out.printf("����� %d�� �Դϴ�.\n", price);

						break;
					case 4:
						// ���ð�
						String stTime = "";
						int buyTime = 0;
						String TotalrmTime = "";
						int TotalRMHour = 0;
						int TotalRMMinute = 0;
						int TotalRMSecond = 0;
						dtos2 = service2.getAllPcInfo();
						for (int i = 0; i < dtos2.size(); i++) {
							if (dtos2.get(i).getID() != null) {
								if (dtos2.get(i).getID().equals(loginId)) {
									stTime = dtos2.get(i).getStartTime();
									buyTime = dtos2.get(i).getBuyTime();
								}
							}
						}
						for (int i = 0; i < dtos.size(); i++) {
							if (dtos.get(i).getID().equals(loginId)) {
								if (dtos.get(i).getRemainTime() != null) {
									TotalrmTime = dtos.get(i).getRemainTime();
								} else {
									TotalrmTime = "2021-10-01 00:00:00";
								}
							}
						}
						String stTimeHour = stTime.substring(11, 13);
						String stTimeMinute = stTime.substring(14, 16);
						String stTimeSecond = stTime.substring(17, 19);

						String rmTimeHour = TotalrmTime.substring(11, 13);
						String rmTimeMinute = TotalrmTime.substring(14, 16);
						String rmTimeSecond = TotalrmTime.substring(17, 19);

						int stHour = Integer.parseInt(stTimeHour); // ���۽ð� String -> int
						int stMinute = Integer.parseInt(stTimeMinute);
						int stSecond = Integer.parseInt(stTimeSecond);

						int rmHour = Integer.parseInt(rmTimeHour); // �����ð� String -> int
						int rmMinute = Integer.parseInt(rmTimeMinute);
						int rmSecond = Integer.parseInt(rmTimeSecond);
						
						if(rmMinute==0) {
							rmMinute=59;
						}
						if(rmSecond==0) {
							rmSecond=60;
						}

						LocalDateTime UseNow = LocalDateTime.now();
						nowHour = UseNow.getHour(); // ���� ��(Hour)�� ����
						nowMinute = UseNow.getMinute();
						nowSecond = UseNow.getSecond();

						stHour = Math.abs(stHour - nowHour); // ���۽ð����� ����ð��� ���� ���ð� ����
						stMinute = Math.abs(stMinute - nowMinute);
						stSecond = Math.abs(stSecond - nowSecond);

						rmHour = rmHour + buyTime; // ������ �����մ� �ܿ��ð��� ���Žð��� ���Ѵ�

						TotalRMHour = Math.abs(rmHour - stHour -1); // ���� �ܿ��ð����� ���ð��� ���� ����� �����ð�
						TotalRMMinute = Math.abs(rmMinute - stMinute);
						TotalRMSecond = Math.abs(rmSecond - stSecond);

						String remainTime = TotalRMHour + ":" + TotalRMMinute + ":" + TotalRMSecond;

						System.out
								.println(loginId + "���� ���ð��� " + stHour + "�ð� " + stMinute + "�� " + stSecond + "�� �̸�,");
						System.out.println(
								"���� �ð��� " + TotalRMHour + "�ð� " + TotalRMMinute + "�� " + TotalRMSecond + "�� �Դϴ�.");
						System.out.println("������ �Ϸ�Ǿ����ϴ�. �����մϴ�.");
						dtos2 = service2.LogoutPc(useSeat);
						dtos = service.SaveTime(loginId, remainTime);
						break;
					}
				}
				break;
			case 4:
				check = false;
				System.out.print("Ż���� id �Է� >>");
				id = sc.next();
				dtos = service.getAllMember();
				for (int i = 0; i < dtos.size(); i++) {
					if (dtos.get(i).getID().equals(id)) {
						pw = sc.next();
						if (dtos.get(i).getPW().equals(pw)) {
							check = true;
						}
					}
				}
				if (check == true) {
					dtos = service.DeleteMember(id);
					System.out.println("������ �Ϸ�Ǿ����ϴ�.");
					System.out.println("�̿����ּż� �����մϴ�.");
				} else {
					System.out.println("id�� pw�� �ٽ� Ȯ�����ּ���.");
				}
				break;
			}

		}
		sc.close();
	}

	public static void Menu() {
		System.out.println();
		System.out.println("1.ȸ������");
		System.out.println("2.���̵�,��й�ȣã��");
		System.out.println("3.�α���");
		System.out.println("4.Ż��");
		System.out.println("0.����");

	}

	public static void subMenu() {
		System.out.println();
		System.out.println("1.ȸ������");
		System.out.println("2.�¼���Ȳ");
		System.out.println("3.�¼����� �� ���");
		System.out.println("4.�������");
		System.out.println("0.�α׾ƿ�");
	}
}
