package com.office.board.community;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.office.board.config.Configs;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/community")
@RequiredArgsConstructor
public class CommunityBoardController {

	final private String CLASS_NAME = "[CommunityBoardController] ";
	
	final private CommunityBoardService communityBoardService;
	
	/*
	 * 글 작성 화면
	 * /community/writeBoardForm
	 */
	@GetMapping("/writeBoardForm")
	public String writeBoardForm() {
		System.out.println(CLASS_NAME.concat("writeBoardForm()"));
		
	    String nextPage = "community/write_board_form";

	    return nextPage;
	    
	}
	
	/*
	 * 글 등록 확인
	 * /community/writeBoardConfirm
	 */
	@PostMapping("/writeBoardConfirm")
	public String writeBoardConfirm(CommunityBoardDto communityBoardDto, HttpSession session) {
		System.out.println(CLASS_NAME.concat("writeBoardConfirm()"));
		
	    String loginedUserMemberId = (String) session.getAttribute(Configs.LOGIN_USER_MEMBER_ID);

	    communityBoardDto.setCb_id(loginedUserMemberId);

	    int result = communityBoardService.writeBoardConfirm(communityBoardDto);
	    
	    if (result > 0) {
	        System.out.println("등록 성공!");
	        
	    } else {	
	        System.out.println("등록 실패!");
	        
	    }

	    return "redirect:/community/listBoard";
	    
	}
	
	/*
	 * 글 전체 목록
	 * /community/listBoard
	 */
	@GetMapping("/listBoard")
	public ModelAndView listBoard() {
		System.out.println(CLASS_NAME.concat("listBoard()"));
		
	    String nextPage = "community/list_board";

	    List<CommunityBoardDto> communityBoardDtos = communityBoardService.listBoard();

	    ModelAndView modelAndView = new ModelAndView();

	    modelAndView.setViewName(nextPage);

	    modelAndView.addObject("communityBoardDtos", communityBoardDtos);

	    return modelAndView;
	    
	}
	
	/*
	 * 글 상세
	 * /community/detailBoard
	 */
	@GetMapping("/detailBoard")
	public String detailBoard(@RequestParam("cb_no") int cb_no, Model model) {
		System.out.println(CLASS_NAME.concat("detailBoard()"));
		
	    String nextPage = "community/detail_board";

	    CommunityBoardDto communityBoardDto = communityBoardService.detailBoard(cb_no);

	    model.addAttribute("communityBoardDto", communityBoardDto);

	    return nextPage;
	}
	
	/*
	 * 글 수정 양식
	 * /community/modifyBoardForm
	 */
	@GetMapping("/modifyBoardForm")
	public String modifyBoardForm(@RequestParam("cb_no") int cb_no, Model model) {
		System.out.println(CLASS_NAME.concat("modifyBoardForm()"));
		
	    String nextPage = "community/modify_board_form";

	    CommunityBoardDto communityBoardDto = communityBoardService.modifyBoardForm(cb_no);

	    model.addAttribute("communityBoardDto", communityBoardDto);

	    return nextPage;
	}
	
	/*
	 * 글 수정 확인
	 * /community/modifyBoardConfirm
	 */
	@PostMapping("/modifyBoardConfirm")
	public String modifyBoardConfirm(CommunityBoardDto communityBoardDto) {
		System.out.println(CLASS_NAME.concat("modifyBoardConfirm()"));
		
		int result = communityBoardService.modifyBoardConfirm(communityBoardDto);
		
	    if (result > 0) {
	    	System.out.println("수정 완료");
	    	
		} else {
			System.out.println("수정 실패");
			
		}

	    return "redirect:/community/detailBoard?cb_no="
	    		+ communityBoardDto.getCb_no();
	}
	
	/*
	 * 글 삭제
	 * /community/deleteBoardConfirm
	 */
	@GetMapping("/deleteBoardConfirm")
	public String deleteBoardConfirm(@RequestParam("cb_no") int cb_no) {
		System.out.println(CLASS_NAME.concat("deleteBoardConfirm()"));
		
	    communityBoardService.deleteBoardConfirm(cb_no);

	    return "redirect:/community/listBoard";
	}
	
}
