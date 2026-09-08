package com.office.board.member.user;

import org.springframework.stereotype.Repository;
import lombok.Data;

@Data
@Repository
public class UserMemberDto {

	private int u_no;
	private String u_id;
	private String u_pw;	
	private String u_phone;
	private String u_reg_date;
	private String u_mod_date;

}
