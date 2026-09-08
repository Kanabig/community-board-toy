package com.office.board.member.user;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.office.board.member.IMemberDao;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserMemberDao implements IMemberDao<UserMemberDto>{
	
	private final String CLASS_NAME = "[UserMemberDao] ";
	private final int DB_CONNECTION_FAIL = -1;
	
	private final JdbcTemplate jdbcTemplate;
	
	@Override
	public int insertMember(UserMemberDto memberDto) {
		System.out.println(CLASS_NAME.concat("insertMember()"));
		
		String sql = "INSERT INTO tbl_user(u_id, u_pw, u_phone) values(?, ?, ?)";
		int result = DB_CONNECTION_FAIL;
		
		try {
			result = jdbcTemplate.update(
					sql, 
					memberDto.getU_id(), 
					memberDto.getU_pw(), 
					memberDto.getU_phone()
			);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return result;
	}

	@Override
	public int updateMember(UserMemberDto memberDto) {
		System.out.println(CLASS_NAME.concat("updateMember()"));
		
		String sql = "UPDATE tbl_user SET u_phone = ? WHERE u_no = ?";
		int result = DB_CONNECTION_FAIL;
		
		try {
			result = jdbcTemplate.update(
					sql,
					memberDto.getU_phone(),
					memberDto.getU_no()
			); 
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return result;
	}

	@Override
	public UserMemberDto selectMember(String userId) {
		System.out.println(CLASS_NAME.concat("selectMember()"));
		
		String sql = "SELECT * FROM tbl_user WHERE u_id = ?";
		List<UserMemberDto> userMemberDtos = null;
		
		try {
			userMemberDtos = jdbcTemplate.query(
					sql, 
					BeanPropertyRowMapper.newInstance(UserMemberDto.class),
					userId
			);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return userMemberDtos.size() > 0 ? userMemberDtos.get(0) : null;
	}
	
	@Override
	public UserMemberDto selectMember(int memberNo) {
		System.out.println(CLASS_NAME.concat("selectMember()"));
		
		String sql = "SELECT * FROM tbl_user WHERE u_no = ?";
		List<UserMemberDto> userMemberDtos = null;
		
		try {
			userMemberDtos = jdbcTemplate.query(
					sql, 
					BeanPropertyRowMapper.newInstance(UserMemberDto.class),
					memberNo
			);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return userMemberDtos.size() > 0 ? userMemberDtos.get(0) : null;
	}

//	@Override
//	public List<UserMemberDto> selectMembers(int memberNo) {
//		System.out.println(CLASS_NAME.concat("selectMember()"));
//		
//		String sql = "SELECT * FROM tbl_user WHERE u_no = ?";
//		List<UserMemberDto> userMemberDtos = null;
//		
//		try {
//			userMemberDtos = jdbcTemplate.query(
//					sql, 
//					BeanPropertyRowMapper.newInstance(UserMemberDto.class),
//					memberNo
//			);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			
//		}
//		
//		return userMemberDtos;
//	}
	
}
