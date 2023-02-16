package org.kh.spring.member.service.logic;

import org.kh.spring.member.domain.Member;
import org.kh.spring.member.service.MemberService;
import org.kh.spring.member.store.MemberStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service	// 빈등록
public class MemberServiceImpl implements MemberService {
	@Autowired		// 의존성 주입
	private MemberStore mStore;

	@Override
	public Member checkMemberLogin(Member member) {
		Member result = mStore.checkMemberLogin(member);
		return result;
	}

}
