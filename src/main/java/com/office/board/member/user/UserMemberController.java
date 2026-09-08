package com.office.board.member.user;

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
		
		return nextPage;
	}

}
