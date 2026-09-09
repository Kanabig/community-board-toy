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
    			+ "WHERE cb_deleted = 0 "
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
                   + "WHERE cb_no = ? "
                   + "AND cb_deleted = 0";

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
                   + "WHERE cb_no = ? "
                   + "AND cb_deleted = 0";

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
        
        String sql = "UPDATE tbl_community_board "
                + "SET cb_deleted = 1 "
                + "WHERE cb_no = ? "
                + "AND cb_deleted = 0";

        int result = -1;

        try {
            result = jdbcTemplate.update(sql, cb_no);

        } catch (Exception e) {
            e.printStackTrace();
            
        }

        return result;
        
    }
    
    public List<CommunityBoardDto> searchBoards(String keyword) {
        System.out.println(CLASS_NAME.concat("searchBoards()"));

        String sql = "SELECT * FROM tbl_community_board "
                   + "WHERE cb_deleted = 0 "
                   + "AND (cb_title LIKE ? "
                   + "OR cb_comment LIKE ?) "
                   + "ORDER BY cb_reg_date DESC";

        List<CommunityBoardDto> communityBoardDtos = null;

        try {
            communityBoardDtos = jdbcTemplate.query(sql,
            		BeanPropertyRowMapper.newInstance(CommunityBoardDto.class), "%" + keyword + "%", "%" + keyword + "%");

        } catch (Exception e) {
            e.printStackTrace();
            
        }

        return communityBoardDtos;
        
    }

    public int selectBoardCount() {
    	System.out.println(CLASS_NAME.concat("selectBoardCount()"));

        String sql = "SELECT COUNT(*) FROM tbl_community_board "
                   + "WHERE cb_deleted = 0";

        int count = 0;

        try {
            count = jdbcTemplate.queryForObject(sql,Integer.class);

        } catch (Exception e) {
            e.printStackTrace();
            
        }

        return count;
        
    }

    public List<CommunityBoardDto> selectBoardsByPage(int page) {
        System.out.println(CLASS_NAME.concat("selectBoardsByPage()"));

        int pageSize = 10;
        int offset = (page - 1) * pageSize;

        String sql = "SELECT * FROM tbl_community_board "
                   + "WHERE cb_deleted = 0 "
                   + "ORDER BY cb_reg_date DESC "
                   + "LIMIT ?, ?";

        List<CommunityBoardDto> communityBoardDtos = null;

        try {
            communityBoardDtos = jdbcTemplate.query(sql, 
            		BeanPropertyRowMapper.newInstance(CommunityBoardDto.class), offset, pageSize);

        } catch (Exception e) {
            e.printStackTrace();
            
        }

        return communityBoardDtos;
        
    }

}
