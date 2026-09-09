package com.office.board.member.user; 
// 사용자 회원 관련 패키지

import org.springframework.security.crypto.password.PasswordEncoder; 
// 비밀번호 암호화

import org.springframework.stereotype.Service; 
// Service Bean 등록

import lombok.Data; 
// Getter, Setter 등 자동 생성

import lombok.RequiredArgsConstructor; 
// 생성자 자동 생성


@Data
@Service
@RequiredArgsConstructor
public class UserMemberService { 
// 회원 관련 비즈니스 로직 처리


	final private String CLASS_NAME = "[UserMemberService] "; 
	
	final static public int USER_ACCOUNT_ALREADY_EXIST		= 0;
	final static public int USER_ACCOUNT_CREATE_SUCCESS		= 1;
	final static public int USER_ACCOUNT_CREATE_FAIL		= -1;
	
	
	final private UserMemberDao userMemberDao; 
	final private PasswordEncoder passwordEncoder; 
	// 비밀번호 암호화 처리
	 
	public int createAccountConfirm(UserMemberDto userMemberDto) { 
	// 회원가입 처리

		System.out.println(CLASS_NAME.concat("createAccountConfirm()")); 

		 
		boolean isMember = userMemberDao.isUserMember(userMemberDto.getU_id()); 
		// 아이디 중복 확인
			 
		if (!isMember) { 
		// 중복되는 아이디가 없다면
			 
			String encodedpassword = passwordEncoder.encode(userMemberDto.getU_pw()); 
			// 비밀번호 암호화

			userMemberDto.setU_pw(encodedpassword); 
			// 암호화된 비밀번호를 DTO에 저장
			 
			int result = userMemberDao.insertMember(userMemberDto); 
			// 회원정보 DB 저장
			 
			if (result > 0) 
				return USER_ACCOUNT_CREATE_SUCCESS; // 회원가입 성공
			 
			else 
				return USER_ACCOUNT_CREATE_FAIL; // 회원가입 실패
		 
		} else { 
			return USER_ACCOUNT_ALREADY_EXIST; // 아이디 중복
		} 
	 
	}

	public String loginConfirm(UserMemberDto userMemberDto) {
		// TODO Auto-generated method stub
		return null;
	} 

}