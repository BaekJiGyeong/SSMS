package com.ktds.ssms.member.service.impl;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.ssms.member.biz.MemberBiz;
import com.ktds.ssms.member.service.MemberService;
import com.ktds.ssms.member.vo.MemberVO;
import com.ktds.ssms.utilities.AjaxUtil;

public class MemberServiceImpl implements MemberService {

	private MemberBiz memberBiz;
	private Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);

	public void setMemberBiz(MemberBiz memberBiz) {
		this.memberBiz = memberBiz;
	}

	@Override
	public ModelAndView registerMember() {
		
		ModelAndView view = new ModelAndView();
		view.setViewName("member/registerMember");
		
		return view;
	}

	@Override
	public ModelAndView addNewMember(MemberVO member) {
		
		ModelAndView view = new ModelAndView();
		
		if ( member == null ) {
			
			view.setViewName("member/registerMember");
			view.addObject("member", member);
			
			return view;
			
		} else {
			
			boolean result = memberBiz.addNewMember(member);
			
			if ( result ) {
				view.setViewName("redirect:/login");
			} else {
				throw new RuntimeException("회원가입시 문제가 발생했습니다.");
			}
			
		}
	
		return view;
	}

	@Override
	public ModelAndView doLoginMember(MemberVO member, HttpSession session) {
		
		ModelAndView view = new ModelAndView();
		
		boolean loginCheck = memberBiz.doLoginMember(member, session);
		
		if ( loginCheck ) {
			view.setViewName("article/list");
			return view;
		}
		else {
			view.setViewName("redirect:/login?loginFail=Y");
			return view;
		}
	}

	@Override
	public String doLogoutMember(HttpSession session) {
		
		session.removeAttribute("_MEMBER_");
		
		return "redirect:/list";
	}

	@Override
	public void checkValidationById(String id, HttpServletResponse response) {

		String message = "OK";
		
		boolean isExistId = memberBiz.isExistId(id);
		
		if ( !isExistId ) {
			message = "NO";
			AjaxUtil.sendResponse(response, message);
			return;
		}
		
		AjaxUtil.sendResponse(response, message);
		return;
		
	}

}
