package service;

import java.util.ArrayList;

import dao.MartMemberDAO;
import dto.MartMemberVO;

public class MartMemberService {
	private MartMemberDAO dao;
	
	public MartMemberService() {
		dao = new MartMemberDAO();
	}
	
	public ArrayList<MartMemberVO> getAllMembers() {

		return dao.getAllMembers();
	}
	
	public ArrayList<MartMemberVO> insertMartMembers(String id, String pw) {
		return dao.insertMartMembers(id,pw);
	}
	
	public ArrayList<MartMemberVO> updateMartMembers(String id, String pw) {
		return dao.updateMartMembers(id,pw);
	}
	
	public ArrayList<MartMemberVO> deleteMartMembers(String id) {
		return dao.deleteMartMembers(id);
	}
	
	public ArrayList<MartMemberVO> updatePoint(String id) {
		return dao.updatePoint(id);
	}
}