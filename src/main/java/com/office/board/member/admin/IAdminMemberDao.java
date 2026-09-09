package com.office.board.member.admin;

import com.office.board.member.core.IMemberDao;

public interface IAdminMemberDao extends IMemberDao<AdminMemberDto> {
	
	public int updateMemberApproval(AdminMemberDto memberDto);
	
}
