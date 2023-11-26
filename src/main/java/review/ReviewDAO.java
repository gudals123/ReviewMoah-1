package review;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReviewDAO {

	private Connection conn;
	private ResultSet rs;
	
	public ReviewDAO() {
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
	
	public String getDate() {	//날짜 받아옴
		String SQL = "SELECT NOW()";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ""; //DB오류
	}
	
	public int getNext() {	//
		String SQL = "SELECT reviewID FROM review ORDER BY reviewID DESC";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1) + 1;
			}
			return 1; // 첫번째 리뷰인 경우
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1; //DB오류
	}
	
	public int write(String movieName, String userID, String reviewContent) {
		String SQL = "INSERT INTO review VALUES (?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, getNext());			//reviewID
			pstmt.setString(2, userID);			//userID
			pstmt.setString(3, reviewContent);	//reviewContent
			pstmt.setString(4, movieName);		//movieName
			pstmt.setString(5, null);			//movieIMG
			pstmt.setString(6, getDate());		//reviewDATE
			pstmt.setInt(7, 1);					//reviewAvailable
			return pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1; //DB오류
	}
	
}
