package service;

import java.util.ArrayList;

import dao.MartDAO;
import dto.MartVO;

public class MartService {
	private MartDAO dao;
	
	public MartService() {
		dao = new MartDAO();
	}
	
	public ArrayList<MartVO> getAllMenu(){
		return dao.getAllMenu();
	}
	
	public ArrayList<MartVO> getSelectMenu(String part){
		return dao.getSelectMenu(part);
	}
	
}
