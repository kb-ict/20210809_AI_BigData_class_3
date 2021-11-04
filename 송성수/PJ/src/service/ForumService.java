package service;

import java.util.ArrayList;

import dao.ForumDAO;
import dto.ForumVO;

public class ForumService {
	private ForumDAO dao;
	
	public ForumService(){
		dao = new ForumDAO();
	}

	public ArrayList<ForumVO> getAllTitle() {		
		return dao.getAllTitle();
	}
	
	public ArrayList<ForumVO> getTitle(int num) {		
		return dao.getTitle(num);
	}

	public ArrayList<ForumVO> UpdateSoldOut(int no) {		
		return dao.UpdateSoldOut(no);
	}
	
	
	public ArrayList<ForumVO> UpdateForum(String title, String content, String writer_id) {		
		return dao.UpdateForum( title,  content,  writer_id);
	}
	
	public ArrayList<ForumVO> EditForum(String title, String content, int num){
		return dao.EditForum( title,  content,  num);
	}
	
	
	public ArrayList<ForumVO> DeleteForum(int no){
		return dao.DeleteForum(no);
	}
	
}
