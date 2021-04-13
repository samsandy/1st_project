package mbti_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import score_vo.MemberVO;

public class UserDAO extends DBConn{
	
	
	/** 로그인 처리 **/
	public boolean getLoginResult(String id, String pass) {
		boolean result = false;
		
		try {
			String sql = " SELECT COUNT(*) FROM SCORE_MEMBER " + 
					" WHERE ID=? AND PASS=?";
			getPreparedStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				if(rs.getInt(1) == 1) result = true;
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	/** 회원가입 처리  **/
	public boolean getJoinResult(UserVO user) {
		boolean result = false;
				
		try {
			String sql = "insert into score_member values(?,?,?,?,?,?,sysdate)";
			getPreparedStatement(sql);
			
			String hp = user.getHp1()+"-"+user.getHp2()+"-"+user.getHp3();
			String addr = user.getAddr1()+" " + user.getAddr2();
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPass());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, hp);
			pstmt.setString(6, addr);
			
			int val = pstmt.executeUpdate();
			if(val != 0) result = true;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	
	
}












