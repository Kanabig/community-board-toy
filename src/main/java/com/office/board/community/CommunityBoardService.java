package com.office.board.community;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CommunityBoardService {

	final private String CLASS_NAME = "[CommunityBoardService]";
	
	final private CommunityBoardDao communityBoardDao;

	public CommunityBoardService(
	        CommunityBoardDao communityBoardDao) {

	    this.communityBoardDao = communityBoardDao;
	}

	public int writeBoardConfirm(CommunityBoardDto communityBoardDto) {
		System.out.println(CLASS_NAME.concat("writeBoardConfirm()"));
		
		int result = communityBoardDao.insertBoard(communityBoardDto);
		
		return result;
		
	}

	public List<CommunityBoardDto> listBoard() {
		System.out.println(CLASS_NAME.concat("listBoard()"));
		
		return communityBoardDao.selectAllBoards();
		
	}

	public CommunityBoardDto detailBoard(int cb_no) {
		System.out.println(CLASS_NAME.concat("detailBoard()"));
		
		return communityBoardDao.selectBoardByCbNo(cb_no);
		
	}

	public CommunityBoardDto modifyBoardForm(int cb_no) {
		System.out.println(CLASS_NAME.concat("modifyBoardForm()"));
		
		return detailBoard(cb_no);
		
	}

	public int modifyBoardConfirm(CommunityBoardDto communityBoardDto) {
		System.out.println(CLASS_NAME.concat("modifyBoardConfirm()"));
		
		int result = communityBoardDao.updateBoard(communityBoardDto);
		
		return result;
		
	}

	public int deleteBoardConfirm(int cb_no) {
		System.out.println(CLASS_NAME.concat("deleteBoardConfirm()"));
		
		int result = communityBoardDao.deleteBoard(cb_no);
		
		return result;
		
	}
	
	public List<CommunityBoardDto> searchBoards(String keyword) {
	    System.out.println(CLASS_NAME.concat("searchBoards()"));

	    return communityBoardDao.searchBoards(keyword);
	}
	
	
}
