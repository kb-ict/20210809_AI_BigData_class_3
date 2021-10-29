package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.MartVO;

public class MartDAO {
	private ArrayList<MartVO> dtos2;
	private Connection con;
	private Statement st;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public MartDAO() {
		dtos2 = new ArrayList<MartVO>();
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
	
	public ArrayList<MartVO> getAllMenu(){
		dtos2 = new ArrayList<MartVO>();
		String SQL = "SELECT * FROM Mart";
		try {
			rs=st.executeQuery(SQL);
			while(rs.next()) {
				String name = rs.getString("name");
				int price = rs.getInt("price");
				int nong = rs.getInt("nong");
				int soo = rs.getInt("soo");
				int snack = rs.getInt("snack");
				int drink = rs.getInt("drink");
				
				MartVO VO2 = new MartVO(name,price,nong,soo,snack,drink);
				dtos2.add(VO2);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return dtos2;
	}
	
	public ArrayList<MartVO> getSelectMenu(String part){
		dtos2 = new ArrayList<MartVO>();
		String SQL = "SELECT * FROM Mart where "+part+"=1";
		try {
			rs=st.executeQuery(SQL);
			while(rs.next()) {
				String name = rs.getString("name");
				int price = rs.getInt("price");
				int nong = rs.getInt("nong");
				int soo = rs.getInt("soo");
				int snack = rs.getInt("snack");
				int drink = rs.getInt("drink");
				
				MartVO VO2 = new MartVO(name,price,nong,soo,snack,drink);
				dtos2.add(VO2);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return dtos2;
	}
		
}
