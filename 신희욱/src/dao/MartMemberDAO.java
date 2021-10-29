package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.MartMemberVO;

public class MartMemberDAO {
	private ArrayList<MartMemberVO> dtos;
	private Connection con;
	private Statement st;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public MartMemberDAO() {
		dtos = new ArrayList<MartMemberVO>();
		try {
			String user = "system";
			String pw = "1234";
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, pw);
			st = con.createStatement();
		} catch (Exception e) {
			System.out.println("데이터베이스 연결 오류:" + e.getMessage());
		}
	}
	
	public ArrayList<MartMemberVO> getAllMembers(){
		dtos = new ArrayList<MartMemberVO>();
		String SQL = "SELECT * FROM MartMember";
		try {
			rs=st.executeQuery(SQL);
			while(rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				int point = rs.getInt("point");
				MartMemberVO VO = new MartMemberVO(id,pw,point);
				dtos.add(VO);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return dtos;
	}
	
	public ArrayList<MartMemberVO> insertMartMembers(String id, String pw) {
		String SQL = "INSERT INTO MartMember (id,pw) values (?,?)";
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
	
	public ArrayList<MartMemberVO> updateMartMembers(String id,String pw) {
		String SQL = "update MartMember set pw=? where id=? ";
		try {
			pstmt = con.prepareStatement(SQL);			
			pstmt.setString(1, pw);
			pstmt.setString(2, id);			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos;
	}
	
	public ArrayList<MartMemberVO> deleteMartMembers(String id) {
		String SQL = "delete from MartMember where id=? ";
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos;
	}
	
	public ArrayList<MartMemberVO> updatePoint(String id){
		String SQL = "update martMember set point=0 where id=?";
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