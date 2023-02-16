package org.kh.spring.member.store.logic;

import org.apache.ibatis.session.SqlSession;
import org.kh.spring.member.domain.Member;
import org.kh.spring.member.store.MemberStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository		// 빈등록
public class MemberStoreLogic implements MemberStore{
	@Autowired		// 의존성 주입
	private SqlSession session;

	@Override
	public Member checkMemberLogin(Member member) {
		Member result = session.selectOne("MemberMapper.checkMemberLogin", member);
		return result;
	}

}
