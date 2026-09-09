package com.office.board.member.admin;

import lombok.Data;

import com.office.board.member.core.IAdminMemberDto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminMemberDto implements IAdminMemberDto{

	private int a_no;
	private int a_approval;
	private String a_id;
	private String a_pw;
	private String a_phone;
	private String a_reg_date;
	private String a_mod_date; 
	
	public AdminMemberDto(String a_id, String a_pw, String a_phone) {
		setA_id(a_id);
		setA_pw(a_pw);
		setA_phone(a_phone);
	}

	@Override
	public int getMemberNo() {
		return getA_no();
	}

	@Override
	public String getMemberId() {
		return getA_id();
	}

	@Override
	public String getMemberPw() {
		return getA_pw();
	}

	@Override
	public String getMemberPhone() {
		return getA_phone();
	}

	@Override
	public String getMemberRegDate() {
		return getA_reg_date();
	}

	@Override
	public String getMemberModDate() {
		return getA_mod_date();
	}

	@Override
	public int getMemberApproval() {
		return getA_approval();
	}
}
