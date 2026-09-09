package com.office.board.member.admin;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminMemberDto {

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
}
