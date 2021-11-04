package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import dto.ForumVO;
import dto.MemberVO;

public class ForumDAO {
	private ArrayList<ForumVO> dtos2;
	private Connection con;
	private Statement st;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public ForumDAO() {
		dtos2 = new ArrayList<ForumVO>();
		try {
			String user = "system";
			String pw = "1234";
			String url = "jdbc:oracle:thin:@cyzhsss.iptime.org:1521:XE";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, pw);
			st = con.createStatement();
		} catch (Exception e) {
			System.out.println("�����ͺ��̽� ���� ����:" + e.getMessage());
		}
	}

	public ArrayList<ForumVO> getAllTitle() {
		dtos2 = new ArrayList<ForumVO>();// dtos2 �ʱ�ȭ
		String SQL = "select * from forum order by no desc";//�������� ���
		try {
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				int no = rs.getInt("no");
				String title=rs.getString("title");
				String content=rs.getString("content");
				int sold_out=rs.getInt("sold_out");
				String writer_id=rs.getString("writer_id");
	
				ForumVO VO = new ForumVO(no, title, content, writer_id, sold_out);
				dtos2.add(VO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos2;
	}
	
	public ArrayList<ForumVO> getTitle(int num) {
		dtos2 = new ArrayList<ForumVO>();// dtos2 �ʱ�ȭ
		String SQL = "select * from forum where no=?";//Ư�� No.�� �Խñ� ���
		try {
			pstmt=con.prepareStatement(SQL);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int no = rs.getInt("no");
				String title=rs.getString("title");
				String content=rs.getString("content");
				int sold_out=rs.getInt("sold_out");
				String writer_id=rs.getString("writer_id");
	
				ForumVO VO = new ForumVO(no, title, content, writer_id, sold_out);
				dtos2.add(VO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos2;
	}

	public ArrayList<ForumVO> UpdateSoldOut( int no) {
		String SQL = "update forum set sold_out=1 where no=?";
		try {
			pstmt=con.prepareStatement(SQL);
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
			System.out.println("�Ǹ� �Ϸ�Ǿ����ϴ�.");
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos2;
	}
	
	
	public ArrayList<ForumVO> UpdateForum(String title, String content, String writer_id) {
		String SQL = "INSERT INTO forum (title,content,writer_id) values (?,?,?)";
		try {
			pstmt=con.prepareStatement(SQL);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, writer_id);
			pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos2;
	}
	
	public ArrayList<ForumVO> EditForum(String title, String content, int num) {
		String SQL = "update forum set title=?,content=? where no=?";
		try {
			pstmt=con.prepareStatement(SQL);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, num);
			pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos2;
	}
	
	
	
	
	public ArrayList<ForumVO> DeleteForum(int no) {
		String SQL = "delete from Forum where no=? ";
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos2;
	}
	
	
	
}
