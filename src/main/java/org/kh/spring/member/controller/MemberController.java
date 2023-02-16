package org.kh.spring.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kh.spring.member.domain.Member;
import org.kh.spring.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller		// 빈등록
public class MemberController {
	@Autowired		// 의존성 주입
	private MemberService mService;

	// /mamber/login.do
	@RequestMapping(value="/member/login.do", method=RequestMethod.POST)
	public String memberLogin(HttpServletRequest request, Model model) {
		String memberId = request.getParameter("member-id");
		String memberPw = request.getParameter("member-pw");
		Member mParam = new Member(memberId, memberPw);
		Member member = mService.checkMemberLogin(mParam);
		if(member != null) {
			// 성공하면 성공페이지
//			request.setAttribute("msg", "성공");	Model model ↑ 쓰고 springframework.ui.Model import해줌
//			request.getRequestDispatcher("/WEB-INF/views/common/success.jsp");
			model.addAttribute("msg", "성공");
			return "common/success";
		} else {
			// 실패하면 실패페이지
			model.addAttribute("msg", "실패");
			return "common/failed";
		}
	}
	
	@RequestMapping(value="/member/logout.do", method=RequestMethod.GET)
	public String memberLogout(HttpServletResponse response) {
//		response.sendRedirect("/index.jsp");
		return "redirect:/index.jsp";
	}
}
