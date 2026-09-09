package com.office.board.member.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserMemberDto {
	
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
	
}
