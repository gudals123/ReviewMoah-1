package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public UserDAO() {
		try {
			String dbURL = "jdbc:mysql://localhost/ReviewMoah?"
					+ "allowPublicKeyRetrieval=true&useUnicode=true&"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=UTC";
			String dbID = "gckbb";
			String dbPW = "dbfl0913@";
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPW);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public int login(String userID, String userPW) {
		String SQL = "SELECT userPW FROM USER WHERE userID = ?";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(userPW)) {
					return 1; // 로그인 성공
				}
				else
					return 0; // 비밀번호 불일치
			}
			return -1; // 아이디 없음
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -2; // DB 오류
	}
	
	public int join(User user) {
		String SQL = "INSERT INTO USER VALUES (?, ?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1,  user.getUserID());
			pstmt.setString(2,  user.getUserPW());
			pstmt.setString(3,  user.getUserName());
			pstmt.setString(4,  user.getUserIcon());
			pstmt.setString(5,  user.getUserIntro());
			return pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1; //db오류
	}
	
	public String getName(String UserID) {
		String SQL = "SELECT userName FROM USER WHERE userID = ?";
		String userName = null;
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.executeUpdate();
			int count = pstmt.executeUpdate();
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				userName = rs.getString(3);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return userName;
		}
	}
