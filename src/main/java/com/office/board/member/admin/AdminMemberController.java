package com.office.board.member.admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.cj.Session;
import com.office.board.member.user.UserMemberDto;

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
	
	/*
	 * 관리자 목록 확인
	 * /member/admin/listupAdminMember
	 */
	@GetMapping("/listupAdminMember")
	public ModelAndView listupAdminMember(HttpSession session) {
		System.out.println(CLASS_NAME.concat("listupAdminMember()"));
		
		String nextPage = "member/admin/listup_admin_member";
		
		Object object = session.getAttribute("loginedAdminMemberId");
		
		if (object == null) {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("redirect:/member/admin/login_form");
			
			return modelAndView;
			
		}
		
		List<AdminMemberDto> adminMemberDtos = adminMemberService.listupAdminMember();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("adminMemberDtos", adminMemberDtos);
		modelAndView.setViewName(nextPage);
		
		return modelAndView;	
		
	}
	
	/*
	 * 사용자 목록 확인
	 * /member/user/listupAdminMember
	 */
	@GetMapping("/listupUserMember")
	public ModelAndView listupUserMember(HttpSession session) {
		System.out.println(CLASS_NAME.concat("listupUserMember()"));
		
		String nextPage = "member/admin/listup_user_member";
		
		Object object = session.getAttribute("loginedAdminMemberId");
		
		if (object == null) {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("redirect:/member/admin/login_form");
			
			return modelAndView;
			
		}
		
		List<UserMemberDto> userMemberDtos = adminMemberService.listupUserMember();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userMemberDtos", userMemberDtos);
		modelAndView.setViewName(nextPage);
		
		return modelAndView;	
		
	}
	
	/*
	 * 관리자 권한 승인
	 */
	@GetMapping("/setAdminApproval")
	public String setAdminApproval(
			@RequestParam("a_no") int a_no,
			HttpSession session) {
		System.out.println(CLASS_NAME.concat("setAdminApproval()"));
		
		Object object = session.getAttribute("loginedAdminMemberId");
		if (object == null)
			return "redirect:/member/admin/login_form";
		
		String nextPage = "redirect:/member/admin/listup_admin_members";
		
		adminMemberService.setAdminApproval(a_no);
		
		return nextPage;
	}
	
	/*
	 * 게시글 삭제
	 */
	@GetMapping("/setDeletedBoard")
	public String setDeletedBoard(
			@RequestParam("cb_no") int cb_no,
			HttpSession session) {
		System.out.println(CLASS_NAME.concat("setDeletedBoard()"));
		
		Object object = session.getAttribute("loginedAdminMemberId");
		if (object == null)
			return "redirect:/member/admin/login_form";
		
		String nextPage = "redirect:/community/list_board";
		
		adminMemberService.setDeletedBoard(cb_no);
		
		return nextPage;
	}
	
}
