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
	public String writeBoardForm(HttpSession session) {
		System.out.println(CLASS_NAME.concat("writeBoardForm()"));

	    String loginedUserMemberId = (String) session.getAttribute(Configs.LOGIN_USER_MEMBER_ID);

	    if (loginedUserMemberId == null) {
	        System.out.println("로그인 필요!");
	        
	        return "redirect:/user/member/loginForm";
	        
	    }

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

	    if (loginedUserMemberId == null) {
	    	System.out.println("로그인 정보 없음!");
	    	
	    	return "redirect:/user/member/loginForm";
	    	
	    }
	    
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
	public ModelAndView listBoard(@RequestParam(value = "page", defaultValue = "1") int page) {
	    System.out.println(CLASS_NAME.concat("listBoard()"));

	    // 페이지가 1보다 작으면 1페이지
	    if (page < 1) {page = 1;}

	    // 현재 페이지 게시글 10개 조회
	    List<CommunityBoardDto> communityBoardDtos = communityBoardService.listBoard(page);

	    // 전체 게시글 개수
	    int totalBoardCount = communityBoardService.getBoardCount();

	    // 전체 페이지
	    int totalPage = (int) Math.ceil(totalBoardCount / 10.0);

	    ModelAndView modelAndView = new ModelAndView();
	    
	    modelAndView.setViewName("community/list_board");
	    modelAndView.addObject("communityBoardDtos", communityBoardDtos);
	    modelAndView.addObject("currentPage", page);
	    modelAndView.addObject("totalPage", totalPage);

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
	public String modifyBoardForm(@RequestParam("cb_no") int cb_no, HttpSession session, Model model) {
		System.out.println(CLASS_NAME.concat("modifyBoardForm()"));
		
		String loginedUserMemberId = (String) session.getAttribute(Configs.LOGIN_USER_MEMBER_ID);

		if (loginedUserMemberId == null) {
	        System.out.println("로그인이 필요합니다.");

	        return "redirect:/community/listBoard";
	        
	    }
		
	    CommunityBoardDto communityBoardDto = communityBoardService.modifyBoardForm(cb_no);
	    
	    if (communityBoardDto == null) {

	        return "redirect:/community/listBoard";
	        
	    }

	    if (!loginedUserMemberId.equals(communityBoardDto.getCb_id())) {

	        System.out.println("본인의 게시글만 수정할 수 있습니다.");

	        return "redirect:/community/detailBoard?cb_no=" + cb_no;
	        
	    }

	    model.addAttribute("communityBoardDto", communityBoardDto);

	    return "community/modify_board_form";
	}
	
	/*
	 * 글 수정 확인
	 * /community/modifyBoardConfirm
	 */
	@PostMapping("/modifyBoardConfirm")
	public String modifyBoardConfirm(CommunityBoardDto communityBoardDto, HttpSession session) {
		System.out.println(CLASS_NAME.concat("modifyBoardConfirm()"));
		
		String loginedUserMemberId = (String) session.getAttribute(Configs.LOGIN_USER_MEMBER_ID);
		
		if (loginedUserMemberId == null) {
			
			return "redirect:/community/listBoard";

		}
		
		CommunityBoardDto savedBoardDto = communityBoardService.detailBoard(communityBoardDto.getCb_no());
		
		if (savedBoardDto == null) {

	        return "redirect:/community/listBoard";
	        
	    }

	    if (!loginedUserMemberId.equals(savedBoardDto.getCb_id())) {

	        System.out.println("수정 권한이 없습니다.");

	        return "redirect:/community/detailBoard?cb_no="
	                + communityBoardDto.getCb_no();
	        
	    }
	    
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
	public String deleteBoardConfirm(@RequestParam("cb_no") int cb_no, HttpSession session) {

	    System.out.println(CLASS_NAME.concat("deleteBoardConfirm()"));

	    String loginedUserMemberId = (String) session.getAttribute(Configs.LOGIN_USER_MEMBER_ID);

	    if (loginedUserMemberId == null) {

	        return "redirect:/community/listBoard";
	        
	    }

	    CommunityBoardDto communityBoardDto = communityBoardService.detailBoard(cb_no);

	    if (communityBoardDto == null) {

	        return "redirect:/community/listBoard";
	        
	    }

	    if (!loginedUserMemberId.equals(communityBoardDto.getCb_id())) {

	        System.out.println("삭제 권한이 없습니다.");

	        return "redirect:/community/detailBoard?cb_no="
	                + cb_no;
	        
	    }

	    int result = communityBoardService.deleteBoardConfirm(cb_no);

	    if (result > 0) {
	        System.out.println("삭제 성공!");
	        

	    } else {
	        System.out.println("삭제 실패!");
	        
	    }

	    return "redirect:/community/listBoard";
	    
	}
	
	/*
	 * 게시글 검색
	 * /community/searchBoards
	 */
	@GetMapping("/searchBoards")
	public ModelAndView searchBoards(@RequestParam("keyword") String keyword) {
	    System.out.println(CLASS_NAME.concat("searchBoards()"));

	    List<CommunityBoardDto> communityBoardDtos = communityBoardService.searchBoards(keyword);

	    ModelAndView modelAndView = new ModelAndView();

	    modelAndView.setViewName("community/list_board");
	    modelAndView.addObject("communityBoardDtos",communityBoardDtos);
	    modelAndView.addObject("keyword",keyword);

	    return modelAndView;
	    
	}
	/*
	 * 관리자 게시글 목록
	 * /community/adminListBoard
	 */
	@GetMapping("/adminListBoard")
	public ModelAndView adminListBoard(@RequestParam(value = "page", defaultValue = "1") int page, HttpSession session) {
	    System.out.println(CLASS_NAME.concat("adminListBoard()"));

	    Object object = session.getAttribute(Configs.LOGIN_ADMIN_MEMBER_ID);

	    if (object == null) {

	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("redirect:/admin/member/loginForm");

	        return modelAndView;
	        
	    }

	    if (page < 1) {page = 1;}

	    List<CommunityBoardDto> communityBoardDtos = communityBoardService.listBoard(page);

	    int totalBoardCount = communityBoardService.getBoardCount();
	    int totalPage = (int) Math.ceil(totalBoardCount / 10.0);

	    ModelAndView modelAndView = new ModelAndView();

	    modelAndView.setViewName("community/admin_list_board");
	    modelAndView.addObject("communityBoardDtos", communityBoardDtos);
	    modelAndView.addObject("currentPage", page);
	    modelAndView.addObject("totalPage", totalPage);

	    return modelAndView;
	    
	}
	
	/*
	 * 관리자 게시글 삭제
	 * /community/adminDeleteBoardConfirm
	 */
	@GetMapping("/adminDeleteBoardConfirm")
	public String adminDeleteBoardConfirm(@RequestParam("cb_no") int cb_no, HttpSession session) {
	    System.out.println(CLASS_NAME.concat("adminDeleteBoardConfirm()"));

	    String loginedAdminMemberId =(String) session.getAttribute(Configs.LOGIN_ADMIN_MEMBER_ID);

	    if (loginedAdminMemberId == null) {return "redirect:/admin/member/loginForm";}

	    communityBoardService.deleteBoardConfirm(cb_no);

	    return "redirect:/community/adminListBoard";
	    
	}
	
	
}
