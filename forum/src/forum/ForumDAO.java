package forum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ForumDAO {
	
	private Connection conn;
	private ResultSet rs;
	
	public ForumDAO() {
		try {
			String dbURL = "jdbc:mysql://localhost:3306/forum?serverTimezone=UTC";
			String dbId = "root";
			String dbPassword = "OEWnFKI_85I2s";
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbId, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getDate() {
		String SQL = "SELECT NOW()";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ""; // 데이터베이스 오류
	}
	
	public int getNext() {
		String SQL = "SELECT forumId FROM forum ORDER BY forumId DESC";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1) +1;
			}
			return 1; // 첫 번째 게시물인 경우
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // 데이터베이스 오류
	}
	
	public int write(String forumTitle, String userId, String forumContent) {
		String SQL = "INSERT INTO forum VALUES(?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, getNext());
			pstmt.setString(2, forumTitle);
			pstmt.setString(3, userId);
			pstmt.setString(4, getDate());
			pstmt.setString(5, forumContent);
			pstmt.setInt(6, 1);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // 데이터베이스 오류
	}
	
	public ArrayList<Forum> getList(int pageNumber) {
		String SQL = "SELECT * FROM FORUM WHERE forumId < ? AND forumAvailable = 1 ORDER BY forumId DESC LIMIT 10";
		ArrayList<Forum> list = new ArrayList<Forum>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, getNext() - (pageNumber -1) *10);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Forum forum = new Forum();
				forum.setForumId(rs.getInt(1));
				forum.setForumTitle(rs.getString(2));
				forum.setUserId(rs.getString(3));
				forum.setForumDate(rs.getString(4));
				forum.setForumContent(rs.getString(5));
				forum.setForumAvailable(rs.getInt(6));
				list.add(forum);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean nextPage(int pageNumber) {
		String SQL = "SELECT * FROM FORUM WHERE forumId < ? AND forumAvailable = 1";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, getNext() - (pageNumber -1) *10);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Forum getForum(int forumId) {
		String SQL = "SELECT * FROM FORUM WHERE forumId = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, forumId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Forum forum = new Forum();
				forum.setForumId(rs.getInt(1));
				forum.setForumTitle(rs.getString(2));
				forum.setUserId(rs.getString(3));
				forum.setForumDate(rs.getString(4));
				forum.setForumContent(rs.getString(5));
				forum.setForumAvailable(rs.getInt(6));
				return forum;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int update(int forumId, String forumTitle, String forumContent) {
		String SQL = "UPDATE forum SET forumTitle=?, forumContent=? WHERE forumId=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, forumTitle);
			pstmt.setString(2, forumContent);
			pstmt.setInt(3, forumId);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // 데이터베이스 오류
	}
	
	public int delete(int forumId) {
		String SQL = "UPDATE forum SET forumAvailable=0 WHERE forumId=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, forumId);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // 데이터베이스 오류
	}
}
