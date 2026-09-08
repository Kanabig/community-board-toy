package com.office.board.member.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.office.board.member.IMemberDao;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class AdminMemberDao implements IMemberDao<AdminMemberDto> {
	
	private final String CLASS_NAME = "[AdminMemberDao] ";
	private final int DB_CONNECTION_FAIL = -1;;
	
	private final JdbcTemplate jdbcTemplate;
	
	@Override
	public int insertMember(AdminMemberDto memberDto) {
		System.out.println(CLASS_NAME.concat("insertMember()"));
		
		String sql = "INSERT INTO tbl_admin(a_id, a_pw, a_phone) values(?, ?, ?)";
		int result = DB_CONNECTION_FAIL;
		
		try {
			result = jdbcTemplate.update(
					sql, 
					memberDto.getA_id(), 
					memberDto.getA_pw(), 
					memberDto.getA_phone()
			);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return result;
	}
	

	@Override
	// a_no에 해당하는 계정 업데이트
	public int updateMember(AdminMemberDto memberDto) {
		System.out.println(CLASS_NAME.concat("updateMember()"));
		
		String sql = "UPDATE tbl_admin SET a_phone = ? WHERE a_no = ?";
		int result = DB_CONNECTION_FAIL;
		
		try {
			result = jdbcTemplate.update(
					sql,
					memberDto.getA_phone(),
					memberDto.getA_no()
			); 
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return result;
	}
	
	@Override
	public AdminMemberDto selectMember(String userId) {
		System.out.println(CLASS_NAME.concat("selectMember()"));
		
		String sql = "SELECT * FROM tbl_admin WHERE a_id = ?";
		List<AdminMemberDto> adminMemberDtos = new ArrayList<AdminMemberDto>();
		
		try {
			adminMemberDtos = jdbcTemplate.query(
					sql, 
					BeanPropertyRowMapper.newInstance(AdminMemberDto.class),
					userId
					);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return adminMemberDtos.size() > 0 ? adminMemberDtos.get(0) : null;
	}
	
	@Override
	public AdminMemberDto selectMember(int memberNo) {
		System.out.println(CLASS_NAME.concat("selectMember()"));
		
		String sql = "SELECT * FROM tbl_admin WHERE a_no = ?";
		List<AdminMemberDto> adminMemberDtos = new ArrayList<AdminMemberDto>();
		
		try {
			adminMemberDtos = jdbcTemplate.query(
					sql, 
					BeanPropertyRowMapper.newInstance(AdminMemberDto.class),
					memberNo
					);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return adminMemberDtos.size() > 0 ? adminMemberDtos.get(0) : null;
	}
	
//	@Override
//	public List<AdminMemberDto> selectMembers(int memberNo) {
//		System.out.println(CLASS_NAME.concat("selectMember()"));
//		
//		String sql = "SELECT * FROM tbl_admin WHERE a_no = ?";
//		List<AdminMemberDto> adminMemberDtos = null;
//		
//		try {
//			adminMemberDtos = jdbcTemplate.query(
//					sql, 
//					BeanPropertyRowMapper.newInstance(AdminMemberDto.class),
//					memberNo
//			);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			
//		}
//		
//		return adminMemberDtos;
//	}
	
}
