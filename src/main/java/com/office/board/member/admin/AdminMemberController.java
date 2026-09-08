package com.office.board.member.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AdminMemberController {
	
	final private String CLASS_NAME = "[AdminMemberController] ";
	
	final private AdminMemberService adminMemberService;

	/*
	 * 관리자 회원가입 양식
	 * member/admin/createAccountForm
	 */
	@GetMapping("/createAccountForm")
	public String createAccountForm() {
		System.out.println(CLASS_NAME.concat("createAccountForm()"));
		
		String nextPage = "member/admin/create_account_form";
		
		return nextPage;
		
	}
	
	/*
	 * 관리자 회원가입 확인
	 * member/admin/createAccountConfirm
	 */
	@PostMapping("/createAccountConfirm")
	public String createAccountConfirm(AdminMemberDto adminMemberDto) {
		System.out.println(CLASS_NAME.concat("createAccountConfirm()"));
		
		String nextPage = "member/admin/create_account_ok";
		
		int result = adminMemberService.createAccountConfirm(adminMemberDto);
		
		if (result <= AdminMemberService.ADMIN_ACCOUNT_ALREADY_EXIST)
			nextPage = "member/admin/create_account_ng";
		
		return nextPage;
		
	}
	
	/*
	 * 관리자 로그인 양식
	 * member/admin/loginForm
	 */
	@GetMapping("/loginForm")
	public String loginForm() {
		System.out.println(CLASS_NAME.concat("loginForm()"));
		
		String nextPage = "member/admin/login_form";
		
		return nextPage;
		
	}
	
	/*
	 * 관리자 로그인 확인
	 * member/admin/loginConfirm
	 */
	@PostMapping("/loginConfirm")
	public String loginConfirm(
			AdminMemberDto adminMemberDto,
			HttpSession session) {
		System.out.println(CLASS_NAME.concat("loginConfirm()"));
		
		String nextPage = "member/admin/login_ok";
		
		String loginedAdminMemberId = adminMemberService.loginConfirm(adminMemberDto);
		
		if (loginedAdminMemberId == null) {
			nextPage = "member/admin/login_ng";
			
		} else {
			session.setAttribute("loginedAdminMemberId", loginedAdminMemberId);
			session.setMaxInactiveInterval(30 * 60);
		}
		
		return nextPage;
		
	}
	
	/*
	 * 관리자 로그아웃 확인
	 * /member/admin/logoutConfirm
	 */
	@GetMapping("/logoutConfirm")
	public String logoutConfirm(HttpSession session) {
		System.out.println(CLASS_NAME.concat("logoutConfirm()"));
		
		String nextPage = "redirect:/admin";
		session.invalidate();
		
		return nextPage;
		
	}
	
}
