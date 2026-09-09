package com.office.board.member.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user/member")
public class UserMemberController {

	final private String CLASS_NAME = "[UserMemberController] ";
	
	final private UserMemberService userMemberService;
	
	
	
	
	@GetMapping("/createAccountForm")
	public String createAccountForm() {
	System.out.println(CLASS_NAME.concat("createAccountForm()"));
		
		String nextPage = "user/member/create_account_form";
		
		return nextPage;
	}
	
	
	
	
	
	@PostMapping("/createAccountConfirm")
	public String createAccountConFirm(UserMemberDto userMemberDto) {
		System.out.println(CLASS_NAME.concat("createAccountConfirm()"));
		
		String nextPage = "user/member/create_account_ok";
		
		int result = userMemberService.createAccountConfirm(userMemberDto);
		
		if (result <= 0)
			nextPage = "user/member/create_account_ng";
		
		return nextPage;
		
		
	}
	
	
	
	@GetMapping("/loginForm")
	public String loginForm() {
		System.out.println(CLASS_NAME.concat("loginForm()"));
		
		String nextPage = "user/member/login_form";
		
		return nextPage;
		
	}
	
	@PostMapping("/loginConFirm")
	public String loginConFirm(UserMemberDto userMemberDto, HttpSession session) {
		System.out.println(CLASS_NAME.concat("loginConFirm()"));
		
		String nextPage = "user/member/login_ok";
		
		String loginedUserMemberId = userMemberService.loginConfirm(userMemberDto);
		
		if (loginedUserMemberId != null) {
			session.setAttribute("loginedUserMemberId", loginedUserMemberId);
			session.setMaxInactiveInterval(60 * 30);
		
		} else {
			nextPage = "user/member/login_ng";
		}
		
		return nextPage;
	}

}
