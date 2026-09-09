package com.office.board.member.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@PostMapping("/loginConfirm")
	public String loginConfirm(UserMemberDto userMemberDto, HttpSession session) {
		System.out.println(CLASS_NAME.concat("loginConfirm()"));
		
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

	@GetMapping("logoutConfirm")
	public String logoutConfirm(HttpSession session) {
		System.out.println(CLASS_NAME.concat("logoutConfirm()"));
		
		String nextPage = "redirect:/";
		
		session.invalidate();
		
		return nextPage;
		
		/*
		<form action="${pageContext.request.contextPath}/logoutConfirm" method="get">
	    <button type="submit">·Î±×¾Æ¿ô</button>
		</form>
		*/
		
	}
	
	@GetMapping("/modifyAccountForm")
	public String modifyAccountForm(HttpSession session, Model model) {
		System.out.println(CLASS_NAME.concat("modifyAccountForm()"));
		
		String nextPage = "user/member/modify_account_form";
		
		String loginedUserMemberId = String.valueOf(session.getAttribute("loginedUserMemberId"));
		
		UserMemberDto loginedUserMemberDto = 
				userMemberService.modifyAccountForm(loginedUserMemberId);
		model.addAttribute("loginedUserMemberDto", loginedUserMemberDto);
		
		return nextPage;
	}
	
}
