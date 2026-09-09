package com.office.board.member.user;

import com.office.board.member.core.IMemberDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserMemberDto implements IMemberDto{
	
	private int u_no;
	private String u_id;
	private String u_pw;
	private String u_phone;
	private String u_reg_date;
	private String u_mod_date; 
	
	public UserMemberDto(String u_id, String u_pw, String u_phone) {
		setU_id(u_id);
		setU_pw(u_pw);
		setU_phone(u_phone);
	}

	@Override
	public int getMemberNo() {
		return getU_no();
	}

	@Override
	public String getMemberId() {
		return getU_id();
	}

	@Override
	public String getMemberPw() {
		return getU_pw();
	}

	@Override
	public String getMemberPhone() {
		return getU_phone();
	}

	@Override
	public String getMemberRegDate() {
		return getU_reg_date();
	}

	@Override
	public String getMemberModDate() {
		return getU_mod_date();
	}
	
}
