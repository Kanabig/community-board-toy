package com.office.board.member.admin;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminMemberService {

	final private String CLASS_NAME = "[AdminMemberService] ";
	
	final static public int ADMIN_ACCOUNT_ALREADY_EXIST 	= 0;
	final static public int ADMIN_ACCOUNT_CREATE_SUCEESS 	= 1;
	final static public int ADMIN_ACCOUNT_CREATE_FAIL 		= -1;
	
//	final private AdminMemberDao adminMemberDao;
	final private PasswordEncoder passwordEncoder;
	
	
	public int createAccountConfirm(AdminMemberDto adminMemberDto) {
		System.out.println(CLASS_NAME.concat("createAccountConfirm()"));
		
		boolean isMember = adminMemberDao.isAdminMember(adminMemberDto.getA_id());
		System.out.println(CLASS_NAME.concat("isMember" + isMember));
		
		if (!isMember) {
			String encodedPassword = passwordEncoder.encode(adminMemberDto.getA_pw());
			adminMemberDto.setA_pw(encodedPassword);
			
			int result = adminMemberDao.insertMember(adminMemberDto);
			
			if (result > 0) {
				System.out.println(CLASS_NAME.concat("ADMIN ACCOUNT CREATE SUCEESS"));
				return ADMIN_ACCOUNT_CREATE_SUCEESS;
			
			} else {
				System.out.println(CLASS_NAME.concat("ADMIN ACCOUNT CREATE FAIL"));
				return ADMIN_ACCOUNT_CREATE_FAIL;
				
			}
		} else {
			System.out.println(CLASS_NAME.concat("ADMIN ACCOUNT CREATE FAIL"));
			return ADMIN_ACCOUNT_ALREADY_EXIST;
		
		}
	}


	public String loginConfirm(AdminMemberDto adminMemberDto) {
		System.out.println(CLASS_NAME.concat("loginConfirm()"));
		
		AdminMemberDto selectAdminMemberDto = adminMemberDao.selectAdmin(adminMemberDto.getA_id());
		
		if (selectAdminMemberDto != null) {
			
			if (passwordEncoder.matches(adminMemberDto.getA_pw(), selectAdminMemberDto.getA_pw())) {
				System.out.println(CLASS_NAME.concat("ADMIN LOGIN SUCCESS"));
				return selectAdminMemberDto.getA_id();
				
			} else {
				System.out.println(CLASS_NAME.concat("ADMIN LOGIN FAIL"));
				return null;
			}
		} else {
			System.out.println(CLASS_NAME.concat("ADMIN LOGIN FAIL"));
			return null;
		}
	}
	
	

}
