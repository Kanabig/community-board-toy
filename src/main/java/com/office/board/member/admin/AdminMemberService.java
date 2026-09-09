package com.office.board.member.admin;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.office.board.community.CommunityBoardDao;
import com.office.board.member.user.UserMemberDao;
import com.office.board.member.user.UserMemberDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminMemberService {

	final private String CLASS_NAME = "[AdminMemberService] ";
	
	final static public int ADMIN_ACCOUNT_ALREADY_EXIST 	= 0;
	final static public int ADMIN_ACCOUNT_CREATE_SUCEESS 	= 1;
	final static public int ADMIN_ACCOUNT_CREATE_FAIL 		= -1;
	
	final private AdminMemberDao adminMemberDao;
	final private CommunityBoardDao communityBoardDao;
	final private UserMemberDao userMemberDao;
	final private PasswordEncoder passwordEncoder;
	
	
	public int createAccountConfirm(AdminMemberDto adminMemberDto) {
		System.out.println(CLASS_NAME.concat("createAccountConfirm()"));
		
		/*
		boolean isMember = adminMemberDao.isAdminMember(adminMemberDto.getA_id());
		System.out.println(CLASS_NAME.concat("isMember" + isMember));
		
		if (!isMember) {
			String encodedPassword = passwordEncoder.encode(adminMemberDto.getA_pw());
			adminMemberDto.setA_pw(encodedPassword);
			*/
		
			int result = adminMemberDao.insertMember(adminMemberDto);
			
			if (result > 0) {
				System.out.println(CLASS_NAME.concat("ADMIN ACCOUNT CREATE SUCEESS"));
				return ADMIN_ACCOUNT_CREATE_SUCEESS;
			
			} else {
				System.out.println(CLASS_NAME.concat("ADMIN ACCOUNT CREATE FAIL"));
				return ADMIN_ACCOUNT_CREATE_FAIL;
				
			}
		/*	
		} else {
			System.out.println(CLASS_NAME.concat("ADMIN ACCOUNT CREATE FAIL"));
			return ADMIN_ACCOUNT_ALREADY_EXIST;
		
		}
		*/
	}


	public String loginConfirm(AdminMemberDto adminMemberDto) {
		System.out.println(CLASS_NAME.concat("loginConfirm()"));
		
		AdminMemberDto selectAdminMemberDto = adminMemberDao.selectMember(adminMemberDto.getA_id());
		
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


	public List<AdminMemberDto> listupAdminMember() {
		System.out.println(CLASS_NAME.concat("listupAdminMember()"));
		
//		return AdminMemberDao.selectAdminMembers();
		return null;
	}


	public List<UserMemberDto> listupUserMember() {
		System.out.println(CLASS_NAME.concat("listupUserMember()"));
		
//		return UserMemberDao.selectUserMembers();
		return null;
	}


	public void setAdminApproval(int a_no) {
		System.out.println(CLASS_NAME.concat("listupUserMember()"));
		
//		int result = adminMemberDao.updateAdminApproval(a_no);
//		
//		if (result > 0) {
//			System.out.println("ADMIN APPROVAL UPDATE SUCCESS");
//			
//		} else {
//			System.out.println("ADMIN APPROVAL UPDATE FAIL");
//		}
	}


	public void setDeletedBoard(int cb_no) {
		System.out.println(CLASS_NAME.concat("setDeletedBoard()"));
		
//		int result = communityBoardDao.updateDeletedBoard(cb_no);
//		
//		if (result > 0) {
//			System.out.println("COMMUNITY BOARD DELETE SUCCESS");
//			
//		} else {
//			System.out.println("COMMUNITY BOARD DELETE FAIL");
//		}
	}
	
	

}
