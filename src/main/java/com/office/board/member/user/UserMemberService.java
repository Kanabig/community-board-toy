package com.office.board.member.user;

import org.springframework.stereotype.Service;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Service
@RequiredArgsConstructor
public class UserMemberService {

	final private String CLASS_NAME = "[UserMemberService] ";
	
	final private UserMemberDao userMemberDao;
	
	public int createAccountConfirm(UserMemberDto userMemberDto) {
		System.out.println(CLASS_NAME.concat("createAccountConfirm()"));
		
			
			
		return 0;
	}

}
