package com.office.board.member;

import java.util.List;

public interface IMemberDao<T> {

	public int insertMember(T memberDto);
	
	public int updateMember(T memberDto);
	public int updateMemberApproval(T memberDto);
	
	public boolean isExists(String memberId);
	public boolean isExists(int memberNo);
	
	public T selectMember(String memberId);
	public T selectMember(int memberNo);
	public List<T> selectMembersByKeywordOfId(String keyword);
	public List<T> selectAllMembers();
	
	/**
	 * dto 내용 출력
	 * @param dto
	 */
	public void printDto(T dto);
	
	/**
	 * dtos를 순회하며 하나씩 내용 출력
	 * @param dtos
	 */
	public void printDtos(List<T> dtos);
	
}
