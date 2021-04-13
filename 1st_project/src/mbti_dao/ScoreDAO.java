package mbti_dao;

import java.util.ArrayList;

import score_vo.ScoreVO;

public class ScoreDAO extends DBConn{
	
	/** 등록 **/
	public boolean getInsertResult(ScoreVO score) {
		boolean result = false;

		try {
			String sql = "insert into score_data values(?,?,?,?,sysdate)";
			getPreparedStatement(sql);
			
			pstmt.setString(1, score.getName());
			pstmt.setInt(2, score.getKor());
			pstmt.setInt(3, score.getEng());
			pstmt.setInt(4, score.getMath());
			
			int val = pstmt.executeUpdate();
			if(val !=0) result = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	/** 조회 **/
	public ArrayList<ScoreVO> getSelectResult(){
		ArrayList<ScoreVO> list = new ArrayList<ScoreVO>();
		
		try {
			String sql = " select rownum rno, name, kor, eng, math " + 
					" from (select name, kor, eng, math " + 
					"          from score_data" + 
					"          order by sdate desc)";
			getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ScoreVO score = new ScoreVO();
				score.setRno(rs.getInt(1));
				score.setName(rs.getString(2));
				score.setKor(rs.getInt(3));
				score.setEng(rs.getInt(4));
				score.setMath(rs.getInt(5));
				
				list.add(score);
			}			
					
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	/** 검색 **/
	public ScoreVO getSelectResult(String name){
		ScoreVO score = new ScoreVO();
		try {
			String sql = " select rownum rno, name, kor, eng,math " 
					+ " from score_data "
					+ " where name=?";
			getPreparedStatement(sql);
			pstmt.setString(1, name);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				score.setRno(rs.getInt(1));
				score.setName(rs.getString(2));
				score.setKor(rs.getInt(3));
				score.setEng(rs.getInt(4));
				score.setMath(rs.getInt(5));				
			}		
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return score;
	}
	
	
	
	/** 수정 **/
	public int getUpdateResult(ScoreVO score, String name) {
		int result = 0;
		
		try {
			String sql = " update score_data "
					+ " set name = ?, kor=?, eng=?, math=? "
					+ " where name =?";
			getPreparedStatement(sql);
			
			pstmt.setString(1, score.getName());
			pstmt.setInt(2, score.getKor());
			pstmt.setInt(3, score.getEng());
			pstmt.setInt(4, score.getMath());
			pstmt.setString(5, name);
			
			result = pstmt.executeUpdate();			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;		
	}
	
	
	/** 삭제 **/
	public boolean getDeleteResult(String name) {
		boolean result = false;
		
		try {
			String sql = "delete from score_data where name=?";
			getPreparedStatement(sql);
			
			pstmt.setString(1, name);
			int val = pstmt.executeUpdate();
			if(val != 0) result = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}
















