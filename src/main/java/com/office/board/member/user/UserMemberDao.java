package com.office.board.member.user;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.office.board.member.IMemberDao;
import com.office.board.member.admin.AdminMemberDto;

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

	/**
	 * u_no에 해당하는 멤버의 u_phone 변경
	 */
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
	
	/**
	 * UserMemberDao에서는 사용할 필요 없음. 무조건 DB_CONNECTION_FAIL(-1)반환
	 */
	@Override
	public int updateMemberApproval(UserMemberDto userMemberDto) {
		System.out.println(CLASS_NAME.concat("updateMemberApproval()"));
		
		return DB_CONNECTION_FAIL;
	}

	@Override
	public boolean isExists(String memberId) {
		System.out.println(CLASS_NAME.concat("isExists()"));
		
		String sql = "SELECT EXISTS (SELECT 1 FROM tbl_user WHERE u_id = ?)";
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

		String sql = "SELECT EXISTS (SELECT 1 FROM tbl_user WHERE u_no = ?)";
		Boolean isMemberExists = false; 
				
		try {
			isMemberExists = jdbcTemplate.queryForObject(sql, Boolean.class, memberNo);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return isMemberExists;
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

	/**
	 * u_id가 %keyword%조건에 걸리는 멤버들 반환
	 */
	@Override
	public List<UserMemberDto> selectMembersByKeywordOfId(String keyword) {
		System.out.println(CLASS_NAME.concat("selectMembersByKeywordOfId()"));
		
		String sql = "SELECT * FROM tbl_user WHERE u_id LIKE ?";
		List<UserMemberDto> userMemberDtos = null;
		
		try {
			userMemberDtos = jdbcTemplate.query(
					sql, 
					BeanPropertyRowMapper.newInstance(UserMemberDto.class),
					"%" + keyword + "%"
			);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return userMemberDtos;
	}
	
	@Override
	public List<UserMemberDto> selectAllMembers() {
		System.out.println(CLASS_NAME.concat("selectAllMembers()"));
		
		String sql = "SELECT * FROM tbl_user";
		List<UserMemberDto> userMemberDtos = null;
		
		try {
			userMemberDtos = jdbcTemplate.query(
					sql, 
					BeanPropertyRowMapper.newInstance(UserMemberDto.class)
			);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return userMemberDtos;
	}
	
	@Override
	public void printDto(UserMemberDto dto) {
		System.out.println(CLASS_NAME.concat("printDto()"));
		
		System.out.println("a_no: " + dto.getU_no());
		System.out.println("a_id: " + dto.getU_id());
		System.out.println("a_pw: " + dto.getU_pw());
		System.out.println("a_phone: " + dto.getU_phone());
		System.out.println("a_mod_date: " + dto.getU_mod_date());
	}

	@Override
	public void printDtos(List<UserMemberDto> dtos) {
		System.out.println(CLASS_NAME.concat("printDtos()"));
		
		for(UserMemberDto dto : dtos) {
			printDto(dto);
		}
	}
	
}
