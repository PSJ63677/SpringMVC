package org.kh.spring.member.service;

import java.util.List;

import org.kh.spring.member.domain.Member;

public interface MemberService {

	/**
	 * 회원 목록 조회 Service
	 * @return
	 */
	public List<Member> selectMembers();
	
	/**
	 * 아이디로 조회
	 * @param memberId
	 * @return
	 */
	public Member selectOneById(String memberId);
	
	/**
	 * 회원 로그인 Service
	 * @param member
	 * @return Member
	 */
	public Member checkMemberLogin(Member member);

	
}
