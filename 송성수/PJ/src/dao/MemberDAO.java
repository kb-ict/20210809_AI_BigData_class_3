package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.ForumVO;
import dto.MemberVO;

public class MemberDAO {
	private ArrayList<MemberVO> dtos;
	private Connection con;
	private Statement st;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public MemberDAO() {
		dtos = new ArrayList<MemberVO>();
		try {
			String user = "system";
			String pw = "1234";
			String url = "jdbc:oracle:thin:@cyzhsss.iptime.org:1521:XE";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, pw);
			st = con.createStatement();
		} catch (Exception e) {
			System.out.println("데이터베이스 연결 오류:" + e.getMessage());
		}
	}

	public ArrayList<MemberVO> getAllMembers() {
		dtos = new ArrayList<MemberVO>();// dtos 초기화
		String SQL = "SELECT * FROM Member"; // 전체회원조회
		try {
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				int sell_cnt= rs.getInt("sell_cnt");
			
				MemberVO VO = new MemberVO(id, pw, sell_cnt);
				dtos.add(VO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos;
	}
	
	public ArrayList<MemberVO> getMembers(String login) {
		dtos = new ArrayList<MemberVO>();// dtos 초기화
		String SQL = "select * from Member where id=?"; //특정 ID출력
		try {
			pstmt=con.prepareStatement(SQL);
			pstmt.setString(1, login);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				int sell_cnt= rs.getInt("sell_cnt");
	
				MemberVO VO = new MemberVO(id, pw, sell_cnt);
				dtos.add(VO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos;
	}
	
	

	public ArrayList<MemberVO> insertMembers(String id, String pw) {
		String SQL = "INSERT INTO Member (id,pw) values (?,?)";
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			pstmt.executeUpdate();
			System.out.println("가입 완료!");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos;
	}

	public ArrayList<MemberVO> deleteMembers(String id) {
		String SQL = "delete from Member where id=? ";
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos;
	}

	public ArrayList<MemberVO> updateSellCnt(String id) {
		String SQL = "UPDATE member SET sell_cnt = sell_cnt+ 1 where id=?";
		try {
			pstmt = con.prepareStatement(SQL);			
			pstmt.setString(1, id);
		
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos;
	}

}
