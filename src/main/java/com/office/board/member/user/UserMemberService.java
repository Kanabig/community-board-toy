package com.office.board.member.user; 


import org.springframework.security.crypto.password.PasswordEncoder; 
// 비밀번호 암호화

import org.springframework.stereotype.Service; 
// Service Bean 등록

import lombok.Data; 
// Getter, Setter 등 자동 생성

import lombok.RequiredArgsConstructor; 



@Data
@Service
@RequiredArgsConstructor
public class UserMemberService { 



	final private String CLASS_NAME = "[UserMemberService] "; 
	
	final static public int USER_ACCOUNT_ALREADY_EXIST		= 0;
	final static public int USER_ACCOUNT_CREATE_SUCCESS		= 1;
	final static public int USER_ACCOUNT_CREATE_FAIL		= -1;
	
	
	final private UserMemberDao userMemberDao; 
	final private PasswordEncoder passwordEncoder; 
	
	 
	public int createAccountConfirm(UserMemberDto userMemberDto) { 
	
		System.out.println(CLASS_NAME.concat("createAccountConfirm()")); 

		 
		boolean isMember = userMemberDao.isUserMember(userMemberDto.getU_id()); 

			 
		if (!isMember) { 
	
			 
			String encodedpassword = passwordEncoder.encode(userMemberDto.getU_pw()); 
		

			userMemberDto.setU_pw(encodedpassword); 
			
			 
			int result = userMemberDao.insertMember(userMemberDto); 
		
			 
			if (result > 0) 
				return USER_ACCOUNT_CREATE_SUCCESS;
			 
			else 
				return USER_ACCOUNT_CREATE_FAIL; 
		 
		} else { 
			return USER_ACCOUNT_ALREADY_EXIST; 
		} 
	 
	}

	public String loginConfirm(UserMemberDto userMemberDto) {
		System.out.println(CLASS_NAME.concat("loginConfirm()"));
		
		UserMemberDto selectedUserMemberDto =
				 userMemberDao.selectUser(userMemberDto.getU_id());
		
		if (selectedUserMemberDto != null) {
			if (passwordEncoder.matches(userMemberDto.getU_pw(), selectedUserMemberDto.getU_pw())) {
				System.out.println(CLASS_NAME.concat("로그인 성공!!"));
				return selectedUserMemberDto.getU_id();
				
			}
			
			System.out.println(CLASS_NAME.concat("로그인 실패!!"));
			return null;
			
		}
		
		System.out.println(CLASS_NAME.concat("로그인 실패!!"));
		return null;
	} 

}