package service;

import java.util.ArrayList;

import dao.MemberDAO;
import dto.MemberVO;

public class MemberService {
	private MemberDAO dao;

	public MemberService() {
		dao = new MemberDAO();
	}

	public ArrayList<MemberVO> getAllMembers() {

		return dao.getAllMembers();
	}
	
	public ArrayList<MemberVO> getMembers(String login) {

		return dao.getMembers(login);
	}

	public ArrayList<MemberVO> insertMembers(String id, String pw) {
		return dao.insertMembers(id,pw);
	}

	public ArrayList<MemberVO> DeleteMembers(String id) {
		return dao.deleteMembers(id);
	}

	public ArrayList<MemberVO> updateSellCnt(String id) {
		return dao.updateSellCnt(id);
	}
}
