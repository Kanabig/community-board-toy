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
	private final int DB_CONNECTION_FAIL = -1;
	
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
	
	/**
	 * a_no에 해당하는 멤버의 a_phone 변경
	 */
	@Override
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

	/**
	 * a_no에 해당하는 멤버의 a_approval을 변경
	 */
	@Override
	public int updateMemberApproval(AdminMemberDto adminMemberDto) {
		System.out.println(CLASS_NAME.concat("updateMemberApproval()"));
		
		String sql = "UPDATE tbl_admin SET a_approval = ? WHERE a_no = ?";
		int result = DB_CONNECTION_FAIL;

		try {
			result = jdbcTemplate.update(
					sql,
					adminMemberDto.getA_approval(),
					adminMemberDto.getA_no()
			); 
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return result;
	}
	
	@Override
	public boolean isExists(String memberId) {
		System.out.println(CLASS_NAME.concat("isExists()"));
		
		String sql = "SELECT EXISTS (SELECT 1 FROM tbl_admin WHERE a_id = ?)";
		Boolean isMemberExists = false; 
				
		try {
			isMemberExists = jdbcTemplate.queryForObject(sql, Boolean.class, memberId);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return isMemberExists;
	}

	@Override
	public boolean isExists(int memberNo) {
		System.out.println(CLASS_NAME.concat("isExists()"));

		String sql = "SELECT EXISTS (SELECT 1 FROM tbl_admin WHERE a_no = ?)";
		Boolean isMemberExists = false; 
				
		try {
			isMemberExists = jdbcTemplate.queryForObject(sql, Boolean.class, memberNo);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return isMemberExists;
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
	
	/**
	 * a_id가 %keyword%조건에 걸리는 멤버들 반환
	 */
	@Override
	public List<AdminMemberDto> selectMembersByKeywordOfId(String keyword) {
		System.out.println(CLASS_NAME.concat("selectMemberByKeywordOfId()"));
		
		String sql = "SELECT * FROM tbl_admin WHERE a_id LIKE ?";
		List<AdminMemberDto> adminMemberDtos = null;
		
		try {
			adminMemberDtos = jdbcTemplate.query(
					sql, 
					BeanPropertyRowMapper.newInstance(AdminMemberDto.class),
					"%" + keyword + "%"
			);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return adminMemberDtos;
	}
	
	@Override
	public List<AdminMemberDto> selectAllMembers() {
		System.out.println(CLASS_NAME.concat("selectAllMembers()"));
		
		String sql = "SELECT * FROM tbl_admin";
		List<AdminMemberDto> adminMemberDtos = null;
		
		try {
			adminMemberDtos = jdbcTemplate.query(
					sql, 
					BeanPropertyRowMapper.newInstance(AdminMemberDto.class)
			);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return adminMemberDtos;
	}


	@Override
	public void printDto(AdminMemberDto dto) {
		System.out.println(CLASS_NAME.concat("printDto()"));

		System.out.println("a_no: " + dto.getA_no());
		System.out.println("a_id: " + dto.getA_id());
		System.out.println("a_pw: " + dto.getA_pw());
		System.out.println("a_phone: " + dto.getA_phone());
		System.out.println("a_mod_date: " + dto.getA_mod_date());
	}


	@Override
	public void printDtos(List<AdminMemberDto> dtos) {
		System.out.println(CLASS_NAME.concat("printDtos()"));
		
		for(AdminMemberDto dto : dtos) {
			printDto(dto);
		}
	}

}
