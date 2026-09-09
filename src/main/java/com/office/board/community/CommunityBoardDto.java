package com.office.board.community;

public class CommunityBoardDto {

	private int cb_no;			// 번호
	private String cb_id;		// 아이디
	private String cb_title;	// 제목
	private String cb_comment;	// 내용
	private int cb_deleted;	// 삭제
	private String cb_reg_date;	// 등록일
	private String cb_mod_date;	// 최근 수정일
	
	
	public int getCb_no() {
		return cb_no;
	}
	public void setCb_no(int cb_no) {
		this.cb_no = cb_no;
	}
	public String getCb_id() {
		return cb_id;
	}
	public void setCb_id(String cb_id) {
		this.cb_id = cb_id;
	}
	public String getCb_title() {
		return cb_title;
	}
	public void setCb_title(String cb_title) {
		this.cb_title = cb_title;
	}
	public String getCb_comment() {
		return cb_comment;
	}
	public void setCb_comment(String cb_comment) {
		this.cb_comment = cb_comment;
	}
	public int getCb_deleted() {
		return cb_deleted;
	}
	public void setCb_deleted(int cb_deleted) {
		this.cb_deleted = cb_deleted;
	}
	public String getCb_reg_date() {
		return cb_reg_date;
	}
	public void setCb_reg_date(String cb_reg_date) {
		this.cb_reg_date = cb_reg_date;
	}
	public String getCb_mod_date() {
		return cb_mod_date;
	}
	public void setCb_mod_date(String cb_mod_date) {
		this.cb_mod_date = cb_mod_date;
	}
	
}
