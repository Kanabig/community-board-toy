package com.office.board.member;

import java.util.List;

public interface IMemberDao<T> {

	public int insertMember(T memberDto);
	public int updateMember(T memberDto);
	public T selectMember(String userId);
	public T selectMember(int memberNo);
//	public List<T> selectMembers(int memberNo);

}
