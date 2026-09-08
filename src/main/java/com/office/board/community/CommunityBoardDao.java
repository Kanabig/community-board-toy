package com.office.board.community;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CommunityBoardDao {

	final private String CLASS_NAME = "[CommunityBoardDao] ";
	
	final private JdbcTemplate jdbcTemplate;

	public CommunityBoardDao(JdbcTemplate jdbcTemplate) {
	    this.jdbcTemplate = jdbcTemplate;
	    
	}

    public int insertBoard(CommunityBoardDto communityBoardDto) {
        System.out.println(CLASS_NAME.concat("insertBoard()"));

        String sql = "INSERT INTO "
                   + "tbl_community_board("
                   + "cb_id, "
                   + "cb_title, "
                   + "cb_comment) "
                   + "VALUES(?, ?, ?)";

        int result = -1;

        try {
        	result = jdbcTemplate.update(sql,
        			communityBoardDto.getCb_id(),
        			communityBoardDto.getCb_title(),
        			communityBoardDto.getCb_comment());
        	
        } catch (Exception e) {
        	e.printStackTrace();
            
        }

        return result;
        
    }

    public List<CommunityBoardDto> selectAllBoards() {
    	System.out.println(CLASS_NAME.concat("selectAllBoards()"));

    	String sql = "SELECT * FROM tbl_community_board "
        		+ "ORDER BY cb_no DESC";

    	List<CommunityBoardDto> communityBoardDtos = null;

    	try {
    		
    		communityBoardDtos = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(CommunityBoardDto.class));

    	} catch (Exception e) {
        	e.printStackTrace();

    	}

    	return communityBoardDtos;
    	
    }

    public CommunityBoardDto selectBoardByCbNo(int cb_no) {
        System.out.println(CLASS_NAME.concat("selectBoardByCbNo()"));

        String sql = "SELECT * FROM tbl_community_board "
                   + "WHERE cb_no = ?";

        List<CommunityBoardDto> communityBoardDtos = null;

        try {
        	
        	communityBoardDtos = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(CommunityBoardDto.class),cb_no);

        } catch (Exception e) {
        	e.printStackTrace();
        	
        }

        if (communityBoardDtos != null
        		&& communityBoardDtos.size() > 0) {

        	return communityBoardDtos.get(0);
        
        }

        return null;
        
    }

    public int updateBoard(CommunityBoardDto communityBoardDto) {

    	System.out.println(CLASS_NAME.concat("updateBoard()"));

    	String sql = "UPDATE tbl_community_board SET "
                   + "cb_title = ?, "
                   + "cb_comment = ? "
                   + "WHERE cb_no = ?";

        int result = -1;

        try {

            result = jdbcTemplate.update(sql,
                    communityBoardDto.getCb_title(),
                    communityBoardDto.getCb_comment(),
                    communityBoardDto.getCb_no());

        } catch (Exception e) {
            e.printStackTrace();
            
        }

        return result;
    }
    
    public int deleteBoard(int cb_no) {
        System.out.println(CLASS_NAME.concat("deleteBoard()"));
        
        String sql = "DELETE FROM tbl_community_board "
                   + "WHERE cb_no = ?";

        int result = -1;

        try {

            result = jdbcTemplate.update(sql, cb_no);

        } catch (Exception e) {
            e.printStackTrace();
            
        }

        return result;
        
    }

}
